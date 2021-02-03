package com.spring.reader.csvreader.dto;

import lombok.*;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author : Sanjay
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames=true)
@Configuration
public @Data class OrderDTO {
    public Long id;
    @Getter @Setter
    public String orderId;
    @Getter @Setter
    public Date orderDate;
    @Getter @Setter
    public Date shipDate;
    @Getter @Setter
    public String shipMode;
    @Getter @Setter
    public int  quantity;
    @Getter @Setter
    public double discount;
    @Getter @Setter
    public double profit;
    @Getter @Setter
    public String productId;
    @Getter @Setter
    public String  customerName;
    @Getter @Setter
    public String category;
    @Getter @Setter
    public String customerId;
    @Getter @Setter
    public String productName;
}