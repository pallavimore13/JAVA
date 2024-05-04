import java.util.Scanner;

class calci {

    public static double Add(double num1, double num2) 
    {
        return num1 + num2;
    }

    public static double Sub(double num1, double num2) 
    {
        return num1 - num2;
    }

    public static double Mul(double num1, double num2) 
    {
        return num1 * num2;
    }

    public static double Div(double num1, double num2) 
    {
        if (num2 != 0) 
        {
            return num1 / num2;
        } else 
        {
            return -1;
        }
    }

    public static double Modulo(double num1, double num2) 
    {
        if (num2 != 0) 
        {
            return num1 % num2;
        } else 
        {
            return -1; 
        }
    }
    public static double Square(double num)
    {
    	if(num != 0){
    		return num*num;
    	}
    	else
    	{
    		return -1;
    	}
    }

    public static double SquareRoot(double num) 
    {
        if (num >= 0) 
        {
            return Math.sqrt(num);
        } else
        {
            return -1; 
        }
    }

    public static double Cube(double num) 
    {
        return num * num * num;
    }

    public static double Logarithm(double num, double base) 
    {
        if (num > 0 && base > 0 && base != 1) 
        {
            return Math.log(num) / Math.log(base);
        } else 
        {
            return -1;
        }
    }
    public static double NaturalLog(double num) 
    {
	    if (num <= 0) {
		return Double.NaN; // Error: Natural logarithm is undefined for non-positive numbers
	    }

	    // Initialize variables
	    double x = (num - 1) / (num + 1);
	    double term = x;
	    double lnX = x;

	    // Compute natural logarithm using the series expansion
	    for (int i = 3; i < 1000; i += 2) { // Adjust the number of iterations for accuracy
		term *= (x * x);
		lnX += term / i;
	    }

	    // Multiply by 2 to get the natural logarithm
	    lnX *= 2;

	    return lnX;
}

    public static double Power(double num, double exponent) 
    {
        return Math.pow(num, exponent);
    }

    public static int Factorial(int num) 
    {
        if (num == 0)
            return 1;
        int fact = 1;
        for (int i = 1; i <= num; i++) 
        {
            fact *= i;
        }
        return fact;
    }

    public static double Sin(double num) 
    {
        return Math.sin(num);
    }

    public static double Cos(double num)
    {
        return Math.cos(num);
    }

    public static double Tan(double num) 
    {
        return Math.tan(num);
    }

    public static double Exponential(double num) 
    {
        return Math.exp(num);
    }

    public static double Negate(double num) 
    {
        return -num;
    }
    public static double Reciprocal(double num) 
    {
        if (num != 0) {
            return 1 / num;
        } else {
            return -1;
        }
    }
     public static double Inverse(double num) 
     {
		return 1 / num;
     }
     public static int nCr(int n, int r) 
     {
	    int result = 1;

	    // Since nCr = n! / (r! * (n-r)!), we calculate numerator and denominator separately
		for (int i = 1; i <= r; i++) {
		result *= (n - i + 1);
		result /= i;
    }
	    return result;
    }

    public static int nPr(int n, int r) 
    {
		int result = 1;
		for (int i = n; i > n - r; i--) 
		{
		    result *= i;
		}
		return result;
    }
     public static String DecimalToHexadecimal(int decimalNumber) {
		if (decimalNumber == 0) {
		    return "0";
		}

		String hexadecimal = "";

		while (decimalNumber > 0) {
		    int remainder = decimalNumber % 16;
		    char hexDigit = toHexDigit(remainder);
		    hexadecimal = hexDigit + hexadecimal;
		    decimalNumber /= 16;
		}

		return hexadecimal;
    }

	  private static char toHexDigit(int value) 
	  {
		if (value >= 0 && value <= 9) 
		{
		    return (char) ('0' + value);
		} else 
		{
		    return (char) ('A' + value - 10);
		}
	   }
	public static String DecimalToBinary(int decimalNumber) {
		    if (decimalNumber == 0) {
			return "0";
		    } 

		    String binary = "";
		    if (decimalNumber < 0) {
			binary = "-" + DecimalToBinary(-decimalNumber);
		    } else {
			while (decimalNumber > 0) {
			    int remainder = decimalNumber % 2;
			    binary = remainder + binary;
			    decimalNumber /= 2;
			}
		    }
		    
		    return binary;
	}

	public static String DecimalToOctal(int decimalNumber) {
		    if (decimalNumber == 0) {
			return "0";
		    } 

		    String octal = "";
		    if (decimalNumber < 0) {
			octal = "-" + DecimalToOctal(-decimalNumber);
		    } else {
			while (decimalNumber > 0) {
			    int remainder = decimalNumber % 8;
			    octal = remainder + octal;
			    decimalNumber /= 8;
			}
		    }
		    
		    return octal;
	}
	/*public static double[][] matrixAdd(double[][] matrix1, double[][] matrix2)
	{
		if( matrix1.length != matrix2.length || matrix1[0].length != matrix[0].length )
		{
			return "The size of two matrices is not same";
		}
		
		double[][] result = new double[matrix1.length][matrix[0].length]
		
		for(int i = 0; i < matrix1.length ; i++)
		{
			for(int j = 0; j < matrix2.length; j++)
			{
				result[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		return result;
	
	}
	public static double arcSin(double num)
	{
		if(num >= -1 && num <= 1)
		{
			return Math.asin(num);
		}
		else{
			System.out.println("Error:Invalid Input");
			return Double.MIN_VALUE;
		}
	
	}
	public static double arcCos(double num)
	{
		if(num >= -1 && num <= 1)
		{
			return Math.acos(num);
		}
		else{
			System.out.println("Error:Invalid Input");
			return Double.MIN_VALUE;
		}
	}
	public static double arcTan(double num)
	{
		if(num >= -1 && num <= 1)
		{
			return Math.atan(num);
		}
		else
		{
			System.out.println("Error:Invalid Input");
			return Double.MIN_VALUE;
		}
	}*/
	public static double DegreeToRadian(double degree) 
	{
        return Math.toRadians(degree);
    	}
    	public static double[] Quadratic(double a, double b, double c) 
    	{
        double[] roots = new double[2];
        
        double discriminant = b * b - 4 * a * c;
        
        if (discriminant > 0) {
            roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
            roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
        } else if (discriminant == 0) {
            roots[0] = roots[1] = -b / (2 * a);
        } else {
            roots[0] = Double.NaN;
            roots[1] = Double.NaN;
        }
        
        return roots;
        }
        
