public class SolutionPow {
    public int pow(int x, int n, int d) {
        long rem = 1L;
        long temp =0L;
        int flag = 0;
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(x < 0){
            x = Math.abs(x);
            if(n%2 == 1){
                flag = 1;
            }
        }
        if(d == 1){
            return (int)temp;
        }
        else{
            temp = x%d;
        }
        while(n != 0){
            if(n%2 == 1){
                rem = (rem*temp)%d;
            }
            temp = temp*temp;
            temp = temp%d;
            n = n/2;
            if(rem > d){
                rem = rem%d;
            }
        }
    
        if(flag == 0)
            return (int)rem;
        return d-(int)rem;
        
    }
    public static void main(String[] args) {
        SolutionPow sp=new SolutionPow();
        System.out.println(sp.pow(-1,2,20));
    }
}
