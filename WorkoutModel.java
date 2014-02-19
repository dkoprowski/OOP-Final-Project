package MVC;
/*
 * 	Author:	Daniel Koprowski
 * 	Date:	23 January 2014
 * 	Webs1:	www.koprowski.it
 * 	Webs2:	www.bizarri.pl
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class WorkoutModel {
	
	public static Connection getConnection()
			   throws SQLException, IOException
			{  
			   Properties props = new Properties();
			   FileInputStream in = new FileInputStream("database.properties");
			   props.load(in);
			   in.close();

			   String drivers = props.getProperty("jdbc.drivers");
			   if (drivers != null)
			      System.setProperty("jdbc.drivers", drivers);
			   String url = props.getProperty("jdbc.url");
			   String username = props.getProperty("jdbc.username");
			   String password = props.getProperty("jdbc.password");

			   return DriverManager.getConnection(url, username, password);
			}

	public static void dodaj(String opis, int  key) throws SQLException, IOException{
		Connection conn = getConnection();
		Statement stat = conn.createStatement();
		stat.execute("INSERT INTO diary VALUES ('"+key+"',  '"+opis+"')");
		
	    stat.close();
	    conn.close();
	}
	
	public static void usun(String id) throws SQLException, IOException{
		Connection conn = getConnection();
		Statement stat = conn.createStatement();
		stat.execute("DELETE FROM diary WHERE id = "+id+";");
		

	    stat.close();
	    conn.close();
	}
	
	public static void edytuj(int key, String opis) throws SQLException, IOException{
		Connection conn = getConnection();
		Statement stat = conn.createStatement();
		stat.execute("UPDATE diary SET text='"+opis+"' WHERE id="+key+";");	

	    stat.close();
	    conn.close();	
	}
	
	public static String tekst(String id) throws SQLException, IOException{
		Connection conn = getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("SELECT TEXT FROM DIARY WHERE ID="+id+";");
		rs.first();
		String opis = rs.getString("TEXT");
		
		rs.close();
	    stat.close();
	    conn.close();
	    
		return opis;
		
	}
	
	public static void ladujListe() throws SQLException, IOException{
		Connection conn = getConnection();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("SELECT id FROM diary");
		
		if(rs.first()){
		
		int dd,mm,yyyy,dataString;
		String tab[];
		String opis = rs.getString("ID");
		System.out.println(opis);
		TrainingDate dateX = new TrainingDate();
		String kluczItemu;
		
		do{
			opis = rs.getString("ID");
			System.out.println(opis);
			dataString = Integer.parseInt(opis);
			yyyy = dataString/10000;
			mm = (dataString - yyyy * 10000)/100;
			dd = (dataString - yyyy * 10000 - mm * 100);
			
			
			kluczItemu = dateX.DString(dd, mm, yyyy);
			WorkoutView.cb_rekordy.addItem(kluczItemu);
		
		}while(rs.next());
		}
		
		rs.close();
	    stat.close();
	    conn.close();
	}

	/*
	 * 	Funkcje definiujace ActionListenery
	 */
	
	public static void lisDodaj(){
		int dd, mm, yyyy, id;
		String kluczItemu, opis;
		opis = WorkoutView.l_wyswietl.getText();
		WorkoutView.l_header.setText("No Pain no Gain - Lets Train!");
		dd = Integer.parseInt(WorkoutView.tf_days.getText().toString());
		mm = Integer.parseInt(WorkoutView.tf_months.getText().toString());
		yyyy = Integer.parseInt(WorkoutView.tf_years.getText().toString());
		TrainingDate datejszyns = new TrainingDate();
		if (dd < 32 &&dd > 0 && mm < 13 && mm > 0 && yyyy>0) {
			kluczItemu = datejszyns.DString(dd, mm, yyyy);
			WorkoutView.cb_rekordy.addItem(kluczItemu);
			
			
			id = (yyyy*10000)+(mm*100)+dd;
			try {
				
				WorkoutModel.dodaj(opis, id);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			WorkoutView.l_footer.setText("Added.");
		}
		else
			WorkoutView.l_footer.setText("No Added - Check date!");
	}
	
	public static void lisUsun(){
		int dd,mm,yyyy,id;
		String tab[];
		int temp = WorkoutView.cb_rekordy.getSelectedIndex();
		String opis = (String) WorkoutView.cb_rekordy.getSelectedItem();
		WorkoutView.cb_rekordy.removeItemAt(temp);
		tab = opis.split("-");
		dd = Integer.parseInt(tab[0]);
		mm = Integer.parseInt(tab[1]);
		yyyy = Integer.parseInt(tab[2]);
		
		id = (yyyy*10000)+(mm*100)+dd;
		try {
			WorkoutModel.usun(String.valueOf(id));
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		WorkoutView.l_footer.setText("Deleted: "+opis);	
	}
	
	public static void lisWybierz(){
		int dd,mm,yyyy,id;
		String tab[];
		String notatka;
		String opis = (String) WorkoutView.cb_rekordy.getSelectedItem();
		tab = opis.split("-");
		dd = Integer.parseInt(tab[0]);
		mm = Integer.parseInt(tab[1]);
		yyyy = Integer.parseInt(tab[2]);
		
		id = (yyyy*10000)+(mm*100)+dd;
		try {
			notatka = WorkoutModel.tekst(String.valueOf(id));
			WorkoutView.l_wyswietl.setText(notatka);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		WorkoutView.l_footer.setText(opis);
	}
	
	public static void lisEdytuj(){
		int dd,mm,yyyy,id;
		String tab[];
		String opis = (String) WorkoutView.cb_rekordy.getSelectedItem();
		tab = opis.split("-");
		dd = Integer.parseInt(tab[0]);
		mm = Integer.parseInt(tab[1]);
		yyyy = Integer.parseInt(tab[2]);
		id = (yyyy*10000)+(mm*100)+dd;
		
		try {
			WorkoutModel.edytuj(id, WorkoutView.l_wyswietl.getText());
		} catch (SQLException | IOException e1) {
			e1.printStackTrace();
		}
		WorkoutView.l_footer.setText("Edited.");
	}
	
	
	
}

