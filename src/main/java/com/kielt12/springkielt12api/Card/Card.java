package com.kielt12.springkielt12api.Card;


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
    private String paragraph;
    @ElementCollection
    private List<String> icons;

    public Card(Long id, String img, String header, String paragraph, List<String> icons) {
        this.id = id;
        this.img = img;
        this.header = header;
        this.paragraph = paragraph;
        this.icons = icons;
    }

    public Card(String img, String header, String paragraph, List<String> icons) {
        this.img = img;
        this.header = header;
        this.paragraph = paragraph;
        this.icons = icons;
    }

    public Card(Long id, String img, String header, String paragraph) {
        this.id = id;
        this.img = img;
        this.header = header;
        this.paragraph = paragraph;
    }

    public Card(String img, String header, String paragraph) {
        this.img = img;
        this.header = header;
        this.paragraph = paragraph;
    }

    public Card() {

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
