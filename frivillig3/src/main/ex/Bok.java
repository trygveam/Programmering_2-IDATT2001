
class Bok implements java.io.Serializable{
	private String tittel;
	private String forfatter;

	public Bok(String tittel, String forfatter){
		this.tittel = tittel;
		this.forfatter = forfatter;
	}

	public String getTittel(){ return tittel;}
	public String getForfatter(){ return forfatter;}

	public String toString(){
		return tittel + " " + forfatter;
	}
}