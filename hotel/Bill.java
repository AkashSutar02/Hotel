package hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class Bill {
    Scanner sc=new Scanner(System.in);
    double total=0.0;

    static  String upi="";

   public  void getBill(){
       double bill=0.0;
       if (!(ShowItem.data.isEmpty())){
           for (double a:ShowItem.data){
               total=bill+=a;
           }


           System.out.println("\n1 Cash\n2 UPI");
           int ch=sc.nextInt();
           if (ch==1){
               if (bill>2000){

                   total=total-total*0.02;
                   total=total+total*0.18;
                   total=total+50;

               }
               else {
                   total=total+total*0.18;
                   total=total+50;
               }
           } else if (ch==2) {

               System.out.println("Enter a UPI ID");
               upi= sc.next();

               total=total+total*0.18;
               total=total+50;

           }


       }
       else {
           System.out.println("please place the order..");
       }
       System.out.println("Your Bill is :"+total);
       //ShowItem.data.clear();

  }


//  public static boolean up(){
//       if (upi==null){
//           return false;
//       }
//       else {
//           return true;
//       }
//  }


}
