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



