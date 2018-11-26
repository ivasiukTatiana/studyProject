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
public class StaffReader {
    private final int NUMBER_FIELDS = 13;
    
    private String path;
    private static String[][]dataTable; 
    
    public StaffReader(String path) throws IOException, PersonException, EmployeeException {
        this.path = path;

        String str;
        String[] strArr;
        ArrayList<String[]> work = new ArrayList();
          
        BufferedReader staffDB = new BufferedReader(new FileReader(this.path));
        while ((str = staffDB.readLine()) != null) {
            
            if (str.split("; ").length == (NUMBER_FIELDS - 1)){
                str = str + " ";
            }
            strArr = str.split("; "); 
            work.add(strArr);
        }
        staffDB.close();
        
        if (!work.isEmpty()) {
            dataTable = new String[work.size()][NUMBER_FIELDS]; 
            
            for (int i = 0; i < work.size(); i++) {
                dataTable[i] = work.get(i);
            }
        }
    }

    public static String[][] getDataTable() {
        return dataTable;
    }

    public Integer readEmployees() throws IOException, PersonException, EmployeeException {
 
        int idCorrection = 0;
        ArrayList<String> dataPerson = new ArrayList();
        ArrayList<String> dataWork = new ArrayList();
 
        if (dataTable != null) {
 
            for (int i = 0; i < dataTable.length; i++) {
            
                dataWork.add(dataTable[i][0]);
                for (int j = 1; j <= 4; j++) {
                    dataPerson.add(dataTable[i][j]);
                }
                for (int j = 5; j < dataTable[i].length; j++) {
                    dataWork.add(dataTable[i][j]);
                }
                Employee.add(new Employee(new Person(dataPerson), dataWork));
                dataPerson.clear();
                dataWork.clear();
            }
            idCorrection = Integer.parseInt(dataTable[dataTable.length - 1][0]) - dataTable.length;
            //Employee.allEmployees(); //for tast
        } 
        //return employees;
        return idCorrection;
    }
}
