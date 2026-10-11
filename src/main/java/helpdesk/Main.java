package helpdesk;

import helpdesk.model.Ticket;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HELP DESK ===");

        Ticket ticket = new Ticket(1, "Не работает Wi-Fi", "Ноутбук не видит сеть в аудитории");
        System.out.println("Заявка: " + ticket.getTitle());
        System.out.println("Статус: " + ticket.getStatus());

        ticket.startProcessing();
        System.out.println("Статус: " + ticket.getStatus());
        ticket.resolve();
        System.out.println("Статус: " + ticket.getStatus());
        ticket.close();
        System.out.println("Статус: " + ticket.getStatus());
    }
}
