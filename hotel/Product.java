package hotel;

import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product_Info pi=new Product_Info();
        String choice = "";
            boolean status = true;


            while(status) {
                System.out.println("1:Display all Product\n2:Add to cart\n3:Dispaly all cart Item\n4:Dispaly Bill\n5:Exit");
                choice = sc.next();
                switch (choice) {
                    case "1":
                        pi.dispaly();
                        break;

                    case "2":
                        System.out.println("Enter product name");
                        String pname = sc.next();
                        System.out.println("Enter a qnt");
                        int qnt = sc.nextInt();
                        pi.addTocart(pname, qnt);
                        break;
                    case "3":
                        pi.addTocardDispay();
                        break;
                    case "4":
                        System.out.println("Enter product name");
                        String name = sc.next();
                        pi.bill(name);
                        break;
                    case "5":
                        status = false;
                        break;
                    default:
                        System.out.println("Enter a valid option");
                        //          choice = sc.nextInt();
                }
            }

        }

    }


