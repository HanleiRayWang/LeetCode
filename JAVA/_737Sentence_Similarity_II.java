/*

Given two sentences words1, words2 (each represented as an array of strings), 
and a list of similar word pairs pairs, determine if two sentences are similar.

For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, 
if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is transitive. For example, if "great" and "good" are similar,
and "fine" and "good" are similar, then "great" and "fine" are similar.

Similarity is also symmetric. 
For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. For example, 
the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, 
even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. 
So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

Note:

The length of words1 and words2 will not exceed 1000.
The length of pairs will not exceed 2000.
The length of each pairs[i] will be 2.
The length of each words[i] and pairs[i][j] will be in the range [1, 20].

*/


class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        
        if (words1.length != words2.length)
            return false;
        
        //使用HashMap代表graph，key存储节点，value为和key相连的各个节点
        Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
        for (String[] pair: pairs) {
            String key = pair[0];
            String value = pair[1];
            if(!graph.containsKey(key))
                graph.put(key, new HashSet<String>());
            if(!graph.containsKey(value))
                graph.put(value, new HashSet<String>());
            
            //每条边，正向反向各存储一次
            graph.get(key).add(value);
            graph.get(value).add(key);
        }

        for(int i=0;i<words1.length;i++){
            String w1 = words1[i], w2 = words2[i];
            
            //w1==w2,无需查找graph,直接跳过
            if(w1.equals(w2))
                continue;
            //如果出现不在graph中的节点，直接false
            if(!graph.containsKey(w1))
                return false;
            //查找图，dfs
            if(!dfs(w1, w2, graph, new HashSet<String>()))
                return false;
        }
        return true;
    }
    
    
    private boolean dfs(String start, String target, Map<String, Set<String>> graph, Set<String> visited){
        if(graph.get(start).contains(target))
            return true;
        visited.add(start);
        for(String next : graph.get(start))
            //如果visited中有next说明有环，dfs会陷入无限循环
            if(!visited.contains(next) && dfs(next, target, graph, visited))
                return true;
        return false;
    }
}
