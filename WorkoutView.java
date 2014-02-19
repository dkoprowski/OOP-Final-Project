package MVC;
/*
 * 	Author:	Daniel Koprowski
 * 	Date:	23 January 2014
 * 	Webs1:	www.koprowski.it
 * 	Webs2:	www.bizarri.pl
 */

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Date;


public class WorkoutView extends JFrame{
	public static JComboBox cb_rekordy;
	public static JTextField tf_days;
	public static JTextField tf_months;
	public static JTextField tf_years;
	public static JLabel l_header;
	public static JLabel l_footer;
	public static JButton b_add;
	public static JButton b_delete;
	public static JTextArea l_wyswietl;
	public static JButton b_edit;
	public static JScrollPane scrollPane;
	Font font = new Font("Verdana", Font.ITALIC, 11);
	public WorkoutView() {
		super("Your's eDiary");
		int HEIGHT, WIDTH;
		HEIGHT = 500;
		WIDTH = 400;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocation(200, 100);
		setVisible(true);
		setResizable(false);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(null);
		
			
		b_add = new JButton("Add Record");
		b_add.setBounds(40, 50, 150, 30);
		add(b_add);
		

		b_delete = new JButton("Delete Record");
		b_delete.setBounds(40, 100, 150, 30);
		add(b_delete);

		b_edit = new JButton("Edit Note");
		b_edit.setBounds(40, 150, 150, 30);
		add(b_edit);

		l_wyswietl = new JTextArea("Note: ");
		
		l_wyswietl.setFont(font);
		scrollPane = new JScrollPane(l_wyswietl);
		scrollPane.setBounds(40,200,300,200);
		add(scrollPane);

		l_header = new JLabel("What happened today?");
		l_header.setText("What happened today?");
		l_header.setBounds(140, 10, 180, 30);
		add(l_header);
		
		l_footer = new JLabel("");
		l_footer.setText("");
		l_footer.setBounds(55, 410, 180, 30);
		add(l_footer);

		tf_days = new JTextField("day");
		tf_months = new JTextField("month");
		tf_years = new JTextField("year");
		tf_days.setBounds(200, 50, 45, 30);
		tf_months.setBounds(250, 50, 45, 30);
		tf_years.setBounds(300, 50, 45, 30);
		add(tf_days);
		add(tf_months);
		add(tf_years);

		cb_rekordy = new JComboBox();
		cb_rekordy.setBounds(200, 100, 150, 30);

		add(cb_rekordy);

		// PRZYKLADOWE DATY::
		

	}

}


