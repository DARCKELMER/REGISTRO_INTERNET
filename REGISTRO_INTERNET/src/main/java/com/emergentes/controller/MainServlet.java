
package com.emergentes.controller;

import com.emergentes.dao.EstudianteDAO;
import com.emergentes.dao.EstudianteDAOimpl;
import com.emergentes.model.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            EstudianteDAO dao = new EstudianteDAOimpl();
            int id;
            Estudiante estudiante = new Estudiante();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            System.out.println(action);

            switch (action) {
                case "add":
                    request.setAttribute("estudiante", estudiante);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    estudiante=dao.getById(id);
                    
                    request.setAttribute("estudiante", estudiante);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    
                    response.sendRedirect(request.getContextPath()+"/MainServlet");
                    break;
                case "view":
                    List<Estudiante> lista = dao.getAll();
                                       
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String seminario = request.getParameter("seminario");
        String confirmadoString = request.getParameter("confirmado");
        int confirmado;
        
        System.out.println("valor de id  "+id);
        
        if(confirmadoString != null){
            confirmado = 1;
        }else{
            confirmado = 0;
        }

        Estudiante estudiante = new Estudiante();
                
        estudiante.setFecha(fecha);
        estudiante.setId(id);
        estudiante.setNombres(nombres);
        estudiante.setApellidos(apellidos);
        estudiante.setSeminario(seminario);
        estudiante.setConfirmado(confirmado);

        

        if (id == 0) {
            
            System.out.println("adentro nuevo");
            try {
                EstudianteDAO dao = new EstudianteDAOimpl();
                dao.insert(estudiante);
                response.sendRedirect(request.getContextPath() + "/MainServlet");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        } else {
            
            System.out.println("adentro editar");
            try {
                EstudianteDAO dao = new EstudianteDAOimpl();
                dao.update(estudiante);
                response.sendRedirect(request.getContextPath() + "/MainServlet");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        
    }

}
