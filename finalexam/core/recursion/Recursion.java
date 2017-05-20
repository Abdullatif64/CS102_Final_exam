package exams.spring2017.solution.finalexam.core.recursion;

public class Recursion {
    
    /** TODO: complete the following recursion function 
     *         x: a real number (in radians)
     *         n: number of iterations
     *         result: you must return the output of the approximated function value for tanh^(-1)(x) using Taylor expansion
     */
    
    public static double itanh(double x, int n){
        if (n==0)return -1/x;
         if (n==1)return x;
         else
         return itanh(x,n-1)+(1/(2*n-1))*Math.pow(x,((2*n)-1));
    }
    
    
    
        
    public static void main(String []args){
        
        double [] xd = {0.1, 0.5, 0.6};
        
        for (double x : xd){

            System.out.printf("itanh(%.2f)=%.10f\n", x, itanh(x, 100));           
            System.out.println("\n");
            
        }
    } 
}

