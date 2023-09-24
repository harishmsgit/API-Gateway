package com.harish.quizeapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//@Table(name = "questionsTB")
public class questions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnsware;
    private String difficultlevel;
    private String category;
}