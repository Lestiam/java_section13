package application.section146;

import application.section146.entities.Order;
import application.section146.enums.OrderStatus;

import java.util.Date;

public class Program {
    public static void main(String[] args) {

        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);//new Date imprime a data atual

        System.out.println(order);

        OrderStatus os1 = OrderStatus.DELIVERED;

        OrderStatus os2 = OrderStatus.valueOf("DELIVERED"); //valueOf converte de String para Enum, TEM QUE ESTAR MAIUSCULO

        System.out.println(os1);
        System.out.println(os2);
    }
}
