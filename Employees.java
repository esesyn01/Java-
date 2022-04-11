import java.util.TreeSet;
import java.util.Set;

public class Employees implements Comparable<Employees>{
    private String Name;
    private String JobTitle;
    private String department;
    private int clearanceLevel;
    private int salary;
    private Set<Employees> subordinates;

    public Employees(String name, String jobTitle, String department, int clearanceLevel, int salary) {
        Name = name;
        JobTitle = jobTitle;
        this.department = department;
        this.clearanceLevel = clearanceLevel;
        this.salary = salary;
        this.subordinates = new TreeSet<Employees>();
    }

    public void add_subordinate(Employees e){
        subordinates.add(e);
    }

    public Set<Employees> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Employees> subordinates) {
        this.subordinates = subordinates;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getClearanceLevel() {
        return clearanceLevel;
    }

    public void setClearanceLevel(int clearanceLevel) {
        this.clearanceLevel = clearanceLevel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void print(String levels)
    {
        String e_name=this.toString();
        levels+="-";
        System.out.print(levels);
        System.out.println(e_name);
        for (Employees subor : subordinates)
        {
            subor.print(levels);
        }
        levels=levels.substring(0,levels.length()-1);
    }

    public int count_subs(int subs)
    {
        for (Employees e : subordinates)
        {
            subs=e.count_subs(subs);
            subs+=1;
        }
        return subs;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Employees employees = (Employees) object;

        if (clearanceLevel != employees.clearanceLevel) return false;
        if (salary != employees.salary) return false;
        if (Name != null ? !Name.equals(employees.Name) : employees.Name != null) return false;
        if (JobTitle != null ? !JobTitle.equals(employees.JobTitle) : employees.JobTitle != null) return false;
        if (department != null ? !department.equals(employees.department) : employees.department != null) return false;
        if (subordinates != null ? !subordinates.equals(employees.subordinates) : employees.subordinates != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (JobTitle != null ? JobTitle.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + clearanceLevel;
        result = 31 * result + salary;
        result = 31 * result + (subordinates != null ? subordinates.hashCode() : 0);
        return result;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Employees{" +
                "Name='" + Name + '\'' +
                ", clearanceLevel=" + clearanceLevel +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employees e) {
        int result = this.Name.compareTo(e.Name);
        if (result != 0) {
            return result;
        }

        result = this.JobTitle.compareTo(e.JobTitle);
        if (result != 0) {
            return result;}

        result = this.department.compareTo(e.department);
        if (result != 0) {
            return result;}

        result = clearanceLevel - e.clearanceLevel;
        if (result != 0) {
            return result;
        }

        result = salary - e.salary;
        return result;


    }
}


