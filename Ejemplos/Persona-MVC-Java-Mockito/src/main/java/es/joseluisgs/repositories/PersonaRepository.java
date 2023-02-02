package es.joseluisgs.repositories;

import es.joseluisgs.models.Persona;

public class PersonaRepository {

    public Persona save(Persona persona) {
        System.out.println("Guardando persona: " + persona);
        return persona;
    }

    public Persona delete(Persona persona) {
        System.out.println("Borrando persona: " + persona);
        return persona;
    }

    public Persona update(Persona persona) {
        System.out.println("Actualizando persona " + persona);
        return persona;
    }

    public Persona find(Persona persona) {
        System.out.println("Buscando persona " + persona);
        return persona;
    }

    public Persona[] findAll() {
        System.out.println("Buscando todas las personas");
        Persona[] personas = new Persona[1];
        personas[0] = new Persona("Pepe", "Pérez");
        return personas;
    }


}
