/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdb;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Employee{
    
    private final int IDEMPLOYEE = 0;
    private final int POSITION = 1;
    private final int DEPARTMENT = 2;
    private final int ROOM = 3;
    private final int PHONE = 4;
    private final int EMAIL = 5;
    private final int SALARY = 6;
    private final int DATERECR = 7;
    private final int NOTES = 8;

    private static int id = 0;
    private String idEmployee;
    private Person dataPerson;
    private String position;
    private String department;
    private String room;
    private String phone;
    private String email;
    private String salary;
    private String dateRecr;
    private String notes;
    private static ArrayList<Employee> employees;
    private boolean isDeleted;

    public Employee(Person dataPerson, ArrayList<String> dataEmployee) throws EmployeeException {
        this.dataPerson = dataPerson;
        //data validation not valid data
        //if(dataEmployee.get(POSITION).length() == 0) throw new EmployeeException("Не заповнено поле 'Посада'", EmployeeException.NO_POSITION);
        if(dataEmployee.get(DATERECR).length() == 0) throw new EmployeeException("Не заповнено поле 'Дата пр. на роботу'", EmployeeException.NO_DATE);
        
        idEmployee = dataEmployee.get(IDEMPLOYEE);
        position = dataEmployee.get(POSITION);
        department = dataEmployee.get(DEPARTMENT);
        room = dataEmployee.get(ROOM);
        phone = dataEmployee.get(PHONE);
        email = dataEmployee.get(EMAIL);
        salary = dataEmployee.get(SALARY);
        dateRecr = dataEmployee.get(DATERECR);
        notes = dataEmployee.get(NOTES);
        
        id ++;
    }

    public static int getId() {
        return id;
    }
    
    public String getIdEmployee() {
        return idEmployee;
    }

    public Person getDataPerson() {
        return dataPerson;
    }
    public void setDataPerson(Person dataPerson) {
        this.dataPerson = dataPerson;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDateRecr() {
        return dateRecr;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public static void add(Employee employee) {
        try {
            employees.add(employee);
    
        } catch (Exception e) {
            employees = new ArrayList();
            employees.add(employee); 
        }
    }

    public static void edit(String[] datanew) {

        String idEmployee = datanew[0];
        int countIndex = 1;
        for (Employee emp : employees ) {
            if (emp.getIdEmployee().equals(idEmployee)) {
                
                emp.dataPerson.setSecondName(datanew[countIndex]);
                countIndex += 1;
                emp.dataPerson.setFirstName(datanew[countIndex]);
                countIndex += 1;
                emp.dataPerson.setSurname(datanew[countIndex]);
                countIndex += 1;
                emp.dataPerson.setDateBirth(datanew[countIndex]);
                countIndex += 1;
                
                emp.setPosition(datanew[countIndex]);
                countIndex += 1;
                emp.setDepartment(datanew[countIndex]);
                countIndex += 1;
                emp.setRoom(datanew[countIndex]);
                countIndex += 1;
                emp.setPhone(datanew[countIndex]);
                countIndex += 1;
                emp.setEmail(datanew[countIndex]);
                countIndex += 1;
                emp.setSalary(datanew[countIndex]);
                countIndex += 1;
                //emp.setDateRecr(datanew[]);
                countIndex += 1;
                emp.setNotes(datanew[countIndex]);
            }
        }
    }
    
    public static void delete(String idDeleted) {

        for (Employee emp : employees ) {
            if (emp.getIdEmployee().equals(idDeleted)) {
                emp.setIsDeleted(true);
            } 
        }    
    }
    
    public static void allEmployees() {
        if (employees != null) { 
            employees.forEach((emp) -> System.out.println(emp)); //for test
        }
    }
 
    @Override
    public String toString() {
        String str = idEmployee + "; " + 
                dataPerson + "; " + 
                position + "; " + 
                department + "; " + 
                room + "; " + 
                phone + "; " + 
                email + "; " + 
                salary + "; " + 
                dateRecr + "; " + 
                notes;
        return str;
    }
}
