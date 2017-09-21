package fr.univ_amu.iut;

import java.sql.*;

/**
 * Created by p16008212 on 21/09/17.
 */
public class TestConnection {
    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion");
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");

            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}
