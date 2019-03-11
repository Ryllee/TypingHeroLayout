package GameLogic;

import DataEncapsulation.PointData;

import java.util.Observable;

public class PointHandler extends Observable {
    private float points;
    private float totalPoints;
    private float pointsPerLetter;
    private float pointsPerSec;

    /**
     * Skapar en Pointhandler
     */
    public PointHandler(){
        points = 0;
        totalPoints = 0;
        pointsPerLetter = 1;
        pointsPerSec = 0;
    }

    /**
     * Uppdatera Observer med ny data från pointhandler
     */
    public void updateNotify(){
        setChanged();
        notifyObservers(getPointData());
    }

    /**
     * Hämtar en PointData av data från pointhandler
     * @return PointData
     */
    public PointData getPointData(){
        return new PointData(points,totalPoints,pointsPerLetter,pointsPerSec);
    }

    /**
     * Hämtar nuvarande points
     * @return nuvarande points
     */
    public float getPoints(){
        return points;
    }

    /**
     * Hämtar nuvarande TotalPoints
     * @return nuvarande TotalPoints
     */
    public float getTotalPoints(){
        return totalPoints;
    }

    /**
     * Hämtar nuvarande pointsPerLetter
     * @return nuvarande pointsPerLetter
     */
    public float getPointsPerLetter(){
        return pointsPerLetter;
    }

    /**
     * Hämtar nuvarand pointsPerSec
     * @return nuvarand pointsPerSec
     */
    public float getPointsPerSec(){
        return pointsPerSec;
    }

    /**
     * Ladda in data från en PointData
     * @param pointdata vilken PointData som datan ska läsas ifrån
     */
    public void loadPointData(PointData pointdata){
        points = pointdata.points;
        totalPoints = pointdata.totalPoints;
        pointsPerLetter = pointdata.pointsPerLetter;
        pointsPerSec = pointdata.pointsPerSec;
    }

    /**
     * Ökar antalet poäng per bokstav
     * @param pointsPerLetterMultiplier med vilken tal nuvarande pointsPerLetter ska multipliceras med
     */
    public void addPointsPerLetter(float pointsPerLetterMultiplier){
        pointsPerLetter = pointsPerLetter * pointsPerLetterMultiplier;
    }

    /**
     * Öker antal poäng per sekund
     * @param pointsToAdd hur mycket pointsPerSec ska öka
     */
    public void addPointsPerSec(float pointsToAdd){
        pointsPerSec += pointsToAdd;
    }

    /**
     * Ökar antal poäng
     * @param pointsToAdd hur mycket antal poäng ska ökas med
     */
    private void addPoints(float pointsToAdd)
    {
        points += pointsToAdd;
        totalPoints += pointsToAdd;
        updateNotify();
    }

    /**
     * Ta bort ett visst antal poäng
     * @param pointsToRemove hur många poäng som ska tas bort
     */
    private void removePoints(float pointsToRemove)
    {
        points -= pointsToRemove;
    }

    /**
     * Vad som händer när man köper en uppgradering
     * @param cost vad uppgraderingen kostar
     * @return om man kunde köpa den eller inte
     */
    public boolean purchase(float cost){
        if(points >= cost){
            removePoints(cost);
            updateNotify();
            return true;
        }
        return false;
    }

    /**
     *
     */
    public void pointsPerSecTick(){
        addPoints(pointsPerSec);
    }

    /**
     * Håller koll på vilken streak man har och vilken multiplier den har
     * @param streak spelarens streak
     * @return rätt multiplier för spelarens streak
     */
    public float getStreakMultiplier(int streak){
        int streakInterval = 5;
        int maxStreak = 25;
        if(streak > maxStreak)
        {
            return ((int)(maxStreak/streakInterval)) +1;
        }
        return ((int)(streak/streakInterval)) +1;
    }

    /**
     * Gör det som ska ske när hela ordet är rätt
     * @param wordlength längden på det färdiga ordet
     * @param streak vilken streak spelaren har
     */
    public void wordCorrect(float wordlength,int streak){
        addPoints((wordlength * pointsPerLetter * getStreakMultiplier(streak)));
    }


}
