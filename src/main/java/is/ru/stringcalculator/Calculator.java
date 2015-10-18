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

				String firstElementOfDelim;


				StringBuilder customDelimitor = new StringBuilder("[");
				int i = 2;

				while(text.charAt(i) != '\n') {
					customDelimitor.append(text.charAt(i));
					i++;
				}

				customDelimitor.append("]*|\\n");
				String customD = customDelimitor.toString();
				text = text.replace(System.getProperty("line.separator"), "");
				String result[] = text.split(customD);
				//ArrayList<String> resultList = new ArrayList<String>(Arrays.asList(resultPre));
			/*	for (int j = 0; j <= resultList.size() - 1; j++) {
					if (resultList.get(j) == " ") {
						resultList.remove(resultList.get(j));
					}
				}*/

			//	String result[] = resultList.toArray(new String[resultList.size()]);
				System.out.println(customD);
				for (int j = 0; j < result.length; j++) {
					System.out.print(result[j]);
				}
				return sumC(result);
			}

			else if (text.contains("-")) {
				String textArr[] = text.split(",|\\n");
				ArrayList<String> list = new ArrayList<String>(Arrays.asList(textArr));
				StringBuilder negatives = new StringBuilder("Negative numbers not allowed: ");
				for ( String number: textArr) {
					if (toInt(number) < 0) {
						negatives.append(number);
						negatives.append(",");
						list.remove(number);
					}
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
			if(toInt(number) < 1000){
			result += toInt(number);
			}
		}
		return result;
	}

	private static int sumC(String numbers[]) {
		int result = 0;
		for (int i = 2; i < numbers.length; i++){
			if(numbers[i].isEmpty()){continue;}
			if (toInt(numbers[i]) < 1000){
			result += toInt(numbers[i]);
			}
		}
		return result;
	}

	public static void ex(String negativeNrs) throws Exception {
				throw new Exception(negativeNrs);
	}
}
