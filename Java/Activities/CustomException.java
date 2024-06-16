package activities;

public class CustomException extends Exception {
    private String message = null;

    public CustomException(String msg)
    {
        message = msg;
        }

    @Override
    public String getMessage()
    {
           return message;
    }

}
