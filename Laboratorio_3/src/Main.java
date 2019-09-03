import java.util.Scanner;  // Import the Scanner class

public class Main {
    public static void main(String[] args) {
        PilaTEC<Integer> pTEC = new PilaTEC();

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        //Ask for 5 objects
        for(int i = 0; i < 5; i++){
            System.out.print("Enter INT: ");
            Integer stackInt = myObj.nextInt();  // Read user input
            pTEC.push(stackInt);
        }

        //Test push, peek and pop methods.
        pTEC.push(9999);
        System.out.println("Peeking: "+pTEC.peek());
        pTEC.pop();

        //Print Final Stack
        System.out.println(pTEC.toString());

    }
}
