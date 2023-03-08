package Helper;

import java.util.Deque;

public class StringHelper {

	public Deque<Long> partsEn(long val, long mul, Deque<Long> queue) {
        
		if (val >= 1000) {
            partsEn(val / 1000, mul * 1000, queue);

            if (val % 1000 > 0)
                partsEn(val % 1000, mul, queue);
        } else if (val <= 20) {
            if (mul == 1)
                queue.add(null);

            queue.add(val);

            if (mul > 1)
                queue.add(mul);
        } else if (val < 100) {
            if (mul == 1)
                queue.add(null);

            queue.add(val / 10 * 10);

            if (val % 10 > 0) {
                queue.add(val % 10);

                if (mul > 1)
                    queue.add(mul);
            }
        } else {
            queue.add(val / 100);
            queue.add(100L);

            if (val % 100 > 0)
                partsEn(val % 100, 1, queue);

            if (mul > 1)
                queue.add(mul);
        }

        return queue;
    }
	
	public Deque<Long> partsTr(long val, long mul, Deque<Long> queue) {
		
		if (val >= 1000) {
            partsTr(val / 1000, mul * 1000, queue);

            if (val % 1000 > 0)
                partsTr(val % 1000, mul, queue);
        } else if (val <= 20) {
            if (mul == 1)
                queue.add(null);
            if(val != 1)
            queue.add(val);

            if (mul > 1)
                queue.add(mul);
        } else if (val < 100) {
            if (mul == 1)
                queue.add(null);

            queue.add(val / 10 * 10);

            if (val % 10 > 0) {
                queue.add(val % 10);

                if (mul > 1)
                    queue.add(mul);
            }
        } else if(val != 100L && val != 1000L) {
        	queue.add(val / 100);
            queue.add(100L);

            if (val % 100 > 0)
                partsTr(val % 100, 1, queue);

            if (mul > 1)
                queue.add(mul);
        } else {
        	
        	queue.add(100L);

            if (val % 100 > 0)
                partsEn(val % 100, 1, queue);

            if (mul > 1)
                queue.add(mul);
        }

        return queue;
    }
	
	public String translateHundredsEn(int number) {
	    String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	    String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	    StringBuilder words = new StringBuilder();
	    int numHundred = number / 100;
	    int numTen = number % 100;
	    if (numHundred > 0) {
	        words.append(units[numHundred]).append(" hundred");
	        if (numTen > 0) {
	            words.append(" ");
	        }
	    }
	    if (numTen > 0) {
	        if (numTen < 20) {
	            words.append(units[numTen]);
	        } else {
	            int numUnit = numTen % 10;
	            int numTens = numTen / 10;
	            words.append(tens[numTens]);
	            if (numUnit > 0) {
	                words.append(" ").append(units[numUnit]);
	            }
	        }
	    }
	    return words.toString();
	}
	
	public String translateHundredsTr(int number) {
		
		String[] units = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz", "on", "on bir", "on iki", "on üç", "on dört", "on beş", "on altı", "on yedi", "on sekiz", "on dokuz"};
	    String[] tens = {"", "", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
	    StringBuilder words = new StringBuilder();
	    int numHundred = number / 100;
	    int numTen = number % 100;
	    if (numHundred > 1) {
	        words.append(units[numHundred]).append(" yüz");
	        if (numTen > 0) {
	            words.append(" ");
	        }
	    }else {
	    	words.append("yüz");
	    	if (numTen > 0) {
	            words.append(" ");
	        }
	    }
	    if (numTen > 0) {
	        if (numTen < 20) {
	            words.append(units[numTen]);
	        } else {
	            int numUnit = numTen % 10;
	            int numTens = numTen / 10;
	            words.append(tens[numTens]);
	            if (numUnit > 0) {
	                words.append(" ").append(units[numUnit]);
	            }
	        }
	    }
	    return words.toString();
	}
	
	public String getTurkishWordForNumber(long number) {
	    switch ((int) number) {
	        case 1:
	            return "bir";
	        case 2:
	            return "iki";
	        case 3:
	            return "üç";
	        case 4:
	            return "dört";
	        case 5:
	            return "beş";
	        case 6:
	            return "altı";
	        case 7:
	            return "yedi";
	        case 8:
	            return "sekiz";
	        case 9:
	            return "dokuz";
	        default:
	            return "";
	    }
	}
	
}
