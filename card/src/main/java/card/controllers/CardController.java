package card.controllers;

import card.dto.CardDTO;
import card.services.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<CardDTO> createCard(@Valid @RequestBody CardDTO cardDTO) {
        return ResponseEntity.ok(cardService.createCard(cardDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> getCard(@PathVariable String id) {
        return ResponseEntity.ok(cardService.getCardById(id));
    }



}
