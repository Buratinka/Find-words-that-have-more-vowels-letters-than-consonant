package main.consoleHelper;

/**
 *
 * @autor oleg.shved.shvets@gmail.com with support from resource https://javarush.ru/
 * Class for simple work with streams of output
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     *
     * print message to console
     *
     * */
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     *
     * print error message to console
     *
     * */
    public static void writeErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }

    /**
     *
     * read String from console
     *
     * */
    public static String readString() {

        while (true) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                System.out.println("An error occurred while trying to enter text. Try again.");
            }
        }
    }

    /**
     *
     * read int from console
     *
     * */
    public static int readInt() {

        while (true) {
            try {
                return Integer.parseInt(readString());

            } catch (NumberFormatException e) {
                System.out.println("An error occurred while trying to enter number. Try again.");
            }
        }
    }


}
