package com.order.dao;

import com.order.dto.Order;

import java.sql.SQLException;

public interface OrderDAO {

    int create(Order order) throws SQLException;
    Order read(int orderID) throws SQLException;

    int updateOrder(Order order) throws SQLException;

    int delete(int orderID) throws  SQLException;




}
