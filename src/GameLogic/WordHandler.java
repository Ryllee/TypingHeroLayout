package GameLogic;

import Notifydata.WordData;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class WordHandler extends Observable {
    private ArrayList<String> wordList;
    private PointHandler pointhandler;
    private HealthHandler healthhandler;
    private int currentLetterIndex;
    private int currentWordIndex;
    private int currentStreak;
    private Random r;

    public WordHandler(ArrayList<String> wordList,PointHandler pointhandler, HealthHandler healthhandler){
        this.wordList = wordList;
        this.pointhandler = pointhandler;
        this.healthhandler = healthhandler;
        r = new Random();
        currentLetterIndex = 0;
        currentWordIndex = r.nextInt(wordList.size());
        currentStreak = 0;
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
   public void incorrectLetter(){
        currentStreak = 0;
        healthhandler.takeDamage(2);
        setChanged();
        notifyObservers(new WordData(2,getCurrentWord(),currentLetterIndex));
   }
   private void nextWord(){
        pointhandler.wordCorrect(getCurrentWordLength(),currentStreak);
        healthhandler.heal(2);
        currentWordIndex = r.nextInt(wordList.size());

        currentLetterIndex = 0;
        currentStreak++;
        setChanged();
        notifyObservers(new WordData(3,getCurrentWord(),currentLetterIndex));
   }
   private boolean wasLastLetter(){return getCurrentWordLength() == (currentLetterIndex);}

   public void updateNotify(){
        setChanged();
        notifyObservers(new WordData(3,getCurrentWord(),currentLetterIndex));
   }
}
