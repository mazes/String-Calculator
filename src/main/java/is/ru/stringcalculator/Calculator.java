package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.isEmpty()){
			return 0;
		}
		else if (text.contains(",") || text.contains("\\n")){
			String result[] = text.split("[,|\\n]");
			return sum(result);
		}
		else {
			return 1;
		}

	}

	private static int toInt(String number) {
		return Integer.parseInt(number);
	}

	private static int sum(String numbers[]) {
		int result = 0;
		for (String number: numbers) {
			result += toInt(number);
		}
		return result;
	}
}
