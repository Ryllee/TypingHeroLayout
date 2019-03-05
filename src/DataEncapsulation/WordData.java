package DataEncapsulation;

public class WordData {
    public int command; // 1 = CORRECT | 2 = INCORRECT | 3 = NEXT_WORD
    public String word;
    public int currentLetterIndex;

    public WordData(int command, String word, int currentLetterIndex){
        this.command = command;
        this.word = word;
        this.currentLetterIndex = currentLetterIndex;
    }
}
