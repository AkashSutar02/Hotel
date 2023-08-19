package hotel;

import java.sql.*;
import java.util.Scanner;

public class Login {
    Scanner sc=new Scanner(System.in);

    static Connection con=null;
    Statement stmt;
    static {
        try {

            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","Akash@02");
        } catch (SQLException e) {
            System.out.println(e);
        }


    }

     public  boolean login(){
        boolean status=false;
        System.out.println("Enter a Mobile Number:");
        long contact=sc.nextLong();
        System.out.println("Enter a Password:");
        String pass=sc.next();

        try {

            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select contact,password from registertable");
            while (rs.next()){
                if(rs.getLong(1)==contact&&rs.getString(2).equals(pass)){

                    status=true;
                }
            }



        } catch (SQLException e) {
            System.out.println(e);
        }

        return status;
    }

}
