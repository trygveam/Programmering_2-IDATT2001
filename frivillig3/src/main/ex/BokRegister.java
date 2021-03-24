
import java.io.*;
class BokRegister{
	private Bok[] bokReg;
	private int antallBoker = 0;
	private static final int MAX_ANTALL = 10;
	private final String filnavn = "bokregister.ser";

	public BokRegister(){
		if (lesRegFraFil()) System.out.println("bokregister lest inn fra fil");
		if (bokReg == null){
			bokReg = new Bok[MAX_ANTALL];
		}
	}
	public boolean leggTilBok(Bok b){
		if (antallBoker < bokReg.length) {
			bokReg[antallBoker] = b;
			antallBoker++;
			return true;
		}
		return false;
	}
	public String toString(){
		String res ="Antall boker " + antallBoker;
		for(int i = 0; i<antallBoker; i++){
			res += "\n" + bokReg[i];
		}
		return res;
	}

	private boolean lesRegFraFil(){
		try (FileInputStream innstrom = new FileInputStream(filnavn);
			ObjectInputStream inn = new ObjectInputStream(innstrom)) {
			Integer ab = (Integer)inn.readObject();  // kaster eofexception ved tom fil, FileNotFound
			antallBoker = ab.intValue();
			bokReg = (Bok[])inn.readObject();
			inn.close();
			return true;
		}catch(FileNotFoundException e){
			System.out.println("Fil ikke funnet! (lesRegFraFil())");
		}catch(EOFException e){
			System.out.println("Fil funnet, men tom! (lesRegFraFil())");
		}catch(IOException ioe){
			System.out.println("IO-feil (hentBokerFraFil())");
		}catch (Exception e){
			System.out.println("Noe som ikke har med IO er feil. (lesRegFraFil())");
		}
		return false; // kommer kun hit naar noe har feilet
	}

	public boolean skrivRegTilfil(){
		try(FileOutputStream utstrom = new FileOutputStream(filnavn);
			ObjectOutputStream ut = new ObjectOutputStream(utstrom)){
			ut.writeObject(new Integer(antallBoker));
			ut.writeObject(bokReg);
			ut.close();
			return true;
		}catch(IOException ioe){
			System.out.println("IO-feil (skrivRegTilFil())");
		}catch (Exception e){
			System.out.println("Noe som ikke har med IO er feil(skrivRegTilFil()");
		}
		return false; // kommer kun hit naar noe har feilet
	}


	public static void main (String[] args){
		Bok a = new Bok("Etter deg", "Jojo Moyes");
		Bok b = new Bok("Luridiumstyven", "Bobbie Peers ");
		BokRegister bokregister = new BokRegister();  // konstruktor leser fra fil
		bokregister.leggTilBok(a);
		bokregister.leggTilBok(b);
		if (bokregister.skrivRegTilfil()) {
			System.out.println("Bokregister skrevet til fil\n" + bokregister);
		}else{
			System.out.println("Noe gikk galt under skriving til fil");
		}
	}
}

