package card.services;

import card.dto.CardDTO;
import card.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public CardDTO createCard(CardDTO cardDTO) {
        return null;
    }
}
