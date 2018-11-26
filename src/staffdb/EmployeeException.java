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
public class EmployeeException extends Exception {
    //final static public int NO_POSITION = 0; 
    final static public int NO_DATE = 1;
    private int errCode;
    
    public EmployeeException(String message, int errCode) {
        super(message);
        this.errCode = errCode;
    }
    
    public int getErrCode() {
        return errCode;
    }
            
}
