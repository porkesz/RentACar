package RentACar;

import java.sql.Date;

/**
 * Berles osztály a bérléseket kezeli
 * 
 * @author Kovács Ádám
 */
public class Berles {
	
	Autok a;
	Ugyfel u;
	String bérlésKezd;
	String bérlésVége;
	boolean autoKlub;
	boolean külföld;
	boolean gps;
	boolean bizt;
	String mikor;
	
	
	
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

	public Autok getA() {
		return a;
	}

	public void setA(Autok a) {
		this.a = a;
	}

	public Ugyfel getU() {
		return u;
	}

	public void setU(Ugyfel u) {
		this.u = u;
	}

	public String getBérlésKezd() {
		return bérlésKezd;
	}

	public void setBérlésKezd(String bérlésKezd) {
		this.bérlésKezd = bérlésKezd;
	}

	public String getBérlésVége() {
		return bérlésVége;
	}

	public void setBérlésVége(String bérlésVége) {
		this.bérlésVége = bérlésVége;
	}

	public boolean isAutoKlub() {
		return autoKlub;
	}

	public void setAutoKlub(boolean autoKlub) {
		this.autoKlub = autoKlub;
	}

	public boolean isKülföld() {
		return külföld;
	}

	public void setKülföld(boolean külföld) {
		this.külföld = külföld;
	}

	public boolean isGps() {
		return gps;
	}

	public void setGps(boolean gps) {
		this.gps = gps;
	}

	public boolean isBizt() {
		return bizt;
	}

	public void setBizt(boolean bizt) {
		this.bizt = bizt;
	}

	public String getMikor() {
		return mikor;
	}

	public void setMikor(String mikor) {
		this.mikor = mikor;
	}

	public Berles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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
	
	public static double fullÁrPlusAk(double full, boolean ak){
		if(ak == true)
			return full * 80 / 100;
		else
			return full;
	}
	
	public static int napokSzáma(String kezd, String vége){
		String[]ke = kezd.split("\\.");
		String[]ve = vége.split("\\.");
		Date k = Date.valueOf(ke[0]+"-"+ke[1]+"-"+ke[2]);
		Date v = Date.valueOf(ve[0]+"-"+ve[1]+"-"+ve[2]);
		final long egyNap = 24 * 60 * 60 * 1000L;
		
		return (int)((v.getTime() - k.getTime()) / egyNap);
	}
	
	public static int gpsDíj(int nap){
		int összeg = 0;
		összeg = nap * 500;
		return összeg;
	}
	
	public static int osszeg(int napiDíj, int napok){
		int össz = 0;
		össz = napiDíj * napok;
		return össz;
	}
	
	public static int összegPlusGps(int o, int g){
		int összeg = 0;
		összeg = o + g;
		return összeg;
	}
	
	public static int biztÖsszeg(int napok){
		int bo = 0;
		bo = napok * 1500;
		return bo;
	}
	
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
