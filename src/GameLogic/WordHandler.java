package GameLogic;

import DataEncapsulation.WordData;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
/**
 * Hanterar vilket ord som är det nuvarande samt jämför knapptryck med en bokstav i ordet.
 * @author Arvid Holmqvist
 * @version 2019-03-12
 */
public class WordHandler extends Observable {
    private ArrayList<String> wordList;
    private PointHandler pointhandler;
    private HealthHandler healthhandler;
    private int currentLetterIndex;
    private int currentWordIndex;
    private int currentStreak;
    private Random r;

    /**
     * Konstruktor för WordHandler, skapar det WordHandler behöver
     * @param wordList vilken ordlista som WordHandler ska använda
     * @param pointhandler vilken PointHandler den ska känna till
     * @param healthhandler vilken HealthHandler den ska känna till
     */
    public WordHandler(ArrayList<String> wordList,PointHandler pointhandler, HealthHandler healthhandler){
        this.wordList = wordList;
        this.pointhandler = pointhandler;
        this.healthhandler = healthhandler;
        r = new Random();
        currentLetterIndex = 0;
        currentWordIndex = r.nextInt(wordList.size());
        currentStreak = 0;
    }

    /**
     * Hämtar det nuvarande ordet
     * @return det nuvarande ordet
     */
   public String getCurrentWord(){ return wordList.get(currentWordIndex);}

    /**
     * Hämtar längden på det nuvarande ordet
     * @return längden på det nuvarande ordet
     */
   public int getCurrentWordLength(){return getCurrentWord().length();}

    /**
     * Kollar om tagentbordsinputen är samma som nuvarande bokstav
     * @param keyInput tagentbordsinput
     */
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

    /**
     * Jämför om tagentbordsinput är samma som nuvarande bokstav
     * @param keyInput tagentbordsinputen som ska jämföras
     * @return TRUE/FALSE beroende på om de är samma eller ej
     */
   private boolean compareKeyToLetter(String keyInput){
        if(keyInput.charAt(0)==getCurrentWord().charAt(currentLetterIndex)){
            return true;
        }
        return false;
   }

    /**
     * Gör det som ska ske vid rätt tagentbordsinput
     */
   private void correctLetter(){
        setChanged();
        notifyObservers(new WordData(1,getCurrentWord(),currentLetterIndex));
        currentLetterIndex++;
   }

    /**
     * Gör det som ska ske vid fel tagentbordsinput
     */
   public void incorrectLetter(){
        currentStreak = 0;
        healthhandler.takeDamage(2);
        setChanged();
        notifyObservers(new WordData(2,getCurrentWord(),currentLetterIndex));
   }

    /**
     * Gör det som ska ske när ett ord är färdigt
     */
   private void nextWord(){
        pointhandler.wordCorrect(getCurrentWordLength(),currentStreak);
        healthhandler.heal(2);
        currentWordIndex = r.nextInt(wordList.size());

        currentLetterIndex = 0;
        currentStreak++;
        setChanged();
        notifyObservers(new WordData(3,getCurrentWord(),currentLetterIndex));
   }

    /**
     * kollar om man är på sista bokstaven i nuvarande ord
     * @return om man är på sista eller inte
     */
   private boolean wasLastLetter(){return getCurrentWordLength() == (currentLetterIndex);}

    /**
     * Skickar en uppdatering till Observer
     */
   public void updateNotify(){
        setChanged();
        notifyObservers(new WordData(3,getCurrentWord(),currentLetterIndex));
   }
}
