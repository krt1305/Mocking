import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class testCollections {


    @Test
    public void test()
    {
        ArrayList<String> arr=new ArrayList<String>();
        arr.add("abc");
        arr.add("bb");
        arr.add("mm");

        Iterator<String> it=arr.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
            it.remove();

        }




}
}
