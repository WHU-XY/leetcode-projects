import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Sort {
    /*
    * 插入排序
    * 保证前i个为升序（有点动态规划的味道）
    * */
    public <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a){
        int j;
        for (int p = 1; p < a.length; p++){
            AnyType tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j-1]) < 0; j--)
                a[j] = a[j--];
            a[j] = tmp;
        }
    }

    /*
    * 冒泡排序
    * 如果左边的比右边的大，则交换
    * 循环循环n-1
    * 第一次排出最大的，放在最右边
    * 第二次将排出次大的
    * */
    public <AnyType extends Comparable<? super AnyType>> void bubbleSort(AnyType[] a){
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 0; j < a.length - i - 1; j++) {//-1为了防止溢出
                if(a[j].compareTo(a[j+1]) > 0) {
                    AnyType temp = a[j];

                    a[j] = a[j+1];

                    a[j+1] = temp;
                }
            }
        }
    }

    /*
    * 选择排序
    * 先排出最小的
    * 再排出次小
    * 拿a[i]和后面的n-i-1个数比较，i从0到n-2
    * */
    public <AnyType extends Comparable<? super AnyType>> void selectSort(AnyType[] a){
        for(int i =0;i<a.length-1;i++) {
            int minIndex = i;
            for(int j=i+1;j<a.length-1;j++) {//-1为了防止溢出
                if(a[i].compareTo(a[j]) > 0) {
                    minIndex = j;
                }
                if (i != minIndex){
                    AnyType temp = a[i];
                    a[i] = a[minIndex];
                    a[minIndex] = temp;
                }
            }
        }
    }

    /*
    * 希尔排序
    * 通过比较相距一定间隔的元素来工作（间隔数为：gap = a.length/2、gap/2、...1）；
    * 各趟比较所用的距离随着算法的进行而减小
    * 直到比较相邻元素的最后一趟排序为止
    * */
    public <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] a){
        int j;

        for (int gap = a.length/2; gap > 0; gap /= 2)
            for (int i = gap; i < a.length; i++){
                AnyType tmp = a[i];
                for (j = i; j >= gap &&
                    tmp.compareTo(a[j - gap]) < 0; j -= gap)
                    a[j] = a[j - gap];
                a[j] = tmp;
            }
    }

    /*
    * 堆排序*/
    public <AnyType extends Comparable<? super AnyType>> void heapSort(AnyType[] a){

    }

    /*
     * 归并排序*/
    public <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a){
        AnyType[] tmpArray = (AnyType[]) new Comparable[a.length];

        mergeSort(a, tmpArray, 0, a.length-1);
    }
    public <AnyType extends Comparable<? super AnyType>>
    void mergeSort(AnyType[] a, AnyType[] tmpArray, int left, int right){
        if (left < right){
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center+1, right);
            merge(a, tmpArray, left, center+1, right);
        }
    }
    public <AnyType extends Comparable<? super AnyType>>
    void merge(AnyType[] a, AnyType[] tmpArray, int leftPos, int rightPos, int rightEnd){

    }


    /*
     * 快速排序*/
    public <AnyType extends Comparable<? super AnyType>> void quickSort(AnyType[] a){

    }

    public void quickSort(int[] arr, int start, int end){
        if (start < end){
            int startData = arr[start];
            int low = start;
            int high = end;
            while (low < high){
                while (low < high && startData <= arr[high])
                    high--;
                arr[low] = arr[high];
                while (low < high && arr[low] <= startData)
                    low++;
                arr[high] = arr[low];
            }
            arr[low] = startData;
            quickSort(arr,start,low);
            quickSort(arr,low+1,end);
        }
    }

    public void mergeSort(int[] arr,int low, int high){
        int middle = (high + low)/2;
        if (low < high){
            mergeSort(arr,low,middle);
            mergeSort(arr,middle+1,high);
            merge(arr,low,middle,high);
        }
    }

    public void merge(int[] arr, int low, int middle, int high){

        int[] temp = new int[high-low+1];
        int i = low;
        int j = middle + 1;
        int index = 0;
        while (i <= middle || j <= high){
            if (j >high){
                temp[index] = arr[i];
                index++;
                i++;
                continue;
            }
            if (i >middle){
                temp[index] = arr[j];
                index++;
                j++;
                continue;
            }
            if (arr[i] < arr[j]){
                temp[index] = arr[i];
                index++;
                i++;
            }else {
                temp[index] = arr[j];
                index++;
                j++;
            }
        }

        for (int k = 0; k < temp.length; k++){
            arr[k+low] = temp[k];
        }
    }


    //堆排序
    public void heapSort(int[] arr){
        //开始位置是最后一个非叶子节点，即最后一个节点的父节点
        int start = (arr.length -1)/2;
        //调整为大顶堆
        for (int i = start;i>=0;i--){
            maxheap(arr,arr.length,i);
        }
        //先把数组中的第0个和堆中的最后一个
        for (int i = arr.length-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxheap(arr,i,0);
        }
    }
    public void maxheap(int[] arr,int size, int index){
        //左子节点
        int leftNode = 2*index+1;
        int rightNode = 2*index+2;
        int max = index;

        if (leftNode < size&&arr[leftNode] > arr[max])
            max = leftNode;
        if (rightNode < size&&arr[rightNode] > arr[max])
            max = rightNode;

        if (max != index){
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            //交换位置以后，可能会破坏之前排好的堆，所以，之前的排好的堆需要重新调整
            maxheap(arr,size,max);
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = new int[]{1,2,9,5,4,8,6};
        //sort.quickSort(arr,0,arr.length-1);
        //sort.mergeSort(arr,0,arr.length-1);
        sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
        //Queue[] queues = new ArrayBlockingQueue[10];
    }
}
