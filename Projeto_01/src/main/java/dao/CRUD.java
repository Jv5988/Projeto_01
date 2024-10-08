package dao;

import java.util.List;

import model.Usuario;

public interface CRUD {
	
	Integer login(String email, String senha);
	
    void create(Usuario usuario);
    
    List<Usuario> readAll();
    
    void update(Usuario usuario);
    
    void delete(int id);
}
