package bubbleSort;

public class BubbleSort {

    /**
     * 将最小的往前排 也可以将最大的往后排实现方式一样
     * @param source
     * @return
     */
    public static int[] sort(int[] source){
        for (int i = 0; i < source.length - 1; i++) {
            for (int j = i + 1; j < source.length; j++) {
                int temp;
                if(source[i] > source[j]){
                    temp = source[i];
                    source[i] = source[j];
                    source[j] = temp;
                }
            }
        }
        return source;
    }

    public static void main(String[] args) {
        int[] source = new int[]{3,6,0,5,4,1};
        source = sort(source);
        for (int a:source) {
            System.out.println(a);
        }
    }
}
