package com.spring.reader.csvreader.service;

import com.spring.reader.csvreader.dto.OrderDTO;
import com.spring.reader.csvreader.exception.CSVReaderException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sanjay
 */
@Configuration
public class CSVService {
    @Autowired
    private ApplicationContext appContext;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     *
     * @param iStream
     * @return
     */
    public Iterable<? extends CSVRecord> getRecord(InputStream iStream) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(iStream, "UTF-8"))) {
            /* ** ** */
            CSVParser csvParser = new CSVParser(fileReader,
                    CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            /* ** ** */
            return csvParser.getRecords();
        } catch (UnsupportedEncodingException ueExe) {
            ueExe.printStackTrace();
        } catch (IOException ioExe) {
            ioExe.printStackTrace();
        }

        /* ** ** */
        return null;
    }

    /**
     *
     * @param iStream
     * @param <T>
     * @return
     */
    public <T> List<OrderDTO> getOrderRecord(InputStream iStream) throws CSVReaderException {
        /* ** ** */
        Iterable<CSVRecord> record = (Iterable<CSVRecord>) getRecord(iStream);

        /* ** ** */
        if(record == null && !record.iterator().hasNext())
            throw new CSVReaderException("no csv record found in file");

        List<OrderDTO> orders = new LinkedList<>();
        /* ** ** */
        record.forEach(fileRecord -> {
            OrderDTO orderDTO = appContext.getBean(OrderDTO.class);

            orderDTO.id = Long.parseLong(fileRecord.get("Row ID"));
            orderDTO.orderId = fileRecord.get("Order ID");
            System.out.print(fileRecord.get("Order Date"));
            try {
                orderDTO.orderDate = dateFormat.parse(fileRecord.get("Order Date"));
            } catch (ParseException e) {
                orderDTO.orderDate = Calendar.getInstance().getTime();
            }
            try {
                orderDTO.shipDate = dateFormat.parse(fileRecord.get("Ship Date"));
            } catch (ParseException e) {
                orderDTO.shipDate = Calendar.getInstance().getTime();
            }
            orderDTO.shipMode = fileRecord.get("Ship Mode");
            orderDTO.quantity = Integer.parseInt(fileRecord.get("Quantity"));
            orderDTO.discount = Double.parseDouble(fileRecord.get("Discount"));
            orderDTO.profit = Double.parseDouble(fileRecord.get("Profit"));
            orderDTO.productId = fileRecord.get("Product ID");
            orderDTO.customerName = fileRecord.get("Customer Name");
            orderDTO.category = fileRecord.get("Category");
            orderDTO.customerId = fileRecord.get("Customer ID");
            orderDTO.productName = fileRecord.get("Product Name");

            /* ** ** */
            orders.add(orderDTO);
        });

        /* ** ** */
        return orders;
    }
}
