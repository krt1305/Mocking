package com.order.bo;

import com.order.bo.exception.BOException;
import com.order.dao.OrderDAO;
import com.order.dto.Order;

import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {


    private OrderDAO dao;



    public boolean placeOrder(Order order) throws BOException {
        try {
            int result=dao.create(order);
            if(result==0)
                return  false;
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }

    public boolean cancelOrder(int orderId) throws BOException {
        try {
           Order order= dao.read(orderId);
           order.setStatus("cancel");
           int updateResult=dao.updateOrder(order);
           if(updateResult==0)
               return false;
        } catch (SQLException e) {
            throw new BOException(e);
        }
        return true;
    }

    public boolean deleteOrder(int orderId) throws BOException {
        try {
            int deleteResult=dao.delete(orderId);
            if(deleteResult==0)
                return false;
        } catch (SQLException e) {
            throw new BOException(e);
        }

        return true;
    }

    public OrderDAO getDao() {
        return dao;
    }

    public void setDao(OrderDAO dao) {
        this.dao = dao;
    }
}

