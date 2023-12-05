package com.example.zouani1.ws;

import com.example.zouani1.bean.Commande;
import com.example.zouani1.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/commandes/")
public class CommandeWs {
    @Autowired
    private CommandeService commandeService;

    @PostMapping
    public int save(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @GetMapping("ref/{ref}")
    public Commande findByRef(@PathVariable String ref) {
        return commandeService.findByRef(ref);
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return commandeService.deleteByRef(ref);
    }

    @GetMapping("")
    public List<Commande> findAll() {
        return commandeService.findAll();
    }

    @PutMapping("payer/ref/{ref}/montant/{montant}")
    public int payer(@PathVariable String ref, @PathVariable double montant) {
        return commandeService.payer(ref, montant);
    }
}
