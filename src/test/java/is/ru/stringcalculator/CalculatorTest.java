package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers(){
		assertEquals(15, Calculator.add("1,2,3,4,5"));
	}

	@Test
	public void testNewLineCharacter() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testMoreDelimitors() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testNegativeNotAllowed() {
		assertEquals(2, Calculator.add("-1,2,-4"));
	}

	@Test
	public void testBigNumbers() {
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void testMultipleDel() {
		assertEquals(3, Calculator.add("//***\n1***2"));
	}
}
