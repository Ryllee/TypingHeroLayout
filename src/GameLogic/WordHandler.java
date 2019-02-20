package GameLogic;

import Notifydata.WordData;

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
   public int getCurrentWordLength(){return getCurrentWord().length();}
   public void keyPressed(String keyInput){
        if(compareKeyToLetter(keyInput))
        {
            correctLetter();
            if(wasLastLetter()){
                nextWord();
            }
        }
        else{
            incorrectLetter();
        }
   }
   private boolean compareKeyToLetter(String keyInput){
        if(keyInput.charAt(0)==getCurrentWord().charAt(currentLetterIndex)){
            return true;
        }
        return false;
   }
   private void correctLetter(){
        setChanged();
        notifyObservers(new WordData(1,getCurrentWord(),currentLetterIndex));
        currentLetterIndex++;
   }
   private void incorrectLetter(){
       setChanged();
       notifyObservers(new WordData(2,getCurrentWord(),currentLetterIndex));
   }
   private void nextWord(){
        points.wordCorrect(getCurrentWordLength());
        currentWordIndex++;
        currentLetterIndex = 0;
       setChanged();
       notifyObservers(new WordData(3,getCurrentWord(),currentLetterIndex));
   }
   private boolean wasLastLetter(){return getCurrentWordLength() == (currentLetterIndex);}

   public void updateNotify(){
       setChanged();
       notifyObservers(new WordData(3,getCurrentWord(),currentLetterIndex));
   }
}
