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

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public CardDTO createCard(@NotNull CardDTO cardDTO) {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setCard_number(cardDTO.getCard_number());
        cardEntity.setCard_type(cardDTO.getCard_type());
        cardEntity.setCard_owner(cardDTO.getCard_owner());
        cardEntity.setCvv(cardDTO.getCvv());
        cardEntity.setPhone_number(cardDTO.getPhone_number());

        return convertDTO(cardRepository.save(cardEntity));
    }

    private CardDTO convertDTO(CardEntity cardEntity) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setCard_id(cardEntity.getCard_id());
        cardDTO.setCard_number(cardEntity.getCard_number());
        cardDTO.setCard_type(cardEntity.getCard_type());
        cardDTO.setCard_amount(cardEntity.getCard_amount());
        cardDTO.setCard_owner(cardEntity.getCard_owner());
        cardDTO.setCvv(cardEntity.getCvv());
        cardDTO.setPhone_number(cardEntity.getPhone_number());
        cardDTO.setExpiry_date(cardEntity.getExpiry_date());
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
