package exception;

public class BrowserNotSupportedException extends IllegalArgumentException {
    public BrowserNotSupportedException(String browser) {
        super(String.format("Browser not supported: %s", browser));
    }
}
