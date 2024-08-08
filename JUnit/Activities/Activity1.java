import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Activity1 {
    static ArrayList<String> list;

    @BeforeEach
    public void setup() throws Exception{
        // Initialize a new ArrayList
        list = new ArrayList<String>();

// Add values to the list
        list.add("alpha"); // at index 0
        list.add("beta"); // at index 1
    }

    @Test
    @Order(1)
    public void insertTest(){
        // Assert size of list
        assertEquals(2, list.size(), "Wrong size");

        list.add(2, "gamma");
        assertEquals(3, list.size(), "Wrong size");

        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("gamma", list.get(2), "Wrong element");

        System.out.println(list);
    }

    @Test
    @Order(2)
    public void replaceTest(){

        list.set(1, "selenium");

        System.out.println(list);

        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("selenium", list.get(1), "Wrong element");


    }

}
