package MVC;
/*
 * 	Author:	Daniel Koprowski
 * 	Date:	23 January 2014
 * 	Webs1:	www.koprowski.it
 * 	Webs2:	www.bizarri.pl
 */
import java.io.IOException;
import java.sql.SQLException;

public class Workout {

	public static void main(String[] args) throws SQLException, IOException {
		

		WorkoutView okno = new WorkoutView();
		okno.repaint();
		WorkoutController kontroler = new WorkoutController();
		WorkoutModel model = new WorkoutModel();
		kontroler.actions();
		model.ladujListe();

	}

}
