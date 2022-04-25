import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Resource {
    private List<Integer> numbers = new ArrayList<>();
    public synchronized int take() throws InterruptedException
    {
        while(numbers.isEmpty())
        {
            wait();
        }
        int ret = numbers.get(0);
        numbers.remove(0);
        return ret;
    }
    public synchronized void put(List<Integer> numb)
    {
        numbers.addAll(numb);
        notifyAll();
    }
}
