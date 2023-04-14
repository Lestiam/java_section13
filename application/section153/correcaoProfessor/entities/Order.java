package application.section153.correcaoProfessor.entities;

import application.section153.correcaoProfessor.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) { //não tem o items pq nele eu já criei um novo item (new arrayList)
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

    //não se pode ter um setItems, pois temos que adicionar e remover itens da Lista e não trocar a lista
    //e não pode ter um getItems pois o método get consegue acessar diretamente a lista e usar o .add e o .remove

    public void addItem(OrderItem item){
        items.add(item);
    }
    public void removeItem(OrderItem item) {
        items.remove(item);
    }
    public double total() {
        double sum = 0.0;
        for (OrderItem it : items) {//para cada item it na minha lista items...
            sum += it.subTotal();//sum recebe ele mesmo + o subTotal
        }
        return sum;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: \n");
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f" , total()));
        return sb.toString();
    }
}