        public static double Sec(double num) 
        {
	    return 1 / Math.cos(num);
	}

	public static double Csc(double num) 
	{
	    return 1 / Math.sin(num);
	}

	public static double Cot(double num) 
	{
	    return 1 / Math.tan(num);
	}

	
	
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String choice;
	System.out.println(" + , -,*,/,mod,square,sq,cube,log,ln,epow,fact,sin,cos,tan,expo,negate,reciprocal,inverse,combination,permuation,Hex,Bin,Oct,degreetorad,quadratic,Sec,Csc,Cot");
	
        do 
        {
        
           
            
            System.out.print("");
            choice = sc.next();
             System.out.print("");
            double num1 = sc.nextDouble();

           
            
            

            double result = 0;

           try
           {
            switch (choice) 
            {
            //1
                case "+":
                    double num2 = sc.nextDouble();
                    result = Add(num1, num2);
                    break;
                case "-":			//2
                    num2 = sc.nextDouble();
                    result = Sub(num1, num2);
                    break;
                case "*":			//3
                    num2 = sc.nextDouble();
                    result = Mul(num1, num2);
                    break;
                case "/":			//4
                    num2 = sc.nextDouble();
                    result = Div(num1, num2);
                    break;
                case "mod":			//5
                    num2 = sc.nextDouble();
                    result = Modulo(num1, num2);
                    break;
                case "square":			//6
                    result = Square(num1);
                    break;
                case "sq":			//7
                    result = SquareRoot(num1);
                    break;
                case "cube":	                 //8
                    result = Cube(num1);
                    break;
                case "log":			//9
                    double base = sc.nextDouble();
                    result = Logarithm(num1, base);
                    break;
                case "ln":			//10
		    result = NaturalLog(num1);
		    break;
                case "epow":			//11
                    double exponent = sc.nextDouble();
                    result = Power(num1, exponent);
                    break;
                case "fact":			//12
                    result = Factorial((int) num1);
                    break;
                case "sin":			//13
                    result = Sin(num1);
                    break;
                case "cos":			//14
                    result = Cos(num1);
                    break;
                case "tan":			//15
                    result = Tan(num1);
                    break;
                case "expo":			//16
                    result = Exponential(num1);
                    break;
                case "negate":			//17
                    result = Negate(num1);
                    break;
                case "reciprocal":			//18
                    result = Reciprocal(num1);
                    break;
                case "inverse":			//19
                    result = Inverse(num1);
                    break;
                 case "combination":			//20
                    int r = sc.nextInt();
                    result = nCr((int) num1, r);
                    break;
                case "permutation":			//21
		    System.out.print("Enter the value of n: ");
		    int n = sc.nextInt();
		    System.out.print("Enter the value of r: ");
		    int d = sc.nextInt();
		    result = nPr(n, d);
		    break;
		 case "Hex":			//22
                    int decimalNum = (int) num1;
                    System.out.println("Hexadecimal: " + DecimalToHexadecimal(decimalNum));
                    break;
                 case "Bin":			//23
                    int decimalNum1 = (int) num1;
                    System.out.println("Binary:" +DecimalToBinary(decimalNum1));
                    break;
                 case "Oct":			//24
                    int decimalNum2 = (int) num1;
                    System.out.println("Octal:" +DecimalToOctal(decimalNum2));
                    break;
                case "degreetorad":              //25
               	    result = DegreeToRadian(num1);
                    break;
                case "quadratic": // New case for quadratic equation solver 26
                    System.out.print("Enter the coefficients (a, b, c) of the quadratic equation (ax^2 + bx + c = 0): ");
                    double a = sc.nextDouble();
                    double b = sc.nextDouble();
                    double c = sc.nextDouble();
                    double[] quadraticRoots = Quadratic(a, b, c);
                    System.out.println("Root 1: " + quadraticRoots[0]);
                    System.out.println("Root 2: " + quadraticRoots[1]);
                    break;
                case "Sec":                 //27
                   result = Sec(num1);
                   break;
                case "Csc":                 //28
                   result = Csc(num1);
                   break;
                   
                case "Cot":                 //29
                   result = Cot(num1);
                   break;
                
                default:
                    System.out.println("Invalid operation!");
            }
            }catch(Exception e){
            	System.out.println(" ");
                result = Double.NaN; // Indicate invalid operation
            }
            

            System.out.println("Result: " + result);
            System.out.print("Do you want to continue? (Y/N): ");
            choice = sc.next();
        } while(choice.equalsIgnoreCase("Y"));

        sc.close();
    }
}

  	
  	
  	
   
   
  	
  	
  	
   
   
//reciprocal
//permutation and combination
//nth root
//ncr
//npr
//inverse
//logbase
//epowerx

//degreetoradian
//quadratic equation
  	
  	
   
   
  	
  	
  	
   
   









