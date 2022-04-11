import java.util.Comparator;

public class Comparatorr implements Comparator<Employees> {
    @Override
    public int compare(Employees o1, Employees o2) {
        int result;
        result = o1.getClearanceLevel() - o2.getClearanceLevel();
        if(result != 0){
            return result;
        }

        result = o1.getName().compareTo(o2.getName());
        if(result != 0){
            return result;
        }

        result = o1.getJobTitle().compareTo(o2.getJobTitle());
        if(result != 0){
            return result;
        }

        result = o1.getDepartment().compareTo(o2.getDepartment());
        if(result != 0){
            return result;
        }

        result = o1.getSalary() - o2.getSalary();
        if(result != 0){
            return result;
        }
        return 0;
    }
}
