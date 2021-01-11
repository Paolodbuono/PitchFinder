package com.pitchfinder.evento.controller;

import com.pitchfinder.evento.entity.Evento;
import com.pitchfinder.evento.services.EventoService;
import com.pitchfinder.evento.services.EventoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@WebServlet("/EventoDetailsController")
public class EventoDetailsController extends HttpServlet {

    /**
     * doPost() method.
     * @param request is the servlet request.
     * @param response is the servlet response.
     */
    public void doPost(final HttpServletRequest request,
                       final HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * doGet() method.
     * @param request is the servlet request.
     * @param response is the servlet response.
     */
    public void doGet(final HttpServletRequest request,
                      final HttpServletResponse response) throws ServletException, IOException {

        Evento evento;
        EventoService service = new EventoServiceImpl();
        String nome = request.getParameter("eventName");
        Date data = Date.valueOf(request.getParameter("eventDate"));
        evento = service.getEvento(nome,data);
        request.setAttribute("eventoDetails",evento);
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/view/evento/eventoDetails.jsp");
        dispatcher.forward(request, response);
    }
}