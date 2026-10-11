package helpdesk.model;

public class Ticket {
    public long id;
    public String title;
    public String description;
    public String status;

    public Ticket(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = "NEW";
    }
}
