package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminManage {

    AdminOper aop=new AdminOper();

        Scanner sc=new Scanner(System.in);
    public void admin(String Username,String password) {
        if (Username.equals("admin") && password.equals("Akash@02")) {


            boolean status = true;
            while (status) {
                System.out.println("1:Today's_Specials\n2:Veg\n3:NonVeg\n4:Display All details of User\n5: Exit");
                int choice=sc.nextInt();

                switch (choice){
                    case 1: todaySpecial();
                    break;
                    case 2:veg();break;
                    case 3:nonVeg();break;
                    case 4:aop.userDatails();break;
                    default: status=false;

                }

            }
        }
    }

        public void todaySpecial () {

            System.out.println("1:Update data.. \n2:Dispaly data..\n3:Insert_Data\n4:Delete_Data");
            int choice=sc.nextInt();
            if (choice==1){
                System.out.println("Enter a Item name");
                String itm=sc.next();
                System.out.println("Enter a price");
                int price=sc.nextInt();
                aop.update_data("today",itm,price);
            } else if (choice==2) {
                aop.Display_Data("today");
            } else if (choice==3) {
                System.out.println("Enter a item name");
                String item=sc.next();
                System.out.println("Enter a price");
                double price=sc.nextDouble();
                aop.insert_Data("today",item,price);
            } else if (choice==4) {
                System.out.println("Enter a deleted item name");
                String itm=sc.next();
                aop.remove_Data("today",itm);

            }

        }


        public void veg () {
            System.out.println("1:Update data.. \n2:Display data..\n3:Insert_Data\n4:Delete_Data");
            int choice=sc.nextInt();
            if (choice==1){
                System.out.println("Enter a Item name");
                String itm=sc.next();
                System.out.println("Enter a price");
                int price=sc.nextInt();
                aop.update_data("veg",itm,price);
            }
            else if (choice==2) {
                aop.Display_Data("veg");
            } else if (choice==3) {
                System.out.println("Enter a item name");
                String item=sc.next();
                System.out.println("Enter a price");
                double price=sc.nextDouble();
                aop.insert_Data("veg",item,price);
            } else if (choice==4) {
                System.out.println("Enter a deleted item name");
                String itm=sc.next();
                aop.remove_Data("veg",itm);

            }

        }


        public void nonVeg () {

            System.out.println("1:Update data.. \n2:Display data..\n3:Insert_Data\n4:Delete_data");
            int choice=sc.nextInt();
            if (choice==1){
                System.out.println("Enter a Item name");
                String itm=sc.next();
                System.out.println("Enter a price");
                int price=sc.nextInt();
                aop.update_data("nonveg",itm,price);
            }
            else if (choice==2) {
                aop.Display_Data("nonveg");
            } else if (choice==3) {
                System.out.println("Enter a item name");
                String item=sc.next();
                System.out.println("Enter a price");
                double price=sc.nextDouble();
                aop.insert_Data("nonveg",item,price);
            } else if (choice==4) {
                System.out.println("Enter a deleted item name");
                String itm=sc.next();
                aop.remove_Data("nonveg",itm);

            }



        }


}
