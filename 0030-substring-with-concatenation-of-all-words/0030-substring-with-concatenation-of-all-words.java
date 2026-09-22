class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words.length == 0) return res;
        
        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        int n = s.length();
        
        if (n < totalLen) return res;
        
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();
            
            for (int j = i; j <= n - wordLen; j += wordLen) {
                String sub = s.substring(j, j + wordLen);
                
                if (counts.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    count++;
                    
                    while (seen.get(sub) > counts.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    
                    if (count == numWords) {
                        res.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        
        return res;
    }
}