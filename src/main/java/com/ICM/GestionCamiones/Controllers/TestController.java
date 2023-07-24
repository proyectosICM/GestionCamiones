package com.ICM.GestionCamiones.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; // Importa la clase HttpServletResponse

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class TestController {
    @GetMapping("/hola")
    public String  Saludo(){
        return "Hello word";
    }

    @PostMapping("/unprotected")
    public void unprotectedLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aquí puedes obtener los parámetros de usuario y contraseña desde la solicitud
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Luego, reenvía la solicitud al controlador protegido /login
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login");
        requestDispatcher.forward(request, response);
    }

    @GetMapping("/get-ip")
    public String getIPAddress(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        return "La petición fue realizada desde la IP: " + ipAddress;
    }
    @GetMapping("/redirigido")
    public void redirigido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aquí puedes obtener los parámetros de usuario y contraseña desde la solicitud
        // Los parámetros @RequestParam se obtienen directamente de la solicitud
        String ipAddress = request.getRemoteAddr();
        // Luego, reenvía la solicitud al controlador protegido /saludof
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/saludof");
        requestDispatcher.forward(request, response);
    }

    @GetMapping("/saludof")
    public String Saludof(HttpServletRequest request){
        String ipAddress = request.getRemoteAddr();
        return "saludo ya" + ipAddress;
    }
}

