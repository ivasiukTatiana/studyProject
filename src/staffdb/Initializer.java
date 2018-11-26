/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdb;

/**
 *
 * @author Admin
 */
public class Initializer {
    private static String dir = "src/employeesDB";
    private static String fileName = "employeesDB.txt";
    
    private static String[] colNames = {
            "ID",
            "Прізвище", 
            "Ім’я", 
            "По-батькові", 
            "Дата народження", 
            "Посада", 
            "Підрозділ", 
            "Номер кімнати", 
            "Службовий телефон",
            "Службовий e-mail",
            "Місячний Оклад",
            "Дата прийняття на роботу",
            "Поле для приміток"
        };

        private static String[] itemsPosition = {
            "Консультант",
            "Менеджер",
            "Адміністратор"
        };
        private static String[] itemsDepartment = {
            "AC",
            "BC",
            "CC"
        };
        private static String[] itemsRoom = {
            " ",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6"
        };
    
    public Initializer() {
    }

    public static String getDir() {
        return dir;
    }

    public static void setDir(String dir) {
        Initializer.dir = dir;
    }

    public static String getFileName() {
        return fileName;
    }

    public static void setFileName(String fileName) {
        Initializer.fileName = fileName;
    }

    public static String[] getColNames() {
        return colNames;
    }

    public static void setColNames(String[] colNames) {
        Initializer.colNames = colNames;
    }

    public static String[] getItemsPosition() {
        return itemsPosition;
    }

    public static void setItemsPosition(String[] itemsPosition) {
        Initializer.itemsPosition = itemsPosition;
    }

    public static String[] getItemsDepartment() {
        return itemsDepartment;
    }

    public static void setItemsDepartment(String[] itemsDepartment) {
        Initializer.itemsDepartment = itemsDepartment;
    }

    public static String[] getItemsRoom() {
        return itemsRoom;
    }

    public static void setItemsRoom(String[] itemsRoom) {
        Initializer.itemsRoom = itemsRoom;
    }
}
