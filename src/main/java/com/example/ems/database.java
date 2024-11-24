package com.example.ems;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {

    public static Connection connectDb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","","root");
            return con;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
