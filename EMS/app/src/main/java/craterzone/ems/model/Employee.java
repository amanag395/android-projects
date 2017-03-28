package craterzone.ems.model;

/**
 * Created by aMAN GUPTA on 3/2/2017.
 */

public class Employee {
    private String id;
    private String name;
    private double salary;
    private String gender;
    private String department;

    public Employee(String id, String name, double salary, String gender, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return id.equals(employee.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return  " Id = " + id +
                "\n Name = " + name +
                "\n Salary = " + salary +
                "\n Gender = " + gender +
                "\n Department = " + department ;
    }
}
