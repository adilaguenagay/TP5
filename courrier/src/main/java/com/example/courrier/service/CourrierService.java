package com.example.courrier.service;

import com.example.courrier.bean.Courrier;
import com.example.courrier.dao.CourrierDao;

import java.util.List;

public interface CourrierService {

    Courrier creer(Courrier courrier);

    List<Courrier> lire();

    Courrier modifier(Long id, Courrier courrier);

    String supprimer(Long id);


}
