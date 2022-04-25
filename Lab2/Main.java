import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinWorkerThread;

public class Main {
    public static void main(String[] args)
    {
        int n= Integer.parseInt(args[0]);
        Resource resource = new Resource();
        Saver saver = new Saver();
        Producer producer = new Producer(resource);
        List<Thread> threads = new ArrayList<>(n);
        Consumer consumer= new Consumer(resource,saver);
        Thread prod = new Thread(producer);
        prod.start();
        for (int i=0; i<n; i++)
        {
            Thread thread = new Thread(consumer);
            thread.start();
            threads.add(thread);
        }
        Scanner input = new Scanner(System.in);
        String command="nocmd";
        while(command.compareTo("end")!=0)
        {
            command=input.nextLine();
            if (command.compareTo("print")==0)
            {
                saver.print();
                System.out.println("\n");
                System.out.println("\n");
            }
            if (command.compareTo("add")==0)
            {
                command=input.nextLine();
                int to_add = Integer.parseInt(command);
                List<Integer> addd = new ArrayList<>();
                addd.add(to_add);
                resource.put(addd);
            }

        }
        prod.interrupt();
        try{prod.join();}
        catch (InterruptedException ex){}
        for(Thread thread : threads)
        {
            thread.interrupt();
        }
        for (Thread thread : threads)
        {
            try{
                thread.join();
            } catch (InterruptedException ex){}
        }
    }
}
