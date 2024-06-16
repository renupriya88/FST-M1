package activities;

class Bicycle implements BicycleParts, BicycleOperations{
    public int gears;
    public int speed;

    Bicycle(int gear, int Speed)
    {
        gears = gear;
        speed = Speed;

    }

    public void applyBrake(int i)
    {
        System.out.println("reduces the currentSpeed by " + i);
            }

    public void speedUp(int s)
    {
        System.out.println("increases the currentSpeed by " + s);
            }

    public String bicycleDesc()
    {
        return ("number of gears are " + gears + "\ncurrentSpeed of the bicycle is " + speed);
            }
}
