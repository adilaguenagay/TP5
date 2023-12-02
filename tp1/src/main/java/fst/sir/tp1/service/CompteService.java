package fst.sir.tp1.service;

import fst.sir.tp1.bean.Compte;
import fst.sir.tp1.dao.CompteDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompteService {
    @Autowired
    private CompteDao compteDao;

    public int crediter(String rib, double montant) {
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

    public int debiter(String rib, double montant) {
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

    private int transferer(Compte source, Compte destination, double montant) {
        if (source == null) {
            return -1;
        } else if (destination == null) return -2;
        if (source.getSolde() < montant) {
            return -3;
        } else {
            source.setSolde(source.getSolde() - montant);
            destination.setSolde(destination.getSolde() + montant);
            compteDao.save(source);
            compteDao.save(destination);
            return 1;
        }
    }

    /*to get the compte using rib*/
    public int transferer(String ribSource, String ribDestination, double montant) {
        Compte cs = findByRib(ribSource);
        Compte cd = findByRib(ribDestination);
        return transferer(cs, cd, montant);

    }

    public int save(Compte compte) {
        if (findByRib(compte.getRib()) != null) {
            return -1;
        } else {
            compteDao.save(compte);
            return 1;
        }
    }

    public Compte findByRib(String rib) {
        return compteDao.findByRib(rib);
    }

    @Transactional
    public int deleteByRib(String rib) {
        return compteDao.deleteByRib(rib);
    }

    public List<Compte> findAll() {
        return compteDao.findAll();
    }
}
