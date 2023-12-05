package com.example.TP_Spring.service;

import com.example.TP_Spring.bean.Compte;
import com.example.TP_Spring.dao.CompteDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CompteService {

    @Autowired
    private CompteDao compteDao;

    public Compte findByRib(String rib) {
        return compteDao.findByRib(rib);
    }

    @Transactional
    public int deleteByRib(String rib) {
        return compteDao.deleteByRib(rib);
    }

    public List<Compte> findByRibLikeAndSoldeGreaterThan(String rib, double solde) {
        return compteDao.findByRibLikeAndSoldeGreaterThan(rib, solde);
    }

    public List<Compte> findAll() {
        return compteDao.findAll();
    }

    public int save(Compte compte) {
        if (findByRib(compte.getRib()) != null) {
            return -1;
        }
        compteDao.save(compte);
        return 1;
    }

    public int crediter(String rib, double montant) {
        Compte compte = findByRib(rib);
        if (compte == null) {
            return -1;
        } else {
            double nvSolde = compte.getSolde() + montant;
            compte.setSolde(nvSolde);
            compteDao.save(compte);
            return 1;
        }

    }

    public int debiter(String rib, double montant) {
        Compte compte = findByRib(rib);
        if (compte == null) {
            return -1;
        } else if (compte.getSolde() < montant) {
            return -2;
        } else {
            double nvSolde = compte.getSolde() - montant;
            compte.setSolde(nvSolde);
            compteDao.save(compte);
            return 1;
        }

    }

    public int transferer(String ribSource, String ribDestination, double montant) {
        Compte source = findByRib(ribSource);
        Compte destination = findByRib(ribDestination);
        if (source == null) {
            return -1;
        } else if (destination == null) {
            return -2;
        } else if (source.getSolde() < montant) {
            return -3;
        } else {
            source.setSolde(source.getSolde() - montant);
            destination.setSolde(destination.getSolde() + montant);
            compteDao.save(source);
            compteDao.save(destination);
            return 1;
        }

    }

        /*
    public int transferer(String ribSource, String ribDestination, double montant) {
        Compte cs = findByRib(ribSource);
        Compte cd = findByRib(ribDestination);
        return transferer(cs, cd, montant);

    }

    public int transferer(Compte compteSource, Compte compteDestination, double montant) {
        //Compte source = findByRib(compteSource.getRib());
        //Compte destination = findByRib(compteDestination.getRib());
        if (compteSource == null) {
            return -1;
        } else if (compteDestination == null) {
            return -2;
        } else if (compteSource.getSolde() < montant) {
            return -3;
        } else {
            compteSource.setSolde(compteSource.getSolde() - montant);
            compteDestination.setSolde(compteDestination.getSolde() + montant);
            compteDao.save(compteSource);
            compteDao.save(compteDestination);
            return 1;
        }

    }
*/
}
