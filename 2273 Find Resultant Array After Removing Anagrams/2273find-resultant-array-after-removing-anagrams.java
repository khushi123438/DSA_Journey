class Solution {
    public List<String> removeAnagrams(String[] words) {
         List<String> result = new ArrayList<>();
        String prevSorted = "";
        
        for (String word : words) {
            
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sortedWord = new String(arr);

           
            if (!sortedWord.equals(prevSorted)) {
                result.add(word);
                prevSorted = sortedWord;
            }
            
        }
        return result;
    }
}