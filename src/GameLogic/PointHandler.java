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

    public PointHandler(float points,float totalPoints, float pointsPerLetter,float pointsPerSec){
        this.points = points;
        this.totalPoints = totalPoints;
        this.pointsPerLetter = pointsPerLetter;
        this.pointsPerSec = pointsPerSec;
    }

    public void updateNotify(){
        setChanged();
        notifyObservers(new PointData(points,totalPoints,pointsPerSec));
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

    public void addPointsPerLetter(float pointsToAdd){
        pointsPerLetter = pointsPerLetter * pointsToAdd;
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

    public void wordCorrect(float wordlength){
        addPoints((wordlength * pointsPerLetter));
    }

}
