package hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ShowItem {


    static  ArrayList<Double> data=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    static Connection con=null;
    PreparedStatement psmt=null;
    Statement stmt=null;
    static {
        try {

            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","Akash@02");
        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public void todaySpecial() {
        String query=" select * from today";

        try {
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString(1)+"\t\t"+rs.getDouble(2));
            }
            boolean s=true;
            while (s){
                System.out.println("Do you want buy item press 1 or 2 for nothing");
                int i=sc.nextInt();
                if (i==1){
                    System.out.println("Enter a item name");
                    String item=sc.next();
                    rs=stmt.executeQuery(query);
                    while (rs.next()){
                        if (rs.getString(1).equals(item)){
                               data.add(rs.getDouble(2));
                        }
                    }

                }else {
                    s=false;
                }
            }


        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public void veg() {
        String query=" select * from veg";

        try {
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString(1)+"\t\t"+rs.getDouble(2));
            }

            boolean s=true;
            while (s){
                System.out.println("Do you want buy item press 1 or 2 for nothing");
                int i=sc.nextInt();
                System.out.println("==================================");
                if (i==1){
                    System.out.println("Enter a item name");
                    String item=sc.next();
                    rs=stmt.executeQuery(query);
                    while (rs.next()){
                        if (rs.getString(1).equals(item)){
                            data.add(rs.getDouble(2));
                        }
                    }

                }else {
                    s=false;
                }
            }



        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public void nonveg() {
        String query=" select * from nonveg";


        try {
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString(1)+"\t\t"+rs.getDouble(2));
            }

            boolean s=true;
            while (s){
                System.out.println("Do you want buy item press 1 or 2 for nothing");
                int i=sc.nextInt();
                if (i==1){
                    System.out.println("Enter a item name");
                    String item=sc.next();
                    rs=stmt.executeQuery(query);

                    while (rs.next()){
                        if (rs.getString(1).equals(item)){

                         data.add(rs.getDouble(2));
                        }
                    }

                }else {
                    s=false;
                }
            }


        } catch (SQLException e) {
            System.out.println(e);
        }


    }







}
