package io.learning.springbootmysql.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Spanish", nullable = false)
    private String spanish;
    @Column(name = "English", nullable = false)
    private String english;
    @Column(name = "Swedish", nullable = false)
    private String swedish;
    @Column(name = "Type")
    private String type;

}