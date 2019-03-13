public class Quick{
  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   return quickselect(data, k, 0, data.length - 1);
 }
 public static int quickselect(int []data, int k, int hi, int lo){
   if (hi == lo) return data[k];
   int pivot = partition(data, lo, hi);
   if (pivot == k) return data[k];
   if (pivot < k) return quickselect(data, k, pivot + 1, hi);
   else return quickselect(data, k, lo, pivot - 1);
 }

 /*Modify the array to be in increasing order.
  */
  public static void quicksort(int[] data){
    quicksort(data, 0, data.length - 1);
  }
  public static void quicksort(int[] data, int lo, int hi){
    if (lo >= hi) return;
    int pivot = partition(data, lo, hi);
    quicksort(data, lo, pivot - 1);
    quicksort(data, pivot + 1, hi);
  }


/*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */

private static int partition ( int [] data, int start, int end){
   int pivot = (int)(Math.random() * (end - start) + start);
   int n = data[pivot];
  System.out.println("n: " + n);
   while (start < end){
     if (start >= pivot && end != start){
       int temp = data[pivot + 1];
       data[pivot + 1] = data[pivot];
       data[pivot] = temp;
       pivot++;
       if (temp < data[pivot]) start++;
     }
     if (end <= pivot && end != start){
       int temp = data[pivot - 1];
       data[pivot - 1] = data[pivot];
       data[pivot] = temp;
       pivot--;
       if (temp > data[pivot]) end--;
     }
     if (data[start] <= data[pivot] && end != start && start != pivot){
       start++;
     }
     if (data[start] > data[pivot] && end != start){
       if (pivot == end) pivot = start;
       int temp = data[end];
       data[end] = data[start];
       data[start] = temp;
       end--;
     }
   }
   return pivot;
 }

 public static void main(String[] args){
   int[] a = new int[]{991,992,993,4,1,0,3,2,994,995,996};
   quicksort(a, 0, a.length - 1);
   for (int i : a){
     System.out.print(i + " ");
   }
   System.out.println();
 }
}
