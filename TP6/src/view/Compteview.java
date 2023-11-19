package view;

import bean.Compte;
import service.CompteService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class Compteview extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField textSolde;
    private JTextField textRib;
    private JButton ouvrirUnCompteButton;
    private JTextField textSolde_r;
    private JTextField textRib_r;
    private JRadioButton ouvertRadioButton;
    private JRadioButton fermerRadioButton;
    private JButton chercherUnCompteButton;
    private JTextField textRib_d;
    private JTextField textSolde_d;
    private JTextField textmontant_d;
    private JButton verifierCompteButton;
    private JButton debiterButton;
    private JButton crediterButton;
    private JLabel infoCompte;

    public Compteview() {
        setContentPane(panel1);
        setTitle("Gestion des Comptes");
        setVisible(true);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CompteService compteService = new CompteService();
        ArrayList<Compte> comptes = new ArrayList<>();

        ouvrirUnCompteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,textRib.getText() + "//" + textSolde.getText());
                if (textRib.getText() != null && textSolde.getText() != null) {
                    int resultat_ouvrir = compteService.ouvrir(textRib.getText(), Double.parseDouble(textSolde.getText()), comptes);
                    if (resultat_ouvrir > 0) {
                        JOptionPane.showMessageDialog(null, "le Compte : " + textRib.getText() + " est ouvert.", "Ouverture de Compte", JOptionPane.INFORMATION_MESSAGE);
                    } else if (resultat_ouvrir == -1) {
                        JOptionPane.showMessageDialog(null, "le Compte : " + textRib.getText() + " existe déjà.", "Ouverture de Compte", JOptionPane.WARNING_MESSAGE);
                    } else if (resultat_ouvrir == -2) {
                        JOptionPane.showMessageDialog(null, "le Solde du Compte : " + textRib.getText() + " est negatif.", "Ouverture de Compte", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Merci de sairvir toutes les information", "Ouverture de ompte", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        textRib.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textRib.setText(null);
                textSolde.setText(null);
                textRib.setForeground(Color.black);
                textSolde.setForeground(Color.black);
            }
        });
        chercherUnCompteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"debut de recherche");
                Compte compte = compteService.findByRib(textRib_r.getText(), comptes);
                if (compte != null) {
                    textSolde_r.setText(Double.toString(compte.getSolde()));
                    if (compte.isOuvert() == true) {
                        ouvertRadioButton.setSelected(true);
                        fermerRadioButton.setSelected(false);
                    } else {
                        ouvertRadioButton.setSelected(false);
                        fermerRadioButton.setSelected(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Compte inexistant", "Recherche de Compte", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        verifierCompteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Compte compte = compteService.findByRib(textRib_d.getText(), comptes);
                if (compte != null) {
                    textSolde_d.setText(Double.toString(compte.getSolde()));
                    infoCompte.setText("N° de Compte : " + compte.getRib() + " || Solde : " + compte.getSolde() + " || Ouvert : " + compte.isOuvert());
                }else{
                    infoCompte.setText("N° de Compte : " + compte.getRib() + "est inixistant");
                    infoCompte.setForeground(Color.red);
                }

            }
        });
        debiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Compte compte = compteService.findByRib(textRib_d.getText(), comptes);
                if (compte != null) {
                    if (compte.getSolde()>Double.parseDouble(textSolde_d.getText())){
                        int resultat_debit = compteService.debiter(textRib_d.getText(),Double.parseDouble(textmontant_d.getText()),comptes);

                    }else{
                        JOptionPane.showMessageDialog(null,"Solde inssufisant !!!","Debit de Compte",JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        });
    }

    public static void main(String[] args) {
        new Compteview();
    }
}
