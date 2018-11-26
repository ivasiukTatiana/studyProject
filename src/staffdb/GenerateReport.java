/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdb;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Formatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Admin
 */
public class GenerateReport extends JFrame implements ActionListener {

    private String buttonReportCmd = "сформувати";
    private JTextArea tarReport = new JTextArea();

    public GenerateReport(String nameFrame) {
        super(nameFrame);
        setBounds(100,100,900,600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
        optionsPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
 
        Dimension buttonSize = new Dimension(170, 25);
        JButton buttonReport = new JButton(buttonReportCmd);
        buttonReport.setPreferredSize(buttonSize);
 
        JLabel lblPosition = new JLabel("Посада:");
        JCheckBox chPosition = new JCheckBox();
        String[] itemsPosition = Initializer.getItemsPosition();
        JComboBox cbPosition = new JComboBox(itemsPosition);
                                
        JLabel lblDepartment = new JLabel("Підрозділ:");
        JCheckBox chDepartment = new JCheckBox();
        String[] itemsDepartment = Initializer.getItemsDepartment();
        JComboBox cbDepartment = new JComboBox(itemsDepartment);

        optionsPanel.add(lblPosition);
        optionsPanel.add(chPosition);
        optionsPanel.add(cbPosition);

        optionsPanel.add(lblDepartment);
        optionsPanel.add(chDepartment);
        optionsPanel.add(cbDepartment);

        optionsPanel.add(buttonReport);
        buttonReport.addActionListener(this);

        add(optionsPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(tarReport), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getActionCommand().equals(buttonReportCmd)) {
 
            ArrayList<Employee> employees = Employee.getEmployees();
            String[] lineEmpl;
            String separator = "------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";

            Formatter lineF = new Formatter();
            String report = "";
            for (Employee emp : employees){
                lineEmpl = emp.toString().split("; ");
                lineF.format("%5.5s | ", lineEmpl[0]);
                for (int i = 1; i < lineEmpl.length; i++) {
                    lineF.format("%-17.17s | ", lineEmpl[i]);
                }
                report = report + lineF + "\n" + separator;
                //System.out.println(lineF);
                lineF = new Formatter();
                //lineF.flush();
            }
            tarReport.setText(report);
            tarReport.setFont(new Font("monospaced", Font.PLAIN, 12)); 
        }
    }
    
    
    
    
}
