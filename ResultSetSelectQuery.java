package javamysqlconnectivity;

import java.util.Date;

public class ResultSetSelectQuery {

    private int orderId;
    private Date orderDate;
    private int totalPrice;

    ResultSetSelectQuery(int orderId, Date orderDate, int totalPrice) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
