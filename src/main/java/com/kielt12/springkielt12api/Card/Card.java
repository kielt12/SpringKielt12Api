package com.kielt12.springkielt12api.Card;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Card {
    @Id
    @SequenceGenerator(
    name = "card_sequence",
            sequenceName = "card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "card_sequence"
    )

    private Long id;
    private String img;
    private String header;
    @Lob
    private String paragraph;
    private String github;
    @ElementCollection
    private List<String> icons;
    public Card() {

    }

    public Card(String img, String header, String paragraph, String github, List<String> icons) {
        this.img = img;
        this.header = header;
        this.paragraph = paragraph;
        this.github = github;
        this.icons = icons;
    }

    public Card(Long id, String img, String header, String paragraph, String github, List<String> icons) {
        this.id = id;
        this.img = img;
        this.header = header;
        this.paragraph = paragraph;
        this.github = github;
        this.icons = icons;
    }


    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }



    public List<String> getIcons() {
        return icons;
    }

    public void setIcons(List<String> icons) {
        this.icons = icons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setHeader(String todoText) {
        this.header = todoText;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", header='" + header + '\'' +
                ", paragraph='" + paragraph + '\'' +
                '}';
    }
}
