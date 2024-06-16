package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {
    public static void main(String[] args)
    {
        Set<String> hs = new HashSet<>();

        hs.add("Apple");
        hs.add("Orange");
        hs.add("Banana");
        hs.add("Pine");
        hs.add("Shyam");
        hs.add("Sharath");

        System.out.println("\nSize of the hashset is "+ hs.size());

        boolean remove = hs.remove("Shyam");

        boolean a = hs.remove(1);

        if (hs.contains("Apple"))
        {
            System.out.println("\nObject is Present\n");
        } else
        {
            System.out.println("\nObject is NOT Present\n");
        }

        for(String i : hs)
        {
            System.out.println(i);
        }

    }
}
