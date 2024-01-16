package pl.pwr.io.err;

public class InsufficientPermissionException extends Exception{
    public InsufficientPermissionException() {
        super("Insufficient permission");
    }
}
