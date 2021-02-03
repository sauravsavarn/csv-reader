package com.spring.reader.csvreader.service;

import com.spring.reader.csvreader.dao.OrderDAO;
import com.spring.reader.csvreader.dto.OrderDTO;
import com.spring.reader.csvreader.message.ResponseMessage;
import com.spring.reader.csvreader.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author : Sanjay
 */
@Configuration
public class DBService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ApplicationContext appContext;
    
    public ResponseEntity<ResponseMessage> saveToStore(List<? extends OrderDTO> orders, ResponseMessage responseMessage) {

        /* ** calling to insert into mysql-table one-by-one ** */
        orders.forEach(order -> {
            /* ** ** */
            //OrderDAO orderDAO = appContext.getBean(OrderDAO.class);
            //orderDAO.setAllProperties(order.id, order.orderId, order.orderDate, order.shipDate, order.shipMode, order.quantity, order.discount, order.profit, order.productId, order.customerName, order.category, order.customerId, order.productName);
            OrderDAO orderDAO = new OrderDAO(order.id, order.orderId, order.orderDate, order.shipDate, order.shipMode, order.quantity, order.discount, order.profit, order.productId, order.customerName, order.category, order.customerId, order.productName);

            /* ** ** */
            storeRepository.save(orderDAO);
            System.out.print("Inserted into schema 'store' success");
        });

        /* ** ** */
        responseMessage.setMessage("all records saved successfully to database table: Store");
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }
    
    public <T> Object getFromStore(int storeId) {
        return null;
    }
}
