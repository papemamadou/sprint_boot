package sn.edu.isepdiamniadio.dbe.gestion.de.tache.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sn.edu.isepdiamniadio.dbe.gestion.de.tache.dao.ContactRepository;
import sn.edu.isepdiamniadio.dbe.gestion.de.tache.models.Contact;

import java.util.List;
import java.util.Optional;

@Service
@Transactional  // Pour gérer les transactions automatiquement
public class ContactService {

    private final ContactRepository contactRepository;

    // Injection via constructeur (pratique recommandée)
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Récupérer tous les contacts
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // Récupérer un contact par son id
    public Optional<Contact> getContactById(Integer id) {
        return contactRepository.findById(id);
    }

    // Créer un nouveau contact
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    // Mettre à jour un contact existant
    public Contact updateContact(Integer id, Contact contact) throws Throwable {
        Contact contactToUpdate = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact non trouvé avec l'id : " + id));

        // Mettre à jour les champs souhaités
        contactToUpdate.setNom(contact.getNom());
        contactToUpdate.setPrenom(contact.getPrenom());
        contactToUpdate.setTelephone(contact.getTelephone());
        contactToUpdate.setEmail(contact.getEmail());

        // Sauvegarder et retourner l'entité mise à jour
        return contactRepository.save(contactToUpdate);
    }

    // Supprimer un contact par son id
    public void deleteContact(Integer id) {
        if (!contactRepository.existsById(id)) {
            throw new RuntimeException("Contact non trouvé avec l'id : " + id);
        }
        contactRepository.deleteById(id);
    }
}
