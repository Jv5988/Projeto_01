package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/projeto_01";
    private static final String USER = "root";
    private static final String PASSWORD = "bbmp5988";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
}

//VOCES VÃO CONFIGURAR O BANCO DE VOCÊS ASSIMMMMMMMMMMM
//SE VOCES TIVEREM PROBLEMA NO DRIVER DO MYSQL, VOCES PODEM BAIXAR UM DA VERSÃO DO MYSQL DE VOCES, QUE TÁ NA PASTA LIB
/*create database projeto_01;

create table Usuario(
	id int not null auto_increment primary key,
    email varchar(50) not null,
    password varchar(50) not null,
    conteudos varbinary(255)
);

CREATE TABLE conteudos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    conteudo TEXT,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);*/