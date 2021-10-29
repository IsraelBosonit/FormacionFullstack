package com.example.DB1.application.port;

import com.example.DB1.domain.Profesor;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService{
    @Override
    public void ComprobarNulos(Profesor p) throws Exception {
        if(p.getBranch()==null){
            throw new Exception("Branch no puede ser null");
        }

    }
}
