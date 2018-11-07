package com.order.bo;

import com.order.bo.exception.BOException;
import com.order.dto.Order;

public interface OrderBO {

    boolean placeOrder(Order order) throws BOException;
    boolean cancelOrder(int orderId) throws BOException;
    boolean deleteOrder(int orderId) throws BOException;

}
