/**
 * This is a word counting program that takes a phrase entered by the user and shows the number of words, outputs
 * each word, and for each word outputs its characters number, the number of vowels in it, and the word spelled backwards
 * working with Javadoc.
 * @author Akrhip Finski
 * Course: CS-49J Section 02
 * Title: String Programming
 * Date: 09/06/2026
 */

import java.util.Scanner;

public class String_Programming{

     /**
     * This method is the entry point.
     * It asks the user for a phrase, passes it to wordProcessing() method, and then asks user
     * (using menu() method) if they want to enter another phrase. The program continues to run until the user says "no"
     * @param args A String type array variable for holding command line options
     */
    public static void main(String[] args) {

        boolean check = true;
        String_Programming user = new String_Programming();
        Scanner input = new Scanner(System.in);

        // Makes sure progrma runs one to N times
        do{
            System.out.println("Please enter a phrase:");
            String phrase = input.nextLine();

            user.wordProcessing(phrase);

            check = user.menu(input);

        }while(check);


        input.close();


    }

    /**
     * This method has a phrase as an argument and counts the number of words in the phrase, outputs each
     * word, and for each word outputs the number of characters, the number of vowels, and the word spelled backwards
     * @param str The phrase entered by the user to be analyzed.
     */
    public void wordProcessing(String str){
        System.out.println("The phrase: " + str);
        int word_count = 0;
        //List of all vowels
        String vowels = "aeiouyAEIOUY ";
        //Tracks if a character is a part of the word or not
        boolean inWord = false;

        // This loop counts the number of words in the phrase
        for(int i = 0; i < str.length(); ++i){
            if( ( (str.charAt(i) >= 'A') && (str.charAt(i) <= 'Z')) || ((str.charAt(i) >= 'a') && (str.charAt(i) <= 'z'))){
                inWord = true;
            }
            else{
                if(inWord){
                    word_count += 1;
                }
                inWord = false;
            }
        }
        // If a phrase ends on a letter, makes sure last word is counted
        if(inWord){
            word_count += 1;
        }

        // Resets inWord for the next loop
        inWord = false;

        System.out.println("The total number of words is: " + word_count);
        System.out.println("");

        // This loop puts each word from the phrase into an array
        String[] words = new String[word_count];
        int index = 0;
        // I used StringBuilder to copy each word character by character
        StringBuilder st = new StringBuilder();

        for(int i = 0; i < str.length(); ++i){
            if( ( (str.charAt(i) >= 'A') && (str.charAt(i) <= 'Z')) || ((str.charAt(i) >= 'a') && (str.charAt(i) <= 'z'))){
                st.append(str.charAt(i));
                inWord = true;
            }
            else{
                if(inWord){
                    words[index] = st.toString();
                    st.delete(0, st.length());
                    index += 1;
                }
                inWord = false;
            }
        }
        // Again this makes sure that if the phrase ends on the letter, last word is copied into an array
        if(inWord){          
            words[index] = st.toString();
            index += 1;
        }
        // Outputs all words from the phrase
        System.out.println("The list of words are:");
        for(String word : words){
            System.out.println("* " + word);
        }

        //This loop outputs number of character, number of vowels and reversed version of each word from the phrase
        for(String word : words){
            int vowels_number = 0;

            // This loop counts vowels in the word
            for(char ch: word.toCharArray()){
                if(vowels.indexOf(ch) != -1){
                    vowels_number += 1;
                }

            }
            System.out.println("The word: \"" + word + "\" has " + word.length() + " characters.");
            // This if statement makes sure that if there is 1 vowel in the word, "vowel" is printed
            if(vowels_number == 1){
                System.out.println("        * There is " + vowels_number + " vowel in this word.");
            }
            // This else statement makes sure that if there is 1+ vowels in the word, "vowels" is printed
            else{
                System.out.println("        * There are " + vowels_number + " vowels in this word.");
            }
            // Outputs word in a reversed order
            StringBuilder stReverse = new StringBuilder(word);
            System.out.println("        * The word spelled backwards: " + stReverse.reverse());
        }

        System.out.println("");

    }

    /**
     * This method asks the user if they would like to enter another phrase, and keeps asking until it receives a
     * valid "yes" or "no" answer
     * @param input The Scanner object used to read users input from the console.
     * @return true if the user answered "yes", false if the user answered "no" (stops the program).
     */
    public boolean menu(Scanner input){
        System.out.println("Would you like to enter another phrase(yes or no):");
        String user_input = input.nextLine();

        while(!(user_input.equalsIgnoreCase("Yes")) && !(user_input.equalsIgnoreCase("No"))){
            System.out.println("Invalid input, please try again!");
            System.out.println("");
            System.out.println("Would you like to enter another phrase(yes or no):");

            user_input = input.nextLine();

        }
        if(user_input.equalsIgnoreCase("Yes")){
            return true;
        }
        else{
            return false;
        }

    }
}