
package com.portfolio.mgb.Interface;

import com.portfolio.mgb.Entity.Persona;
import java.util.List;

public interface IpPersonaService {
    
        public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletPersona(Long Id);
    
    public Persona findPersona(Long Id);
}











