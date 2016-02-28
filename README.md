# AISD_lista1

polecenie:

/*1.Zdefiniuj klasę Student. Klasa ma posiadać następujące własności: 
- Pola: nazwisko, imię(String), album(long), rok(int), srednia(double), 
- Konstruktory (domyślny, inicjujący), 
- Metody: 
    - wyświetl() – w jednej linii wyświetla dane studenta (sformatowane, użycie funkcji printf()) 
    - toString()  – zwraca jako łańcuch sformatowany  tekst „nazwisko, imie, album, rok, srednia (String.format())
2. Zdefiniuj klasę Main.  Zadeklaruj tablicę jednowymiarową typu Student. W pętli czytaj dane studentów  i zapisz je w kolejnych elementach tablicy.  yświetl elementy tablicy w postaci tabeli.  
3.Dodaj operacje na plikach (klasy: ObjectOutputStream, ObjectInputStream). Zapisz do pliku liczbę studentów oraz kolejne elementy tablicy ( nie korzystaj z faktu, że tablica jest obiektem). Następnie odczytaj dane z pliku i wyświetl je.
*/

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


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in);
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Student[] stud = new Student[2];	
		
		PrintWriter out = new PrintWriter(System.out,true);		
	    Scanner in = new Scanner(System.in);
	    
		for(int i=0; i<2; i++){
			out.printf("nazwisko: ");
			String nazwisko = in.next();
			out.printf("imie: ");
			String imie = in.next();			
			out.printf("album: ");			
			Long album = in.nextLong();
			out.printf("rok: ");			
			int rok = in.nextInt();	
			out.printf("srednia: ");			
			double srednia = in.nextDouble();
			
			stud[i]=new Student(nazwisko, imie, album, rok, srednia);
		}
		in.close();
		
		for(int j=0;j<63;j++)
			out.printf("*");	
		
		out.printf("\r");					
			
		stud[0].wyswietlNaglowek();
			
		out.printf("\r");							
			
		for(int j=0;j<63;j++)
			out.printf("*");	
		    out.printf("\r");	
			    
		for(int k=0;k<2;k++){					
			out.printf(stud[k].toString());
				
			out.printf("\r");	
				
				
			for(int j=0;j<63;j++)
				out.printf("*");	
				out.printf("\r");	
					
		}
	
		try	(ObjectOutputStream st = new ObjectOutputStream(new FileOutputStream("dane.txt"))){
			st.writeInt(2);	
			for(int i=0;i<2;i++)
				st.writeObject(stud[i]);
		}

		int liczba;
		Student[] studPl;
		try{
			ObjectInputStream st = new ObjectInputStream(new FileInputStream("dane.txt"));
			liczba = st.readInt();
			studPl = new Student[liczba];
			out.println("jest "+liczba+ "studentow: ");
			int i=0;
			while(true){
				studPl[i]=(Student)st.readObject();
				out.printf("\r"+i+".Student: ");
				studPl[i].wyswietl();	
				i++;
			}	
		}	
		catch (IOException e){
			System.out.println("blad!!");
			
		}
		
//		for(int j=0; j<3; j++){
//			out.println(j+".Student: ");
//			stud[0].wyswietl();
//		}

		
	}		
}



