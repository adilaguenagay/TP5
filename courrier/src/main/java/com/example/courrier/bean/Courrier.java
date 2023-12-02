package com.example.courrier.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity //Annotation pour mapper la classe avec une table de la DB
@Table(name="courrier")
@Getter
@Setter
@NoArgsConstructor
public class Courrier {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int num_depot;
    private int annee_depot;
    private Date date_depot;
    private int ifu;
    @Column(length = 100)
    private String nom;
    @Column(length = 100)
    private String prenom;

}
