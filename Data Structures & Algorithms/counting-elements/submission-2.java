class Solution {
    public int countElements(int[] arr) {
        if(arr.length == 1){
            return 0;
        }
        int count = 0;
        int end = arr.length - 1;
        HashSet<Integer> tracker = new HashSet<>(arr.length);
        for(int element : arr){
            tracker.add(element);
        }
        for(int i = 0; i <= end; i++){
            if(tracker.contains(arr[i] + 1)){
                count++;
            }
        }

        return count;
    }
}
