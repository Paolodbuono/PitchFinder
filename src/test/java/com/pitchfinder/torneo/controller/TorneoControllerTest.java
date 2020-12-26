package com.pitchfinder.torneo.controller;

import com.pitchfinder.autenticazione.entity.Admin;
import com.pitchfinder.campo.entity.Campo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TorneoControllerTest {
    private TorneoController servlet;
    private HttpServletRequest mockedRequest;
    private HttpServletResponse mockedResponse;
    private HttpSession session;
    @BeforeAll
    void setUp() {
        servlet = new TorneoController();
        mockedRequest = Mockito.mock(HttpServletRequest.class);
        mockedResponse = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        Mockito.when(mockedRequest.getParameter("flag")).thenReturn("1");
    }

    @Test
    void TC_21_1() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("50");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Lunghezza nome non valida";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_2() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("?<<Champions?F");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("50");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Formato nome non valido";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_3() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn(null);
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("50");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Sport non selezionato";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_4() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn(null);
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("50");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Tipo non selezionato";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_5() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn(null);
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("50");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Struttura non selezionata";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_6() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn(null);
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("50");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Data inizio non selezionata";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_7() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("5/13/1980");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("50");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Formato data inizio non valido";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_8() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn(null);
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("50");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Data fine non selezionata";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
     void TC_21_9() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("1970-13-10");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("50");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Formato data fine non valido";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }


    @Test
    void TC_21_10() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("50");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Lunghezza giorno partite non valida";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_11() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("<<>/Giove/dì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("50");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Formato giorno partite non valido";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_12() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("n");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Formato numero squadre non valido";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());

    }

    @Test
    void TC_21_13() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("51");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("2");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Numero di squadre non valido";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());

    }

    @Test
    void TC_21_14() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("12");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("an");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Formato minimo partecipanti non valido";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_15() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("12");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("0");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        String message = "Numero minimo di partecipanti non valido";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_16() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("12");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("1");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("aap");
        String message = "Numero massimo di partecipanti non valido";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_17() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("12");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("1");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("20");
        String message = "Numero massimo di partecipanti non valido";
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                servlet.doPost(mockedRequest, mockedResponse));
        assertEquals(message, exception.getMessage());
    }

    @Test
    void TC_21_18() {
        Mockito.when(mockedRequest.getParameter("nome")).thenReturn("Champions Five");
        Mockito.when(mockedRequest.getParameter("sport")).thenReturn("Tennis");
        Mockito.when(mockedRequest.getParameter("tipo")).thenReturn("Eliminazione diretta");
        Mockito.when(mockedRequest.getParameter("struttura")).thenReturn("Partite singole");
        Mockito.when(mockedRequest.getParameter("dataInizio")).thenReturn("2021-12-5");
        Mockito.when(mockedRequest.getParameter("dataFine")).thenReturn("2021-12-15");
        Mockito.when(mockedRequest.getParameter("giornoPartite")).thenReturn("Giovedì");
        Mockito.when(mockedRequest.getParameter("maxSquadre")).thenReturn("12");
        Mockito.when(mockedRequest.getParameter("minPartecipanti")).thenReturn("1");
        Mockito.when(mockedRequest.getParameter("maxPartecipanti")).thenReturn("5");
        Admin admin = new Admin();
        admin.setNome("Emanuele");
        admin.setCognome("Mezzi");
        admin.setUsername("memex99");
        admin.setPassword("password");
        Campo campo = new Campo();
        campo.setIdentificativo(1002);
        campo.setSport("Tennis");
        Mockito.when(mockedRequest.getSession()).thenReturn(session);
        Mockito.when(mockedRequest.getSession().getAttribute("admin")).thenReturn(admin);
        Mockito.when(mockedRequest.getSession().getAttribute("campo")).thenReturn(campo);
        servlet.doGet(mockedRequest, mockedResponse);
        Mockito.verify(mockedResponse).setContentType("Creazione avvenuta");
    }

    @AfterAll
    void tearDown() {
        servlet = null;
        mockedRequest = null;
        mockedResponse = null;
        session = null;
    }
}