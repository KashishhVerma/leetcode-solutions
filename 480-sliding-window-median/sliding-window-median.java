class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        double result[]=new double[n-k+1];
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        PriorityQueue<Integer>minHeap=new PriorityQueue<>((a,b)->Integer.compare(a,b));
        Map<Integer,Integer> map=new HashMap<>();
        int balance=0;
        for(int i=0;i<k;i++){
            maxHeap.add(nums[i]);
        }
        for(int i=0;i<k/2;i++){
            minHeap.add(maxHeap.poll());
        }
        result[0]=get(maxHeap,minHeap,k);
        for(int i=k;i<n;i++){
            int out=nums[i-k];
            int in=nums[i];
            balance=0;
            map.put(out,map.getOrDefault(out,0)+1);
            if(!maxHeap.isEmpty()&&out<=maxHeap.peek())balance--;
            else balance++;
            if(!maxHeap.isEmpty()&& in<=maxHeap.peek()){
                maxHeap.add(in);
                balance++;
            }
            else{
                minHeap.add(in);
                balance--;
            }
            if(balance<0){
                maxHeap.add(minHeap.poll());

            }
            else if(balance>0){
                minHeap.add(maxHeap.poll());
            }
            prune(maxHeap,map);
            prune(minHeap,map);
            result[i-k+1]=get(maxHeap,minHeap,k);


        }
        return result;

    }
    void prune(PriorityQueue<Integer> heap,Map<Integer,Integer>map){
        while(!heap.isEmpty()&& map.containsKey(heap.peek())){
            int num=heap.peek();
            int count=map.get(num);
            if(count==1) map.remove(num);
            else map.put(num,count-1);
            heap.poll();
        }
    }
    double get(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int k){
        if(k%2!=0){
            return (double)maxHeap.peek();

        }
        else return((double)maxHeap.peek()+(double)minHeap.peek())/2.0;
    }
}