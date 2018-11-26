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
public class PersonException extends Exception{
   final static public int NO_SECONDNAME = 0;
   final static public int NO_FIRSTNAME = 1;
   final static public int NO_SURNAME = 2;
   private int errCode;

    public PersonException(String message, int errCode) {
        super(message);
        this.errCode = errCode;
    }
   
    public int getErrCode() {
       return errCode;
    }
}
