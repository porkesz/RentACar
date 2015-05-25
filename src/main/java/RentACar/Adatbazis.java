package RentACar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Adatbázis kezelő osztály.
 * 
 * @author Kovács Ádám
 */
public class Adatbazis {
	/**
	 * connection változó
	 */
	Connection connection = null;
	/**
	 * statement változó
	 */
	Statement statement = null;
	/**
	 * rs változó
	 */
	ResultSet rs = null;
	
	/**
	 * Kapcsolódás az adatbázishoz
	 */
	public Adatbazis() {		
		try {
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g", "h_pbxkhu", "juventus");
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Sikeres kapcsolódás az adatbázishoz!");
			
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Sikertelen kapcsolódás az adatbázishoz!");
		}
	}
	
	/**
	 * Autok tábla eldobása
	 */
	public void autokTáblaEldobása(){
		try {
			statement = connection.createStatement();
			statement.executeUpdate("drop table autok");
			statement.close();
		
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Autok tábla eldobása nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Ugyfel tábla eldobása
	 */
	public void ügyfélTáblaEldobása(){
		try {
			statement = connection.createStatement();
			statement.executeUpdate("drop table ugyfel");
			statement.close();
		
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Ugyfel tábla eldobása nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Autok tábla létrehozása
	 */
	public void autokTáblaLétrehozása(){
		try {
			statement = connection.createStatement();
			statement.executeUpdate("create table autok(azonosito number(2), marka varchar2(30), tipus varchar2(30),"
									+ " evjarat number(4), kolcsonzesiDijPerNap number(5))");
			statement.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Autok tábla létrehozása nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Ugyfel tábla létrehozása
	 */
	public void ügyfélTáblaLétrehozása(){
		try {
			statement = connection.createStatement();
			statement.executeUpdate("create table ugyfel(ugyfelAzon number(2), vezetekNev varchar2(30), keresztNev varchar2(30), eletkor number(3),"
									+ " varos varchar2(30), utca varchar2(30), hazszam varchar2(10), autokod number(2), "
									+ "berlesKezdete varchar2(10), berlesVege varchar2(10), akk varchar2(5))");
			statement.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Ugyfel tábla lekérdezése nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Autok tábla feltöltése autókkal
	 */
	public void autokTáblaFeltöltése(){
		try {
			statement = connection.createStatement();
			statement.executeUpdate("insert into autok values(1, 'Mercedes', 'A180CDI', 2012, 9000)");
			statement.executeUpdate("insert into autok values(2, 'Mercedes', 'C200CDI', 2011, 11000)");
			statement.executeUpdate("insert into autok values(3, 'Mercedes', 'E220CDI', 2013, 13000)");
			statement.executeUpdate("insert into autok values(4, 'Mercedes', 'E350CDI', 2012, 14000)");
			statement.executeUpdate("insert into autok values(5, 'Mercedes', 'S350CDI', 2012, 16000)");
			statement.executeUpdate("insert into autok values(6, 'Mercedes', 'ML350CDI', 2011, 15000)");
			statement.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Autok tábla feltöltése nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Az egész Autok tábla lekérdezése
	 * 
	 * @return <code>Autok</code> lista
	 */
	public LinkedList<Autok> autokTáblaLekérdezése(){
		
		LinkedList<Autok> l = new LinkedList<Autok>();
				
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from autok");
			while(rs.next()){
				Autok auto = new Autok();
				
				auto.azonosító = rs.getInt("azonosito");
				auto.márka = rs.getString("marka");
				auto.típus = rs.getString("tipus");
				auto.évjárat = rs.getInt("evjarat");
				auto.kölcsönzésiDíjPerNap = rs.getInt("kolcsonzesiDijPerNap");
				
				l.add(auto);
			}			
			statement.close();
			rs.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Autok tábla lekérdezése nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return l;
	}
	
	/**
	 * Autok táblából lekérdezés azonosító alapján
	 * 
	 * @return <code>Autok</code>
	 * @param azon egy egyedi azonosító
	 */
	public Autok autokTáblaLekérdezéseAzon(int azon){
		
		Autok auto = new Autok();
				
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from autok where azonosito="+azon);
			while(rs.next()){
				
				auto.azonosító = rs.getInt("azonosito");
				auto.márka = rs.getString("marka");
				auto.típus = rs.getString("tipus");
				auto.évjárat = rs.getInt("evjarat");
				auto.kölcsönzésiDíjPerNap = rs.getInt("kolcsonzesiDijPerNap");
				
			}			
			statement.close();
			rs.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Autok tábla lekérdezése azonosítóval nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return auto;
	}
	
	/**
	 * Az egész Ugyfel tábla lekérdezése
	 * 
	 * @return <code>Ugyfel</code> lista
	 */
	public LinkedList<Ugyfel> ügyfélTáblaLekérdezése(){
		
		LinkedList<Ugyfel> l = new LinkedList<Ugyfel>();
				
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from ugyfel");
			while(rs.next()){
				Ugyfel ugyfel = new Ugyfel();
				
				ugyfel.ügyfelAzon = rs.getInt("ugyfelAzon");
				ugyfel.vezetékNév = rs.getString("vezetekNev");
				ugyfel.keresztNév = rs.getString("keresztNev");
				ugyfel.életkor = rs.getInt("eletkor");
				ugyfel.város = rs.getString("varos");
				ugyfel.utca = rs.getString("utca");
				ugyfel.házszám = rs.getString("hazszam");
				ugyfel.autoKód = rs.getInt("autokod");
				ugyfel.bérlésKezdete = rs.getString("berlesKezdete");
				ugyfel.bérlésVége = rs.getString("berlesVege");
				ugyfel.akk = rs.getString("akk").equals("true") ? true : false;
				
				l.add(ugyfel);
			}			
			statement.close();
			rs.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Ugyfel tábla lekérdezése nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return l;
	}
	
	/**
	 * Ugyfel táblából lekérdezés azonosító alapján
	 * 
	 * @return <code>Ugyfel</code> 
	 * @param azon egy egyedi azonosító
	 */
	public Ugyfel ügyfélTáblaLekérdezéseAzon(int azon){
	
		Ugyfel ügyfél = new Ugyfel();
			
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from ugyfel where ugyfelAzon ="+azon);
			while(rs.next()){
			
				ügyfél.ügyfelAzon = rs.getInt("ugyfelAzon");
				ügyfél.vezetékNév = rs.getString("vezetekNev");
				ügyfél.keresztNév = rs.getString("keresztNev");
				ügyfél.életkor = rs.getInt("eletkor");
				ügyfél.város = rs.getString("varos");
				ügyfél.utca = rs.getString("utca");
				ügyfél.házszám = rs.getString("hazszam");
				ügyfél.autoKód = rs.getInt("autokod");
				ügyfél.bérlésKezdete = rs.getString("berlesKezdete");
				ügyfél.bérlésVége = rs.getString("berlesVege");
				ügyfél.akk = Boolean.valueOf(rs.getString("akk"));
			
			}			
			statement.close();
			rs.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Ugyfel tábla lekérdezése azonosítóval nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return ügyfél;
	}
	
	/**
	 * Adott azonosítójú autó napi díjának lekérdezése az Autok táblából
	 * 
	 * @return int
	 * @param autoAzon egy egyedi azonosító
	 */
	public int adottAutoNapiDíjaLekérdezés(int autoAzon){
		int nd = 0;		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from autok where azonosito = "+ autoAzon);
			while(rs.next()){
				nd = rs.getInt("kolcsonzesiDijPerNap");
			}			
			statement.close();
			rs.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Auto napi díjának lekérdezése nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return nd;
	}
	
	/**
	 * Egy ügyfél felvitele az Ugyfel táblába
	 * 
	 * @param u egy Ugyfel
	 */
	public void felvitelÜgyfélTáblába(Ugyfel u){
		try {
			statement = connection.createStatement();
			statement.executeUpdate("insert into ugyfel values("+u.ügyfelAzon+",'"+u.vezetékNév+"', '"+u.keresztNév+"', "+u.életkor+", "
									+ "'"+u.város+"', '"+u.utca+"', '"+u.házszám+"', "+u.autoKód+", "
									+ "'"+u.bérlésKezdete+"', '"+u.bérlésVége+"', '"+u.akk+"')");
			statement.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Ugyfel táblába feltöltés nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Berles tábla létrehozása
	 */
	public void bérlésTáblaLétrehozása(){
		try {
			statement = connection.createStatement();
			statement.executeUpdate("create table berles(autoKod number(2), ugyfelKod number(2), berlesKezdete varchar2(10), berlesVege varchar2(10),"
					+ " autoKlub varchar2(5), kulfold varchar2(5), mikor date)");
			statement.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Berles tábla létrehozása nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Egy Berles felvitele a Berles táblába
	 * 
	 * @param b egy Berles
	 */
	public void bérlésTáblaAdd( Berles b){
		try {
			statement = connection.createStatement();
			statement.executeUpdate("insert into berles values("+b.a.azonosító+", "+b.u.ügyfelAzon+", '"+b.bérlésKezd+"',"
					+ "'"+b.bérlésVége+"', '"+b.autoKlub+"', '"+b.külföld+"', CURRENT_TIMESTAMP)");
			statement.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Felvitel a Berles táblába nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Az egész Berles tábla lekérdezése
	 * 
	 * @return <code>Berles</code> lista
	 */
	public LinkedList<Berles> bérlésTáblaLekérdezése(){
		
		LinkedList<Berles> l = new LinkedList<Berles>();
		Adatbazis a = new Adatbazis();
		
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from berles");
			while(rs.next()){
				Berles b = new Berles();
				
				b.a = a.autokTáblaLekérdezéseAzon(rs.getInt("autoKod"));
				b.u = a.ügyfélTáblaLekérdezéseAzon(rs.getInt("ugyfelKod"));
				b.bérlésKezd = rs.getString(3);
				b.bérlésVége = rs.getString(4);
				b.külföld = rs.getString(5).equals("true") ? true : false;
				b.mikor = rs.getString(6);
							
				l.add(b);
			}			
			statement.close();
			rs.close();
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Berles tábla lekérdezése nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return l;
	}

	/**
	 * Berles tábla eldobása
	 */
	public void bérlésTáblaEldobása(){
		try {
			statement = connection.createStatement();
			statement.executeUpdate("drop table berles");
			statement.close();
	
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Berles tábla eldobása nem sikerült!");
		}finally{
			if(statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Adabázis kapcsolat lezárása
	 */
	public void kapcsolatZárása(){
		try {
			connection.close();
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Kapcsolatbontás az adatbázissal sikerült!");
		} catch (SQLException e) {
			Logger.getLogger(Adatbazis.class.getName()).log(Level.SEVERE, "Adatbázis kapcsolat lezárása nem sikerült!");
		}
	}

}
