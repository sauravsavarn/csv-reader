package com.spring.reader.csvreader.controller;

import com.spring.reader.csvreader.dto.OrderDTO;
import com.spring.reader.csvreader.message.ResponseMessage;
import com.spring.reader.csvreader.service.CSVService;
import com.spring.reader.csvreader.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Sanjay
 * <p>
 * This is the main Controller class to mediate all action on request
 */
@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CSVController {

    @Autowired
    private Environment environment;
    @Autowired
    private CSVService csvService;
    @Autowired
    private DBService dbService;
    StringBuilder message = new StringBuilder();

    @GetMapping("/consume")
    public ResponseEntity<ResponseMessage> consumeFile(ResponseMessage responseMessage) {
        /* ** ** */
        final String filePath = environment.getProperty("bucket.csv.path");
        final File file = new File(filePath);
        /* ** ** */
        if(!file.exists() && !file.isFile() && !file.canRead()) {
            responseMessage.setMessage("Please check the File, either it not exists or not a file or Read permission denied");

            /* ** ** */
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
        }

        /* ** ** */
        FileInputStream fiStream = null;
        List<OrderDTO> lOrders = null;
        try {
            fiStream = new FileInputStream(file);
            lOrders = csvService.getOrderRecord(fiStream);
        } catch (FileNotFoundException e) {
            /* ** ** */
            responseMessage.setMessage("File not found exception");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
        }

        /* ** Finally call to insert records filtered into database-schema ** */
        dbService.saveToStore(lOrders, responseMessage);

        /* ** ** */
        responseMessage.setMessage("File consumed successfully");
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }
}