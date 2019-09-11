package quickSort;

public class QuickSort {

    public static void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    /**
     * 快速排序 从右边向左寻找第一个比key值小的 再从左往右寻找到第一个比key值大的交换位置 再递归执行左右两个子数组
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSort(int[] nums,int l,int r){
        if(l>=r) return;
        int key = nums[l];
        int i = l;
        int j = r;
        while(i < j){
            //从右向左寻找小于key的第一个值
            while(i < j && nums[j] >= key){
                j--;
            }
            if(i < j){
                nums[i] = nums[j];
                i++;
            }

            while(i < j && nums[i] < key){
                i++;
            }
            if(i < j){
                nums[j] = nums[i];
                j--;
            }

        }
        //此时 i==j
        nums[i] = key;
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }

    public static void main(String[] args) {
        int[] source = new int[]{3,6,0,5,4,1};
        quickSort(source);
        for (int a:source) {
            System.out.println(a);
        }
    }
}
