import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args)
    {
        String argument = args[0];
        Company comp = new Company(argument);
        initialize(comp);
        comp.print();
        comp.print_stats();
    }
    public static void initialize(Company comp)
    {
        Employees e1= new Employees("John Bass","Worker","Logistics",1,2500);
        Employees e2= new Employees("Gregory Newman","Researcher","Inventions",3,12500);
        Employees e3= new Employees("Ann Shepherd","Founder","Inventions",4,17800);
        Employees e4 = new Employees("Neil Armweak","Junior Developer","Modern Tech",2,4200);
        Employees e5 = new Employees("Arnold Schwarz","Senior developer","Modern tech",2,6700);
        Employees e6 = new Employees("Frank Smisth","Junior Developer","Modern Tech",1,5200);
        Employees e7 = new Employees("Jeff Trotsky","Junior Developer","Modern Tech",1,5000);
        Employees e8 = new Employees("Pablo Area","Senior Developer","Modern Tech",2,7200);
        Employees e9 = new Employees("Chu Main","Project Manager","Modern Tech",3,11200);
        Employees e10 =new Employees("Caroline Brown","HR manager","Human Resource",3,9600);
        e2.add_subordinate(e1);
        e3.add_subordinate(e2);
        e5.add_subordinate(e4);
        e8.add_subordinate(e6);
        e8.add_subordinate(e7);
        e9.add_subordinate(e5);
        e9.add_subordinate(e8);
        comp.hire(e1);
        comp.hire(e2);
        comp.hire(e3);
        comp.hire(e4);
        comp.hire(e5);
        comp.hire(e6);
        comp.hire(e7);
        comp.hire(e8);
        comp.hire(e9);
        comp.hire(e10);
    }
}
