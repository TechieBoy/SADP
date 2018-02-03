package main;

import server.Server;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Server server = new Server(2000);
        while(true) {
            try {
                server.runServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
