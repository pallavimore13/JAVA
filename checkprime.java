class PrimeNumber {


	public static void main(String[] args){
	int i=0;
	while(i<5){
	
	long[] arr1 = generateArrray();
	//countPrime(arr1);
	long startTime = System.nanoTime();
	countPrime(arr1);
	long endTime = System.nanoTime();
	//countPrime(arr1);
	long timeDiff = endTime - startTime;
	System.out.println(timeDiff);
	i++;
	}
	int j=0;
	while(j<5){
	long[] arr2 = generateArrray();
	//countPrime(arr1);
	long startTime = System.nanoTime();
	countNonPrime(arr2);
	long endTime = System.nanoTime();
	//countPrime(arr1);
	long timeDiff = endTime - startTime;
	System.out.println(timeDiff);
	j++;
	}
}
	public static boolean validNotPrime(long num){
		if(num < 2){
			return false;
		}
		for(int i=2;i<=num/2;i++){
			if(num%i == 0){
				return true;
			}
		}
		return false;
	}
	public static boolean validPrime(long num){
		if(num < 2){
			return false;
		}
		for(int i=2;i<=num/2;i++){
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}
	public static long sevenDigitNum(){
		long randomNum = (generate1Num()*1000000)+(generate1Num()*100000)+(generate1Num()%10*10000)+(generate1Num()*1000)+(generate1Num()*100)+(generate1Num()*10)+(generate1Num()*1);
		
		return randomNum;
	}
	public static long generate1Num(){
		long num = System.nanoTime()%10;
		return num;
	}
	
	
	public static long[] generateArrray(){
		long arr[] = new long[1000000];
		for(int i=0;i<1000000;i++){
		arr[i] = sevenDigitNum();
		}
		return arr;
	}
	public static void countPrime(long[] array){
	
		int countPrime = 0;
		int countNonPrime = 0;
		for(int i=0;i<array.length;i++){
			if(validPrime(array[i])){
				countPrime++;
			}
			else{
				countNonPrime++;
			}
		}
		System.out.println(countPrime);
		System.out.println(countNonPrime);
	
	}
	public static void countNonPrime(long[] array){
	
		int countPrime = 0;
		int countNonPrime = 0;
		for(int i=0;i<array.length;i++){
			if(validNotPrime(array[i])){
				countPrime++;
			}
			else{
				countNonPrime++;
			}
		}
		System.out.println(countPrime);
		System.out.println(countNonPrime);
	
	}


}

