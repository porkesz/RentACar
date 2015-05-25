package RentACar;

import java.sql.Date;

/**
 * Ugyfel osztály az ügyfeleket kezeli
 * 
 * @author Kovács Ádám
 */
public class Ugyfel {
	/**
	 * Az ügyfél egyedi azonosítója
	 */
	int ügyfelAzon;
	/**
	 * Az ügyfél vezetékneve 
	 */
	String vezetékNév;
	/**
	 * Az ügyfél keresztneve 
	 */
	String keresztNév;
	/**
	 * Az ügyfél életkora 
	 */
	int életkor;
	/**
	 * Város ahol az ügyfél lekik 
	 */
	String város;
	/**
	 * Utca ahol az ügyfél lekik 
	 */
	String utca;
	/**
	 * Házszám ahol az ügyfél lekik 
	 */
	String házszám;
	/**
	 * Annak az autónak a kódja amit az ügyfél kibérel 
	 */
	int autoKód;
	/**
	 * Bérlés kezdete 
	 */
	String bérlésKezdete;
	/**
	 * Bérlés vége 
	 */
	String bérlésVége;
	/**
	 * Van e az ügyfélnek autóklub kártyája 
	 */
	boolean akk;

	/**
	 * Az Ugyfél osztály paraméter nélküli konstruktora 
	 */
	public Ugyfel() {
		
	}
	
	/**
	 * Az Ugyfél osztály konstruktora
	 * 
	 * @param ügyfelAzon egyedi azonosító
	 * @param vezetékNév az ügyfél vezetékneve
	 * @param keresztNév az ügyfél keresztneve
	 * @param életkor az ügyfél életkora
	 * @param város város ahol az ügyfél lakik
	 * @param utca utca ahol az ügyfél lakik
	 * @param házszám házszám ahol az ügyfél lakik
	 * @param autoKód a bérelt autó azonosítója
	 * @param bérlésKezdete a bérlés kezdete
	 * @param bérlésVége a bérlés vége
	 * @param akk van e autóklub kártyája
	 */
	public Ugyfel(int ügyfelAzon, String vezetékNév, String keresztNév, int életkor,
			String város, String utca, String házszám, int autoKód,
			String bérlésKezdete, String bérlésVége, boolean akk) {
		super();
		this.ügyfelAzon = ügyfelAzon;
		this.vezetékNév = vezetékNév;
		this.keresztNév = keresztNév;
		this.életkor = életkor;
		this.város = város;
		this.utca = utca;
		this.házszám = házszám;
		this.autoKód = autoKód;
		this.bérlésKezdete = bérlésKezdete;
		this.bérlésVége = bérlésVége;
		this.akk = akk;
	}
	/**
	 * Lekéri az azonosítót
	 * @return ügyfél azonosítója
	 */
	public int getÜgyfelAzon() {
		return ügyfelAzon;
	}
	/**
	 * Beállítja az azonosítót
	 * @param ügyfelAzon ügyfél azonosítója
	 */
	public void setÜgyfelAzon(int ügyfelAzon) {
		this.ügyfelAzon = ügyfelAzon;
	}
	/**
	 * Lekéri a vezetéknevet
	 * @return ügyfél vezetékneve
	 */
	public String getVezetékNév() {
		return vezetékNév;
	}
	/**
	 * Beállítja a vezetéknevet
	 * @param vezetékNév vezetéknév
	 */
	public void setVezetékNév(String vezetékNév) {
		this.vezetékNév = vezetékNév;
	}
	/**
	 * Lekéri a keresztnevet
	 * @return ügyfél keresztneve
	 */
	public String getKeresztNév() {
		return keresztNév;
	}
	/**
	 * Beállítja a keresztnév
	 * @param keresztNév keresztnév
	 */
	public void setKeresztNév(String keresztNév) {
		this.keresztNév = keresztNév;
	}
	/**
	 * Lekéri az életkort
	 * @return ügyfél életkora
	 */
	public int getÉletkor() {
		return életkor;
	}
	/**
	 * Beállítja a kort
	 * @param életkor életkor
	 */
	public void setÉletkor(int életkor) {
		this.életkor = életkor;
	}
	/**
	 * Lekéri a várost
	 * @return város ahol az ügyfél lakik 
	 */
	public String getVáros() {
		return város;
	}
	/**
	 * Beállítja a várost
	 * @param város város ahol az ügyfél lakik
	 */
	public void setVáros(String város) {
		this.város = város;
	}
	/**
	 * Lekéri az utcát
	 * @return utca ahol az ügyfél lakik 
	 */
	public String getUtca() {
		return utca;
	}
	/**
	 * Beállítja a utcát
	 * @param utca utca ahol az ügyfél lakik
	 */
	public void setUtca(String utca) {
		this.utca = utca;
	}
	/**
	 * Lekéri a házszámot
	 * @return házszám ahol az ügyfél lakik 
	 */
	public String getHázszám() {
		return házszám;
	}
	/**
	 * Beállítja a házszámot
	 * @param házszám házszám ahol az ügyfél lakik
	 */
	public void setHázszám(String házszám) {
		this.házszám = házszám;
	}
	/**
	 * Lekéri az autó kódját
	 * @return  autó azonosító
	 */
	public int getAutoKód() {
		return autoKód;
	}
	/**
	 * Beállítja az autó kódot
	 * @param autoKód a bérelt autó kódja
	 */
	public void setAutoKód(int autoKód) {
		this.autoKód = autoKód;
	}
	/**
	 * Lekéri a bérlés kezdetét
	 * @return bérlés kezdete 
	 */
	public String getBérlésKezdete() {
		return bérlésKezdete;
	}
	/**
	 * Beállítja a bérlés kezdetét
	 * @param bérlésKezdete a bérlés kezdete
	 */
	public void setBérlésKezdete(String bérlésKezdete) {
		this.bérlésKezdete = bérlésKezdete;
	}
	/**
	 * Lekéri a bérlés végét
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
	 * Van e autóklub kártya
	 * @return igen vagy nem  
	 */
	public boolean isAkk() {
		return akk;
	}
	/**
	 * Beállítja van e autóklub kártya
	 * @param akk igen vagy nem   
	 */
	public void setAkk(boolean akk) {
		this.akk = akk;
	}
	
