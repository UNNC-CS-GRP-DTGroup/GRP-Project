package cn.edu.nottingham.notetaking.mainFrame;

import java.awt.GridLayout;
import javax.swing.*;

import cn.edu.nottingham.notetaking.leftPart.LeftPanel;
import cn.edu.nottingham.notetaking.rightPart.RightPane;

/**
 * create the GUI for the app
 * 
 * @author RUNFA LV,WENYU DU
 * 
 */
public class MyFrame extends JFrame {

	private static final long serialVersionUID = 66563949539476644L;

	public MyFrame() {
		super("NoteBook GUI");

		getContentPane().setLayout(new GridLayout(1, 2));
		
		//add left and right parts
		getContentPane().add(new LeftPanel().getLeft());
		getContentPane().add(new RightPane());
		
		setSize(1200, 650);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
