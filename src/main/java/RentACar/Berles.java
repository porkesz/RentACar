package RentACar;

import java.sql.Date;

/**
 * Berles osztály a bérléseket kezeli
 * 
 * @author Kovács Ádám
 */
public class Berles {
	
	/**
	 * Bérelt autó
	 */
	Autok a;
	/**
	 * Bérelő
	 */
	Ugyfel u;
	/**
	 * Bérlés kezdete
	 */
	String bérlésKezd;
	/**
	 * Bérlés vége
	 */
	String bérlésVége;
	/**
	 * Van e autoklub kártya
	 */
	boolean autoKlub;
	/**
	 * Lesz e külföldi használat
	 */
	boolean külföld;
	/**
	 * GPS-t bérelt e az ügyfél
	 */
	boolean gps;
	/**
	 * Extra biztosítást kötött e az ügyfél
	 */
	boolean bizt;
	/**
	 * Mikor
	 */
	String mikor;
	
	
	/**
	 * Berles osztály konstruktora
	 * 
	 * @param a a bérelt autó
	 * @param u az ügyfél
	 * @param bérlésKezd a bérlés kezdete
	 * @param bérlésVége a bérlés vége
	 * @param autoKlub van e autoklub kártya
	 * @param gps volt e gps bérelve
	 * @param bizt extra bitosítás volt e
	 * @param mikor mikor
	 */
	public Berles(Autok a, Ugyfel u, String bérlésKezd, String bérlésVége,
			boolean autoKlub, boolean külföld, boolean gps, boolean bizt,
			String mikor) {
		super();
		this.a = a;
		this.u = u;
		this.bérlésKezd = bérlésKezd;
		this.bérlésVége = bérlésVége;
		this.autoKlub = autoKlub;
		this.külföld = külföld;
		this.gps = gps;
		this.bizt = bizt;
		this.mikor = mikor;
	}
	
	/**
	 * Lekéri a bérelt autót
	 * @return Autok objektum
	 */
	public Autok getA() {
		return a;
	}
	/**
	 * Beállítja a bérelt autót
	 * @param a bérelt autó
	 */
	public void setA(Autok a) {
		this.a = a;
	}
	/**
	 * Lekéri a bérelőt
	 * @return Ugyfel objektum
	 */
	public Ugyfel getU() {
		return u;
	}
	/**
	 * Beállítja a bérelőt
	 * @param u bérlő
	 */
	public void setU(Ugyfel u) {
		this.u = u;
	}
	/**
	 * Lekéri a bérelés kezdetét
	 * @return bérlés kezdete
	 */
	public String getBérlésKezd() {
		return bérlésKezd;
	}
	/**
	 * Beállítja a bérlés kezdetét
	 * @param bérlésKezd a bérlés kezdete
	 */
	public void setBérlésKezd(String bérlésKezd) {
		this.bérlésKezd = bérlésKezd;
	}
	/**
	 * Lekéri a bérelés végét
	 * @return bérlés vége
	 */
	public String getBérlésVége() {
		return bérlésVége;
	}
	/**
	 * Beállítja a bérlés végét
	 * @param bérlésVége a bérlés vége
	 */
	public void setBérlésVége(String bérlésVége) {
		this.bérlésVége = bérlésVége;
	}
	/**
	 * Lekéri hogy van e autoklub kártya
	 * @return van vagy nincs
	 */
	public boolean isAutoKlub() {
		return autoKlub;
	}
	/**
	 * Beállítja hogy van e autoklub kártya
	 * @param autoKlub igen vagy nem
	 */
	public void setAutoKlub(boolean autoKlub) {
		this.autoKlub = autoKlub;
	}
	/**
	 * Lekéri hogy lesz e külföldi használat
	 * @return igen vagy nem
	 */
	public boolean isKülföld() {
		return külföld;
	}
	/**
	 * Beállítja hogy van e külföldi használat
	 * @param külföld igen vagy nem
	 */
	public void setKülföld(boolean külföld) {
		this.külföld = külföld;
	}
	/**
	 * Lekéri hogy van e gps bérelve
	 * @return van vagy nincs
	 */
	public boolean isGps() {
		return gps;
	}
	/**
	 * Beállítja hogy van e gps bérelve
	 * @param gps igen vagy nem
	 */
	public void setGps(boolean gps) {
		this.gps = gps;
	}
	/**
	 * Lekéri hogy van e extra biztosítás
	 * @return van vagy nincs
	 */
	public boolean isBizt() {
		return bizt;
	}
	/**
	 * Beállítja hogy van e extra biztosítás kötve
	 * @param bizt igen vagy nem
	 */
	public void setBizt(boolean bizt) {
		this.bizt = bizt;
	}
	/**
	 * Lekéri hogy mikor
	 * @return mikor
	 */
	public String getMikor() {
		return mikor;
	}
	/**
	 * Beállítja hogy mikor
	 * @param mikor mikor
	 */
	public void setMikor(String mikor) {
		this.mikor = mikor;
	}
	/**
	 * Berles osztály paraméter nélküli konstruktora
	 */
	public Berles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Meghatározza a kedvezményes árat amely a bérlés hossza után jár
	 * 
	 * @param végÖsszeg a kiszámolt végösszeg
	 * @param napokSzáma a bérlés időtartama
	 * 
	 * @return a kedvezményes végösszeg
	 */
	public static double fullÁr(int végÖsszeg, int napokSzáma){
		double x = végÖsszeg;
		
		if(napokSzáma < 10){
			return x;
		} else if(napokSzáma < 20){
			return x * 90 / 100;
		} else if(napokSzáma < 30){
			return x * 80 / 100;
		} else {
			return x * 70 / 100; 
		}
	}
	
