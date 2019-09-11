package mergeSort;

public class MergeSort {


    /**
     * 归并排序 注意合并的两个数组必须事先有序
     * @param a a数组
     * @param m a数组长度
     * @param b b数组
     * @param n b数组长度
     * @param c 合并后存放元素的数组
     */
    public static void sort(int[] a,int m,int[] b,int n,int[] c){
        int i = 0,j=0,z=0;
        for (; i < m && j < n;) {
            if(a[i] < b[j]){
                c[z++] = a[i];
                i++;
            }else {
                c[z++] = b[j];
                j++;
            }
        }
        while(i < m){
            c[z++] = a[i++];
        }
        while(j < n){
            c[z++] = b[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,1,3,4,5,6};
        int[] b = new int[]{1,2,3,4,8,9};
        int[] c = new int[a.length+b.length];
        sort(a,a.length,b,b.length,c);
        for (int i:c
             ) {
            System.out.println(i);
        }
    }
}
