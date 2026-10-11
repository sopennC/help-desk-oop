package helpdesk;

import helpdesk.model.Ticket;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HELP DESK ===");

        Ticket ticket = new Ticket(
                1,
                "Не работает интернет",
                "После перезагрузки компьютера пропало подключение"
        );
        System.out.println("Статус: " + ticket.status);

        ticket.status = "БАНАН";
        System.out.println("Статус: " + ticket.status);
    }
}
