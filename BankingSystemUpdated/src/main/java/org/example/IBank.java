package org.example;

public interface IBank {

    long getBalance();
    void deposit(long amount);
    void withdraw(long amount);
    void showAccount();
    boolean search(String acc_no);

}
