// 20180911 add by sunny
public class MergeSort{

	MergeSort(){
    }
    
    // merge two subarray ( start , middle ) and ( middle+1,end)    
    void merge(int arr[], int start ,int middle , int end){
    	System.out.println("start:"+start + ",middle:" + middle + ",end:" + end);
        // find the size of subarray
        int length1 = middle-start+1;
        int length2 =  end-middle;
        
        // create two temp array
        int arr1[] = new int[length1];
        int arr2[] = new int[length2];
        
        // copy data to two temp array
        for (int i=0;i<length1;++i)
            arr1[i]= arr[start+i]; 
        for (int j=0;j<length2;++j)
            arr2[j]= arr[middle+1+j];
            
        //merge the two temp array
        int index1=0 , index2=0 ;
        int ori=start;
        while (index1 < length1 && index2 < length2){
            if (arr1[index1]<= arr2[index2]){
                arr[ori] = arr1[index1];
                index1++;
                //verify
                System.out.println("index1:"+index1 +","+ arr1[index1-1]+ ",index2:" + index2 +","+arr2[index2]+ ",ori:" + ori);
                PrintArray(arr);
                System.out.println("");
                System.out.println("11  ---------  ");
            }
            else{
               arr[ori]= arr2[index2];
               index2++;
               //verify 
               System.out.println("index1:"+index1 +","+ arr1[index1]+ ",index2:" + index2 +","+arr2[index2-1]+ ",ori:" + ori);
               PrintArray(arr);
               System.out.println("");
               System.out.println("22  ---------  ");
            }
            ori++;
        }
        while (index1 < length1 ){
            arr[ori]= arr1[index1];
            ori++;
            index1++;
            //verify 
            System.out.println("index1:"+index1 +","+ arr1[index1-1]+  ",ori:" + ori);
            PrintArray(arr);
            System.out.println("");
            System.out.println("33  ---------  ");
        } 
        
        while (index2 < length2 ){
            arr[ori]= arr2[index2];
            ori++;
            index2++;
            
            //verify 
            System.out.println("index2:"+index2 +","+ arr2[index2-1]+  ",ori:" + ori);
            PrintArray(arr);
            System.out.println("");
            System.out.println("44  ---------  ");
        }
                   
        
        
    }
    // merge sort : divide and conquer
    void sort(int arr[], int start , int end){
        if (start < end){
            int middle = (start+end)/2 ;
            sort(arr,start,middle);
            sort(arr,middle+1,end);
            merge(arr,start,middle,end);
        }
        
    
    }
    void PrintArray(int arr[]){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
            
        }
    }
    
    public static void main(String args[]){
        int arr[] = {12, 11, 13, 5, 6, 7};
        MergeSort ms = new MergeSort();
        ms.PrintArray(arr);
        System.out.println() ;
        
        ms.sort(arr,0,arr.length-1);
        
        System.out.println();
        System.out.println("result:");
        ms.PrintArray(arr);
        System.out.println();
        
        
    }
}
