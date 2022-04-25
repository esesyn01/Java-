import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Saver {
    private Map<Integer,Boolean> results= new TreeMap<>();
    public synchronized void put(int number, boolean res)
    {
        results.put(number,res);
    }
    public synchronized void print()
    {
        results.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
