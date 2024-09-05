package dao;

import java.util.List;

import model.Conteudo;

public interface CRUD_conteudo {

    void criarConteudo(Conteudo conteudo);

    List<Conteudo> listarConteudos(int usuarioId);

    void atualizarConteudo(int id,String novoConteudo);

    void excluirConteudo(int id);
}
