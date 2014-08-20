/* adopted code from book: cracking the coding interview
 * by Mcdowell
 */

public class MergeSort {
    private static void mergesort(int[] array){
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length-1);
    }
    private static void mergesort(int[] array, int[] helper, int low, int high){
        if(low < high){
            int middle = (low+high)/2;
            mergesort(array, helper, low, middle);     //sort left half
            mergesort(array, helper, middle+1, high);  //sort right half
            merge(array, helper, low, middle, high);
            
        }
    }
    private static void merge(int[] array, int[] helper,int low, int middle, int high){
        /*copy the contents of the original array into helper */
       for(int i = low; i <= high; i++){
           helper[i] = array[i];
       }
       int helperleft = low;
       int helperright = middle+1;
       int current = low;
       
       while(helperleft <= middle && helperright <= high){
           if(helper[helperleft] <= helper[helperright]){
               array[current] = helper[helperleft];
               helperleft++;
           }else{
               array[current] = helper[helperright];
               helperright++;
           }
           current++;
       }
       
       /* copy the rest of the left side of the array into the
        * target array
        */
       int remaining = middle - helperleft;
       for(int i = 0; i<= remaining; i++){
           array[current + i] = helper[helperleft+i];
       }
    }
    public static void main(String[] args){
        int[] numbers = {2,3,7,1,40,32,36,11,-2,23};
        mergesort(numbers);
        for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }
    }
}
