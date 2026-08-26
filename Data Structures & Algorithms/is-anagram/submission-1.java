class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sList = s.toCharArray();
        char[] tList = t.toCharArray();
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < sList.length; i++){
            if(sMap.containsKey(sList[i])){
                sMap.replace(sList[i], sMap.get(sList[i]) + 1);
            }else{
                sMap.put(sList[i], 1);
            }

            if(tMap.containsKey(tList[i])){
                tMap.replace(tList[i], tMap.get(tList[i]) + 1);
            }else{
                tMap.put(tList[i], 1);
            }
        }
        
        for(int j = 0; j < sList.length; j++){
            if(!sMap.get(sList[j]).equals(tMap.get(sList[j]))){
                return false;
            }
        }
        return true;
    }
}
