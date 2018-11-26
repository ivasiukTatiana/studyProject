/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdb;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Admin
 */
public class StaffFrame extends MainFrame{
    
    private final int NUMBER_FIELDS = 13;
    
    private JTextField tfId;
    private JTextField tfSecondName;
    private JTextField tfFirstName;
    private JTextField tfSurname;
    private JTextField tfDateBirth; //data date, field format
    private JComboBox cbPosition;
    private JComboBox cbDepartment;
    private JComboBox cbRoom;
    private JTextField tfPhone;
    private JTextField tfEmail;
    private JTextField tfSalary;
    private JTextField tfDateRecr; //data date, field format
    private JTextField tfNotes;
  
    private JComponent[] fields = new JComponent[NUMBER_FIELDS];
    
    private JTable dataTable;
    private DefaultTableModel dtm;
    private String[] dataNew;
    
    public StaffFrame() {    
        super("Картотека працівників", "Персональні дані", "Службові дані");
        
        //topPanel.personPanel
        int countFields = 0;
        JLabel lblId = new JLabel("Id:");
        lblId.setHorizontalAlignment(SwingConstants.RIGHT);
        tfId = new JTextField();
        tfId.setEnabled(false);
        tfId.setText(Integer.toString(Employee.getId() + StaffDB.getIdCorrection() + 1));
        fields[countFields] = tfId;
        countFields += 1;
        
        JLabel lblSecondName = new JLabel("Прізвище:");
        lblSecondName.setHorizontalAlignment(SwingConstants.RIGHT);
        tfSecondName = new JTextField();
        tfSecondName.requestFocusInWindow();
        fields[countFields] = tfSecondName;
        countFields += 1;
                
        JLabel lblFirstName = new JLabel("Ім’я:");
        lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
        tfFirstName = new JTextField();
        fields[countFields] = tfFirstName;
        countFields += 1;
                
        JLabel lblSurname = new JLabel("По-батькові:");
        lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
        tfSurname = new JTextField();
        fields[countFields] = tfSurname;
        countFields += 1;
                
        JLabel lblDateBirth = new JLabel("Дата народження:");
        lblDateBirth.setHorizontalAlignment(SwingConstants.RIGHT);
        MaskFormatter dateMask;
        try {
            dateMask = new MaskFormatter("##/##/####");
            tfDateBirth = new JFormattedTextField(dateMask);
            tfDateBirth.setColumns(10);
        } catch (ParseException ex) {
            Logger.getLogger(StaffFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fields[countFields] = tfDateBirth;
        countFields += 1;
                
        leftPanel.add(lblId);
        leftPanel.add(tfId);
        leftPanel.add(lblSecondName);
        leftPanel.add(tfSecondName);
        leftPanel.add(lblFirstName);
        leftPanel.add(tfFirstName);
        leftPanel.add(lblSurname);
        leftPanel.add(tfSurname);
        leftPanel.add(lblDateBirth);
        leftPanel.add(tfDateBirth);
         
        //topPanel.workPanel
        JLabel lblPosition = new JLabel("Посада:");
        lblPosition.setHorizontalAlignment(SwingConstants.RIGHT);

        String[] itemsPosition = Initializer.getItemsPosition();
        cbPosition = new JComboBox(itemsPosition);
        fields[countFields] = cbPosition;
        countFields += 1;
                        
        JLabel lblDepartment = new JLabel("Підрозділ:");
        lblDepartment.setHorizontalAlignment(SwingConstants.RIGHT);
        
        String[] itemsDepartment = Initializer.getItemsDepartment();
        cbDepartment = new JComboBox(itemsDepartment);
        fields[countFields] = cbDepartment;
        countFields += 1;
                
        JLabel lblRoom = new JLabel("Номер кімнати:");
        lblRoom.setHorizontalAlignment(SwingConstants.RIGHT);
        
        String[] itemsRoom = Initializer.getItemsRoom();
        cbRoom = new JComboBox(itemsRoom);
        fields[countFields] = cbRoom;
        countFields += 1;

        JLabel lblPhone = new JLabel("Службовий телефон:");
        lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
        try {
            MaskFormatter phoneMask = new MaskFormatter("+38-###-###-##-##");
            tfPhone = new JFormattedTextField(phoneMask);
            tfPhone.setColumns(17);
        } catch (ParseException ex) {
            Logger.getLogger(StaffFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fields[countFields] = tfPhone;
        countFields += 1;
                
        JLabel lblEmail = new JLabel("Службовий e-mail:");
        lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        tfEmail = new JTextField();
        fields[countFields] = tfEmail;
        countFields += 1;
                
        JLabel lblSalary = new JLabel("Місячний оклад:");
        lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
        tfSalary = new JTextField();
        tfSalary.setColumns(9);
        fields[countFields] = tfSalary;
        countFields += 1;
                
        JLabel lblDateRecr = new JLabel("Дата прийняття на роботу:");
        lblDateRecr.setHorizontalAlignment(SwingConstants.RIGHT);
        //MaskFormatter dateMask;
        try {
            dateMask = new MaskFormatter("##/##/####");
            tfDateRecr = new JFormattedTextField(dateMask);
            tfDateRecr.setColumns(10);
            
        } catch (ParseException ex) {
            Logger.getLogger(StaffFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fields[countFields] = tfDateRecr;
        countFields += 1;
                
        JLabel lblNotes = new JLabel("Поле для приміток:");
        lblNotes.setHorizontalAlignment(SwingConstants.RIGHT);
        tfNotes = new JTextField();
        fields[countFields] = tfNotes;
        //countFields += 1;

        rightPanel.add(lblPosition);
        rightPanel.add(cbPosition);
        rightPanel.add(lblDepartment);
        rightPanel.add(cbDepartment);
        rightPanel.add(lblRoom);
        rightPanel.add(cbRoom);
        rightPanel.add(lblPhone);
        rightPanel.add(tfPhone);
        rightPanel.add(lblEmail);
        rightPanel.add(tfEmail);
         
        rightPanel.add(lblSalary);
        rightPanel.add(tfSalary);
        rightPanel.add(lblDateRecr);
        rightPanel.add(tfDateRecr);
        rightPanel.add(lblNotes);
        rightPanel.add(tfNotes);
        
        //dataTable
        String[] colNames = Initializer.getColNames();
        //DefaultTableModel dtm = new DefaultTableModel(data,colNames);
        String[][] data = StaffReader.getDataTable();
        dtm = new DefaultTableModel(data, colNames) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        }; 
 
        dataTable = new JTable(dtm);
        dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
        JScrollPane dataTableScroll = new JScrollPane(dataTable);
        getContentPane().add(dataTableScroll, BorderLayout.CENTER);
        
        dataTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                fillFields();
                tfDateRecr.setEnabled(false);
            }
            @Override
            public void mousePressed(MouseEvent me) {
            }
            @Override
            public void mouseReleased(MouseEvent me) {
            }
            @Override
            public void mouseEntered(MouseEvent me) {
            }
            @Override
            public void mouseExited(MouseEvent me) {
            }
        }  );
        
        dataTable.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
            }
            @Override
            public void keyPressed(KeyEvent ke) {
            }
            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode() == 38 | ke.getKeyCode() == 40) {
                    fillFields();
                    tfDateRecr.setEnabled(false);
                }
            }
        });
        dataNew = new String[colNames.length];
    }

    private String dataValidation(String[] dataNew) {
        String validationMessage = "";
        
        Pattern ptrName = Pattern.compile("[ІЇЄА-Я][іїєа-я]{1,20}");
        Matcher mtchName = ptrName.matcher(dataNew[1]);
        if (!mtchName.matches()){
            validationMessage +=  "Не коректне значення поля 'Прізвище'\n";
        }
        mtchName = ptrName.matcher(dataNew[2]);
        if (!mtchName.matches()){
            validationMessage +=  "Не коректне значення поля 'Ім’я'\n";
        }
        mtchName = ptrName.matcher(dataNew[3]);
        if (!mtchName.matches()){
            validationMessage +=  "Не коректне значення поля 'По-батькові'\n";
        }        
        ptrName = Pattern.compile("(0[1-9]|(1|2)[0-9]|3(0|1))\\/(0[1-9]|1(0|1|2))\\/(19[6-9][0-9]|20\\d\\d)");
        mtchName = ptrName.matcher(dataNew[4]);
        if (!mtchName.matches()){
            validationMessage +=  "Не коректне значення поля 'Дата народження'\n";
        } 
        ptrName = Pattern.compile("\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}");
        mtchName = ptrName.matcher(dataNew[9]);
        if (!mtchName.matches()){
            validationMessage +=  "Не коректне значення поля 'Службовий e-mail'\n";
        } 
        ptrName = Pattern.compile("\\d[0-9 ]{1,7}");
        mtchName = ptrName.matcher(dataNew[10]);
        if (!mtchName.matches()){
            validationMessage +=  "Не коректне значення поля 'Місячний оклад'\n";
        } 
        ptrName = Pattern.compile("(0[1-9]|(1|2)[0-9]|3(0|1))\\/(0[1-9]|1(0|1|2))\\/20\\d\\d");
        mtchName = ptrName.matcher(dataNew[11]);
        if (!mtchName.matches()){
            validationMessage +=  "Не коректне значення поля 'Дата прийняття на роботу'\n";
        } 

        return validationMessage;
    }

    private void clearFields() {
        JTextField tf = new JTextField();
        JComboBox cb = new JComboBox();
        JFormattedTextField ftf = new JFormattedTextField();
        
        tfId.setText(Integer.toString(Employee.getId() + StaffDB.getIdCorrection() + 1));
        for (int i = 1; i < NUMBER_FIELDS; i++) {
            
            if(fields[i].getClass().equals(tf.getClass())) {
                tf = (JTextField)fields[i];
                tf.setText("");
                fields[i] = tf;
            }
            if(fields[i].getClass().equals(ftf.getClass())) {
                ftf = (JFormattedTextField)fields[i];
                ftf.setText("");
                fields[i] = ftf;
            } 
            if(fields[i].getClass().equals(cb.getClass())) {
                cb = (JComboBox)fields[i];
                cb.setSelectedIndex(0);
                fields[i] = cb;
            }
        }
    }
    private void fillFields() {
        JTextField tf = new JTextField();
        JComboBox cb = new JComboBox();
        JFormattedTextField ftf = new JFormattedTextField();
        
        for (int i = 0; i < NUMBER_FIELDS; i++) {
            if(fields[i].getClass().equals(tf.getClass())) {
                tf = (JTextField)fields[i];
                tf.setText(dataTable.getValueAt(dataTable.getSelectedRow(), i).toString());
                fields[i] = tf;
            }
            if(fields[i].getClass().equals(ftf.getClass())) {
                ftf = (JFormattedTextField)fields[i];
                ftf.setText(dataTable.getValueAt(dataTable.getSelectedRow(), i).toString());
                fields[i] = ftf;
            }            
            if(fields[i].getClass().equals(cb.getClass())) {
                cb = (JComboBox)fields[i];
                cb.setSelectedItem(dataTable.getValueAt(dataTable.getSelectedRow(), i).toString());
                fields[i] = cb;
            }
        }
    }
    
    private void fillDataNew() {
        JTextField tf = new JTextField();
        JComboBox cb = new JComboBox();
        JFormattedTextField ftf = new JFormattedTextField();
        
        for (int i = 0; i < NUMBER_FIELDS; i++) {
            if(fields[i].getClass().equals(tf.getClass())) {
                tf = (JTextField)fields[i];
                dataNew[i] = tf.getText(); 
            }
            if(fields[i].getClass().equals(ftf.getClass())) {
                ftf = (JFormattedTextField)fields[i];
                dataNew[i] = ftf.getText(); 
            }
            if(fields[i].getClass().equals(cb.getClass())) {
                cb = (JComboBox)fields[i];
                dataNew[i] = cb.getSelectedItem().toString(); 
            }
        }
    }

    private void fillDataTable() {
        JTextField tf = new JTextField();
        JComboBox cb = new JComboBox(); 
        JFormattedTextField ftf = new JFormattedTextField();
        
        for (int i = 0; i < NUMBER_FIELDS; i++) {
            if(fields[i].getClass().equals(tf.getClass())) {
                tf = (JTextField)fields[i];
                dataTable.setValueAt(tf.getText(), dataTable.getSelectedRow(), i);
            }
            if(fields[i].getClass().equals(ftf.getClass())) {
                ftf = (JFormattedTextField)fields[i];
                dataTable.setValueAt(ftf.getText(), dataTable.getSelectedRow(), i);
            }
            if(fields[i].getClass().equals(cb.getClass())) {
                cb = (JComboBox)fields[i];
                dataTable.setValueAt(cb.getSelectedItem(), dataTable.getSelectedRow(), i);
            }        
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //super.actionPerformed(ae);
        ArrayList<String> dataPerson = new ArrayList();
        ArrayList<String> dataWork = new ArrayList();
 
        if (ae.getActionCommand().equals(buttonAddCmd)) {
            tfDateRecr.setEnabled(true);
            dataTable.clearSelection();
            tfSecondName.requestFocusInWindow();

            if (Integer.parseInt(tfId.getText()) == (Employee.getId() + StaffDB.getIdCorrection() + 1)) { 
 
                fillDataNew();
                //validation
                String validationMessage = dataValidation(dataNew);
                if (validationMessage.equals("")) {

                    dataPerson.add(tfSecondName.getText());
                    dataPerson.add(tfFirstName.getText());
                    dataPerson.add(tfSurname.getText());
                    dataPerson.add(tfDateBirth.getText());

                    dataWork.add(tfId.getText());
                    dataWork.add(cbPosition.getSelectedItem().toString());
                    dataWork.add(cbDepartment.getSelectedItem().toString());
                    dataWork.add(cbRoom.getSelectedItem().toString());
                    dataWork.add(tfPhone.getText());
                    dataWork.add(tfEmail.getText());
                    dataWork.add(tfSalary.getText());
                    dataWork.add(tfDateRecr.getText());
                    dataWork.add(tfNotes.getText()); 

                    try {
                        Employee.add(new Employee(new Person(dataPerson), dataWork));

                        dtm.addRow(dataNew);
                        clearFields();
                        added = true;        
                    } catch(PersonException | EmployeeException e) {
                        JOptionPane.showMessageDialog(this, e.getMessage(), "", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, validationMessage, "", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                clearFields();
            }
        } else if (ae.getActionCommand().equals(buttonEditCmd)) {

            if (dataTable.getSelectedRow() != -1) {
                
                fillDataNew();
                //validation
                String validationMessage = dataValidation(dataNew);
                if (validationMessage.equals("")) {
                    
                    Employee.edit(dataNew);
                    fillDataTable();
                    edited = true;
                    
                } else {
                    JOptionPane.showMessageDialog(this, validationMessage, "", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else if (ae.getActionCommand().equals(buttonDelCmd)) {
            if (dataTable.getSelectedRow() != -1) {
               
                Employee.delete(dataTable.getValueAt(dataTable.getSelectedRow(), 0).toString());

                int currentSelect = dataTable.getSelectedRow();
                dtm.removeRow(dataTable.getSelectedRow());
                
                if(currentSelect == dtm.getRowCount()) {
                    currentSelect -= 1;
                }
                dataTable.addRowSelectionInterval(currentSelect, currentSelect);

                fillFields();
                tfDateRecr.setEnabled(false);
                deleted = true;
            }

        } else if (ae.getActionCommand().equals(buttonReportCmd)) {
            //System.out.println("report");
            GenerateReport generateReport = new GenerateReport("Картотека працівників");
            generateReport.setVisible(true);
            generateReport.addWindowListener(new WindowListener(){
                @Override
                public void windowOpened(WindowEvent we) {
                }
                @Override
                public void windowClosing(WindowEvent we) {
                    generateReport.dispose();
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
 
        } else if (ae.getActionCommand().equals(buttonExitCmd)) { 
            try {
                StaffWriter employeesWrite = new StaffWriter(Employee.getEmployees());
                employeesWrite.writeEmployees();
                
            } catch (IOException ex) {
                Logger.getLogger(StaffFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Жодного не внесено", "", JOptionPane.WARNING_MESSAGE);
            }
            dispose();
        }
    }
}
