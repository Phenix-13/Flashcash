package com.Phenix13.Flashcash.Repository;

import com.Phenix13.Flashcash.Model.SocialLink;
import com.Phenix13.Flashcash.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SocialLinkRepository extends JpaRepository<SocialLink,Integer> {
    public List<SocialLink> findSocialLinksByUser1Email(String email);

    public SocialLink findSocialLinkByUser1EmailAndUser2Email(String email1,String email2);
}
