class SY2022bit151 {
    public static void main(String[] args) {
        int valCount1,valCount2;
	String[] arr;
	long[] timeDiffs1 = new long[10];
	long[] timeDiffs2 = new long[10]; 
	
	
        int i = 0;
        while (i < 10) {
            arr = generateArray();
            valCount1 = approch1(arr);
            long startTime = System.nanoTime();
            //System.out.println(startTime);
            valCount1 = approch1(arr);
            


            long endTime = System.nanoTime();
           // System.out.println(endTime);
            long timeDiff1 = endTime - startTime;
            //System.out.println(timeDiff);
            
            timeDiffs1[i] = timeDiff1;
            
            //approch2
            valCount2 = approch2(arr);
            long startTime2 = System.nanoTime();
            valCount2 = approch2(arr);
            long endTime2 = System.nanoTime();
            long timeDiff2 = endTime2 - startTime2;
            timeDiffs2[i] = timeDiff2;
            
            i++;
        }
        
        
	double average1 = calAverage(timeDiffs1);
	double average2 = calAverage(timeDiffs2);
	
	System.out.println(average1);
	System.out.println(average2);
    
    
    
        arr = generateArray();
        int validCount1 = 0 , validCount2 =0;
        for (String registration : arr) {
            if (isApproach1(registration)) 
            {
                validCount1++;
            }
            
            if(isApproach2(registration))
            {
            	validCount2++;
            }
        }
        System.out.println(validCount1);
        System.out.println(validCount2);
    }
    
    public static double calAverage(long[] array) {
        long sum = 0;
        for (long value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }

    public static int getValidRegistrationsCount(String[] arr) {
        int count = 0;

        for (String registration : arr) {
            if (isValidRegistration(registration) && isApproach1(registration)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isValidRegistration(String arr) {
        if (arr == null) {
            return false;
        }
        if (arr.length() != 10 || arr.charAt(0) != '2' || arr.charAt(1) != '0' ||
                (arr.charAt(2) != '0' && arr.charAt(2) != '1' && arr.charAt(2) != '2') ||
                !Character.isDigit(arr.charAt(3))) {
            return false;
        }

        String str1 = arr.substring(4, 7);
        String[] validStrings = {"bit", "bcs", "bch", "bme"}; // Valid strings
        boolean isValidString = false;
        for (String validStr : validStrings) {
            if (str1.equals(validStr)) {
                isValidString = true;
                break;
            }
        }
        if (!isValidString) {
            return false;
        }

        String s1 = arr.substring(7, 10);
        if (!Character.isDigit(s1.charAt(0)) || !Character.isDigit(s1.charAt(1)) || !Character.isDigit(s1.charAt(2))) {
            return false;
        }

        return true;
    }

    public static long generate1Num() {
        long num = System.nanoTime() % 10;
        return num;
    }

    public static String generate4DigitNum() {
        String num1 = "20";
        String num2 = num1 + (generate1Num() * 10);
        return num2;
    }

    public static int generateUpto34() {
        long currentTime = System.nanoTime();
        int randomNum = (int) (currentTime % 35);
        return randomNum;
    }

    /*public static char generateRandomChar() {
        int randomChar = generateUpto34();
        char randomLowerChar = (char) ('a' + randomChar % 26);
        return randomLowerChar;
    }*/

    public static String generateThreeChar() {
        String[] validStrings = {"bit", "bcs", "bch", "bme"}; // Valid strings
        int index = generateUpto34() % validStrings.length;
        return validStrings[index];
    }

    /*public static String generateThreedigitNum() {
        long threeDigit = (generate1Num() * 100) + (generate1Num() * 10) + (generate1Num() * 1);
        return String.valueOf(threeDigit);
    }*/
    public static String generateThreedigitNum() {
    long currentTime = System.nanoTime();
    int threeDigit = (int) (currentTime % 200); // Generate a pseudo-random number less than 50
    return String.format("%03d", threeDigit); // Ensure the number has three digits
}


    public static String[] generateArray() {
        String[] arr = new String[100];

        for (int i = 0; i < 100; i++) {
            String registrationNum = generate4DigitNum() + generateThreeChar() + generateThreedigitNum();
            arr[i] = registrationNum;
        }
        return arr;
    }

    public static boolean isApproach1(String registration) {
        if (registration != null) {
            String lastThreeDigitsStr = registration.substring(7); // Extract last three digits
	int lastThreeDigits = Integer.parseInt(lastThreeDigitsStr);

            return lastThreeDigits <= 50;
        }
        return false;
    }
    
    public static boolean isApproach2(String registration) 
    {
	    if (registration != null && registration.length() >= 10) {
		int lastThreeDigits = 0;
		for (int i = 7; i < registration.length(); i++) {
		    char c = registration.charAt(i);
		    if (Character.isDigit(c)) {
		        lastThreeDigits = lastThreeDigits * 10 + (c - '0');
		    } else {
		        // If any character is not a digit, return false
		        return false;
		    }
		}
		// Check if the last three digits are less than 50
		return lastThreeDigits < 50;
	    }
	    return false;
    }
    
	public static int approch1(String[] arr) {
	    int countValid = 0;
	    for (String registration : arr) {
		if (isApproach1(registration)) {
		    countValid++;
		}
	    }
	    return countValid;
	}

	public static int approch2(String[] arr) {
	    int countValid = 0;
	    for (String registration : arr) {
		if (isApproach2(registration)) {
		    countValid++;
		}
	    }
	    return countValid;
	}



}
