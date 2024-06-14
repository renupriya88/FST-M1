package activities;

public class Activity5
{
    public static void main(String[] arg)
    {
        String title = "Whu are you?";
        Book newNovel = new MyBook();
        newNovel.setTitle(title);
        String b = newNovel.getTitle();
        System.out.println("Book Name is : " + b);
    }
}
