class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        Set<String> wordSet = getSetOfWords(wordList);
         if(!wordSet.contains(endWord))
            return new ArrayList<>();
        
        Queue<List<String>> queue = new LinkedList<>();
        
        queue.offer(Arrays.asList(beginWord));
        int level=1;
        int minLevel = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            Set<String> toBeRemoved = new HashSet<>();
            for(int i=0;i<size;i++){
                if(minLevel != Integer.MAX_VALUE && level>minLevel){
                    queue.clear();
                    break;
                }
                List<String> intermList = queue.poll();
                String lastVal = intermList.get(intermList.size()-1);
                for(int j=0;j<lastVal.length();j++){
                    
                for(char k='a';k<='z';k++){
                    char[] charArray = lastVal.toCharArray();
                    charArray[j]=k;
                    String newString = String.valueOf(charArray);
                    if(newString.equals(lastVal))
                        continue;
                    if(newString.equals(endWord)){
                        intermList.add(endWord);
                        minLevel = Math.min(level,minLevel);
                        if(level==minLevel)
                            result.add(intermList);
                    }
                    else if(wordSet.contains(newString)){
                        toBeRemoved.add(newString);
                        List<String> newList = new ArrayList<>(intermList);
                        
                        newList.add(newString);
                        queue.offer(newList);
                    }
                }  
                }
                
                
            }
            wordSet.removeAll(toBeRemoved);
            level++;
            
        }
        
        return result;
    
    
    }
    
    
    

    private Set<String> getSetOfWords(List<String> wordList){
         Set<String> wordSet = new HashSet<>();
        for(int i=0;i<wordList.size();i++)
            wordSet.add(wordList.get(i));
        return wordSet;
    }

}
