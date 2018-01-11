/*

输入的数x没有溢出，在反转之后可能会溢出
如Integer.MAXVALUE为2147483647，反转之后是7463847412产生了溢出
所以选择用表示范围比int更大的long类型存储转换之后的结果result
将反转之后的结果result与Integer.MAX_VALUE和Integer.MIN_VALUE作比较，如没有溢出，则将result强制转换为int返回，若有溢出，则返回0.

*/

class Solution {
    public int reverse(int x) {
        long result = 0;
        while(x!=0){
            result= result*10+x%10;
            if(result>Integer.MAX_VALUE || result< Integer.MIN_VALUE)
                return 0;
            x = x/10;
        }
        return (int)result;
            
    }
}
