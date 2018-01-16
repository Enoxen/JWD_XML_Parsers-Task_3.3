package by.tc.parser_task.dao.exception;

/**
 * Created by Y50-70 on 13.12.2017.
 */
public class ParseException extends Exception {
    public ParseException(){}
    public ParseException(String message){
        super(message);
    }
    public ParseException(String message, Throwable exception){
        super(message,exception);
    }
    public ParseException(Throwable exception){
        super(exception);
    }
}
