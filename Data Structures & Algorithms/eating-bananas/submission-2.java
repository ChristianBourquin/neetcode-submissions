class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = piles[0]; 
        int bestGuess = end;
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > end) {
                end = piles[i];
            }
        }
        while(start <= end){
            int middle = start + (end - start) / 2;
            int hours = findHours(piles, middle);
            if(hours > h){
                start = middle + 1;
            }else{
                end = middle - 1;
                bestGuess = middle;
            }
        }
        return bestGuess;
    }

    private int findHours(int[] piles,int rate){
        int h = 0;
        for(int i = 0; i < piles.length; i++){
            h += Math.ceil(piles[i]/ (double)rate);
        }
        return h;
    }
}