import java.io.*;
import static javax.swing.JOptionPane.*;

class DirekteTilFil{
	public static void main(String[] args) throws IOException{
		String filnavn = "direktefil.txt";
		RandomAccessFile fil = new RandomAccessFile(filnavn, "rw");

	 	/* Skriver 10 heltall til fila */
	 	for(int i=0; i<10;i++){
			fil.writeInt(i);
		}
		System.out.println("Fillengde: " + fil.length());  // vil gi til svar 40 byte (10 tall av typen int er lagret på fila og en int er 4 byte)
		/* Flytter filpeker til posisjon 7, leser tallet og ganger med 10 og skriver det tilbake igjen */
		fil.seek(6*4); // flytter forbi 6 tall a 4 byte (int-storrelse)
		int tall = fil.readInt() * 10; // filpeker flytter seg ett hakk
		fil.seek(6*4); // flytter filpeker tilbake igjen
		fil.writeInt(tall);

		fil.seek(0); // flytter filpeker til begynnelsen av fila
		boolean eof = false;
		try{
			while(!eof){
				int t = fil.readInt();
				System.out.println(t);
			}
		} catch(EOFException e){
			eof = true;
		}
		fil.close();
	}
}
/* Kjoring av programmet:
Fillengde: 40
0
1
2
3
4
5
60
7
8
9
*/
