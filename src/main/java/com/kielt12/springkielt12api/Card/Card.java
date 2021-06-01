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
    private String image;
    private String header;
    @Lob
    private String paragraph;
    private String github;
    private String site;
    @ElementCollection
    private List<String> icons;
    public Card() {

    }

    public Card(Long id, String image, String header, String paragraph, String github, String site, List<String> icons) {
        this.id = id;
        this.image = image;
        this.header = header;
        this.paragraph = paragraph;
        this.github = github;
        this.site = site;
        this.icons = icons;
    }

    public Card(String image, String header, String paragraph, String github, String site, List<String> icons) {
        this.image = image;
        this.header = header;
        this.paragraph = paragraph;
        this.github = github;
        this.site = site;
        this.icons = icons;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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

    public String getImage() {
        return image;
    }

    public void setImage(String img) {
        this.image = img;
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
                ", img='" + image + '\'' +
                ", header='" + header + '\'' +
                ", paragraph='" + paragraph + '\'' +
                '}';
    }
}
