package es.joseluisgs.controllers;

import es.joseluisgs.models.Persona;
import es.joseluisgs.repositories.PersonaRepository;

public class PersonaController {

    private final PersonaRepository personaRepository;

    public PersonaController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona save(Persona persona) {
        System.out.println("Controlador: Guardando persona");
        return personaRepository.save(persona);
    }

    public Persona delete(Persona persona) {
        System.out.println("Controlador: Borrando persona");
        return personaRepository.delete(persona);
    }

    public Persona update(Persona persona) {
        System.out.println("Controlador: Actualizando persona");
        return personaRepository.update(persona);
    }

    public Persona find(Persona persona) {
        System.out.println("Controlador: Buscando persona");
        return personaRepository.find(persona);
    }

    public Persona[] findAll() {
        System.out.println("Controlador: Buscando todas las personas");
        return personaRepository.findAll();
    }
}
