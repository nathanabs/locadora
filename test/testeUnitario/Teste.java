/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeUnitario;

import org.junit.Before;
import org.junit.Test;
import service.LocadoraService;

/**
 *
 * @author Nathan
 */
public class Teste {
    private LocadoraService locadoraService;
    
    @Before
    public void setup(){
        locadoraService = new LocadoraService();
    }
    
    @Test
    public void alugarMaisDeUmFilmePorVez(){
        
    }
}
