package es.joseluisgs.controllers;

import es.joseluisgs.models.Persona;
import es.joseluisgs.repositories.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

// Hay que extenderla con MockitoExtension para que funcione
@ExtendWith(MockitoExtension.class)
class PersonaControllerTest {

    @Mock
    PersonaRepository personasRepository;

    // Ya está mockeado e inyectado
    @InjectMocks
    PersonaController personaController;

    Persona testPersona = new Persona("TestNombre", "TestApellido");


    @Test
    void trueTest() {
        assertTrue(true);
    }

    @Test
    void save() {
        // when
        when(personasRepository.save(any())).thenReturn(testPersona);

        // accion
        var res = personaController.save(testPersona);

        // assert
        assertAll(
                () -> assertEquals(res.getNombre(), testPersona.getNombre()),
                () -> assertEquals(res.getApellido(), testPersona.getApellido())
        );

        // Verificar que se ha llamado al método save
        verify(personasRepository, times(1)).save(any());


    }

    @Test
    void delete() {
        // when
        when(personasRepository.delete(any())).thenReturn(testPersona);

        // accion
        var res = personaController.delete(testPersona);

        // assert
        assertAll(
                () -> assertEquals(res.getNombre(), testPersona.getNombre()),
                () -> assertEquals(res.getApellido(), testPersona.getApellido())
        );

        // Verificar que se ha llamado al método delete
        verify(personasRepository, times(1)).delete(any());
    }

    @Test
    void update() {
        // when
        when(personasRepository.update(any())).thenReturn(testPersona);

        // accion
        var res = personaController.update(testPersona);

        // assert
        assertAll(
                () -> assertEquals(res.getNombre(), testPersona.getNombre()),
                () -> assertEquals(res.getApellido(), testPersona.getApellido())
        );

        // Verificar que se ha llamado al método update
        verify(personasRepository, times(1)).update(any());
    }

    @Test
    void find() {
        // when
        when(personasRepository.find(any())).thenReturn(testPersona);

        // accion
        var res = personaController.find(testPersona);

        // assert
        assertAll(
                () -> assertEquals(res.getNombre(), testPersona.getNombre()),
                () -> assertEquals(res.getApellido(), testPersona.getApellido())
        );

        // Verificar que se ha llamado al método find
        verify(personasRepository, times(1)).find(any());
    }

    @Test
    void findAll() {
        // when
        when(personasRepository.findAll()).thenReturn(new Persona[]{testPersona});

        // accion
        var res = personaController.findAll();

        // assert
        assertAll(
                () -> assertEquals(res[0].getNombre(), testPersona.getNombre()),
                () -> assertEquals(res[0].getApellido(), testPersona.getApellido())
        );

        // Verificar que se ha llamado al método findAll
        verify(personasRepository, times(1)).findAll();
    }

    @Test
    void saveException() {
        // when
        when(personasRepository.save(any())).thenThrow(new IllegalArgumentException("Error en el save"));

        // accion
        var res = assertThrows(IllegalArgumentException.class, () -> personaController.save(testPersona));

        // assert
        assertEquals(res.getMessage(), "Error en el save");

        // Verificar que se ha llamado al método save


    }
}