package insertSort;

public class InsertSort {

    /**
     * 插入排序 将外循环的起点前当成已经排序完成的数组 后面数字依次插入
     * @param source
     * @return
     */
    private static int[] insertSort(int[] source){
        for (int i = 0; i < source.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                int temp;
                if(source[j] < source[j-1]){
                    temp = source[j-1];
                    source[j-1] = source[j];
                    source[j] = temp;
                }else {
                    break;
                }
            }
        }
        return source;
    }

    public static void main(String[] args) {
        int[] source = new int[]{3,6,0,5,4,1};
        source = insertSort(source);
        for (int a:source) {
            System.out.println(a);
        }
    }
}
