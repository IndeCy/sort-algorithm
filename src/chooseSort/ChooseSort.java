package chooseSort;

public class ChooseSort {

    public static int[] chooseSort(int[] source){
        for (int i = 0; i < source.length - 1; i++) {
            int min = source[i];
            int minIndex = i;
            for (int j = i + 1; j < source.length; j++) {
                if(source[j] < min){
                    min = source[j];
                    minIndex = j;
                }
            }
            source[minIndex] = source[i];
            source[i] = min;
        }
        return source;
    }

    public static void main(String[] args) {
        int[] source = new int[]{3,6,0,5,4,1};
        source = chooseSort(source);
        for (int a:source) {
            System.out.println(a);
        }
    }
}
