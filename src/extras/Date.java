package extras;
import java.util.Calendar;
//import java.util.Date;
import java.util.GregorianCalendar;
//import java.text.SimpleDateFormat;
public class Date {

	public static String fechaActual() {
		int dd, mm, aa;
		Calendar c = new GregorianCalendar();
		dd = c.get(Calendar.DAY_OF_MONTH);
		mm = c.get(Calendar.MONTH) + 1;
		aa = c.get(Calendar.YEAR);
		return Adjust(dd) + "/" + Adjust(mm) + "/" + aa;
	}
	
	private static String Adjust(int numero) {
		return String.format("%02d", numero);
	}
}
