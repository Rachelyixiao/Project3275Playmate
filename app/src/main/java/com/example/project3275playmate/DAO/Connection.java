package com.example.project3275playmate.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public java.sql.Connection connect() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/PlayMate", "root","");
        return con1;
    }
}
