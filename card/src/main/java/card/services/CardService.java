package card.services;

import card.dto.CardDTO;
import card.entities.CardEntity;
import card.exps.CardBadExp;
import card.repositories.CardRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public CardDTO createCard(@NotNull CardDTO cardDTO) {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setCardNumber(cardDTO.getCardNumber());
        cardEntity.setCardType(cardDTO.getCardType());
        cardEntity.setCardOwner(cardDTO.getCardOwner());
        cardEntity.setCvv(cardDTO.getCvv());
        cardEntity.setPhoneNumber(cardDTO.getPhoneNumber());

        return convertDTO(cardRepository.save(cardEntity));
    }

    private CardDTO convertDTO(CardEntity cardEntity) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setCardId(cardEntity.getCardId());
        cardDTO.setCardNumber(cardEntity.getCardNumber());
        cardDTO.setCardType(cardEntity.getCardType());
        cardDTO.setCardAmount(cardEntity.getCardAmount());
        cardDTO.setCardOwner(cardEntity.getCardOwner());
        cardDTO.setCvv(cardEntity.getCvv());
        cardDTO.setPhoneNumber(cardEntity.getPhoneNumber());
        cardDTO.setExpiryDate(cardEntity.getExpiryDate());
        return cardDTO;
    }

    @SneakyThrows
    public CardDTO getCardById(String id) {
        return cardRepository
                .findById(id)
                .map(this::convertDTO)
                .orElseThrow(() -> new CardBadExp("Card Not Found"));
    }
}
