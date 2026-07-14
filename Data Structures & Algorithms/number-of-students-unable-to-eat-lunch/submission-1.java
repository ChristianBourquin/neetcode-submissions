class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count = 0;
        int zeroCount = 0;
        int oneCount = 0;
        Queue<Integer> line = new LinkedList<>();
        for(int student : students){
            line.add(student);
            if(student == 0){
                zeroCount++;
            }else{
                oneCount++;
            }
        }
        while(count != sandwiches.length){
            if(line.element() == sandwiches[count]){
                    if(line.element() == 0){
                        zeroCount--;
                    }else{
                        oneCount--;
                    }
                    count ++;
                    line.remove();
            }else if(zeroCount == 0 && sandwiches[count] == 0 || oneCount == 0 && sandwiches[count] == 1){
                return zeroCount + oneCount;
            }else{
                line.add(line.element());
                line.remove();
            }
        }
        return 0;
    }
}