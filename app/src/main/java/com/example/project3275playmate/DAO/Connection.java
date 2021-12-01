package com.example.project3275playmate.DAO;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public java.sql.Connection connect() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/playmate?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT", "root","");
        return con1;
    }
}
