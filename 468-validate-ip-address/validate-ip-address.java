class Solution {
    public String validIPAddress(String queryIP) {
        if(ip4(queryIP)) return "IPv4";
        else if(ip6(queryIP)) return "IPv6";
        else return "Neither";
    }
    boolean ip4(String ip){
        String parts[]=ip.split("\\.",-1);
        if(parts.length!=4)return false;
        for(String part:parts){
            if(part.length()==0||part.length()>3) return false;
            if(part.length()>1 && part.charAt(0)=='0') return false;
            int val=0;
            for(char ch:part.toCharArray()){
                if(!Character.isDigit(ch)) return false;
                val=val*10+(ch-'0');
            }
            if(val<0 ||val>255 ) return false;
        }
        return true;
    }
    boolean  ip6(String ip){
        String parts[]=ip.split("\\:",-1);
        if(parts.length!=8) return false;
        for(String part:parts){
            if(part.length()==0|| part.length()>4) return false;
            for(char ch:part.toCharArray()){
                boolean digit=Character.isDigit(ch);
                boolean low=ch>='a' && ch<='f';
                boolean upp=ch>='A' && ch<='F';
                if(!digit && !low &&!upp) return false;
            }
        }
        return true;
    }
}