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
    public List<Card> getCard() {
        return cardService.getCard();
    }

    @PostMapping(path = "set-module")
    public void addCard(@RequestBody Card card){
        cardService.addCard(card);
    }

    @PutMapping(path ="api/put-module/{cardId}")
    public void updateCard(@PathVariable ("cardId") long cardId,
                           @RequestParam(required = false) String img,
                           @RequestParam(required = false) String header,
                           @RequestParam(required = false) String paragraph,
                           @RequestParam(required = false) String github,
                           @RequestParam(required = false) List<String> icons)
            {
        cardService.updateCard(cardId,img,header,paragraph,github,icons);
    }




}
