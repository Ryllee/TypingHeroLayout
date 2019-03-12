package DataEncapsulation;

/**
 * Inkappslings-klass för data som rör poäng.
 * @author Joel Petersson
 * @version 2019-03-12
 */
public class PointData {
    public float points;
    public float totalPoints;
    public float pointsPerLetter;
    public float pointsPerSec;

    /**
     * Skapar en PointData
     * @param points antal points
     * @param totalPoints antal totalpoints
     * @param pointsPerLetter antal pointsperletter
     * @param pointsPerSec antal pointspersec
     */
    public PointData(float points, float totalPoints, float pointsPerLetter,float pointsPerSec){
        this.points = points;
        this.totalPoints = totalPoints;
        this.pointsPerLetter = pointsPerLetter;
        this.pointsPerSec = pointsPerSec;
    }
}
