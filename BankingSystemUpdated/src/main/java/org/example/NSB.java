package org.example;

public class NSB implements IBank{

    String name;
    String accNo;
    String accType;
    long balance;


    public NSB(String name, String accNo, String accType, long balance) {
        this.name = name;
        this.accNo = accNo;
        this.accType = accType;
        this.balance = balance;
    }


    public long getBalance(){
        return balance;
    }


    public void deposit(long amount){
        balance = balance + amount;
    }


    public void withdraw(long amount){
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amount + "\tTransaction Failed!!!" );
        }
    }


    public void showAccount() {
        System.out.println("NSB Account");
        System.out.println("Account Holder's Name: " + name);
        System.out.println("Account No: " + accNo);
        System.out.println("Account type: " + accType);
        System.out.println("Balance: " + balance);
    }


    public boolean search(String acc_no) {
        if (accNo.equals(acc_no)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}
