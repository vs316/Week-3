package DSA.StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k){
        if(nums==null||k<=0){
            return new int[0];
        }
        int n= nums.length;
        int[] result=new int[n-k+1];
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //remove indices that are outside the current window
            if(!deque.isEmpty() && deque.peekFirst()<i-k+1){
                deque.pollFirst();
            }
            //remove indices whose corresponding values are less than the current value
            while (!deque.isEmpty()&& nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            //add the current index to the deque
            deque.offerLast(i);
            //start recording results after the first k elements
            if(i>=k-1){
                result[i-k+1]=nums[deque.peekFirst()];//maximum of the current window
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] result=maxSlidingWindow(nums,k);
        System.out.println("Sliding Window Maximum: ");
        for(int max:result){
            System.out.println(max+" ");
        }
    }
}
