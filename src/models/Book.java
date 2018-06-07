package models;

public class Book {
	
	private String imie;
	private String nazwisko;
	private String tytul;
	private float cena;
	private int rok;
	private String wydawca;
	
	public Book() {}
	
	public String getImie() {
		return this.imie;
	}
	
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	public String getNazwisko() {
		return this.nazwisko;
	}
	
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public String getTytul() {
		return this.tytul;
	}
	
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	
	public float getCena() {
		return this.cena;
	}
	
	public void setCena(float cena) {
		this.cena = cena;
	}
	
	public int getRok() {
		return this.rok;
	}
	
	public void setRok(int rok) {
		this.rok = rok;
	}
	
	public String getWydawnictwo() {
		return this.wydawca;
	}
	
	public void setWydawnictwo(String wydawca) {
		this.wydawca = wydawca;
	}
}
