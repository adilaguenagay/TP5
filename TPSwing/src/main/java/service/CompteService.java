/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author user_Adil
 */
import bean.Compte;
import java.util.ArrayList;

public class CompteService {

    private double nvSoldeSource;
    private double nvSoldeDestination;

    public Compte findByRib(String rib, ArrayList<Compte> comptes) {
        for (int i = 0; i < comptes.size(); i++) {
            Compte c = comptes.get(i);
            if (c.getRib().equals(rib)) {
                return c;
            }
        }
        return null;
    }

    public int fermer(String rib, ArrayList<Compte> comptes) {
        Compte c = findByRib(rib, comptes);
        if (c == null) {
            return -3;
        } else if (c.getSolde() > 0) {
            return -1;
        } else if (!c.isOuvert()) {
            return -2;
        } else {
            c.setOuvert(false);
            return 1;
        }
    }

    public int transfert(String ribSource, String ribDestination, double montant, ArrayList<Compte> comptes) {
        Compte compteSource = findByRib(ribSource, comptes);
        Compte compteDestination = findByRib(ribDestination, comptes);
        if (compteSource.getRib() == null || !compteSource.isOuvert()) {
            return -1;
        } else if (compteDestination.getRib() == null || !compteDestination.isOuvert()) {
            return -2;
        } else if (compteSource.getSolde() < montant) {
            return -3;
        } else {
            nvSoldeSource = compteSource.getSolde() - montant;
            nvSoldeDestination = compteDestination.getSolde() + montant;
            compteSource.setSolde(nvSoldeSource);
            compteDestination.setSolde(nvSoldeDestination);
            return 1;
        }

    }


}



