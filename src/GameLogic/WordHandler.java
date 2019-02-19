package GameLogic;

import java.util.ArrayList;
import java.util.Observable;

public class WordHandler extends Observable {
    private ArrayList<String> wordList;
    private PointHandler points;
    private int currentLetterIndex;
    private int currentWordIndex;

    public WordHandler(ArrayList<String> wordList,PointHandler points){
        this.wordList = wordList;
        this.points = points;
        currentLetterIndex = 0;
        currentWordIndex = 0;
    }

   public String getCurrentWord(){ return wordList.get(currentWordIndex);}
   public int getCurrentWordLength(){return wordList.get(currentWordIndex).length();}
   public void keyPressed(String keyInput){}
   private void compareKeyToLetter(String keyInput){}
   private void correctLetter(){}
   private void incorrectLetter(){}
   private void nextWord(){}
   private boolean isLastLetter(){return getCurrentWordLength() == (currentLetterIndex + 1);}

}
