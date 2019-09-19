package heapSort;

public class HeapSort {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void ajust(int[] arr,int parent,int n){
        int temp = arr[parent];
        int i;
        for( i = 2 * parent;i <= n; i = i * 2){
            if(i < n && arr[i] < arr[i + 1]){
                //当右孩子比左孩子大 i++ 将交换值设为右孩子
                i++;
            }

            if(temp >= arr[i]){
                //当父节点值大于孩子中的较大值时就不需要交换直接跳出循环
                break;
            }
            //否则将父节点设置为子节点中的较大值
            arr[parent] = arr[i];
            //将当前子节点设置为父节点继续向下比较
            parent = i;
        }
        //最终的父节点为最小的将其赋值
        arr[parent] = temp;
    }


    public static void heapSort(int[] arr,int n){
        int i;
        //先自下而上堆化
        for(i = n / 2;i > 0;i--){
            ajust(arr,i,n);
        }
        //将第一个数与最后一个数交换 因为堆化后第一个数最大 所以循环交换下去数组就从小到大排序完成
        for(i = n;i > 1;i--){
            swap(arr,1,i);
            ajust(arr,1,i - 1);
        }
    }

    public static void main(String[] args) {
        //由于从1开始 所以第一个数忽略
        int[] source = new int[]{-1,3,6,0,5,4,1};
        heapSort(source,6);
        for (int i:source
             ) {
            System.out.println(i);
        }
    }
}
