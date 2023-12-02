package fst.sir.tp1.dao;

import fst.sir.tp1.bean.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteDao extends JpaRepository<Compte,Long> {
    Compte findByRib(String rib);
    int deleteByRib(String rib);
}
