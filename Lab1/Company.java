import java.util.*;

public class Company{
    private String type;
    private Set<Employees> AllEmployees;
    private Map <Employees, Integer> statistics;

    public Company(String _type) {
        this.type = _type;
        System.out.println(_type);
        if (_type.compareTo("1")== 0)
        {
            System.out.println("Zwykly sort");
            this.AllEmployees= new TreeSet<>();
            this.statistics= new TreeMap<>();
        }
        else
        {
            if(_type.compareTo("2")==0)
            {
                System.out.println("Inny sort");
                this.AllEmployees= new TreeSet<>(new Comparatorr());
                this.statistics= new TreeMap<>();
            }
            else
            {
                System.out.println("No sort");
                this.AllEmployees= new HashSet<>();
                this.statistics= new HashMap<>();
            }
        }
    }

    public void hire(Employees e)
    {
        AllEmployees.add(e);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(type, company.type) && Objects.equals(AllEmployees, company.AllEmployees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, AllEmployees);
    }

    @Override
    public String toString() {
        return "Company{" +
                "type='" + type + '\'' +
                '}';
    }
    

    public void print()
    {
        Set <Employees> bosses = new TreeSet<Employees>();
        for (Employees e : AllEmployees)
        {
            boolean boss=true;
            for (Employees e1 : AllEmployees)
            {
                for (Employees subor : e1.getSubordinates())
                {
                    if (subor == e)
                    {
                        boss=false;
                    }
                }
            }
            if (boss == true)
            {
                bosses.add(e);
            }
        }
        for (Employees e : bosses)
        {
            e.print("");
        }
    }

    public void print_stats()
    {
        int subs=0;
        for (Employees e : AllEmployees)
        {
            subs=0;
            subs=e.count_subs(subs);
            statistics.put(e,subs);
            String e_name=e.toString();
            e_name+=" : ";
            e_name+=subs;
            System.out.println(e_name);
        }
    }
}


