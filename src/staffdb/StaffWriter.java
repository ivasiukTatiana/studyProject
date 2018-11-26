/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdb;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class StaffWriter {
 
    //private static String dir = "src/employeesDB";
    //private static String path = dir + "/employeesDB.txt";
    
    private static String dir = Initializer.getDir();
    private static String path = dir + "/" + Initializer.getFileName();
    
    private ArrayList<Employee> employees = new ArrayList();

    public StaffWriter(ArrayList<Employee> employees){
        this.employees = employees;
        //Employee.allEmployees(); //for test 
    }

    public static String getPath() {
        return path;
    }
    
    public void writeEmployees() throws IOException  {
        
        if (!(new File(dir).exists())) {
            new File(dir).mkdir();
        }
        BufferedWriter staffDB = new BufferedWriter(new FileWriter(path));
        if (!employees.isEmpty()) {
             for(Employee emp : employees) {

                if (!emp.isIsDeleted()) {
                    staffDB.write(emp.toString()+'\n');
                }
            }
        }
        staffDB.close();
    }
}
