package com.example.BS4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Configuration
@PropertySource("application.yaml")
@Component
public class Propiedades {
    @Value("${VAR1: var1 no tiene valor}")
    private String var1;
    @Value("${MyVAR2: var2 no tiene valor}")
    private String var2;
    @Value("${VAR3: var3 no tiene valor}")
    private String var3;

    public String getVar1() {
        return var1;
    }

    public String getVar2() {
        return var2;
    }

    public String getVar3() {
        return var3;
    }
}
