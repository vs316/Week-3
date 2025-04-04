package DSA.SearchingAlgorithms.BinarySearch;

public class FindSmallestElementInRotatedSortedArray {
    private static int binarySearchToFindSmallestElement(int[] arr){
        int left=0, right=arr.length-1;
        while(left<right){
            int mid=left+(right-left)/2;

            if(arr[mid]>arr[right]){
                left=mid+1;
            } else {
                right=mid;
            }
        }
        return  arr[left];
    }
    public static void main(String[] args) {
        int[] arr={4,5,6,7,1,2,3};
        int smallestElement=binarySearchToFindSmallestElement(arr);
        System.out.println("Smallest element in given rotated sorted array: "+smallestElement);
    }
}
