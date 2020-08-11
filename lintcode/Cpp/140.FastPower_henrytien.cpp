




class Solution {
public:
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    int fastPower(int a, int b, int n) {
       if(n == 0){
           return 1%b;
       }
       if(n == 1)
       {
           return a%b;
       }
       long long half = fastPower(a,b,n/2);
        half =  (half*half) % b;
        
        if(n % 2 == 1)
            half = (half * a) % b;

          return half;
        
         
    }
};



/*

class Solution:
    """
    @param a: A 32bit integer
    @param b: A 32bit integer
    @param n: A 32bit integer
    @return: An integer
    """
    def fastPower(self, a, b, n):
        if n == 0:
            return 1 % b
        if n == 1:
            return a % b
        
        # a^n = (a^n/2)^2
        power = self.fastPower(a,b,n//2)
        power = (power * power) % b
        
        if n % 2 == 1:
            power = (power * a) % b;
            
        return power;


*/