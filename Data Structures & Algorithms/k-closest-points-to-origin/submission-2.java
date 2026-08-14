class Solution {
    int[] indexList;
    public int[][] kClosest(int[][] points, int k) {
        double[] distances = new double[points.length];
        indexList = new int[points.length];
        for(int i = 0; i < points.length; i++){
            distances[i] = Math.hypot(0 - points[i][0], 0 - points[i][1]);
            indexList[i] = i;
        }
        
        quickSort(distances, 0, points.length - 1);
        int[][] slice = new int[k][];

        for (int i = 0; i < k; i++) {
            slice[i] = Arrays.copyOfRange(points[indexList[i]], 0, 2);
        }
        return slice;
    }

    private void quickSort(double[] inArray, int start, int end){
        if(end <= start){
            return;
        }

        int pivot = partition(inArray, start, end);
        quickSort(inArray, start, pivot - 1);
        quickSort(inArray, pivot + 1, end);
    }

    private int partition(double[] inArray, int start, int end){
        int i = start - 1;
        double pivot = inArray[end];
        double temp1;
        int temp2;
        for(int j = start; j < end; j++){
            if(inArray[j] <= pivot){
                i++;
                temp1 = inArray[i];
                inArray[i] = inArray[j];
                inArray[j] = temp1;
                temp2 = indexList[i];
                indexList[i] = indexList[j];
                indexList[j] = temp2;
            }
        }

        i++;
        temp1 = inArray[i];
        inArray[i] = inArray[end];
        inArray[end] = temp1;
        temp2 = indexList[i];
        indexList[i] = indexList[end];
        indexList[end] = temp2;

        return i;
    }
}
