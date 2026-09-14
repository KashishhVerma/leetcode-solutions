class Solution {
    public String simplifyPath(String path) {
        Deque<String> queue=new ArrayDeque<>();
        String tokens[]=path.split("/");
        for(String token:tokens){
            if(token.equals("")||token.equals("."))continue;
            else if(token.equals("..")){
                if(!queue.isEmpty()) queue.removeLast();
            }
            else queue.addLast(token);
        }
        StringBuilder sb=new StringBuilder();
        for(String str:queue){
            sb.append("/").append(str);
        }
        return sb.length()==0?"/":sb.toString();
    }
}