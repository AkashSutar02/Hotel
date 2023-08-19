package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RegisterUser {
    Scanner sc=new Scanner(System.in);
    static Connection con=null;
    PreparedStatement pstmt;
    static {
        try {

            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","Akash@02");
        } catch (SQLException e) {
            System.out.println(e);
        }


    }


    public void register(){
        int uppar=0,lower=0,special=0,coount=0,digit=0;
        System.out.println("Enter a Contact Number");
        Long contact=sc.nextLong();
        System.out.println("Enter a name");
        String name=sc.next();
        System.out.println("Enter a Address");
        sc.nextLine();
        String address=sc.nextLine();
        System.out.println("Enter a pincode");
        int pincode=sc.nextInt();
        System.out.println("Enter a password");
        String pass=sc.next();
        System.out.println("Enter a conform password");
        String pass1=sc.next();

        for (int i=0;i<pass.length();i++) {
            char ch=pass.charAt(i);
            //||pass.length()>=8||)
            if (ch>=65&&ch<=91) {

                uppar++;

            }
            if (ch>=97&&ch<=123) {
                lower++;
            }
            if (ch>33&&ch<=41||ch==64) {
                special++;

            }
            if(ch>=48&&ch<=57){
                digit++;

            }

        }
        while(!(lower>=1&&special>=1&&uppar>=1&&pass.length()>=8&&digit>=1)) {
            System.out.println("Please Enter a valide passward");
            pass=sc.next();
            System.out.println("Enter a conform password");
            pass1=sc.next();

        }



        long temp=contact;
        while (temp!=0){
            coount++;
            temp=temp/10;
        }
        while (!(coount==10)){
            System.out.println(coount);
            System.out.println("Enter a valde contact number");
            contact=sc.nextLong();
        }
        while (!(pass.equals(pass1))){
            System.out.println("Please Enter password");
            pass=sc.next();
            System.out.println("please conform password");
            pass1=sc.next();
        }


        String query="insert into registertable values(?,?,?,?,?)";

        try {
            pstmt=con.prepareStatement(query);
            pstmt.setLong(1,contact);
            pstmt.setString(2,name);
            pstmt.setString(3,address);
            pstmt.setInt(4,pincode);
            pstmt.setString(5,pass);
            pstmt.executeUpdate();
            System.out.println("Register succesfully.........");

        } catch (SQLException e) {
            System.out.println(e);
        }


    }

}
