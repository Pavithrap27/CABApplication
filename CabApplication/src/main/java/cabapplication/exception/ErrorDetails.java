package cabapplication.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime d;
    private String message;
    private String details;
    public ErrorDetails(LocalDateTime d, String message, String details) {
        super();
        this.d = d;
        this.message = message;
        this.details = details;
    }
    public LocalDateTime getD() {
        return d;
    }
    public void setD(LocalDateTime d) {
        this.d = d;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

}