	/**
	 * Meghatározza megfelelő e a dátum formátuma
	 * @param dátum egy dátum
	 * 
	 * @return megvelelő e vagy nem
	 */
	public static boolean megfelelőDátumFormátum(String dátum){
		if(dátum.length()!=10)
			return false;
		if((dátum.charAt(4)!='.') && (dátum.charAt(7)!='.'))
			return false;
		for(int i = 0; i < 10; ++i){
			if(i == 4)
				++i;
			if(i == 7)
				++i;
			if(!Character.isDigit(dátum.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Meghatározza megfelelő e a két dátum
	 * @param kezd a kezdő dátum
	 * @param vége a második dátum
	 * 
	 * @return megvelelő e vagy nem
	 */
	public static boolean megfelelőDátum(String kezd, String vége){
		String[]ke = kezd.split("\\.");
		String[]ve = vége.split("\\.");
		int [] k = new int[3];
		int [] v = new int[3];
		Date kd = null;
		Date vd = null;
		
		for(int i = 0; i < 3; ++i){
			k[i] = Integer.valueOf(ke[i]);
			v[i] = Integer.valueOf(ve[i]);
		}
		
		if((k[0] < 2014) || (v[0] < 2014) || (k[1] > 12) || (v[1] > 12) || (k[2] > 31) || (v[2] > 31)){
			return false;
		}
		
		kd = Date.valueOf(ke[0]+"-"+ke[1]+"-"+ke[2]);
		vd = Date.valueOf(ve[0]+"-"+ve[1]+"-"+ve[2]);
	
		if(kd.getTime() > vd.getTime()){
			return false;
		}
		return true;
	}
	
	/**
	 * Meghatározza szabad e a dátum
	 * @param k1 bérlés kezdete
	 * @param k2 a listában lévő dátum kezdete
	 * @param v1 bérlés vége
	 * @param v2 a listában lévő dátum vége
	 * 
	 * @return szabad e vagy nem
	 */
	public static boolean szabadDátum(String k1, String k2, String v1, String v2){
		String[]ke1 = k1.split("\\.");
		String[]ve1 = v1.split("\\.");
		String[]ke2 = k2.split("\\.");
		String[]ve2 = v2.split("\\.");
		Date kezdÜgyfél = Date.valueOf(ke1[0]+"-"+ke1[1]+"-"+ke1[2]);
		Date végeÜgyfél = Date.valueOf(ve1[0]+"-"+ve1[1]+"-"+ve1[2]);
		Date kezdLista = Date.valueOf(ke2[0]+"-"+ke2[1]+"-"+ke2[2]);
		Date végeLista = Date.valueOf(ve2[0]+"-"+ve2[1]+"-"+ve2[2]);
		
		if((kezdÜgyfél.getTime() >= kezdLista.getTime()) && (kezdÜgyfél.getTime() <= végeLista.getTime()))
			return false;
		if((végeÜgyfél.getTime() >= kezdLista.getTime()) && (végeÜgyfél.getTime() <= végeLista.getTime()))
			return false;
		if((kezdÜgyfél.getTime() <= kezdLista.getTime()) && (végeÜgyfél.getTime() >= végeLista.getTime()))
			return false;
		
		return true;
	}


}
