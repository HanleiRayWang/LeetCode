/*

Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

*/


//方法一，单纯的做DFS
//正确，但是超时
class Solution {
    
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    //O(n^2),n代表wordList的长度
    public void buildMap(List<String> wordList, String beginWord){
        for(String word : wordList){
            List<String> list = new LinkedList<String>();
            map.put(word, list);
            for(String str : wordList){
                if(diff(word, str)==1)
                    map.get(word).add(str);
            }
        }
        if(!map.containsKey(beginWord)){
            List<String> list = new LinkedList<String>();
            map.put(beginWord, list);
            for(String str : wordList){
                if(diff(beginWord, str)==1)
                    map.get(beginWord).add(str);
            }
        }
    }
    public int diff(String a, String b){
        int count = 0;
        for(int i=0;i<a.length();i++)
            if(a.charAt(i)!=b.charAt(i))
                count++;
        return count;
    }
    
    public void DFS(List<String> currList, HashSet<String> used, List<List<String>> result, String endWord){
        String curr = currList.get(currList.size()-1);
        if(curr.equals(endWord)){
            if(result.size()==0 || currList.size()==result.get(0).size()){
                result.add(new LinkedList<String>(currList));
            }else if(currList.size() < result.get(0).size()){
                result.clear();
                result.add(new LinkedList<String>(currList));
            }
        }else if(result.size()==0 || currList.size()<result.get(0).size()){
            for(String str : map.get(curr)){
                if(!used.contains(str)){
                    currList.add(str);
                    used.add(str);
                    DFS(currList, used, result, endWord);
                    currList.remove(currList.size()-1);
                    used.remove(str);
                }
            }
        }

    }

    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        buildMap(wordList, beginWord);
        List<List<String>> result = new LinkedList<List<String>>();
        
        List<String> currList = new LinkedList<String>();
        HashSet<String> used = new HashSet<String>();
        currList.add(beginWord);
        used.add(beginWord);
        
        DFS(currList, used, result, endWord);
        return result;
    }
}


//方法二
//先做一个BFS找到最小长度，相当于wordLadderI
//然后根据这个最小长度再去DFS，如果长度大于最小长度就停止DFS，以优化时间
