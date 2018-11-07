package com.order.dao;

import com.order.dto.Order;

import java.sql.SQLException;

public class OrderDAOImpl implements OrderDAO{
    public int create(Order order) throws SQLException {
        return 0;
    }

    public Order read(int orderID) throws SQLException {
        return null;
    }

    public int updateOrder(Order order) throws SQLException {
        return 0;
    }

    public int delete(int orderID) throws SQLException {
        return 0;
    }
}
