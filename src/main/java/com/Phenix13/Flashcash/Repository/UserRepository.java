package com.Phenix13.Flashcash.Repository;

import com.Phenix13.Flashcash.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
