package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

    public static void main(String[] args)
    {
        List<String> myList = new ArrayList<>();
        myList.add("sam");
        myList.add("Ram");
        myList.add("Rome");
        myList.add("Kate");
        myList.add("Jack");

        for(String i: myList)
        {System.out.println(i);}

        System.out.println(myList.get(3));

        if (myList.contains("Jack"))
        {System.out.println("name exists");}
        else
        {System.out.println("name does not exists");}

        System.out.println("Size of the array is " + myList.size());

        myList.remove("sam");

        System.out.println("After removing sam size of the array is " + myList.size());

    }


}
