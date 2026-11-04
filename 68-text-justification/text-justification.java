class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String>result=new ArrayList<>();
        int n=words.length;
        int i=0;
        while(i<n){
            int start=i;
            int currLen=words[i].length();
            i++;
            while(i<n&& currLen+1+words[i].length()<=maxWidth){
                currLen+=1+words[i].length();
                i++;
            }
            int numWord=i-start;
            int numSlot=numWord-1;
            StringBuilder sb=new StringBuilder();
            if(i==n ||numSlot==0){
                for(int j=start;j<i;j++){
                    sb.append(words[j]);
                    if(j<i-1) sb.append(" ");
                }
                while(sb.length()<maxWidth)sb.append(" ");
            }
            else {
                int totalChar=0;
                for(int j=start;j<i;j++){
                    totalChar+=words[j].length();
                }
                int totalSpace=maxWidth-totalChar;
                int spacePerSlot=totalSpace/numSlot;
                int extraSpace=totalSpace%numSlot;
                for(int j=start;j<i;j++){
                    sb.append(words[j]);
                    if(j<i-1){
                        int space=spacePerSlot+(extraSpace>0?1:0);
                        extraSpace--;
                        for(int s=0;s<space;s++)sb.append(" ");
                    }
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}