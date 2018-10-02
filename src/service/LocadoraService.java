package service;


import entities.Filme;
import entities.Locacao;
import entities.Usuario;
import exception.ListaDeFilmeVaziaException;
import exception.LocadoraException;
import exception.UsuarioInvalidoException;
import java.util.Date;
import java.util.List;
import static utils.DataUtils.adicionarDias;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nathan
 */
public class LocadoraService {
    public Locacao alugarFilmes(Usuario usuario, List<Filme> filmes) throws LocadoraException, UsuarioInvalidoException, ListaDeFilmeVaziaException{
        
        if (usuario == null) {
            throw new UsuarioInvalidoException("Usuario invalido.");
        }
        if (filmes.isEmpty()) {
            throw new ListaDeFilmeVaziaException("Lista de filmes vazio.");
        }
        for(Filme f : filmes){
            if (f.getEstoque()==0) {
                throw new LocadoraException("Filme sem estoque.");
            }
        }
        
        
        Locacao locacao = new Locacao();
        locacao.setFilmes(filmes);
        locacao.setUsuario(usuario);
        
        double valor = 0;
        
        for(Filme f : locacao.getFilmes()){
            valor += f.getPrecoLocacao();
        }
        locacao.setValor(valor);
        
        locacao.setDataLocacao(new Date());
        
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        locacao.setDataRetorno(dataEntrega);
        
        return locacao;
    }
}
