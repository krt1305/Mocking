import com.order.bo.OrderBOImpl;
import com.order.bo.exception.BOException;
import com.order.dao.OrderDAO;
import com.order.dto.Order;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

public class OrderBoImplTest {

    @Mock
    OrderDAO dao;
    List mockList;

    @Before
    public void setUp()
    {
            MockitoAnnotations.initMocks(this);
    }



    @Test
    public void placeOrder_Should_Create_An_Order() throws BOException ,SQLException{
        OrderBOImpl bo=new OrderBOImpl();
        bo.setDao(dao);
        Order order=new Order();
        when(dao.create(order)).thenReturn(new Integer(1));

           boolean placeOrderResult= bo.placeOrder(order);

        assertTrue(placeOrderResult);
        verify(dao).create(order);


    }

    @Test
    public void placeOrder_Should_Not_Create_An_Order() throws BOException ,SQLException{
        OrderBOImpl bo=new OrderBOImpl();
        bo.setDao(dao);
        Order order=new Order();
        when(dao.create(order)).thenReturn(new Integer(0));

        boolean placeOrderResult= bo.placeOrder(order);

        assertFalse(placeOrderResult);
        verify(dao).create(order);


    }

    @Test(expected = BOException.class)
    public void placeOrder_Should_Throw_BOException() throws BOException ,SQLException{
        OrderBOImpl bo=new OrderBOImpl();
        bo.setDao(dao);
        Order order=new Order();
        when(dao.create(order)).thenThrow(SQLException.class);

        boolean placeOrderResult= bo.placeOrder(order);





    }

   @Test(expected=RuntimeException.class)
    public void mockList()
   {
       mockList=mock(List.class);
        when(mockList.size()).thenReturn(2);
       System.out.println(mockList.size());
       when(mockList.get(anyInt())).thenReturn("abc");
       System.out.println(mockList.get(0));
       System.out.println(mockList.get(1));
       when(mockList.get(0)).thenThrow(new RuntimeException("list exception"));
       mockList.get(0);
   }
}
