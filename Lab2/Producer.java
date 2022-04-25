import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;

public class Producer implements Runnable{
    private Resource resource;
    public Producer(Resource _resource)
    {
        this.resource=_resource;
    }

    @Override
    public void run()
    {
            List<Integer> generated = new ArrayList<Integer>(3);
            Random rnd = new Random();
            for (int i = 0; i < 5; i++) {
                generated.add(Math.abs(rnd.nextInt() % 10000));
            }
            resource.put(generated);
    }
}
