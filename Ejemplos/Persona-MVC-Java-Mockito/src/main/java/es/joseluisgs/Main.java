package es.joseluisgs;

import es.joseluisgs.controllers.PersonaController;
import es.joseluisgs.models.Persona;
import es.joseluisgs.repositories.PersonaRepository;

public class Main {
    public static void main(String[] args) {
        PersonaController personaController = new PersonaController(new PersonaRepository());
        Persona[] lista = personaController.findAll();

        for (Persona persona : lista) {
            System.out.println(persona);
        }
    }
}