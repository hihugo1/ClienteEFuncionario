/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Fatec
 */
public class Pessoa {

    String lastName;
    String FirstName;

    public static ArrayList<Pessoa> getListEmployees() throws Exception {
        ArrayList<Pessoa> list = new ArrayList<Pessoa>();
        Class.forName("org.sqlite.JDBC");

        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employees order by firstName");
        while (rs.next()) {
            list.add(new Pessoa(rs.getString("EmployeeID"), rs.getString("firstName")));
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }
    
    public static ArrayList<Pessoa> getListCustomers() throws Exception {
        ArrayList<Pessoa> list = new ArrayList<Pessoa>();
        Class.forName("org.sqlite.JDBC");

        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customers order by firstName");
        while (rs.next()) {
            list.add(new Pessoa(rs.getString("CustomerId"), rs.getString("firstName")));
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }

   
     public static int getCountCustomers() throws Exception {
        int count = 0;
        Class.forName("org.sqlite.JDBC");
// Objeto de conexão com o banco de dados
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select count (*) as count from customers");
        while (rs.next()) {
            count = rs.getInt("count");
        }

        rs.close();
        stmt.close();
        con.close();
        return count;
    }
     
     public static int getCountEmployees() throws Exception {
        int count = 0;
        Class.forName("org.sqlite.JDBC");
// Objeto de conexão com o banco de dados
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select count (*) as count from employees");
        while (rs.next()) {
            count = rs.getInt("count");
        }

        rs.close();
        stmt.close();
        con.close();
        return count;
    }
    

    public Pessoa(String lastName, String FirstName) {
        this.lastName = lastName;
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

}
