package artem.belskii;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalc {
	Convert convert = new Convert();
	@Test
	public void convertroRome() {
		assertEquals(1024, convert.convert("MXXIV(r)"));
	}
	
	@Test
	public void convertBin(){
		assertEquals(1024, convert.convert("10000000000(2)"));
	}

	@Test
	public void convertHex(){
		assertEquals(1024, convert.convert("400(16)"));
	}
	
	@Test
	public void sumHexAndBin(){
		Calc calc = new Calc();
		assertEquals("800(16)", calc.add("400(16)", "10000000000(2)"));
	}

	@Test
	public void sumDecAndRome(){
		Calc calc = new Calc();
		assertEquals("2048(dec)", calc.add("1024", "MXXIV(r)"));
	}

	

}
