package sn.edu.isepdiamniadio.dbe.gestion.de.tache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.edu.isepdiamniadio.dbe.gestion.de.tache.models.Contact;
import sn.edu.isepdiamniadio.dbe.gestion.de.tache.service.ContactService;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Liste des contacts
    @GetMapping
    public String listContact(Model model) {
        List<Contact> contacts = contactService.getAllContacts();
        model.addAttribute("contacts", contacts);  // pluriel dans la vue pour la liste
        return "contact/list";
    }

    // Afficher formulaire création contact
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact/create";
    }

    // Traiter création contact (formulaire POST)
    @PostMapping
    public String createContact(@ModelAttribute Contact contact) {
        contactService.createContact(contact);
        return "redirect:/contact";
    }

    // Afficher formulaire modification contact
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Contact contact = contactService.getContactById(id)
                .orElseThrow(() -> new IllegalArgumentException("Contact invalide Id:" + id));
        model.addAttribute("contact", contact);
        return "contact/edit";
    }

    // Traiter modification contact (formulaire POST)
    @PostMapping("/update/{id}")
    public String updateContact(@PathVariable Integer id, @ModelAttribute Contact contact) throws Throwable {
        contactService.updateContact(id, contact);
        return "redirect:/contact";
    }

    // Supprimer contact
    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Integer id) {
        contactService.deleteContact(id);
        return "redirect:/contact";
    }
}
