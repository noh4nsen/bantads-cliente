package com.bantads.cliente.bantadscliente.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("analises")
public class AnaliseController {
    @GetMapping("/health")
    public String health() {
        return "ʕ·͡ᴥ·ʔ";
    }    
}
