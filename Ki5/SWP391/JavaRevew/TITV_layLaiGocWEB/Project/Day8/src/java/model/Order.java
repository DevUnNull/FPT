package model;

import java.util.Date;

public class Order {
    private int id;
    private int userId;
    private Date orderDate;
    private String status;      // pending, shipped, completed,...
    private int totalAmount;    // 👉 Tổng tiền đơn hàng (cần thêm)

    public Order() {}

    // Constructor đầy đủ
    public Order(int id, int userId, Date orderDate, String status, int totalAmount) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", userId=" + userId +
               ", orderDate=" + orderDate +
               ", status='" + status + '\'' +
               ", totalAmount=" + totalAmount +
               '}';
    }
}
