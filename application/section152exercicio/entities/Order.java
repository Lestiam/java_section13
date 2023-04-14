package application.section152exercicio.entities;



import application.section152exercicio.enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment = new Date();
    private OrderStatus status;
    private Client client;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(){
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }


    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public double total() {
        double total = 0;
        for ( OrderItem o : orderItems) {
            total += o.subTotal();
        }
        //return Double.parseDouble(String.format("%.2n",total));
        return total;
    }

    public String toString(){
        Date orderDate = new Date();
        StringBuilder sb = new StringBuilder();
        //sb.append("Order moment: " + orderDate);

        for (OrderItem o : orderItems) {
            sb.append(o.getProduct().getName());
            sb.append(" , $");
            sb.append(o.getPrice());
            sb.append(" , ");
            sb.append("Quantity: ");
            sb.append(o.getQuantity());
            sb.append(" , ");
            sb.append(" Subtotal: $");
            sb.append(o.subTotal());
            sb.append("\n");
        }
        sb.append("Total price: $");
        sb.append(total());

        return sb.toString();
    }
}
