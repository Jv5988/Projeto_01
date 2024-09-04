package dao;

import java.util.List;

import model.Conteudo;

public interface CRUD_conteudo {

    void criarConteudo(Conteudo conteudo);

    List<Conteudo> listarConteudos();

    void atualizarConteudo(Conteudo conteudo);

    void excluirConteudo(int id);
}
