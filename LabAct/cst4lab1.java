package isa;
import java.util.Scanner;

public class cst4lab1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Enter a binary string (type 'STOP' to end): ");
            input = sc.nextLine();


            if (input.equals("STOP")) {
                System.out.println("Program ended.");
                break;
            }


            String currentState = "q0";


            for (char symbol : input.toCharArray()) {
                if (symbol != '0' && symbol != '1') {
                    System.out.println("Invalid input! Only binary digits (0 or 1) are allowed.");
                    currentState = "invalid";
                    break;
                }

                switch (currentState) {
                    case "q0":
                        currentState = (symbol == '0') ? "q1" : "q0";
                        break;
                    case "q1":
                        currentState = (symbol == '0') ? "q1" : "q2";
                        break;
                    case "q2":
                        currentState = (symbol == '0') ? "q1" : "q0";
                        break;
                }
            }


            if (!currentState.equals("invalid")) {
                if (currentState.equals("q2")) {
                    System.out.println("Accepted");
                } else {
                    System.out.println("Rejected");
                }
            }

            System.out.println(); 
        }

    }
}
