/*


Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

*/



class Solution {
    public int romanToInt(String s) {
        int nums[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':   nums[i]=1000;break;
                case 'D':   nums[i]=500;break;
                case 'C':   nums[i]=100;break;
                case 'L':   nums[i]=50;break;
                case 'X':   nums[i]=10;break;
                case 'V':   nums[i]=5;break;
                case 'I':   nums[i]=1;break;
            }
        }
        
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            //如果当前位比后一位小，说明需要在后一位的基础上减去
            if(nums[i]<nums[i+1])
                sum -= nums[i];
            //如果当前位不小于后一位，说明简单相加即可
            else
                sum += nums[i];
        }
        //记得要把最后一位加上，无论如何最后一位一定是加
        return sum+nums[nums.length-1];
    }
}
