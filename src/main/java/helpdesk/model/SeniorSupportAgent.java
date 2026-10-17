package helpdesk.model;

public class SeniorSupportAgent extends SupportAgent {
    public SeniorSupportAgent(long id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void performAction() {
        System.out.println(getName() + " разбирает сложные заявки");
    }
}
