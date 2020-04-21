package customexceptions;

public class IterationsOutException extends Exception{
    public IterationsOutException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
