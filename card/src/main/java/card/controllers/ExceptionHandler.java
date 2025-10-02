package card.controllers;

import card.exps.CardBadExp;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {

    public ResponseEntity<String> handeBadRequest(CardBadExp cardBadExp) {
        return new ResponseEntity<>(cardBadExp.getMessage(), HttpStatus.BAD_REQUEST);
    }

}

