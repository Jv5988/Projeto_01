package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.MySqlConnection;
import model.Usuario;

public class UsuarioDao implements CRUD {

	public boolean login(String email, String senha) {
		String sql = "select * from Usuario where email = ? and password = ?";
		Connection connection = null;

		try {
			connection = MySqlConnection.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();

			return rs.next(); //Significa que existe um merda no banco de dados
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			MySqlConnection.closeConnection(connection);
		}

		return false;
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
	public Usuario read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
	}
}