	/**
	 * Meghatározza a kedvezményes árat amely az autoklub kártyásokra vonatkozik
	 * 
	 * @param full a teljes ár
	 * @param ak van e autoklub kártya
	 * 
	 * @return a kedvezményes végösszeg
	 */
	public static double fullÁrPlusAk(double full, boolean ak){
		if(ak == true)
			return full * 80 / 100;
		else
			return full;
	}
	
	/**
	 * Meghatározza a bérlés hosszát
	 * 
	 * @param kezd a bérlés kezdete
	 * @param vége a bérlés vége
	 * 
	 * @return a bérlés hossza
	 */
	public static int napokSzáma(String kezd, String vége){
		String[]ke = kezd.split("\\.");
		String[]ve = vége.split("\\.");
		Date k = Date.valueOf(ke[0]+"-"+ke[1]+"-"+ke[2]);
		Date v = Date.valueOf(ve[0]+"-"+ve[1]+"-"+ve[2]);
		final long egyNap = 24 * 60 * 60 * 1000L;
		
		return (int)((v.getTime() - k.getTime()) / egyNap);
	}
	
	/**
	 * Meghatározza a Gps díjját a bérlés időtartamára
	 * 
	 * @param nap a bérlés időtartama napokban
	 * 
	 * @return a Gps díjja
	 */
	public static int gpsDíj(int nap){
		int összeg = 0;
		összeg = nap * 500;
		return összeg;
	}
	
	/**
	 * Meghatározza az autó díjját a bérlésre
	 * 
	 * @param napiDíj az autó napidíjja
	 * @param napok a bérlés időtartama
	 * 
	 * @return bérleti díj
	 */
	public static int osszeg(int napiDíj, int napok){
		int össz = 0;
		össz = napiDíj * napok;
		return össz;
	}
	
	/**
	 * Meghatározza a bérleti díj és a Gps összegét
	 * 
	 * @param o bérleti díj
	 * @param g Gps díjja
	 * 
	 * @return a bérleti díj Gps-el
	 */
	public static int összegPlusGps(int o, int g){
		int összeg = 0;
		összeg = o + g;
		return összeg;
	}
	
	/**
	 * Meghatározza az extra biztosítás összegét a bérlés időtartamára
	 * 
	 * @param napok a bérlés időtartama
	 * 
	 * @return extra biztosítás díja a bérlésre
	 */
	public static int biztÖsszeg(int napok){
		int bo = 0;
		bo = napok * 1500;
		return bo;
	}
	
	/**
	 * Meghatározza azt az árat amiben benne van a kor kockázat, a külföldi tartózkodás és a biztosítás
	 * 
	 * @param teljesÁr teljes ár
	 * @param kor a bérlő kora
	 * @param külföld lesz a külföldi tartózkodás
	 * @param biztosítás biztosítás díjja 
	 * 
	 * @return végösszeg
	 */
	public static double végÖsszeg(int teljesÁr, int kor, boolean külföld, int biztosítás){
		double végösszeg;
		double x = 100;
		
		végösszeg = teljesÁr;
		
		if(kor < 21)
			x = (x + 20);
		else if(kor > 50)
			x = (x - 10);
		
		if(külföld == true)
			x = (x + 10);
		
		végösszeg = végösszeg + biztosítás;
		
		végösszeg = (végösszeg * x) / 100;
		
		return végösszeg;
	}

}
