package com.example.TP_Spring.dao;

import com.example.TP_Spring.bean.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteDao extends JpaRepository<Compte,Long> {

    Compte findByRib(String rib);
    int deleteByRib(String rib);
    List<Compte> findByRibLikeAndSoldeGreaterThan(String rib, double solde);
}
