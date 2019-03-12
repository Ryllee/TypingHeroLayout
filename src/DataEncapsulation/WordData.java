package DataEncapsulation;

/**
 * Inkappslings-klass för data som rör ord.
 * @author Joel Petersson
 * @version 2019-03-12
 */
public class WordData {
    public int command; // 1 = CORRECT | 2 = INCORRECT | 3 = NEXT_WORD
    public String word;
    public int currentLetterIndex;

    /**
     * Skapar en WordData
     * @param command vilket kommando som ska utföras
     * @param word vilket ord man ska skicka
     * @param currentLetterIndex vilken plats i ordet man är på
     */
    public WordData(int command, String word, int currentLetterIndex){
        this.command = command;
        this.word = word;
        this.currentLetterIndex = currentLetterIndex;
    }
}
