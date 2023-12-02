package com.example.courrier.service;

import com.example.courrier.bean.Courrier;
import com.example.courrier.dao.CourrierDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourrierServiceImpl implements CourrierService {
    private final CourrierDao courrierDao;

    @Override
    public Courrier creer(Courrier courrier) {
        return courrierDao.save(courrier);
    }

    @Override
    public List<Courrier> lire() {
        return courrierDao.findAll();
    }

    @Override
    public Courrier modifier(Long id, Courrier courrier) {
        return courrierDao.findById(id)
                .map(p-> {
                    p.setIfu(courrier.getIfu());
                    p.setNom(courrier.getNom());
                    p.setPrenom(courrier.getPrenom());
                    return courrierDao.save(p);
                }) .orElseThrow(()-> new RuntimeException("Courrier non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        courrierDao.deleteById(id);
        return "Courrier supprimer";
    }
}
