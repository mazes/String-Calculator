package is.ru.stringcalculator;
import java.lang.StringBuilder;
import java.lang.Exception;
import java.lang.Object;
import java.util.*;

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

			else if (text.contains("-")) {
				int i = 0; int j = 0;
				String textArr[] = text.split(",|\\n");
				ArrayList<String> list = new ArrayList<String>(Arrays.asList(textArr));
				StringBuilder negatives = new StringBuilder("Negative numbers not allowed: ");
				for ( String number: textArr) {
					if (toInt(number) < 0) {
						negatives.append(number);
						negatives.append(",");
						list.remove(number);
					}
					i++;
				}
				String negativeNumbers = negatives.toString();
				negativeNumbers = negativeNumbers.substring(0, negativeNumbers.length() - 1);
				String[] resultArr = new String[list.size()];
				resultArr = list.toArray(resultArr);
				return sum(resultArr);
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

	public static void ex(String negativeNrs) throws Exception {
				throw new Exception(negativeNrs);
	}
}
