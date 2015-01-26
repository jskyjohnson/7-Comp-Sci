public class QuadraticFunction{
    int a, b, c;
    public QuadraticFunction(int aa, int bb, int cc){
        a = aa;
        b = bb;
        c = cc;
        
    }
    
    public double valueAt(int x){
        return ((a*a)*x)+(b*x)+c;
        
    }
    public String toString(){
           return (a+"x^2 "+b+"x "+c);
    }
    public boolean equals(QuadraticFunction k){
        if(a == k.a && b == k.b && c == k.c){
            return true;
        }
        return false;
    }
}