package helpdesk.model;

public class Ticket {
    private long id;
    private String title;
    private String description;
    private String status;

    public Ticket(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = "NEW";
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void startProcessing() {
        status = "IN_PROGRESS";
    }

    public void resolve() {
        status = "RESOLVED";
    }

    public void close() {
        status = "CLOSED";
    }
}
