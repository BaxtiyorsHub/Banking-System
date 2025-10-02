package card.services;

import card.dto.CardDTO;
import card.entities.CardEntity;
import card.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public CardDTO createCard(@NotNull CardDTO cardDTO) {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setCard_number(cardDTO.getCard_number());
        cardEntity.setCard_type(cardDTO.getCard_type());
        cardEntity.setCard_owner(cardDTO.getCard_owner());
        cardEntity.setCvv(cardDTO.getCvv());
        cardEntity.setPhone_number(cardDTO.getPhone_number());
        return null;
    }
}
