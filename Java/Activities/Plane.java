package activities;

import java.time.Instant;
import java.util.*;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    Plane(int maxPassenger){
        maxPassengers = maxPassenger;
        passengers = new ArrayList<>();
    }

    public void onboard(String passenger)
    {
        passengers.add(passenger);
    };

    public Date takeOff()
    {
        lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }

    public void land()
    {
        lastTimeLanded = new Date();
        passengers.clear();
    }
    public Date getLastTimeLanded()
    {
        return lastTimeLanded;
    }
    public List<String> getPassesngers()
    {
       return passengers;
    }
}



