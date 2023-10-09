package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static IBank createAcc(ArrayList<IBank> B) {
        int choice;
        String name, accno, accType;
        long balance;
        boolean found;

        IBank customer_1;

        System.out.println("Enter Your Bank:" );
        System.out.println("1.NSB 2.BOC");
        Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            System.out.println("Enter Your Name: ");
            name = sc.next();
            System.out.println("Enter Your Account No: ");
            accno = sc.next();
            System.out.println("Enter Your Account Type: ");
            accType = sc.next();
            System.out.println("Enter Your Balance: ");
            balance = sc.nextLong();

        found = false;

        for (int i = 0; i < B.size(); i++){
            found = B.get(i).search(accno);

            if (found) {
                System.out.println("Entered Account No Already Exists");
                break;
            }
        }

        if (!found) {
            switch(choice) {
                case 1 : if (balance < 1000){
                    System.out.println("Minimum balance is 1000.");
                }
                else {
                    customer_1 = new NSB(name, accno, accType, balance);
                    System.out.println("Account Created in NSB Bank!");
                    return customer_1;
                }
                    break;

                case 2 : if (balance < 2000){
                    System.out.println("Minimum balance is 2000.");
                }
                else {
                    customer_1 = new BOC(name, accno, accType, balance);
                    System.out.println("Account Created in BOC Bank!");
                    return customer_1;
                }
                    break;

                default :
                    System.out.println("Wrong Choice!");
            }
        }

        return null;
    }


    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            ArrayList<IBank> B = new ArrayList<>();
            System.out.println("No account found. Plaese create an account");
            IBank customer_1 = createAcc(B);

            if(customer_1 != null){
                B.add(customer_1);
            }

            int ch;

            do {
                System.out.println("\n #Banking System");
                System.out.println(" 1. Create an account \n 2. Display all account details \n 3. Search by account no\n 4. Deposit amount\n 5. Withdraw amount\n 6.Exit");
                System.out.println("Enter Your Choice: ");
                ch = sc.nextInt();

                switch(ch) {
                    case 1 : IBank customer = createAcc(B);
                        if (customer != null) {
                            B.add(customer);
                        }
                        break;

                    case 2 :
                        if(B.isEmpty()){
                            System.out.println("No account found");
                        }
                        for (int i = 0; i < B.size(); i++) {
                            B.get(i).showAccount();
                        }
                        break;

                    case 3 :
                        System.out.print("Enter account no, you want to search: ");
                        String acc_no = sc.next();
                        boolean found = false;
                        for (int i = 0; i < B.size(); i++) {
                            found = B.get(i).search(acc_no);
                            if (found) {
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Search failed! Account doesn't exist..!!");
                        }
                        break;

                    case 4 :
                        System.out.print("Enter Account no. : ");
                        acc_no = sc.next();
                        found = false;
                        for (int i = 0; i < B.size(); i++) {
                            found = B.get(i).search(acc_no);
                            if (found) {
                                System.out.println("Enter the amount to deposit");
                                long amount = sc.nextLong();
                                B.get(i).deposit(amount);
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search failed! Account doesn't exist..!!");
                        }
                        break;

                    case 5 :
                        System.out.print("Enter Account No : ");
                        acc_no = sc.next();
                        found = false;
                        for (int i = 0; i < B.size(); i++) {
                            found = B.get(i).search(acc_no);
                            if (found) {
                                System.out.println("Enter the amount to withdraw");
                                long amount = sc.nextLong();
                                B.get(i).withdraw(amount);
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search failed! Account doesn't exist.!");
                        }
                        break;

                    case 6 :
                        break;

                    default :
                        System.out.println("Enter the correct choice");
                        break;
                }
            }

            while (ch != 6);

        }catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
}


