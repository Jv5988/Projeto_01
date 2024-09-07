package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.MySqlConnection;
import model.Usuario;

public class UsuarioDao implements CRUD {

	public Integer login(String email, String senha) {
		String sql = "SELECT id FROM Usuario WHERE email = ? AND password = ?";
		Connection connection = null;
		Integer userId = null;

		try {
			connection = MySqlConnection.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				userId = rs.getInt("id");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			MySqlConnection.closeConnection(connection);
		}

		return userId;
	}

	@Override
	public void create(Usuario usuario) {
		String sql = "INSERT INTO Usuario(email, password) VALUES (?, ?)";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {

			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());

			pst.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> readAll() {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM Usuario";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String senha = rs.getString("password");

				Usuario usuario = new Usuario(id, email, senha);
				usuarios.add(usuario);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public void update(Usuario usuario) {
		String sql = "UPDATE Usuario SET email = ?, password = ? WHERE id = ?";

		try (Connection connection = MySqlConnection.getConnection();
				PreparedStatement pst = connection.prepareStatement(sql)) {

			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getPassword());
			pst.setInt(3, usuario.getId());

			pst.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int userId) {
		System.out.println("Id: " + userId);
		String usuariofk = "DELETE FROM conteudos WHERE usuario_id = ?";
		String usuariopk = "DELETE FROM Usuario WHERE id = ?";

		try (Connection connection = MySqlConnection.getConnection();

				PreparedStatement pst0 = connection.prepareStatement(usuariofk)) {
			pst0.setInt(1, userId);
			pst0.executeUpdate();

			try (PreparedStatement pst1 = connection.prepareStatement(usuariopk)) {
				pst1.setInt(1, userId);
				pst1.executeUpdate();
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}