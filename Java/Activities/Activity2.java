package activities;

public class Activity2
{
    public static void main(String[] arg)
    {
        int[] aNum = {10, 77, 10, 54, -11, 10};
        int addValue = 30;

        findTens(aNum, addValue);

    }

    public static void findTens(int[] bNum, int addValue)
        {
            int Sum1 = 0;
                for (int i=0; i <= bNum.length-1; i++)
                {
                    if (bNum[i] == 10)
                    {
                        Sum1 = Sum1 + bNum[i];
                    }
                }

                if (addValue == Sum1)
                    {
                        System.out.println("Value is equal to 30");
                    }
        }
}