package GameLogic;

import Notifydata.PointData;

import java.util.Observable;

public class PointHandler extends Observable {
    private float points;
    private float totalPoints;
    private float pointsPerLetter;
    private float pointsPerSec;

    public PointHandler(){
        points = 0;
        totalPoints = 0;
        pointsPerLetter = 1;
        pointsPerSec = 0;

    }


    public void updateNotify(){
        setChanged();
        notifyObservers(getPointData());
    }

    public PointData getPointData(){
        return new PointData(points,totalPoints,pointsPerLetter,pointsPerSec);
    }
    public float getPoints(){
        return points;
    }
    public float getTotalPoints(){
        return totalPoints;
    }
    public float getPointsPerLetter(){
        return pointsPerLetter;
    }
    public float getPointsPerSec(){
        return pointsPerSec;
    }

    public void loadPointData(PointData pointdata){
        points = pointdata.points;
        totalPoints = pointdata.totalPoints;
        pointsPerLetter = pointdata.pointsPerLetter;
        pointsPerSec = pointdata.pointsPerSec;
    }

    public void addPointsPerLetter(float pointsPerLetterMultiplier){
        pointsPerLetter = pointsPerLetter * pointsPerLetterMultiplier;
    }

    public void addPointsPerSec(float pointsToAdd){
        pointsPerSec += pointsToAdd;
    }

    private void addPoints(float pointsToAdd)
    {
        points += pointsToAdd;
        totalPoints += pointsToAdd;
        updateNotify();
    }

    private void removePoints(float pointsToRemove)
    {
        points -= pointsToRemove;
    }

    public boolean purchase(float cost){
        if(points >= cost){
            removePoints(cost);
            updateNotify();
            return true;
        }
        return false;
    }

    public void pointsPerSecTick(){
        addPoints(pointsPerSec);
    }

    public float getStreakMultiplier(int streak){
        int streakInterval = 5;
        int maxStreak = 25;
        if(streak > maxStreak)
        {
            return ((int)(maxStreak/streakInterval)) +1;
        }
        System.out.println(((int)(streak/streakInterval)) +1);
        return ((int)(streak/streakInterval)) +1;
    }

    public void wordCorrect(float wordlength,int streak){
        addPoints((wordlength * pointsPerLetter * getStreakMultiplier(streak)));
    }


}
