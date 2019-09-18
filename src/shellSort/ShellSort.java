package shellSort;

public class ShellSort {

    /**
     * 希尔排序 缩小步长的插入排序   这是错误示范
     * @param source
     * @return
     */
    public static int[] sort(int[] source){
        int gap = source.length/2;
        while(gap != 0){
            for (int i = 0; i <source.length && i+gap<source.length ; i++) {
                int temp;
                if(source[i] > source[i+gap]){
                    temp = source[i];
                    source[i] = source[i+gap];
                    source[i+gap] = temp;
                }
            }
            gap /= 2;
        }
        return source;
    }

    /**
     * 真正的希尔排序
     * @param array
     */
    public static void sortV2(int array[]) {
    int temp = 0;
    int incre = array.length;
    while (true) {
        incre = incre / 2;
         for (int k = 0; k < incre; k++) { //根据增量分为若干子序列
            for (int i = k + incre; i < array.length; i += incre) {
                for (int j = i; j > k; j -= incre) {
                    if (array[j] < array[j - incre]) {
                         temp = array[j - incre];
                         array[j - incre] = array[j];
                         array[j] = temp;
                     } else {
                         break;
                     }
                 }
             }
         }
         if (incre == 1) {
             break;
         }
      }
    }

    public static void sortV3(int array[]){
        int h = 1;
        while(h < array.length / 3){
            h = h * 3 + 1;
        }

        while(h > 0){

            for(int i = h;i < array.length;i++){

            }

            h = (h - 1) / 3;
        }




    }




    public static void main(String[] args) {
        int[] source = new int[]{3,6,0,5,4,1};
        sortV2(source);
        for (int a:source) {
            System.out.println(a);
        }
    }
}
