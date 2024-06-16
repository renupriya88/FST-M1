package activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("C:\\Users\\02054I744\\Documents\\IBM FST Projects\\Java\\src\\main\\java\\activities\\renuu.txt");
            boolean s = file.createNewFile();
            if (s == true) {
                System.out.println("file is created");
                FileWriter wri = new FileWriter("C:\\Users\\02054I744\\Documents\\IBM FST Projects\\Java\\src\\main\\java\\activities\\renuu.txt");
                wri.write("Not sure if data is written!");
                wri.close();
            }
            else
            {System.out.println("file is present or cant be created");}

            File a = FileUtils.getFile("C:\\Users\\02054I744\\Documents\\IBM FST Projects\\Java\\src\\main\\java\\activities\\renuu.txt");

            String c = FileUtils.readFileToString(a, "UTF8");
            System.out.println(c);

            File dir = new File("C:\\Users\\02054I744\\Documents\\IBM FST Projects\\Java\\src\\main\\java\\activities\\resources");
            FileUtils.copyFileToDirectory(file, dir);

            File o = FileUtils.getFile("C:\\Users\\02054I744\\Documents\\IBM FST Projects\\Java\\src\\main\\java\\activities\\renuu.txt");

            String z = FileUtils.readFileToString(o, "UTF8");
            System.out.println(z);

            

        }catch(IOException msg)
        {
            System.out.println(msg);
        }
    }


}
