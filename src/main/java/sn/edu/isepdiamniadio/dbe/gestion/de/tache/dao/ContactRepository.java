package sn.edu.isepdiamniadio.dbe.gestion.de.tache.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.edu.isepdiamniadio.dbe.gestion.de.tache.models.Contact;

import java.util.List;


public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByNomContaining(String nom);
}

