package dao;

import java.util.List;

import model.Conteudo;

public interface CRUD_conteudo {

    void criarConteudo(Conteudo conteudo);

    List<Conteudo> listarConteudos(int usuarioId);
    
    List<Conteudo> listarTodosConteudos();

    void atualizarConteudo(int id,String novoConteudo);

    void excluirConteudo(int id);
}
