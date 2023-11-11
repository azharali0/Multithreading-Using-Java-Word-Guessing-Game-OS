import java.io.*; 
import java.util.*;
import java.util.Scanner;
import java.util.Random;

class WordGuessing extends Thread { 
    String name;
    WordGuessing(String name){
        this.name = name;
    }
    
    

    public void run() {

        Random rand = new Random();// random object

        System.out.print("What is your name? ");
        
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        System.out.println("Good Luck ! " + name);

        String[] words = {"rainbow", "bench", "engineer", "hostel", "python", "sibau", "community", "condition","reverse", "water", "society", "technical"
            ,"abort","stranger", "things","beautiful"
        };// array of words
                
        // choosing the random word from the array
        String word = words[rand.nextInt(words.length)];

        System.out.println("Guess the characters");
        // here it will give the specific number of characters and let you to guess the letter from the word
        String guesses ="";

        int turns = 7;// turn for tryings

        while (turns > 0) {

            // counts the number of times a user fails
            int failed = 0;

            for (char ch : word.toCharArray()) {

                if (guesses.indexOf(ch) != -1) {
                    System.out.print(ch + " ");
                } else {
                    System.out.print("_ ");

                    failed++;
                }

            }

            if (failed == 0) {// no fail mean win in game

                System.out.println("You Win");

                System.out.println("The word is: " + word);
                break;
            }

            System.out.println();
            System.out.print("guess a character:");
            char guess = sc.next().charAt(0);

            guesses += guess;

            if (word.indexOf(guess) == -1) {

                turns--;

                System.out.println("Wrong");

                System.out.println("You have " + turns + " more guesses");

                if (turns == 0) {
                    System.out.println("You Loose");
                }
                
            }
            
        }

        System.out.println("Thread " + Thread.currentThread().getId() +" (" + Thread.currentThread().getName() + ") is running");// prints the about  thread
    } 

    public static void main(String cmd[]){
        WordGuessing player1 = new WordGuessing("Thread One");
        WordGuessing player2 = new WordGuessing("Thread Two");
        player1.start();
        try{  
          player1.join();  
         }
         catch(Exception e){
             System.out.println(e);
        }  
        player1.start();
    }
}