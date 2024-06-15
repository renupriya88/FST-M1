package activities;

import java.util.Date;

public class Activity6
{
    public static void main(String[] args) throws InterruptedException {
        Plane obj = new Plane(10);
        obj.onboard("Ram");
        obj.onboard("Karan");
        obj.onboard("Lorry");
        obj.onboard("Kian");
        obj.onboard("Vian");
        obj.onboard("Amal");
        obj.onboard("Syam");
        obj.onboard("Don");
        obj.onboard("Hemanth");
        obj.onboard("Om");
        System.out.println("Take of time is :" + obj.takeOff());
        System.out.println("Passengers on plane : " + obj.getPassesngers());
        Thread.sleep(5000);
        obj.land();
        System.out.println("landed at: " + obj.getLastTimeLanded());
        System.out.println("Passengers after landing: " + obj.getPassesngers());
    }
}
