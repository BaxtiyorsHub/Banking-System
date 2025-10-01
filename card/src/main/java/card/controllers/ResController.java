package card.controllers;

import card.dto.CardDTO;
import card.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class ResController {

    private final CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<CardDTO> createCard(@RequestBody CardDTO cardDTO){
        return ResponseEntity.ok(cardService.createCard(cardDTO));
    }

}
