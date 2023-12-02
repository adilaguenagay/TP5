package com.example.courrier.ws;

import com.example.courrier.bean.Courrier;
import com.example.courrier.dao.CourrierDao;
import com.example.courrier.service.CourrierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courrier")
@AllArgsConstructor
public class CourrierWs {
    private final CourrierService courrierService;

    @PostMapping("/create")
    public Courrier create(@RequestBody Courrier courrier) {
        return courrierService.creer(courrier);
    }

    @GetMapping("/read")
    public List<Courrier> read() {
        return courrierService.lire();
    }

    @PutMapping("/update/{id}")
    public Courrier update(@PathVariable Long id, @RequestBody Courrier courrier) {
        return courrierService.modifier(id, courrier);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return courrierService.supprimer(id);
    }

}
