import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class Employee {
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(String firstName, String lastName, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName;  }
    public double getSalary()    { return salary;    }
}

public class Mapping {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Khayal",   "Shafiyev",   75000.00));
        employees.add(new Employee("Bob",     "Johnson", 52000.50));
        employees.add(new Employee("Clara",   "Williams",98000.00));
        employees.add(new Employee("David",   "Brown",   43000.75));
        employees.add(new Employee("Emma",    "Jones",   61000.00));

        Function<Employee, String> formatCard = e -> "Name: [" + e.getLastName() + ", " + e.getFirstName() + "] - Salary: $" + e.getSalary();

        Function<Employee, Double> salaryPicker = Employee::getSalary;

        for (Employee e : employees) {
            System.out.println(formatCard.apply(e));
            System.out.println("Salary only: $" + salaryPicker.apply(e));
            System.out.println();
        }
    }
}
