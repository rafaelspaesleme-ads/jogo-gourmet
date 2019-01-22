/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gourmet.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael S. Paes Leme - Desenvolvedor Java|PHP|MySQL|Postgree
 */
public class conexaoGourmet {
    
       private static String recebe_driver, recebe_url, recebe_usuario, recebe_senha;

    public static void carrega_bd() {

        try {
            // strings de valores 
            // strings de conexão
            String banco = "jdbc:postgresql://localost/joguim";
            String usuario = "root";
            String senha = "*****";
            String nomedodriver = "org.postgresql.Driver";
            Class.forName(nomedodriver).newInstance();

            recebe_driver = nomedodriver;
            recebe_url = banco;
            recebe_usuario = usuario;
            recebe_senha = senha;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Problemas ao tentar conectar com o banco de dados. informação do erro: " + e);
        }

    }

    Connection connection = null;
    static conexaoGourmet instance = null;

    public static Connection GeraConexao() throws ClassNotFoundException {
        Connection conexao = null;

        try {
            carrega_bd();

            //String driverName = "com.mysql.jdbc.Driver";
            String driverName = recebe_driver;

            Class.forName(driverName);

            String url = recebe_url;
            String usuario = recebe_usuario;
            String senha = recebe_senha;
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso.");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao tentar conectar: " + e.getMessage());
            conexao = null;
        }
        return conexao;
    }

    public static conexaoGourmet getInstance() throws Exception {
        if (instance == null) {
            instance = new conexaoGourmet();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
