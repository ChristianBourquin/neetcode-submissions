class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int student : students) {
            if (student == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (zeroCount == 0) {
                    return zeroCount + oneCount;
                }
                zeroCount--;
            } else {
                if (oneCount == 0) {
                    return zeroCount + oneCount;
                }
                oneCount--;
            }
        }

        return 0;
    }
}