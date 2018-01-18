/*

Equations are given in the format A / B = k, where A and B are variables represented as strings, 
and k is a real number (floating point number). 
Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, 
vector<pair<string, string>> queries , where equations.size() == values.size(), 
and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. 
You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

*/


class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        
        //创建Map，key为String，value是和key有直接关系的所有String及其兑换关系
        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
        for(int i=0;i<equations.length;i++){
            
            //正着放一次
            if(!map.containsKey(equations[i][0]))
                map.put(equations[i][0], new HashMap<String, Double>());
            map.get(equations[i][0]).put(equations[i][1],values[i]);
            
            //反着放一次
            if(!map.containsKey(equations[i][1]))
                map.put(equations[i][1], new HashMap<String, Double>());
            map.get(equations[i][1]).put(equations[i][0],1/values[i]);
        }
        
        //search dividend and divisor using DFS
        double[] result = new double[queries.length];
        for(int i=0;i<queries.length;i++){
            
            //这里的doube[] itr_result其实就是一个数字，为了能够保证数值传递才设置成数组的，因为java中函数无法直接传递数值
            double[] itr_result = new double[]{1.0};
            
            //calculate中的Set用于记录已经访问过的所有String
            if(calculate(map,queries[i][0],queries[i][1],itr_result, new HashSet<>(),1.0))
                result[i]=itr_result[0];
            else
                result[i]=-1.0;
        }
        return result;
    }
    
    //DFS
    private boolean calculate(Map<String, Map<String, Double>> map, String num1, String num2, 
                              double[] itr_result, Set<String> visited, double temp){
        
        //如果map中不包含num1或者num2，说明num1不可达num2
        //如果visited中包含num1说明有环存在，return false，直接使用itr_result中的原始值1即可
        if(!map.containsKey(num1) || !map.containsKey(num2) || visited.contains(num1))
            return false;
        
        //如果num1和num2相同，说明num1可达num2，并且当前一直计算的itr_result就是路径值
        if(num1.equals(num2)){
            itr_result[0]=temp;
            return true;
        }
        
        //visited中加入num1，以方便再一次的dfs
        visited.add(num1);
        for(Map.Entry<String, Double> entry : map.get(num1).entrySet())
            if(calculate(map, entry.getKey(), num2, itr_result, visited, temp*entry.getValue()))
                return true;
        //不要忘了吧num1从已访问的set中删除
        visited.remove(num1);
        return false;
    }
}
