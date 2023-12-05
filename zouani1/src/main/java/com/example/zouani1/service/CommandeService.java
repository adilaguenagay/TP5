package com.example.zouani1.service;

import com.example.zouani1.bean.Commande;
import com.example.zouani1.dao.CommandeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeDao commandeDao;

    public int save(Commande commande) {
        if (findByRef(commande.getRef()) != null) {
            return -1;
        } else if (commande.getTotal() < commande.getTotalPaye()) {
            return -2;
        } else {
            commandeDao.save(commande);
            return 1;
        }
    }

   public int payer(String ref, double montant) {
        Commande commande = findByRef(ref);
        if (commande == null) {
            return -1;
        } else {
            double totalPaye = commande.getTotalPaye() + montant;
            if (commande.getTotal() < totalPaye) {
                return -2;
            } else {
                commande.setTotalPaye(totalPaye);
                commandeDao.save(commande);
                return 1;
            }
        }
    }

    public Commande findByRef(String ref) {
        return commandeDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return commandeDao.deleteByRef(ref);
    }

    public List<Commande> findAll() {
        return commandeDao.findAll();
    }
}
