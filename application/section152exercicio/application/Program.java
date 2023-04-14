package application.section152exercicio.application;

import application.section152exercicio.entities.Client;
import application.section152exercicio.entities.Order;
import application.section152exercicio.entities.OrderItem;
import application.section152exercicio.entities.Product;
import application.section152exercicio.enums.OrderStatus;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String clientEmail = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date clientBirth = sdf.parse(sc.next());

        Client client = new Client(clientName, clientEmail, clientBirth);

        System.out.println("Enter order data: ");
        sc.nextLine();
        System.out.print("Status: ");
        String orderStatus = sc.nextLine();
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        Date orderDate = new Date();
        Order order = new Order(orderDate, OrderStatus.valueOf(orderStatus), client);


        OrderItem orderItem = null;
        for (int i = 1; i <= n; i++) {
            sc.nextLine();
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String prodName = sc.nextLine();
            System.out.print("Product price: ");
            double prodPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int prodQuantity = sc.nextInt();
            orderItem = new OrderItem(prodQuantity, prodPrice, new Product(prodName, prodPrice));
            order.addItem(orderItem);
            System.out.println();
        }

        //usei o StringBuilder na Classe Order
        System.out.println("ORDER SUMMARY: ");
        String orderDateFormatada = sdf2.format(orderDate);
        System.out.print("Order moment: " +  orderDateFormatada);
        System.out.print("\nOrder status: " + orderStatus);
        System.out.print("\nClient: " + client.getName() + " " + "(" + sdf.format(client.getBirthDate()) + ")" + " - " + client.getEmail());
        System.out.println("\nOrder items:");

        System.out.println(order);


        sc.close();
    }
}
