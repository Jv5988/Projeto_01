package dao;

import model.Conteudo;
import db.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ConteudoDao implements CRUD_conteudo {

    @Override
    public void criarConteudo(Conteudo conteudo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySqlConnection.getConnection();
            String sql = "INSERT INTO conteudos (usuario_id, conteudo) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            for (String c : conteudo.getConteudos()) {
                preparedStatement.setInt(1, conteudo.getUsuarioId());
                preparedStatement.setString(2, c);
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar o conteúdo: " + e.getMessage());
        } finally {
            MySqlConnection.closeConnection(connection);
        }
    }

    @Override
    public List<Conteudo> listarConteudos() {
        return null;
    }

    @Override
    public void atualizarConteudo(Conteudo conteudo) {
    }

    @Override
    public void excluirConteudo(int id) {
    }
}
