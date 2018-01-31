package monolithic;

import ui.CalcUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter Expression :");
        Scanner sc = new Scanner(System.in);
        while(true) {
            String expr = sc.next();
            CalcUI u = new CalcUI(expr);
            u.runUI();
        }

    }
}
