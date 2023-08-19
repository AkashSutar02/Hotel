package hotel;

import java.util.Scanner;

public class CancleOrder {
    Scanner sc=new Scanner(System.in);

    public void cancle() {
        if(!(ShowItem.data.isEmpty())) {

            System.out.println("Enter a reason");
            // sc.nextLine();
            String reason = sc.nextLine();


            System.out.println("Enter a ypur UPI No");
            String upi1 = sc.next();
            if (upi1.equals(Bill.upi)) {
                System.out.println("Your order cancle succssfull..");
                ShowItem.data.clear();
            } else {
                System.out.println("you are paying by cash ..or please Enter a valide UPI");
            }

        }else {
            System.out.println("you are not place any order!!!!!!");
        }
    }
}
