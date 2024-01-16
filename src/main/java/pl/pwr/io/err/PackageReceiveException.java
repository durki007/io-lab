package pl.pwr.io.err;

public class PackageReceiveException extends Exception {
    public PackageReceiveException() {
        super("Package receive failed");
    }
}
