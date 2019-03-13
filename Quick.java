public class Quick{
  /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect(int []data, int k){
   return 0;
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
  System.out.println(n);
   while (start < end){
     if (start == pivot && end != start){
       int temp = data[pivot + 1];
       data[pivot + 1] = data[pivot];
       data[pivot] = temp;
       pivot++;
       if (temp < data[pivot]) start++;
     }
     if (end == pivot && end != start){
       int temp = data[pivot - 1];
       data[pivot - 1] = data[pivot];
       data[pivot] = temp;
       pivot--;
       if (temp > data[pivot]) end--;
     }
     if (data[start] < data[pivot]){
       start++;
     }
     if (data[start] > data[pivot]){
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
   int[] a = new int[]{998,997,996,4,1,0,3,2,995,994,999};
   System.out.println(partition(a, 0, 10));
   for (int i : a){
     System.out.print(i + " ");
   }
   System.out.println();
 }
}
