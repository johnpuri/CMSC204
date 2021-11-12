import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MorseCodeConverter {

    private static MorseCodeTree morseCodeTree = new MorseCodeTree();

    
    public MorseCodeConverter() {
    }

    /** 
     * @param codeFile - name of the File that contains Morse Code
     * @return the English translation of the file
     * @throws FileNotFoundException
     */
    static String convertToEnglish(File codeFile) throws FileNotFoundException {

        String sentenceInMorse = "";
        String sentenceInEnglish;

        Scanner scanner = new Scanner(codeFile);

        while (scanner.hasNext()) {
            sentenceInMorse += scanner.nextLine();
        }

        sentenceInEnglish = convertToEnglish(sentenceInMorse);

        return sentenceInEnglish;
    }

    /**
      * @param code - the morse code
     * @return the English translation
     */
    static String convertToEnglish(String code) {

        String sentenceInEnglish = "";

        String[] wordsInMorseArray = code.split("/"); //split sentence into words

        for (String wordInMorse : wordsInMorseArray) {

            String[] lettersInMorseArray = wordInMorse.split(" "); // split words into letters
            String wordInEnglish = "";

            for (String letter : lettersInMorseArray) {
                if (!(letter.equals(("")))) {
                    wordInEnglish += morseCodeTree.fetch(letter);
                }
            }

            wordInEnglish += " ";
            sentenceInEnglish += wordInEnglish;
        }

        return sentenceInEnglish.substring(0, sentenceInEnglish.length() - 1);
    }

    /**
     * returns a string with all the data in the tree in LNR order with an space in between them.
     * @return the data in the tree in LNR order separated by a space.
     */
    static String printTree() {

        ArrayList<String> arrayListTree = new ArrayList<>();

        arrayListTree = morseCodeTree.toArrayList();

        String stringTree = "";

        for (String letter : arrayListTree) {
            stringTree += letter + " ";
        }

        return stringTree;
    }


}