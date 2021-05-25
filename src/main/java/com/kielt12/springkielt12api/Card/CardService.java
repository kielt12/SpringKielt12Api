package com.kielt12.springkielt12api.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRespository cardRespository;

    @Autowired
    public CardService(CardRespository cardRespository) {
        this.cardRespository = cardRespository;
    }

    public List<Card> getTodo() {
        return cardRespository.findAll();
    }

    public void addTodo(Card card) {
        cardRespository.save(card);
    }
}
