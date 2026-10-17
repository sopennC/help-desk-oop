package helpdesk.model;

public class Ticket {
    private long id;
    private String title;
    private String description;
    private TicketStatus status;
    private final TicketPriority priority;

    public Ticket(long id, String title, String description, TicketPriority priority) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Ошибка: нельзя создать заявку без названия");
        }
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = TicketStatus.NEW;
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

    public TicketStatus getStatus() {
        return status;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void startProcessing() {
        if (status != TicketStatus.NEW && status != TicketStatus.REOPENED) {
            System.out.println("Ошибка: в работу можно взять только новую или переоткрытую заявку");
            return;
        }
        status = TicketStatus.IN_PROGRESS;
    }

    public void resolve() {
        if (status != TicketStatus.IN_PROGRESS) {
            System.out.println("Ошибка: решить можно только заявку в работе");
            return;
        }
        status = TicketStatus.RESOLVED;
    }

    public void close() {
        if (status != TicketStatus.RESOLVED) {
            System.out.println("Ошибка: сначала заявку нужно решить, потом закрыть");
            return;
        }
        status = TicketStatus.CLOSED;
    }

    public void cancel() {
        if (status == TicketStatus.CLOSED) {
            System.out.println("Ошибка: заявка уже закрыта, отменить её нельзя");
            return;
        }
        status = TicketStatus.CANCELLED;
    }

    public void reopen() {
        if (status != TicketStatus.RESOLVED && status != TicketStatus.CLOSED) {
            System.out.println("Ошибка: открыть повторно можно только решённую или закрытую заявку");
            return;
        }
        status = TicketStatus.REOPENED;
    }

    @Override
    public String toString() {
        return "#" + id + " " + title + " | " + status;
    }
}
