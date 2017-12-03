/*

Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Do it in O(n) time

这道题给我们一个一维数组nums，让我们求和为k最大子数组，默认子数组必须连续，
题目中提醒我们必须要在O(n)的时间复杂度完成
我们需要用哈希表和累积和来做，那么建立累积和的好处显而易见
如果当前累积和正好等于k，那么从开头到此位置的子数组就是一个符合要求的解，但不一定是最长的子数组
而使用哈希表来建立累积和和其坐标之间的映射，我们就从题目中给的例子进行分析：

nums: [1, -1, 5, -2, 3], k = 3
sums: [1, 0, 5, 3, 6]
我们可以看到累积和的第四个数字为3，和k相同，则说明前四个数字就是符合题意的一个子数组，再来看第二个例子：

nums: [-2, -1, 2, 1], k = 1
sums: [-2, -3, -1, 0]
我们发现累积和中没有数字等于k，但是我们知道这个例子的答案是[-1, 2]，
那么我们看累积和数组的第一和第三个数字，我们是否能看出一些规律呢，没错，第三个数字-1减去k，得到第一个数字，
这就是规律，这也是累积和求区间和的方法，但是由于累计和数组中可能会有重复数字，而哈希表的关键字不能相同，比如下面这个例子：

nums: [1, 0, -1], k = -1
sums: [1, 1, 0]
我们发现累积和数组的第一个和第二个数字都为1，那么如何建立映射呢，
我想的是用一个一维数组将其都存起来，然后比较的话就比较数组中的第一个数字，
当我们建立完哈希表后，开始遍历这个哈希表，当累积和跟k相同时，我们更新res，
不相同的话我们检测当前值减去k得到的值在哈希表中存不存在，如果存在就更新结果

所以应该有
int maxLen = 0;
int[] sum = new int[nums.length];
HashMap<Integer, List<Integer>> map = new HashMao<Integer, List<Integer>>();
sum里面存储从0至i的累加和，maxLen记录当前最长值
map的value记录和key(也就是sum[i])对应的可以满足和为k的各位置，期中List<Integer>.get(0)就是最靠前的那个


然而当我上网看大神们的解法时，才发现我图样图森破，根本不需要我写的那么复杂，
我们不需要另外创建一个累积和的数组，而是直接用一个变量sum边累加边处理，
而且我们哈希表也完全不用建立和一维数组的映射，只要保存第一个出现该累积和的位置，后面再出现直接跳过，这样算下来就是最长的子数组

*/


class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum=0, maxLen=0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            //如果在从0开始累加的过程中达到k，则记录maxLen为当前位置
            //不一定是最长，但是在循环到当前i的位置，就是最长的，需要记录
            if(sum==k)
                maxLen=i+1;
            //如果map中有key
            else if(map.containsKey(sum-k))
                maxLen=Math.max(maxLen, i-map.get(sum-k));
            //如果map中没有key==sum，说明
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return maxLen;
    }
    
}








