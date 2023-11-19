package service;

import bean.Compte;

import java.util.ArrayList;

public class CompteService {
    public int fermer(String rib, ArrayList<Compte> comptes) {
        Compte c = findByRib(rib, comptes);
        if (c == null) {
            return -1;
        } else if (!c.isOuvert()) {
            return -2;
        } else if (c.getSolde() != 0) {
            return -3;
        } else {
            c.setOuvert(false);
            return 1;
        }
    }

    public int ouvrir(String rib, double solde, ArrayList<Compte> comptes) {
        Compte c = findByRib(rib, comptes);
        if (c != null) {
            return -1;
        } else if (solde < 0) {
            return -2;
        } else {
            Compte myCompte = new Compte(rib, solde, true);
            comptes.add(myCompte);
            return 1;
        }

    }

    public Compte findByRib(String rib, ArrayList<Compte> comptes) {
        for (int i = 0; i < comptes.size(); i++) {
            Compte c = comptes.get(i);
            if (c.getRib().equals(rib)) {
                return c;
            }

        }
        return null;
    }
    private double nvSoldDebit;
    private double nvSoldeCredit;
    public int debiter(String rib, double montant,ArrayList<Compte> comptes) {
        Compte compte = findByRib(rib,comptes);
        if (compte==null || !compte.isOuvert()) {
            return -1;
        } else if(compte.getSolde()<montant) {
            return -2;
        }else{
            nvSoldDebit = compte.getSolde() - montant;
            compte.setSolde(nvSoldDebit);
            return 1;
        }

    }

    public int crediter(String rib, double montant,ArrayList<Compte> comptes) {
        Compte compte = findByRib(rib,comptes);
        if (compte==null || !compte.isOuvert()) {
            return -1;
        }else{
            nvSoldeCredit = compte.getSolde() + montant;
            compte.setSolde(nvSoldeCredit);
            return 1;
        }

    }



}
