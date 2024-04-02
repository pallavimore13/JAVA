class SY2022bit151 {
    public static void main(String[] args) {
        String[] arr;

        int i = 0;
        while (i < 10) {
            arr = generateArray();
            long startTime = System.nanoTime();
            System.out.println(startTime);
            arr = generateArray();

            for (String registration : arr) {
                System.out.println(registration);
            }

            long endTime = System.nanoTime();
            System.out.println(endTime);
            long timeDiff = endTime - startTime;
            System.out.println(timeDiff);
            i++;
        }

        arr = generateArray();
        int validCount = 0;
        for (String registration : arr) {
            if (isRegistrationLessthan50(registration)) {
                validCount++;
            }
        }
        System.out.println(validCount);
    }

    public static int getValidRegistrationsCount(String[] arr) {
        int count = 0;

        for (String registration : arr) {
            if (isValidRegistration(registration) && isRegistrationLessthan50(registration)) {
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

    public static String generateThreedigitNum() {
        long threeDigit = (generate1Num() * 100) + (generate1Num() * 10) + (generate1Num() * 1);
        return String.valueOf(threeDigit);
    }

    public static String[] generateArray() {
        String[] arr = new String[100];

        for (int i = 0; i < 100; i++) {
            String registrationNum = generate4DigitNum() + generateThreeChar() + generateThreedigitNum();
            arr[i] = registrationNum;
        }
        return arr;
    }

    public static boolean isRegistrationLessthan50(String registration) {
        if (registration != null) {
            String lastThreeDigitsStr = registration.substring(7); // Extract last three digits
	int lastThreeDigits = Integer.parseInt(lastThreeDigitsStr);

            return lastThreeDigits <= 50;
        }
        return false;
    }
}
