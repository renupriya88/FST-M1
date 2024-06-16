package activities;

public class MountainBike extends Bicycle{
    public int seatHeight;

    MountainBike(int gears, int speed, int Heightseat)
    {
        super(gears,speed);
                seatHeight = Heightseat;
    }

    public void setHeight(int r)
    {
        seatHeight = r;
    }

    public String bicycleDesc()
    {
        return("number of gears are " + gears + "\ncurrentSpeed of the bicycle is " + speed + "\nseat height is " + seatHeight);
    }

}
