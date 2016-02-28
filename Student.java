import java.io.PrintWriter;
import java.io.Serializable;

public class Student implements Serializable{

	String nazwisko;
	String imie;
	long album;
	int rok;
	double srednia;
	
	public Student(String nazwisko, String imie, long album, int rok, double srednia){
		this.nazwisko=nazwisko;
		this.imie=imie;
		this.album=album;
		this.rok=rok;
		this.srednia=srednia;
	}
	
	public Student(){
		nazwisko=null;
		imie=null;
		album=0;
		rok=0;
		srednia=0;
	}
	
	public void wyswietl(){
		PrintWriter out = new PrintWriter(System.out,true);
		out.printf("%-10s %-10s %-10d %-10d %-10.2f", nazwisko, imie, album, rok, srednia);

	}

	public void wyswietlNaglowek(){
		PrintWriter out = new PrintWriter(System.out,true);
		out.printf("%c %-10s %c %-10s %c %-10s %1c %-10s %1c %-7s %1c ", '*', "nazwisko", '*', "imie", '*', "album", '*', "rok", '*', "srednia", '*');
	}
	public String toString(){
		String s = String.format("%c %-10s %c %-10s %c %10d %1c %10d %1c %7.2f %1c ", '*', nazwisko, '*', imie, '*', album, '*', rok, '*', srednia, '*');
		return s;		
	}

}
