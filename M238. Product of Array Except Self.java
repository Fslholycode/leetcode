public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pro = 1;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                num++;
                continue;
            } else {
                pro *= nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (num >= 2) { 
                res[i] = 0;
            } else if (num == 1) {
                res[i] = nums[i] == 0 ? pro:0;
            } else {
                res[i] = pro/nums[i];
            }
        }
        return res;
    }
}

//best solution
public class Solution {
	public int[] productExceptSelf(int[] nums) {
	    int leng = nums.length;
	    int[] ret = new int[leng];
	    if(leng == 0)
	        return ret;
	    int runningprefix = 1;
	    for(int i = 0; i < leng; i++){
	        ret[i] = runningprefix;
	        runningprefix*= nums[i];
	    }
	    int runningsufix = 1;
	    for(int i = leng -1; i >= 0; i--){
	        ret[i] *= runningsufix;
	        runningsufix *= nums[i];
	    }
	    return ret;
	}
}