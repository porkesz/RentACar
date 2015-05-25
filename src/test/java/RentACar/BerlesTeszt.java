package RentACar;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BerlesTeszt {
	

		@Test
		public void testfullÁr(){
			int végösszeg = 10000;
			int napokSzáma = 5;
			double x;
			x = Berles.fullÁr(végösszeg, napokSzáma);
			assertTrue(x == 10000);
			napokSzáma = 15;
			x = Berles.fullÁr(végösszeg, napokSzáma);
			assertTrue(x == 9000);
			napokSzáma = 25;
			x = Berles.fullÁr(végösszeg, napokSzáma);
			assertTrue(x == 8000);
			napokSzáma = 35;
			x = Berles.fullÁr(végösszeg, napokSzáma);
			assertTrue(x == 7000);
		}
		
		@Test
		public void testfullÁrPlusAk(){
			double ar = 1000;
			boolean b = true;
			double x = Berles.fullÁrPlusAk(ar, b);
			assertTrue(x == 800);
			b = false;
			x = Berles.fullÁrPlusAk(ar, b);
			assertTrue(x == 1000);
			
			
		}
	
		@Test
		public void testnapokSzáma(){
			int napok = 0;
			napok = Berles.napokSzáma("2011.12.01", "2011.12.16");
			assertTrue(napok == 15);
			napok = Berles.napokSzáma("2011.12.01", "2012.12.01");
			assertTrue(napok == 366);
		}
		
		@Test
		public void testgpsDíj() {
			int nap = 5;
			int osszeg = Berles.gpsDíj(nap);
			assertTrue(osszeg == 2500);
			osszeg = Berles.gpsDíj(0);
			assertTrue(osszeg == 0);
		}
		
		@Test
		public void testösszeg(){
			int össz = 0;
			össz = Berles.osszeg(500, 10);
			assertTrue(össz == 5000);
			össz = Berles.osszeg(5000, 0);
			assertTrue(össz == 0);
		}
		
		@Test
		public void testösszegPlusGps(){
			int összeg = 0;
			összeg = Berles.összegPlusGps(100, 100);
			assertTrue(összeg == 200);
			összeg = Berles.összegPlusGps(0, 0);
			assertTrue(összeg == 0);
		}
		
		
		@Test
		public void testvégÖsszeg() {
			int teljes_ár = 1000;
			int kor = 30;
			boolean kul = false;
			int biz = 100;
			double vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 1100);
			
			biz = 200;
			vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 1200);
			
			kul = true;
			vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 1320);
			
			biz = 0;
			vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 1100);
			
			
			kor = 20;
			kul = false;
			biz = 0;
			vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 1200);
			
			biz = 100;
			vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 1320);
			
			kul = true;
			vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 1430);
			
			biz = 0;
			vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 1300);
			
			kor = 60;
			kul = false;
			biz = 0;
			vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 900);
			
			biz = 100;
			vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 990);
			
			kul = true;
			vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 1100);
			
			biz = 0;
			vo = Berles.végÖsszeg(teljes_ár, kor, kul, biz);
			assertTrue(vo == 1000);
		}

}
