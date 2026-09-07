import java.util.Scanner;

public class String_Programming{
    public static void main(String[] args) {

        boolean check = true;
        String_Programming user = new String_Programming();
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("Please enter a phrase:");
            String phrase = input.nextLine();

            user.wordProcessing(phrase);

            check = user.menu(input);

        }while(check);


        input.close();


    }

    public void wordProcessing(String str){
        System.out.println("The phrase: " + str);
        int word_count = 0;
        String vowels = "aeiouyAEIOUY ";
        boolean inWord = false;

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
        if(inWord){
            word_count += 1;
        }

        inWord = false;

        System.out.println("The total number of words is: " + word_count);
        System.out.println("");

        String[] words = new String[word_count];
        int index = 0;
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
        if(inWord){          
            words[index] = st.toString();
            index += 1;
        }
        System.out.println("The list of words are:");
        for(String word : words){
            System.out.println("* " + word);
        }

        for(String word : words){
            int vowels_number = 0;
            for(char ch: word.toCharArray()){
                if(vowels.indexOf(ch) != -1){
                    vowels_number += 1;
                }

            }
            System.out.println("The word: \"" + word + "\" has " + word.length() + " characters.");
            if(vowels_number == 1){
                System.out.println("        * There is " + vowels_number + " vowel in this word.");
            }
            else{
                System.out.println("        * There are " + vowels_number + " vowels in this word.");
            }
            StringBuilder stReverse = new StringBuilder(word);
            System.out.println("        * The word spelled backwards: " + stReverse.reverse());
        }

        System.out.println("");

    }

    public boolean menu(Scanner input){
        System.out.println("Would you like to enter another phrase(yes or no):");
        String user_input = input.nextLine();

        while(!(user_input.equalsIgnoreCase("Yes")) && !(user_input.equalsIgnoreCase("No"))){
            System.out.println("Invalid input, please try again!");

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