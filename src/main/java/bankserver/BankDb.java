package bankserver;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//This class handles the connection to a database

public class BankDb {

    //Connect
    //getQuery
    //putQuery


    public static String url = "jdbc:h2:file:D:/004 - Si/assignment-002/src/main/resources/data";
    public static String user = "";
    public static String password = "";
    public static String driver = "org.h2.Driver";

    public BankDb() {
        //Setting up the database.
        String sql = "drop table if exists bankcustomer;";
        executeH2(sql);
        sql = "Create table bankcustomer (ID INT auto_increment PRIMARY KEY, NAME VARCHAR(30));";
        executeH2(sql);
    }

    public void getSize(){
        try
        {
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM bankcustomer;";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getInt(1) + " : " + rs.getString(2));
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Error : " + e);
        }
    }


    public void insertNewCustomer (String name ){
        String sql = "insert into bankcustomer(Name) values ('"+ name + "'); ";
        System.out.println(sql);
        executeH2(sql);
    }


    public int getDatabaseSize(){
        int temp =1020;
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT value FROM INFORMATION_SCHEMA.SETTINGS WHERE NAME = 'info.PAGE_COUNT';";
            System.out.println(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("1");
            ResultSet rs = ps.executeQuery();
            System.out.println("2");
            while(rs.next()) {
                System.out.println(rs.getInt(1));
                temp = rs.getInt(1);
            con.close();
            }
        }
        catch(Exception e ){

        }
        return temp * 4;
    }

    private void executeH2 (String sql){
        Statement stmt = null;
        try {
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            stmt.execute(sql);
            con.close();
            System.out.println("Did execute in DB");
        }
        catch (Exception e){
            System.out.println("Error : " + e );
        }
    }
    }


    //getSize
    //SELECT `VALUE` FROM INFORMATION_SCHEMA.SETTINGS WHERE NAME = 'info.FILE_SIZE';



