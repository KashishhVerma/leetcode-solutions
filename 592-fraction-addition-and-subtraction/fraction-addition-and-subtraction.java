class Solution {
    public String fractionAddition(String expression) {
        int i=0;
        int num=0;
        int deno=1;
        int n=expression.length();
        while(i<n){
            int sign=1;
            if(expression.charAt(i)=='-'||expression.charAt(i)=='+'){
                if(expression.charAt(i)=='-'){
                    sign=-1;
                }
                    i++;
            }
            int currNum=0;
            while(i<n&& Character.isDigit(expression.charAt(i))){
                currNum=currNum*10+(expression.charAt(i)-'0');
                i++;
            }
            i++;
            currNum*=sign;
            int currDeno=0;
            while(i<n&& Character.isDigit(expression.charAt(i))){
                currDeno=currDeno*10+(expression.charAt(i)-'0');
                i++;
            }
            num=num*currDeno+currNum*deno;
            deno=deno*currDeno;
            int gcd=getGcd(Math.abs(num),deno);
            num/=gcd;
            deno/=gcd;
        }
        return num+"/"+deno;
    }
    int getGcd(int a,int b){
        if(b==0) return a;
        return getGcd(b,a%b);
    }
}