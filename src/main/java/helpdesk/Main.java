package helpdesk;

import helpdesk.model.Administrator;
import helpdesk.model.Customer;
import helpdesk.model.SupportAgent;
import helpdesk.model.Ticket;
import helpdesk.model.User;
import helpdesk.service.ConsoleNotificationService;
import helpdesk.service.NotificationService;
import helpdesk.service.TicketService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HELP DESK ===");

        NotificationService notificationService = new ConsoleNotificationService();
        TicketService ticketService = new TicketService(notificationService);

        Ticket ticket = new Ticket(1, "Не работает Wi-Fi", "Ноутбук не видит сеть в аудитории");
        System.out.println("Заявка: " + ticket.getTitle());
        System.out.println("Статус: " + ticket.getStatus());

        ticketService.startTicket(ticket);
        System.out.println("Статус: " + ticket.getStatus());
        ticketService.resolveTicket(ticket);
        System.out.println("Статус: " + ticket.getStatus());
        ticketService.closeTicket(ticket);
        System.out.println("Статус: " + ticket.getStatus());

        System.out.println();
        List<User> users = new ArrayList<>();
        users.add(new Customer(1, "Анна", "anna@mail.ru"));
        users.add(new SupportAgent(2, "Сергей", "sergey@helpdesk.ru"));
        users.add(new Administrator(3, "Олег", "admin@helpdesk.ru"));

        for (User user : users) {
            user.performAction();
        }
    }
}
