package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import db.MySqlConnection;
import model.Conteudo;

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
                preparedStatement.setInt(1, conteudo.getUsuarioId()); //o ID do user é definido
                preparedStatement.setString(2, c); //O texto do conteudo
                preparedStatement.addBatch(); //adiciona no banco
            }

            int[] linha = preparedStatement.executeBatch();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar o conteúdo: " + e.getMessage());
        } finally {
            MySqlConnection.closeConnection(connection);
        }
    }

    @Override
    public List<Conteudo> listarConteudos(int usuarioId) {
        List<Conteudo> conteudos = new ArrayList<>();
        String sql = "SELECT * FROM conteudos WHERE usuario_id = ?";

        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setInt(1, usuarioId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String conteudo = rs.getString("conteudo");
                Conteudo conteudoObj = new Conteudo(usuarioId, Collections.singletonList(conteudo));
                conteudoObj.setId(id);
                conteudos.add(conteudoObj);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conteudos;
    }

    public void atualizarConteudo(int id, String novoConteudo) {
        String sql = "UPDATE conteudos SET conteudo = ? WHERE id = ?";

        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setString(1, novoConteudo);
            pst.setInt(2, id);
            int linha = pst.executeUpdate();
            System.out.println("numero de linhas: " +linha);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluirConteudo(int id) {
        String sql = "DELETE FROM conteudos WHERE id = ?";

        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("O erro está na classe ConteudoDao");
        }
    }

}
