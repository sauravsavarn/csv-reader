package com.spring.reader.csvreader.repository;

import com.spring.reader.csvreader.dao.OrderDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sanjay
 * <p>
 * Use the repository default methods:
 * save(), findOne(), findById(), findAll(), count(), delete(), deleteById()
 */
@Repository
public interface StoreRepository extends JpaRepository<OrderDAO, Long> {

}