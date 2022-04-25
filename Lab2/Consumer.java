public class Consumer implements  Runnable{
    private  Resource resource;
    private Saver saver;
    public Consumer(Resource _resource, Saver _saver)
    {
        this.resource=_resource;
        this.saver=_saver;
    }

    @Override
    public void run()
    {
        while(!Thread.interrupted()) {
            try {
                int to_check = resource.take();
                boolean res = check_ifprime(to_check);
                saver.put(to_check, res);
            } catch (InterruptedException ex)
            {
                break;
            }
        }
    }

    public boolean check_ifprime(int n)
    {
        for (int i=2; i*i<=n; i++)
        {
            if (n%i==0)
            {
                return false;
            }
        }
        return true;
    }
}
