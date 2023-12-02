package com.example.TP_Spring.ws;

import com.example.TP_Spring.bean.Compte;
import com.example.TP_Spring.service.CompteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/compte/")
public class CompteWs {
    @Autowired
    public CompteService compteService;


    @GetMapping("rib/{rib}")
    public Compte findByRib(@PathVariable String rib) {
        return compteService.findByRib(rib);
    }

    @DeleteMapping("rib/{rib}")
    public int deleteByRib(@PathVariable String rib) {
        return compteService.deleteByRib(rib);
    }

    @GetMapping("rib/{rib}/solde/{solde}")
    public List<Compte> findByRibLikeAndSolde(@PathVariable String rib, @PathVariable double solde) {
        return compteService.findByRibLikeAndSolde(rib, solde);
    }

    @GetMapping("")
    public List<Compte> findAll() {
        return compteService.findAll();
    }

    @PostMapping("")
    public int save(@RequestBody Compte compte) {
        return compteService.save(compte);
    }

    @PutMapping("crediter/rib/{rib}/montant/{montant}")
    public int crediter(@PathVariable String rib, @PathVariable double montant) {
        return compteService.crediter(rib, montant);
    }

    @PutMapping("debiter/rib/{rib}/montant/{montant}")
    public int debiter(@PathVariable String rib, @PathVariable double montant) {
        return compteService.debiter(rib, montant);
    }

    @PutMapping("transferer/source/rib/{ribSource}/destination/rib/{ribDestination}/montant/{montant}")
    public int transferer(String ribSource, String ribDestination, double montant) {
        return compteService.transferer(ribSource, ribDestination, montant);
    }

}
