
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.Persona;
import com.portfolio.mgb.Interface.IpPersonaService;
import com.portfolio.mgb.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IpPersonaService{
    @Autowired IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona);

    }

    @Override
    public void deletPersona(Long Id) {
        ipersonaRepository.deleteById(Id);
    }

    @Override
    public Persona findPersona(Long Id) {
      Persona persona = ipersonaRepository.findById(Id).orElse(null);
      return persona;
    }
    
}

