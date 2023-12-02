package com.example.courrier.dao;

import com.example.courrier.bean.Courrier;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourrierDao extends JpaRepository<Courrier, Long> {


}
