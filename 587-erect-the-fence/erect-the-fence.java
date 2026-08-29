class Solution {
    public int[][] outerTrees(int[][] trees) {
        int n=trees.length;
        if(n<=3) return trees;
        Arrays.sort(trees,(a,b)->a[0]!=b[0]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        Stack<int[]>stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(stack.size()>=2 && cross(stack.get(stack.size()-2),stack.peek(),trees[i])<0)stack.pop();
            stack.push(trees[i]);
        }
        for(int i=n-1;i>=0;i--){
            while(stack.size()>=2&& cross(stack.get(stack.size()-2),stack.peek(),trees[i])<0) stack.pop();
            stack.push(trees[i]);
        }
        Set<int[]> set=new HashSet<>(stack);
        int [][] result=new int[set.size()][2];
        int idx=0;
        for(int point[]:set){
            result[idx++]=point;
        }
        return result;

    }
    private int cross(int p1[],int p2[],int p3[]){
        return (p2[1]-p1[1])*(p3[0]-p2[0])-(p3[1]-p2[1])*(p2[0]-p1[0]);
    }
}