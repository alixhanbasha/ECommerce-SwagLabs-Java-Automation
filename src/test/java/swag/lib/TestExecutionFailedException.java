package swag.lib;

public class TestExecutionFailedException extends RuntimeException {
    public TestExecutionFailedException(String message){
        super(message);
    }
}
