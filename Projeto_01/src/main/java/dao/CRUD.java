package dao;

import java.util.List;

import model.Usuario;

public interface CRUD {
	
	boolean login(String email, String senha);
	
    void create(Usuario usuario);
    
    Usuario read(int id);
    
    List<Usuario> readAll();
    
    void update(Usuario usuario);
    
    void delete(int id);
}
