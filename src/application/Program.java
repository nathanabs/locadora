/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Filme;
import entities.Usuario;
import entities.Locacao;
import exception.LocadoraException;
import java.util.ArrayList;
import java.util.List;
import service.LocadoraService;

/**
 *
 * @author Nathan
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Filme> filmes = new ArrayList<>();
        
        filmes.add(new Filme("f1", 2, 4));
        filmes.add(new Filme("f2", 4, 5));
        
        Usuario u = new Usuario("Nathan");
        
        Locacao l = new Locacao();
        
        LocadoraService locadoraService = new LocadoraService();
        
        try{
        l = locadoraService.alugarFilmes(u, filmes);
            System.out.println(l.getUsuario().getNome());
            for(Filme f : l.getFilmes()){
                System.out.println(f.getNome());
            }
        }catch(LocadoraException e){
            System.out.println("Erro: "+ e.getMessage());
        }
        
    }
    
}
