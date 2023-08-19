package hotel;

import java.util.Scanner;

public class FrontendHotel {
    public static void main(String[] args) {

        boolean login=false;
        Scanner sc=new Scanner(System.in);

        System.out.println("1:Admin\n2:User");
        int c= sc.nextInt();
        if (c==1){
            System.out.println("Enter Username");
            String user=sc.next();
            System.out.println("Enter a password");
            String pass=sc.next();
            new AdminManage().admin(user,pass);
        } else if (c==2) {

        boolean status=true;
        while (status){
            System.out.println("1:Display Menu.\n2:View Bill\n3:Cancel Oreder\n4:Exit");
            int choice=sc.nextInt();
            if (choice==1){

                System.out.println("1:Already have an account.\n2:Enter a new register");
                int ch=sc.nextInt();

                if (ch==1){

                    if (login=new Login().login()){
                        System.out.println("Login Succesfully..");

                        ShowItem si=new ShowItem();

                        boolean s=true;
                        while (s){
                            System.out.println("1:Todays Special\n2:veg\n3:nonveg\n4:Get Bill");
                            int itemChoice=sc.nextInt();
                            if (itemChoice==1){
                                si.todaySpecial();

                            } else if (itemChoice==2) {
                                si.veg();

                            } else if (itemChoice==3) {
                                si.nonveg();

                            }else {
                                System.out.println("Order place successful.....");
                                s=false;
                            }
                        }

                    }
                    System.out.println("Plase check contact number or password..");


                } else if (ch==2) {

                    RegisterUser user=new RegisterUser();
                    user.register();

                }

            } else if (choice==2) {

                Bill b=new Bill();
                b.getBill();

            } else if (choice==3) {
                CancleOrder co=new CancleOrder();
                co.cancle();

            } else if (choice==4) {
                status=false;

            }
        }

    }
        else {
            System.out.println("Select vaalide option");
        }

    }
}
