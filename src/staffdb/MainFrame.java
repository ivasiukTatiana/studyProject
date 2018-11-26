/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffdb;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class MainFrame extends JFrame implements ActionListener { 
   
    protected JPanel leftPanel = new JPanel();
    protected JPanel rightPanel = new JPanel();
    protected String buttonReportCmd = "сформувати звіт";
    protected String buttonAddCmd = "додати";
    protected String buttonEditCmd = "відредагувати";
    protected String buttonDelCmd = "видалити";
    protected String buttonExitCmd = "зберегти і вийти";    
    protected boolean added = false;
    protected boolean edited = false;
    protected boolean deleted = false;
            
    public MainFrame(String nameFrame, String nameLeftPanel, String nameRightPanel) {
        super(nameFrame);
        setBounds(100,100,900,600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //validation before
        
        //topPanel
        JPanel dataPanel = new JPanel();    
        dataPanel.setLayout(new GridLayout(1,3));
        
        //topPanel.personPanel
        leftPanel.setBorder(BorderFactory.createTitledBorder(nameLeftPanel));
        leftPanel.setLayout(new GridLayout(0,2,5,5));
 
        //topPanel.workPanel
        rightPanel.setBorder(BorderFactory.createTitledBorder(nameRightPanel));
        rightPanel.setLayout(new GridLayout(0,2,5,3));

        dataPanel.add(leftPanel);
        dataPanel.add(rightPanel);
 
        //buttonsPanel
        JPanel buttons = new JPanel();
        buttons.setBorder(BorderFactory.createRaisedBevelBorder());
        Dimension buttonSize = new Dimension(170, 25);
 
        JButton buttonAdd = new JButton(buttonAddCmd);
        buttonAdd.setPreferredSize(buttonSize);
        
        JButton buttonEdit = new JButton(buttonEditCmd);
        buttonEdit.setPreferredSize(buttonSize);
        
        JButton buttonDel = new JButton(buttonDelCmd);
        buttonDel.setPreferredSize(buttonSize);
        
        JButton buttonExit = new JButton(buttonExitCmd);
        buttonExit.setPreferredSize(buttonSize);
        
        JButton buttonReport = new JButton(buttonReportCmd);
        buttonReport.setPreferredSize(buttonSize);
       
        buttons.add(buttonAdd);
        buttons.add(buttonEdit);
        buttons.add(buttonDel);
        buttons.add(buttonReport);
        buttons.add(buttonExit);
        
        add(dataPanel, BorderLayout.NORTH);
        //getContentPane().add(dataTableScroll, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        
        buttonAdd.addActionListener(this);
        buttonEdit.addActionListener(this);
        buttonDel.addActionListener(this);
        buttonReport.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    public boolean isAdded() {
        return added;
    }

    public boolean isEdited() {
        return edited;
    }

    public boolean isDeleted() {
        return deleted;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getActionCommand().equals(buttonAddCmd)) {
            System.out.println("add");
        } else if (ae.getActionCommand().equals(buttonEditCmd)) {
            System.out.println("edit");
        } else if (ae.getActionCommand().equals(buttonDelCmd)) {
            System.out.println("del");
        } else if (ae.getActionCommand().equals(buttonReportCmd)) {
            System.out.println("report");
        } else if (ae.getActionCommand().equals(buttonExitCmd)) {
            System.out.println("exit");
        }
    }
 
}
