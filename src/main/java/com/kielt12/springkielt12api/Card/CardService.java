package com.kielt12.springkielt12api.Card;

import com.kielt12.springkielt12api.exception.ApiRequestException;
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
        if(card.getHeader() == null || card.getHeader().isEmpty()){
           throw new ApiRequestException("header can not be empty");
        }
        if(card.getIcons() == null || card.getIcons().isEmpty()){
            throw new ApiRequestException("icon can not be empty");
        }
        if(card.getImg() == null || card.getImg().isEmpty()){
            throw new ApiRequestException("image can not be empty");
        }
        if(card.getParagraph() == null || card.getParagraph().isEmpty()){
            throw new ApiRequestException("Paragraph can not be empty");
        }
        if(card.getGithub() == null || card.getGithub().isEmpty()){
            throw new ApiRequestException("github-Url can not be empty");
        }
        cardRespository.save(card);
    }
}
