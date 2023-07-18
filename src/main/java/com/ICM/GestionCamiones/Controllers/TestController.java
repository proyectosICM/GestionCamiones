package com.ICM.GestionCamiones.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/helloword")
    public String  Saludo(){
        return "Hello word";
    }
}
