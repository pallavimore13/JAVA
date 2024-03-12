 class calci{
 public static double Add( double num1,double num2){
   double sum=num1+num2;
   return sum;
   }
  public static double Sub(double num1,double num2){
   double result=num1-num2;
   return result;
  }
   public static double Mul(double num1,double num2){
   double result=num1*num2;
   return result;
   }
  public static double Div(double num1,double num2){
  if(num2 != 0){
  double result = num1/num2;
  return result;
  }
  else{
  return -1;
  }
  }
   public static double modulo(double num1,double num2){
   if(num2 != 0){
   double result = num1%num2;
   return result;
   }
   else{
    return -1;
    }
    }
   public static double squareroot(double num1){
   if(num1>=0){
    double result=Math.sqrt(num1);
    return result;
   }
   else{
     return -1;
     }
   }
   
   
