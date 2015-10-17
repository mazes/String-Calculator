package is.ru.stringcalculator;
import java.lang.StringBuilder;

public class Calculator {

	public static int add(String text){
		if(text.isEmpty()){
			return 0;
		}
		else if (text.contains(",") || text.contains(";") ||
				 text.contains("\\n") || text.contains("/")) {

			if (text.contains("//")){
				String textArr[] = text.split("");
				StringBuilder customDelimitor = new StringBuilder(textArr[2]);
				customDelimitor.append("|,|\\n");
				String customD = customDelimitor.toString();
				String result[] = text.split(customD);
				return sumC(result);
			}

			else {
				String result[] = text.split("[,|\\n]");
				return sum(result);
			}

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

	private static int sumC(String numbers[]) {
		int result = 0;
		for (int i = 2; i < numbers.length; i++){
			result += toInt(numbers[i]);
		}
		return result;
	}
}
