package helpdesk;

import helpdesk.model.Administrator;
import helpdesk.model.Customer;
import helpdesk.model.SupportAgent;
import helpdesk.model.Ticket;
import helpdesk.model.User;
import helpdesk.repository.TicketRepository;
import helpdesk.service.ConsoleNotificationService;
import helpdesk.service.NotificationService;
import helpdesk.service.TicketService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== HELP DESK ===");

        Customer anna = new Customer(1, "Анна Петрова", "anna@mail.ru");
        SupportAgent sergey = new SupportAgent(2, "Сергей Иванов", "sergey@helpdesk.ru");
        System.out.println("Клиент: " + anna.getName());
        System.out.println("Специалист: " + sergey.getName());

        Ticket wifiTicket = new Ticket(1, "Не работает Wi-Fi", "Ноутбук не видит сеть в аудитории");
        System.out.println("Заявка: " + wifiTicket);

        NotificationService notificationService = new ConsoleNotificationService();
        TicketService ticketService = new TicketService(notificationService);

        ticketService.startTicket(wifiTicket);
        System.out.println("Статус: " + wifiTicket.getStatus());
        ticketService.resolveTicket(wifiTicket);
        System.out.println("Статус: " + wifiTicket.getStatus());
        ticketService.closeTicket(wifiTicket);
        System.out.println("Статус: " + wifiTicket.getStatus());

        TicketRepository ticketRepository = new TicketRepository();
        ticketRepository.add(wifiTicket);
        ticketRepository.add(new Ticket(2, "Ошибка приложения", "Приложение вылетает при открытии"));
        ticketRepository.add(new Ticket(3, "Не печатает принтер", "Документы зависают в очереди печати"));

        System.out.println();
        System.out.println("Все заявки:");
        for (Ticket item : ticketRepository.findAll()) {
            System.out.println(item);
        }

        System.out.println();
        List<User> users = new ArrayList<>();
        users.add(anna);
        users.add(sergey);
        users.add(new Administrator(3, "Олег", "admin@helpdesk.ru"));

        for (User user : users) {
            user.performAction();
        }
    }
}
