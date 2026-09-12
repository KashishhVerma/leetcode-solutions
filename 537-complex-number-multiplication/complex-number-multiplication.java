class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int parse1[]=complex(num1);
        int parse2[]=complex(num2);
        int a=parse1[0];
        int b=parse1[1];
        int c=parse2[0];
        int d=parse2[1];
        int real=a*c-b*d;
        int com=b*c+a*d;
        return real+"+"+com+"i";
    }
    int[] complex(String num){
        int plusIdx=num.indexOf('+');
        int a=Integer.parseInt(num.substring(0,plusIdx));
        int b=Integer.parseInt(num.substring(plusIdx+1,num.length()-1));
        return new int[]{a,b};

    } 
}