package fr.univ_amu.iut;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique {
    private Connection connection;
    private static ConnexionUnique instance = new ConnexionUnique();

    private ConnexionUnique(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://mysql-places.alwaysdata.net:3306/places_bdcours", "places_" , "Yotti");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){return connection;}
    public static ConnexionUnique getInstance(){return instance;}
}
