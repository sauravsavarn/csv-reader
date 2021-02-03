package com.spring.reader.csvreader.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * @author : Sanjay
 */
@Entity
@Table(name = "store_order")
public class OrderDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORDER_ID")
    private String orderId;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "SHIP_DATE")
    private Date shipDate;

    @Column(name = "SHIP_MODE")
    private String shipMode;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "DISCOUNT")
    private double discount;

    @Column(name = "PROFIT")
    private double profit;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "first_name")
    public String getOrderId() {
        return orderId;
    }

    public OrderDAO() {
    }

    public OrderDAO(Long id, String orderId, Date orderDate, Date shipDate, String shipMode, int quantity, double discount, double profit, String productId, String customerName, String category, String customerId, String productName) {
        this.id = id;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.shipMode = shipMode;
        this.quantity = quantity;
        this.discount = discount;
        this.profit = profit;
        this.productId = productId;
        this.customerName = customerName;
        this.category = category;
        this.customerId = customerId;
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public Date getShipDate() {
        return shipDate;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipMode() {
        return shipMode;
    }

    public void setShipMode(String shipMode) {
        this.shipMode = shipMode;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAllProperties(Long id, String orderId, Date orderDate, Date shipDate, String shipMode, int quantity, double discount, double profit, String productId, String customerName, String category, String customerId, String productName) {
        this.id = id;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.shipMode = shipMode;
        this.quantity = quantity;
        this.discount = discount;
        this.profit = profit;
        this.productId = productId;
        this.customerName = customerName;
        this.category = category;
        this.customerId = customerId;
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "OrderDAO{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", shipDate=" + shipDate +
                ", shipMode='" + shipMode + '\'' +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", profit=" + profit +
                ", productId='" + productId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", category='" + category + '\'' +
                ", customerId='" + customerId + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}