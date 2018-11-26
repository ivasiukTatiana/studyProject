/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdb;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class StaffDB {
    private static int idCorrection; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            StaffReader employeesRead = new StaffReader(StaffWriter.getPath());
            //ArrayList<Employee> employees = employeesRead.readEmployees();
            idCorrection = employeesRead.readEmployees();
            
            //Employee.setEmployees(employees); 
        } catch (PersonException | EmployeeException | IOException ex) {
            //Logger.getLogger(StaffDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        StaffFrame staffFrame = new StaffFrame();
                
        staffFrame.addWindowListener(new WindowListener() { 
            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
                if (staffFrame.isAdded() | staffFrame.isEdited() | staffFrame.isDeleted()) {

                    String[] options = {"так", "ні"};
                    int confirm = JOptionPane.showOptionDialog(we.getWindow(), "Є незбережені дані. Вийти?", "", 
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
                            options, options[0]);
                    
                    if (confirm == 0) staffFrame.dispose();
                } else {
                    staffFrame.dispose();
                }
            }

            @Override
            public void windowClosed(WindowEvent we) {
            }
            @Override
            public void windowIconified(WindowEvent we) {
            }
            @Override
            public void windowDeiconified(WindowEvent we) {
            }
            @Override
            public void windowActivated(WindowEvent we) {
            }
            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        });
        staffFrame.setVisible(true);
    }

    public static int getIdCorrection() {
        return idCorrection;
    }
}
