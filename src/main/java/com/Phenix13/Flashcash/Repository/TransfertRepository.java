package com.Phenix13.Flashcash.Repository;

import com.Phenix13.Flashcash.Model.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransfertRepository extends JpaRepository<Transfert,Integer> {
}
