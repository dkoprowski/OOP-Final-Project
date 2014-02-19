package MVC;
/*
 * 	Author:	Daniel Koprowski
 * 	Date:	23 January 2014
 * 	Webs1:	www.koprowski.it
 * 	Webs2:	www.bizarri.pl
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import MVC.WorkoutModel;
import MVC.TrainingDate;

import javax.swing.JLabel;
import javax.swing.JTextArea;


public class WorkoutController  implements ActionListener  {

	public void actions(){
		WorkoutView.b_add.addActionListener(this);
		WorkoutView.b_delete.addActionListener(this);
		WorkoutView.b_edit.addActionListener(this);
		WorkoutView.cb_rekordy.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e){
		
		Object z = e.getSource();
		if (z == WorkoutView.b_add) {
			WorkoutModel.lisDodaj();
		}
		if(z == WorkoutView.b_delete){
			WorkoutModel.lisUsun();
		}
		if(z == WorkoutView.cb_rekordy){
			WorkoutModel.lisWybierz();
			
		}
		
		if(z == WorkoutView.b_edit){
			WorkoutModel.lisEdytuj();
		}
		
	}
	

}
