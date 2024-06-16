package activities;

public class Activity7 {
    public static void main(String[] args)
    {
        MountainBike MB = new MountainBike(2, 50,3);
        System.out.println(MB.bicycleDesc());
        MB.speedUp(20);
        MB.applyBrake(5);

    }
}
