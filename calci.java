import java.util.Scanner;

class calci {

    public static double Add(double num1, double num2) {
        return num1 + num2;
    }

    public static double Sub(double num1, double num2) {
        return num1 - num2;
    }

    public static double Mul(double num1, double num2) {
        return num1 * num2;
    }

    public static double Div(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            return -1;
        }
    }

    public static double Modulo(double num1, double num2) {
        if (num2 != 0) {
            return num1 % num2;
        } else {
            return -1; 
        }
    }

    public static double SquareRoot(double num) {
        if (num >= 0) {
            return Math.sqrt(num);
        } else{
            return -1; 
        }
    }

    public static double Cube(double num) {
        return num * num * num;
    }

    public static double Logarithm(double num, double base) {
        if (num > 0 && base > 0 && base != 1) {
            return Math.log(num) / Math.log(base);
        } else {
            return -1;
        }
    }

    public static double Power(double num, double exponent) {
        return Math.pow(num, exponent);
    }

    public static int Factorial(int num) {
        if (num == 0)
            return 1;
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static double Sin(double num) {
        return Math.sin(num);
    }

    public static double Cos(double num) {
        return Math.cos(num);
    }

    public static double Tan(double num) {
        return Math.tan(num);
    }

    public static double Exponential(double num) {
        return Math.exp(num);
    }

    public static double Negate(double num) {
        return -num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            System.out.print("");
            double num1 = sc.nextDouble();

           System.out.print("");
            choice = sc.next().charAt(0);

            double result = 0;

            switch (choice) {
                case '+':
                    double num2 = sc.nextDouble();
                    result = Add(num1, num2);
                    break;
                case '-':
                    num2 = sc.nextDouble();
                    result = Sub(num1, num2);
                    break;
                case '*':
                    num2 = sc.nextDouble();
                    result = Mul(num1, num2);
                    break;
                case '/':
                    num2 = sc.nextDouble();
                    result = Div(num1, num2);
                    break;
                case '%':
                    num2 = sc.nextDouble();
                    result = Modulo(num1, num2);
                    break;
                case 's':
                    result = SquareRoot(num1);
                    break;
                case 'c':
                    result = Cube(num1);
                    break;
                case 'l':
                    double base = sc.nextDouble();
                    result = Logarithm(num1, base);
                    break;
                case 'p':
                    double exponent = sc.nextDouble();
                    result = Power(num1, exponent);
                    break;
                case 'f':
                    result = Factorial((int) num1);
                    break;
                case 'S':
                    result = Sin(num1);
                    break;
                case 'C':
                    result = Cos(num1);
                    break;
                case 'T':
                    result = Tan(num1);
                    break;
                case 'e':
                    result = Exponential(num1);
                    break;
                case 'n':
                    result = Negate(num1);
                    break;
                default:
                    System.out.println("Invalid operation!");
            }

            System.out.println("Result: " + result);
            System.out.print("Do you want to continue? (Y/N): ");
            choice = sc.next().charAt(0);
        } while (choice == 'Y' || choice == 'y');

        sc.close();
    }
}

  	
  	
  	
   
   
  	
  	
  	
   
   









