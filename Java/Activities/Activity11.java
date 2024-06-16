package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args)
    {
        Map<Integer, String> colours = new HashMap<>();

        colours.put(1, "Red");
        colours.put(2, "Orange");
        colours.put(3, "Yellow");
        colours.put(5, "Violet");
        colours.put(6, "Pink");

        System.out.println(colours);

        System.out.println("\nRemove a colour\n");
        colours.remove(5, "Violet");

        boolean x = colours.containsValue("Green");
        System.out.println("\nIs Green Present\n" + x);


        System.out.println("\nSize of the Map is \n" + colours.size());

    }
}
