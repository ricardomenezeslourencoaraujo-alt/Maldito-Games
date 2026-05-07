package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection instance;


    private Connection connection;

   
    private static final String URL = "jdbc:postgresql://localhost:5432/banco_maldito";
    private static final String USER = "Gamer";
    private static final String PASSWORD = "riadgari";

    // Construtor PRIVADO (ninguém pode dar "new DBConnection()")
    private DBConnection() {
        try {
            // Carrega o driver (opcional em versões modernas, mas seguro)
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do PostgreSQL não encontrado!", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados!", e);
        }
    }

    // Método público que retorna a única instância (Singleton com double-checked locking)
    public static DBConnection getInstance() {
        if (instance == null) { // 1ª verificação (rápida)
            synchronized (DBConnection.class) {
                if (instance == null) { // 2ª verificação (segura)
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

    // Retorna a conexão para os DAOs usarem
    public Connection getConnection() {
        return this.connection;
    }

    // Fecha a conexão (opcional, mas útil ao encerrar a aplicação)
    public void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                instance = null; // permite recriar se necessário
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar conexão", e);
        }
    }
}