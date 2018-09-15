package main.parse;
/**
 * @autor oleg.shved.shvets@gmail.com
 * Searching all words that have more vowels than consonant letters
 */
import main.consoleHelper.ConsoleHelper;


import java.io.*;
import java.util.*;


public class Parser {
    private String fileReaderString = "";
    private ConsoleHelper consoleHelper;
    private ArrayList<String> arrParsedWords = new ArrayList();
    private static final Set<Character> alphabetLoud = new HashSet<>();
    private Map<String, Object> map = new HashMap<>();
    private String inAddress;
    private String outAddress;

    public Parser(String inAddress, String outAddress) {
        this.inAddress = inAddress;
        this.outAddress = outAddress;
    }

/**
 *
 * init loud letters alphabet in my case cyrillic and latin together
 *
 * */
    static {
        for (char ch : "eyuioaуеоаяиюєїіыэ".toCharArray()) {
            alphabetLoud.add(ch);
        }

    }

    /**
     *
     * method that running all dependencies
     *
     * */

    public void start() {
        readFile();
        findWords();
        writeFile();
    }

    /**
     *
     * read file from input path
     *
     * */

    public void readFile() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inAddress)))) {
            String sb;
            while ((sb = reader.readLine()) != null) {
                fileReaderString += sb.trim() + " ";
            }
        } catch (FileNotFoundException ex) {
            consoleHelper.writeErrorMessage("Error " + ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * finds all words that have more vowels than consonat letters
     *
     * */

    public void findWords() {
        String[] arr = fileReaderString.split("[\\p{P}?[ \\t\\n\\r]+\\d]");

        for (String s : arr) {
            arrParsedWords.add(s.trim().replaceAll("[\\p{P}?[ \\t\\n\\r]+\\d]", "").toLowerCase());
        }


        for (String s : arrParsedWords) {

            int countLoud = 0;
            int countConsonat = 0;
            char[] arrS = s.toCharArray();

            for (char ch : arrS) {
                if (alphabetLoud.contains(ch)) {
                    ++countLoud;
                } else {
                    ++countConsonat;
                }
            }
            if (countLoud > countConsonat) {
                map.put(s, null);

            }
        }

    }

    /**
     *
     * write result into output path
     *
     * */

    public void writeFile() {


        try (BufferedWriter writer = new BufferedWriter
                (new OutputStreamWriter(new FileOutputStream(outAddress)))) {
            for (String s : map.keySet()) {
                writer.write(s + "\n ");
            }

        } catch (IOException ex) {
            consoleHelper.writeErrorMessage("Error " + ex.getMessage());
        }

    }
}
