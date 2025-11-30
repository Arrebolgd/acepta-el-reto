package Day1;

import java.util.Scanner;

public class problema595 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numeroPruebas = input.nextInt();

        for(int i = 0; i < numeroPruebas; i++)
            System.out.println(input.nextInt() / 100);

    }
}