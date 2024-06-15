package activities;

import java.util.Arrays;

public class Activity4
{
    static int[] numb = {26, 8, 5, 100, 45, 89, 98};
    public static void main(String[] arg)
    {

        System.out.println("Before Sorting, The array is : " + Arrays.toString(numb));
        sortNumber(numb);
        System.out.println("After Sorting, The array is : " + Arrays.toString(numb));
    }

    public static void sortNumber(int[] number)
    {
        int size = number.length, i;

        for (i = 1; i < size; i++)
        {
            int key = number[i];
            int j = i - 1;

            while (j >= 0 && key < number[j])
            {
                number[j + 1] = number[j];
                --j;
            }
            number[j + 1] = key;
        }
    }
}
