package com.example.BS4_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Controlador {
    @Value("${spring.profiles.active:}")
    private String activeProfile;
    @Autowired
    perfil1 perfil1;
    @Autowired
    perfil2 perfil2;
    @Autowired
    Propiedades propiedades;
    @Autowired
    Configuracion configuracion;

    @GetMapping("/perfil")
    public void getPerfil(){
        if(activeProfile.equals(perfil1.perfil)){
            perfil1.miFuncion();
        }else{
            if(activeProfile.equals(perfil2.perfil)){
                perfil2.miFuncion();
            }
        }
    }
    @GetMapping("/parametros")
    public void getPropiedades(){
        System.out.println("url:"+propiedades.getUrl()+","+"password:"+propiedades.getPassword());
    }
    @GetMapping("/miconfiguracion")
    public void getConfiguracion(){
        System.out.println("Valor1: "+configuracion.getValor1()+","+"Valor2: "+configuracion.getValor2());
    }

}
