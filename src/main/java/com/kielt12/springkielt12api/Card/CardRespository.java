package com.kielt12.springkielt12api.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRespository extends JpaRepository<Card, Long> {

}
