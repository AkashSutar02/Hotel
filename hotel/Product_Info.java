package hotel;

import java.sql.*;

public class Product_Info {
    static Connection con;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/productdata","root","Akash@02");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void dispaly(){
        Statement stmt;
        String query="select * from productinfo";
        try {
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getDouble(4));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addTocart(String pname, int qnt) {
        boolean b=false;

        Statement stmt;
        String query="select * from productinfo";
        try {
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()){
             if (pname.equals(rs.getString(2))&&qnt<=rs.getInt(3)){
                PreparedStatement psmt;
                 String q1="insert into addtocart values(?,?,?)";
                    psmt=con.prepareStatement(q1);
                    psmt.setString(1,pname);
                    psmt.setInt(2,qnt);
                    psmt.setDouble(3,rs.getDouble(4));
                    psmt.executeUpdate();
                 System.out.println("Added succussfully..");

                b=true;

             }


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (!b){
            System.out.println("miss match information and stock over flow");
        }


    }


    public void addTocardDispay()  {
        Statement stmt;
        String query="select * from addtocart";
        try {
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getDouble(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void bill(String name) {
        Statement stmt;
        String  query="select * from addtocart";
        try {
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()){
                if (rs.getString(1).equals(name)){
                    double total=rs.getInt(2)*rs.getDouble(3);
                    total=total*1.18;
                    System.out.println("bill is  "+total);
                }
                else{
                    System.out.println("cart not found");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
