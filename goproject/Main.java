package goproject;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int size;

        System.out.println("Enter map size:");
        while(true)
        {
            if (scan.hasNextInt())
            {
                size = scan.nextInt();
                break;
            }
            else {
                scan.nextLine();
                System.out.println("Enter map size (number):");
            }
        }
        Gomoku game = new Gomoku(size);
        game.run();
        scan.close();
    }
}
