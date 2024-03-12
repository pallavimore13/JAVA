public class SY2022bit151 {
    public static void main(String[] args) {
        String arr[] = {
            "2022bit057",
            "2022bcs023",
            "2022bme012",
            "2022bch023",
            "2022bpr152",
            "2022bin017"
        };
        int count = getValidRegistrationsCount(arr);
        System.out.println(count);
        
        int count1 = isValidRegistrationap1(arr);
        System.out.println(count1);
    }

    public static int getValidRegistrationsCount(String[] str) {
        int count = 0;

        for (String registration : str) {
            if (isValidRegistration(registration)){
                count++;
            }
        }
        return count;
    }

    public static boolean isValidRegistration(String arr){
        // Your validation logic here
        return true;
    }

    public static int getSequenceNoLessthan50(int[] sequenceNo) {
        int n = 0;
        for (int s1 : sequenceNo) {
            if (s1 <= 50) {
                n++;
            }
        }

        return n;
    }

    // Approach 2
    public static int isValidRegistrationap1(String[] arr) {
        int count1 = 0;

        for (int i = 0; i < arr.length; i++) {
            int validNo = Integer.parseInt(arr[i].substring(7, 10));
            if (validNo <= 50) {
                count1++;
            }
        }
        System.out.println("Count within isValidRegistrationap1: " + count1);
        return count1;
    }
}
