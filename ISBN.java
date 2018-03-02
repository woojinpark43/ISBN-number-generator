package Assignment1;

import java.util.Scanner;

public class WoojinPU1A1Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //(special)Creates Scanner
        int checkSum = 0,//Sum
                inputValue = 0,//User's input
                checker = 1,//Check if the program run 9 times
                playAgain; // use to store input from the user to figure out whether they want to play again
        int[] iSBNArray = new int[9];//9 integers
        boolean endLoop = true;//true or false that is used to check if the program should stop
        boolean endProgram = true;//use to check if the user want to exit the program
        boolean exitOption = true;//use to run program until the user enter a valid input

        //Loop while player wants to play the game
        while (endProgram) {
            System.out.println("This program generates the 10-digit ISBN if the user enters the first 9 digits");//Explains the code
            System.out.println("Type in integer between 0 and 9");//Tells user what to do
            do {
                try {
                    //Check if the input is an integer
                    if (input.hasNextInt()) {
                        inputValue = input.nextInt();//Stores the integer the user input
                        //Check if the user input a number higher than -1 or less than 10
                        if (inputValue > -1 && inputValue < 10) {
                            iSBNArray[checker - 1] = inputValue;//Store the InputValue to the iSBNArray
                            checkSum = inputValue * checker;//Add the checkSum with the user's input times the number it is input
                            checker++;//Add one to the Checker
                        } else {
                            throw new RuntimeException();
                        }

                    } else {
                        throw new RuntimeException();
                    }
                    //Check if the user input 9 times
                    if (checker == 10)
                        endLoop = false;//End the program by making End false
                } catch (Throwable exception) {
                    System.out.println("Invalid Input!");//Print out "Invalid Input"
                    input = new Scanner(System.in);//The user inputs again
                }
            }
            while (endLoop);

            //Check if the Remainder of Sum divided by 11 is equal to 10
            if (checkSum % 11 == 10) {
                //(concise) Run a for loop 9 times as the length of the ISBNArray is 9
                for (int a = 0; a < iSBNArray.length; a++)
                    System.out.print(iSBNArray[a]);//Outputs the entire 9-digit ISBN
                System.out.print("-X\n");// (io) Outputs "X" at the end of the ISBN
            } else {
                //(concise) Run a for loop 9 times as the length of the ISBNArray is 9
                for (int a = 0; a < iSBNArray.length; a++)
                    System.out.print(iSBNArray[a]);//Outputs the entire 9-digit iSBN
                System.out.print("-" + checkSum % 11 + "\n");//Outputs the remainder of the Sum divided by 11 to the user
            }

            System.out.println("If you want to restart the program enter 1 and if you want to exit enter any integer");

            while (exitOption) {
                try {
                    //Check if the input is an integer
                    if (input.hasNextInt()) {
                        playAgain = input.nextInt();//stores user's input
                        //Check if the input is equal to 1
                        if (playAgain == 1) {
                            endLoop = true;
                            exitOption = false;
                            checkSum = 0;
                            inputValue = 0;
                            checker = 1;
                        } else {
                            endProgram = false;//End the program
                            exitOption = false;
                        }
                    } else
                        throw new RuntimeException();//throw exception
                } catch (Throwable exception) {
                    System.out.println("Invalid Input!");//Print out "Invalid Input"
                    input = new Scanner(System.in);//The user inputs again
                }
            }
            exitOption = true;
        }
    }
}
