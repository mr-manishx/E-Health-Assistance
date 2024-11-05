package com.java.servlet.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.java.servlet.database.DatabaseConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet("/AdminRegister")
public class AdminRegister extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int i = 0;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        try {
            String userp = request.getParameter("email");
            String passp = request.getParameter("pass");
            String rpassp = request.getParameter("re_pass");
            String tikbox = request.getParameter("agree-term");

            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement pst = con.prepareStatement("insert into adminreg values(?,?)");
            pst.setString(1, userp);
            pst.setString(2, passp);
            i = pst.executeUpdate();
            if (i > 0) {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Registerd Successfully..!');");
                pw.println("window.location.href = \"adminLogin.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
                //rd.forward(request, response);
            } else {
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Username or Password is Incorrect..!');");
                pw.println("window.location.href = \"adminRegister.jsp\";");
                pw.println("</script>");
                //RequestDispatcher rd = request.getRequestDispatcher("adminRegister.jsp");
                //rd.forward(request, response);
            }

        } catch (Exception e) {

        }

    }

}