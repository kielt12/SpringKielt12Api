package com.kielt12.springkielt12api.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")

public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @CrossOrigin
    @GetMapping(path = "get-module")
    public List<Card> getTodo() {
        return cardService.getTodo();
    }

    @PostMapping(path = "set-module")
    public void addTodo(@RequestBody Card card){
        cardService.addTodo(card);
    }



}
