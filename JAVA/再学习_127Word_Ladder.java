/*

Given two words (beginWord and endWord), and a dictionary's word list, 
find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.


*/

class Solution {
    
    //map中：key表示起始String；value表示wordList中，从key一步可变化成的各种String
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    public void buildMap(List<String> wordList, String beginWord){
        
        //针对wordList中的所有word分别放入map
        for(String str : wordList){
            List<String> nList = new LinkedList<String>();
            map.put(str, nList);
            for(String nxt : wordList)
                if(diff(str, nxt)==1)
                    map.get(str).add(nxt);
        }
        //如果beginWord不在wordList中，单独将beginWord加入map
        if(!map.containsKey(beginWord)){
            List<String> nList = new LinkedList<String>();
            map.put(beginWord,nList);
            for(String nxt : wordList)
                if(diff(beginWord, nxt)==1)
                    map.get(beginWord).add(nxt);
        }
    }
    
    //计算两个String之间的距离，已知两个String相同长度
    public int diff(String a , String b){
        int count =0;
        for(int i=0; i<a.length(); i++)
            if(a.charAt(i)!=b.charAt(i))
                count++;
        return count;
    }
    
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord))
            return 0;
        buildMap(wordList, beginWord);
        //hashset用于存放已经访问过的String，防止 dog-> cog -> dog 这种反复计算
        HashSet<String> visited = new HashSet<String>();
        
        //既然是BFS，一般就要一个queue，对应每一次有一个size=queue.size()好遍历每一层
        Queue<String> queue = new LinkedList<String>();
        
        //先把beginWord放入queue和hashset
        queue.offer(beginWord);
        visited.add(beginWord);
        int steps=1;//beginWord也算是一步长度
        
        //进行BFS
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size ;i++){
                String curr = queue.poll();
                if(curr.equals(endWord))
                    return steps;
                //  if(map.containsKey(curr))
                List<String> nxtStrList = map.get(curr);
                for(String nxtStr : nxtStrList){
                    if(!visited.contains(nxtStr)){
                        queue.offer(nxtStr);
                        visited.add(nxtStr);
                    }
                }
                // }
            }
            steps++;
        }
        return 0;
    }
    
}
