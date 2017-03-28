package craterzone.ems.controler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import craterzone.ems.model.Employee;

/**
 * Created by aMAN GUPTA on 3/2/2017.
 */

public class ListControler {
    public static HashSet<Employee> employeeList = new HashSet<>();

    public static boolean addEmployee(Employee employee){
        return employeeList.add(employee);
    }

    public static List<Employee> getList(){
        ArrayList<Employee> list= new ArrayList<>();
        for (Employee employee:employeeList) {
            list.add(employee);
        }
        return list;
    }
}
