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


    //将数组按照给定的比较值进行分区
    public static int partition(int[] source,int left,int right,int point){
        int leftIdx = left - 1;
        //因为选择最右边的数为point所以从倒数第二个开始比较
        int rightIdx = right;
        while (true){
            while(leftIdx < rightIdx && source[++leftIdx] < point);
            while(leftIdx < rightIdx && source[--rightIdx] > point);
            if(leftIdx < rightIdx){
                int temp = source[leftIdx];
                source[leftIdx] = source[rightIdx];
                source[rightIdx] = temp;
            }else{
                break;
            }
        }
        int temp = source[leftIdx];
        source[leftIdx] = point;
        source[right] = temp;
        return leftIdx;
    }

    public static void quickSortV2(int[] source,int left,int right){
        if(left >= right){
            return;
        }
        int mid = partition(source,left,right,source[right]);
        quickSortV2(source,left,mid - 1);
        quickSortV2(source,mid + 1,right);
    }

    public static void main(String[] args) {
        int[] source = new int[]{3,6,0,5,4,1};
        quickSortV2(source,0,source.length-1);
        for (int a:source) {
            System.out.println(a);
        }
    }
}
