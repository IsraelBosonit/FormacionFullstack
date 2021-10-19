package com.example.BS4_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
@PropertySource("application.properties")
@Component
public class Propiedades {
    @Value("${url: no tiene valor}")
    private String url;
    @Value("${password: no tiene valor}")
    private String password;
    @GetMapping("/parametros")
    public void getPropiedades(){
        System.out.println("url:"+url+","+"password:"+password);
    }

}
