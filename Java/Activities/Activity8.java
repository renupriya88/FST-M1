package activities;

public class Activity8 {
    public static void main(String[] args) throws CustomException {
        try {
           exceptionTest("Hi");
           exceptionTest(null);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
             }

    static void exceptionTest(String err) throws CustomException
    {
        if(err == null) {
            throw new CustomException("String value is null");}
        else {System.out.println(err);
             }
    }
}
