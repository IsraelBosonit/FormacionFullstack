package com.example.BS4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controlador{

   @Autowired
   Propiedades propiedades;

    @GetMapping("/valores")
    public String getValores(){

        return("valor de var1 es:"+propiedades.getVar1()+"valor de my.var2 es"+propiedades.getVar2());
    }
    @GetMapping("/var3")
    public String getVar3(){
        return("valor de var3 es:"+propiedades.getVar3());
    }
}
