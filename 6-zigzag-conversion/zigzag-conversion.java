class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1|| s.length()<numRows) return s;
        ArrayList<StringBuilder> list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new StringBuilder());
        }
        int curr=0;
        boolean down=false;
        for(char ch:s.toCharArray()){
            list.get(curr).append(ch);
            if(curr==0||curr==numRows-1){
                down=!down;
            }
            curr+=down?1:-1;
        }
        StringBuilder sb=new StringBuilder();
        for(StringBuilder l:list){
            sb.append(l);
        }
        return sb.toString();
    }
}