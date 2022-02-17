/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Martin3
 */
public class Vista extends JFrame{
    
    private JPanel PBase;
    
    private JPanel PHeader;
    private JPanel PBody;
    private JPanel PFoot;
    
    public JButton bt_start;
    public JButton bt_Cancel;
    
    public JTextArea textArea;
	public JScrollPane scroll;
	public JScrollBar scrollBar;
    
    public Vista (){
        settingFrame();
        
        panelHeader();
        panelBody();
        panelFooter();
        
        panelBase();
    }
    
    private void settingFrame(){
       setTitle("REST Adrimar send data");
       setSize(600, 330);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void panelBase(){
        PBase = new JPanel(new BorderLayout());
        PBase.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        
        getContentPane().add(PBase);      
        
        PBase.add(PHeader, BorderLayout.NORTH);
        PBase.add(PBody, BorderLayout.CENTER);
        PBase.add(PFoot, BorderLayout.SOUTH); 
    }
     
    private void panelHeader(){
        FlowLayout space = new FlowLayout(FlowLayout.LEFT);     
        space.setVgap(6);
        
        PHeader = new JPanel(space);
        PHeader.setBorder(new EtchedBorder(EtchedBorder.RAISED));      
        
        bt_start = new JButton("Start");
        bt_start.setPreferredSize(new Dimension(95,30));      
        
        PHeader.add(bt_start, BorderLayout.WEST);
    }
        
    private void panelBody(){
        PBody = new JPanel(new BorderLayout());
        PBody.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        
        textArea = new JTextArea();
        scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);		
		scrollBar = scroll.getVerticalScrollBar();
		
        PBody.add(scroll);
    }
    
    private void panelFooter(){ 
        PFoot = new JPanel(new BorderLayout());
        PFoot.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        
        FlowLayout space = new FlowLayout(FlowLayout.CENTER);
        space.setVgap(6);
        PFoot.setLayout(space);
        
        bt_Cancel = new JButton("Cancelar");
        bt_Cancel.setPreferredSize(new Dimension(95,30));
        
        PFoot.add(bt_Cancel, BorderLayout.WEST); 
    }
}
