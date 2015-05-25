package RentACar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UgyfelTeszt {
	
	@Test
	public void testmegfelelőDátumFormátum(){
		String datum1 = "2014.08.01";
		String datum2 = "2014.aa.01";
		String datum3 = "2014 01 01";
		
		assertTrue(Ugyfel.megfelelőDátumFormátum(datum1));
		assertFalse(Ugyfel.megfelelőDátumFormátum(datum2));
		assertFalse(Ugyfel.megfelelőDátumFormátum(datum3));
	}
	
	@Test
	public void testmegfelelőDátum(){
		String kezd1 = "2014.08.01";
		String vege1 = "2014.08.10";
		String kezd2 = "2014.08.15";
		String vege2 = "2014.08.10";
		
		assertTrue(Ugyfel.megfelelőDátum(kezd1, vege1));
		assertFalse(Ugyfel.megfelelőDátum(kezd2, vege2));
	}
	
	@Test
	public void testszabadDátum(){
		String kezdU1 = "2014.08.01";
		String vegeU1 = "2014.08.10";
		String kezdL1 = "2014.08.15";
		String vegeL1 = "2014.08.20";
		
		String kezdU2 = "2014.08.01";
		String vegeU2 = "2014.08.10";
		String kezdL2 = "2014.08.09";
		String vegeL2 = "2014.08.20";
		
		String kezdU3 = "2014.08.12";
		String vegeU3 = "2014.08.25";
		String kezdL3 = "2014.08.10";
		String vegeL3 = "2014.08.20";
		
		String kezdU4 = "2014.08.01";
		String vegeU4 = "2014.08.25";
		String kezdL4 = "2014.08.10";
		String vegeL4 = "2014.08.20";
		
		assertTrue(Ugyfel.szabadDátum(kezdU1, kezdL1, vegeU1, vegeL1));
		assertFalse(Ugyfel.szabadDátum(kezdU2, kezdL2, vegeU2, vegeL2));
		assertFalse(Ugyfel.szabadDátum(kezdU3, kezdL3, vegeU3, vegeL3));
		assertFalse(Ugyfel.szabadDátum(kezdU4, kezdL4, vegeU4, vegeL4));
		
	}

}
