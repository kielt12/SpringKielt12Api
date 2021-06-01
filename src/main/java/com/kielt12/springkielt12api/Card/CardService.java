package com.kielt12.springkielt12api.Card;

import com.kielt12.springkielt12api.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class CardService {

    private final CardRespository cardRespository;

    @Autowired
    public CardService(CardRespository cardRespository) {
        this.cardRespository = cardRespository;
    }

    public List<Card> getCard() {
        return cardRespository.findAll();
    }

    public void addCard(Card card) {
        if(card.getHeader() == null || card.getHeader().isEmpty()){
           throw new ApiRequestException("header can not be empty");
        }
        if(card.getIcons() == null || card.getIcons().isEmpty()){
            throw new ApiRequestException("icon can not be empty");
        }
        if(card.getImage() == null || card.getImage().isEmpty()){
            throw new ApiRequestException("image can not be empty");
        }
        if(card.getParagraph() == null || card.getParagraph().isEmpty()){
            throw new ApiRequestException("Paragraph can not be empty");
        }
        if(card.getGithub() == null || card.getGithub().isEmpty()){
            throw new ApiRequestException("github-Url can not be empty");
        }

        if(card.getSite().equals( "null")){
            card.setSite(null);
        }
        cardRespository.save(card);
    }
    @Transactional
    public void updateCard(long cardId, String image, String header, String paragraph, String github, String site, List<String> icons) {
    Card card = cardRespository.findById(cardId).orElseThrow(()-> new IllegalStateException("card with id" + cardId + "does not exist"));
        if(image != null && image.length() > 0 && !Objects.equals(card.getImage(),image)){
            card.setImage(image);
        }

        if(header != null && header.length() > 0 && !Objects.equals(card.getHeader(),header)){
            card.setHeader(header);
        }

        if(paragraph != null && paragraph.length() > 0 && !Objects.equals(card.getParagraph(),paragraph)){
            card.setParagraph(paragraph);
        }

        if(github != null && github.length() > 0 && !Objects.equals(card.getGithub(),github)){
            card.setGithub(github);
        }

        if(!Objects.equals(card.getSite(),site)){
            if(card.getSite().equals( "null")){
                card.setSite(null);
            } else {
                card.setSite(site);
            }
        }

        if(icons != null && !icons.isEmpty() && !Objects.equals(card.getIcons(),icons)){
            card.setIcons(icons);
        }

    }

}
