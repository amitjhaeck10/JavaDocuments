package com.java.java8feature;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Programming {

    public static void main(String[] args) {
     List<Employee> employeeList = buildEmployeeList();

      //1.Write a program to print employee details working in each department
      Map<Integer, Set<Employee>> mapDeptIDToEmployee =
        employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.toSet()));

      mapDeptIDToEmployee.forEach((e1,e2)->{
          System.out.println(" DeptID:"+e1);
          e2.stream().forEach(e3-> System.out.println(e3+","));
      });

      //2.Write a program to print employees count working in each department
        Map<Integer, Long> mapDeptIDToCount =
                employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.counting()));
        mapDeptIDToCount.entrySet().stream().forEach(e1->System.out.println(e1.getKey()+":"+e1.getValue()));

        //3.Write a program to print active and inactive employees in the given collection
        List<Employee> activeEmployee = employeeList.stream().filter(e-> e.getStatus()=="active").collect(Collectors.toList());
        List<Employee> inActiveEmployee = employeeList.stream().filter(e-> e.getStatus()=="inactive").collect(Collectors.toList());

        Long activeEmpCount = employeeList.stream().filter(e-> e.getStatus()=="active").count();
        Long inActiveEmpCount = employeeList.stream().filter(e-> e.getStatus()=="inactive").count();

        //4.Write a program to print Max/Min employee salary from the given collection
        System.out.println("================ Get Max/Min employee salary from the given collection ===========");
        Optional<Employee> maxEmployee = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(maxEmployee.isEmpty()+" "+maxEmployee.isPresent()+" "+maxEmployee.get().getSalary());
        Optional<String> option = Optional.ofNullable(null);
        System.out.println(option.isEmpty());
        int minSalary = employeeList.stream().min(Comparator.comparing(Employee::getSalary)).get().getSalary();

        //5.Write a program to print the max salary of an employee from each department
        System.out.println("=========== Max salary of an employee in each department ======");

        mapDeptIDToEmployee.forEach((e1,e2)->{
            System.out.print("DeptID: "+e1);
            System.out.println(" Max Salary: "+e2.stream().max(Comparator.comparing(Employee::getSalary)).get().getSalary());
        });


    }

    public static List<Employee> buildEmployeeList(){
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(101, "siva", 101, "active", 2000));
        empList.add(new Employee(102, "reddy", 101, "active", 5000));
        empList.add(new Employee(103, "raju", 102, "inactive", 6000));
        empList.add(new Employee(104, "shivam", 102, "inactive", 4000));
        empList.add(new Employee(105, "bob", 103, "active", 3500));
        empList.add(new Employee(106, "alice", 103, "inactive", 3500));
        empList.add(new Employee(107, "srinu", 104, "active", 3500));

        return empList;
    }
}

class Employee{

    private int empId;
    private String empName;
    private int deptId;
    private String status = "active";
    private int salary;

    public Employee(int empId, String empName, int deptId, String status, int salary) {
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
        this.status = status;
        this.salary = salary;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getStatus() {
        return status;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return this.empId == employee.getEmpId() && getDeptId() == employee.getDeptId() && getSalary() == employee.getSalary() && Objects.equals(getEmpName(), employee.getEmpName()) && Objects.equals(getStatus(), employee.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpId(), getEmpName(), getDeptId(), getStatus(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", deptId=" + deptId +
                ", status='" + status + '\'' +
                ", salary=" + salary +
                '}';
    }
}
