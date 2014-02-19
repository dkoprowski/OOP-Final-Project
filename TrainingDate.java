package MVC;
/*
 * 	Author:	Daniel Koprowski
 * 	Date:	23 January 2014
 * 	Webs1:	www.koprowski.it
 * 	Webs2:	www.bizarri.pl
 */
public class TrainingDate {

		int day;
		int month;
		int year;
		String notatka = new String();
		
		public void SetDate(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;
		}

		public void TrainingDate(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;
		}

		public void TrainingDate() {
			this.day = 00;
			this.month = 00;
			this.year = 0000;
		}

		String DString(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;
			return (day + "-" + month + "-" + year);
		}
}
