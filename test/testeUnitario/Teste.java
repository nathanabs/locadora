/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeUnitario;

import entities.Filme;
import entities.Locacao;
import entities.Usuario;
import exception.ListaDeFilmeVaziaException;
import exception.LocadoraException;
import exception.UsuarioInvalidoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
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
    public void setup() {
        locadoraService = new LocadoraService();
    }

    @Test
    public void alugarMaisDeUmFilmePorVez() throws UsuarioInvalidoException, ListaDeFilmeVaziaException {
        List<Filme> filmes = new ArrayList<>();

        filmes.add(new Filme("filme1", 2, 4));
        filmes.add(new Filme("filme2", 4, 5));
        filmes.add(new Filme("filme3", 1, 5));

        Usuario usuario = new Usuario("Nathan");

        try {
            Locacao l = locadoraService.alugarFilmes(usuario, filmes);

            int contador = l.getFilmes().size();

            Assert.assertThat(contador, CoreMatchers.is(CoreMatchers.equalTo(3)));

        } catch (LocadoraException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

    }

    @Test
    public void SemEstoqueDeFilme() throws UsuarioInvalidoException, ListaDeFilmeVaziaException {
        List<Filme> filmes = new ArrayList<>();

        filmes.add(new Filme("filme1", 2, 4));
        filmes.add(new Filme("filme2", 4, 5));
        filmes.add(new Filme("filme3", 0, 5));

        Usuario usuario = new Usuario("Nathan");

        try {
            Locacao l = locadoraService.alugarFilmes(usuario, filmes);
            Assert.fail();

        } catch (LocadoraException ex) {
            Assert.assertThat(ex.getMessage(), CoreMatchers.is(CoreMatchers.equalTo("Filme sem estoque.")));
        }
    }

    @Test(expected = ListaDeFilmeVaziaException.class)
    public void listaDeFilmeNull() throws UsuarioInvalidoException, LocadoraException, ListaDeFilmeVaziaException {
        Usuario usuario = new Usuario("Nathan");
        List<Filme> filmes = new ArrayList<>();

        Locacao l = locadoraService.alugarFilmes(usuario, filmes);
    }
}
