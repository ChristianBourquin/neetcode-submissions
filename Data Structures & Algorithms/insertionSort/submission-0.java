// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> states = new ArrayList<>();
        for(int i = 0; i < pairs.size(); i++){
            int j = i - 1;
            Pair current = pairs.get(i);
            while(j >= 0 && pairs.get(j).key > current.key){
                pairs.set(j + 1, pairs.get(j));
                j--;
            }
            pairs.set(j + 1, current);
            states.add(List.copyOf(pairs));
        }
        return states;
    }
}
