package hotel;

import java.sql.*;

public class AdminOper implements HotelManage{


    static Connection con;
    static {
        try {

            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","Akash@02");
        } catch (SQLException e) {
            System.out.println(e);
        }


    }



    @Override
    public void update_data(String today, String itm, int price) {
        boolean s=false;
        Statement stmt;
        String q1="select * from "+today;
        try {
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(q1);
            while (rs.next()){
                if (rs.getString(1).equals(itm)){
                    PreparedStatement pstmt;
                    String query="update "+today+" set price=? where item=?";
                    try {
                        pstmt=con.prepareStatement(query);
                        //  pstmt.setString(1,today);
                        pstmt.setInt(1,price);
                        pstmt.setString(2,itm);
                        int cout=pstmt.executeUpdate();
                        System.out.println(cout+"  Upadated successfull...");
                        s=true;



                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (!s){
            System.out.println(itm +" not found");
        }


    }

    @Override
    public void insert_Data(String tableName, String item_Name, double price) {

        PreparedStatement pstmt;
        String query="insert into "+tableName+ " values(?,?)";
        try {
            pstmt=con.prepareStatement(query);
            pstmt.setString(1,item_Name);
            pstmt.setDouble(2,price);
            pstmt.executeUpdate();
            System.out.println("Inserted succussesfully!!!!!");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove_Data(String tableName, String item) {
        boolean b=false;
        PreparedStatement pstmt;
        Statement stmt;
        String q="select * from "+tableName;
        String query="delete from "+tableName+" where item=?";
        try {
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(q);
            while (rs.next()){
                if (rs.getString(1).equals(item)){
                    pstmt=con.prepareStatement(query);
                    pstmt.setString(1,item);
                    pstmt.executeUpdate();
                    b=true;
                    System.out.println("Item deleted Succusfullyyyy!!!");

                }
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (!b){
            System.out.println(item+"   not found");
        }


    }

    @Override
    public void Display_Data(String tablename) {

        Statement stmt;
        String Query="select * from "+tablename;
        try {
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(Query);
            while (rs.next()){
                System.out.println(rs.getString(1)+"    "+rs.getDouble(2));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void userDatails() {
        Statement stmt;
        String query="select * from registertable";
        try {
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getLong(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getString(5));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
