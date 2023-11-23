// Rowan Medcraft
// 10/28/2021
// hangman game made for my AP computer science class. This was done in under an hour for an exam.
import java.util.Scanner;

public class hangman{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        String secretWord = "java";
        String dashes = dashString(secretWord);
        String guess = "";
        secretWord = format(secretWord);
        int wrongGuesses = 0;

        while(dashes.indexOf("_") > -1){
            System.out.println(dashes);
            System.out.println("Enter a letter? ");
            guess = input.next();

            if(secretWord.indexOf(guess) > -1){
                dashes = correctGuess(dashes, guess, secretWord);
            } else {
                wrongGuesses++;
            }
            
            if(wrongGuesses == 6){
                dashes = "";
                System.out.println("You lose!");
            }
            input.close();
        }

        if(wrongGuesses < 6){
            System.out.println(secretWord);
            System.out.println("You win!");
        }
    }

    public static String format(String word){
        String output = "";
        for(int i = 0; i < word.length(); i++){
            output = word.substring(i, i + 1) + " ";
        }
        return output;
    }

    public static String dashString(String word){
        String output = "";
        for(int i = 0; i < word.length(); i++){
            output += "_ ";
        }
        return output;
    }

    public static String correctGuess(String dashes, String guess, String secretWord){
        String output = "";
        for(int i = 0; i < dashes.length(); i = i + 2){
            String let = secretWord.substring(i, i + 1);
            if(guess.equals(let)){
                output += let + " ";
            } else {
                output += dashes.substring(i, i + 2);
            }
        }
        return output;
    }
}