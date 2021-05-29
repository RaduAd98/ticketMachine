/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticketmachine;

import java.sql.*;

/**
 *
 * @author Radu
 */
public class DataBase {

    //Method that returns movie title by code
    public String getMovieName(String code) {
        String valuesTitle = "";
        try {
            Connection conObj = DriverManager.getConnection("jdbc:derby://localhost:1527/MovieDB", "use", "use");
            Statement statObj = conObj.createStatement();
            ResultSet resObj = statObj.executeQuery("Select TITLE from MOVIES WHERE CODE = '" + code + "'");
            while (resObj.next()) {
                valuesTitle = resObj.getString("TITLE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valuesTitle;
    }
}
