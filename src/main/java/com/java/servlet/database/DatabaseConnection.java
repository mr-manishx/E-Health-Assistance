package com.java.servlet.database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
  
// This class can be used to initialize the database connection 
public class DatabaseConnection { 
    public static Connection initializeDatabase() 
        throws SQLException, ClassNotFoundException 
    { 
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "com.mysql.jdbc.Driver"; 
        String dbURL = "jdbc:mysql://localhost:3306/"; 
        // Database name to access 
        String dbName = "hospital_db"; 
        String dbUsername = "root"; 
        String dbPassword = "iesbpl@2024"; 
  
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(dbURL+dbName,dbUsername,dbPassword); 
        return con; 
    } 
} 

