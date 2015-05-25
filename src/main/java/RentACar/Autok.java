package RentACar;

/**
 * Autókat megvalósító osztály
 * 
 * @author Kovács Ádám
 */
public class Autok {
	
	
	/**
	 * Az autó egyedi azonosítója
	 */
	int azonosító;
	/**
	 * Az autó márkája 
	 */
	String márka;
	/**
	 * Az autó típusa
	 */
	String típus;
	/**
	 * Az autó évjárata
	 */
	int évjárat;
	/**
	 * Az autó köcsönzési díja egy napra
	 */
	int kölcsönzésiDíjPerNap;
	
	/**
	 * Az Autok osztály konstruktora
	 * 
	 * @param azonosító egy egyedi azonosító
	 * @param márka egy autó márkája
	 * @param típus egy autó típusa
	 * @param évjárat egy autó évjárata
	 * @param kölcsönzésiDíjPerNap egy autó kölcsönzési díja egy napra
	 */
	public Autok(int azonosító, String márka, String típus, int évjárat,
			int kölcsönzésiDíjPerNap) {
		super();
		this.azonosító = azonosító;
		this.márka = márka;
		this.típus = típus;
		this.évjárat = évjárat;
		this.kölcsönzésiDíjPerNap = kölcsönzésiDíjPerNap;
	}
	
	/**
	 * Az Autok osztály paraméter nélküli konstruktora
	 */
	public Autok() {
		
	}

	/**
	 * Lekéri az azonosítót
	 * @return autó azonosítója
	 */
	public int getAzonosító() {
		return azonosító;
	}
	/**
	 * Beállítja az azonosítót
	 * @param azonosító autó azonosítója
	 */
	public void setAzonosító(int azonosító) {
		this.azonosító = azonosító;
	}
	/**
	 * Lekéri a márkát
	 * @return autó márkája
	 */
	public String getMárka() {
		return márka;
	}
	/**
	 * Beállítja a márkát
	 * @param márka autó márkája
	 */
	public void setMárka(String márka) {
		this.márka = márka;
	}
	/**
	 * Lekéri a típust
	 * @return autó típusa
	 */
	public String getTípus() {
		return típus;
	}
	/**
	 * Beállítja a típust
	 * @param típus autó típusa
	 */
	public void setTípus(String típus) {
		this.típus = típus;
	}
	/**
	 * Lekéri az évjáratot
	 * @return autó évjárata
	 */
	public int getÉvjárat() {
		return évjárat;
	}
	/**
	 * Beállítja az évjáratot
	 * @param évjárat autó évjárata
	 */
	public void setÉvjárat(int évjárat) {
		this.évjárat = évjárat;
	}
	/**
	 * Lekéri a kölcsönzési díjat egy napra
	 * @return autó köcsönzési díja egy napra
	 */
	public int getKölcsönzésiDíjPerNap() {
		return kölcsönzésiDíjPerNap;
	}
	/**
	 * Beállítja a kölcsönzési díjat egy napra
	 * @param kölcsönzésiDíjPerNap autó köcsönzési díja egy napra
	 */
	public void setKölcsönzésiDíjPerNap(int kölcsönzésiDíjPerNap) {
		this.kölcsönzésiDíjPerNap = kölcsönzésiDíjPerNap;
	}

}
