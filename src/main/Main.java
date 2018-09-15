package main;
/**
 *
 * @autor oleg.shved.shvets@gmail.com
 * Main method that running program
 *
 * */

import main.parse.Parser;

/**
 *
 * Creating object of parser with input parameters and start program
 *
 * */
public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser("/home/oleg/test/Text1Input.txt","/home/oleg/test/Text1Output.txt");
        parser.start();
    }
}
