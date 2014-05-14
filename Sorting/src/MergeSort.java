import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MergeSort implements Sortable {
    public int[] sort(int[] numbers) {
        return sort(numbers, 0, numbers.length-1);
    }

    public int[] sort(int[] numbers, int left, int right) {
        int [] returnValue;
        int medium = left + (right-left)/2;
        if ( (right-left) > 0){
            int[] firstArray  = sort(numbers, left, medium);
            int[] secondArray = sort(numbers, medium+1, right);
            returnValue = merge(firstArray, secondArray);
        }
        else
        {
            returnValue = Arrays.copyOfRange(numbers, left, right+1);
        }
        return returnValue;
    }

    public int[] merge(int[] firstArray, int[] secondArray){
        int[] returnValue = new int[firstArray.length+secondArray.length];
        int i=0, j=0;
        for ( ;(i<firstArray.length) && (j<secondArray.length); ){
            if (firstArray[i] < secondArray[j]){
                returnValue[i+j] = firstArray[i++];
            }
            else
            {
                returnValue[i+j] = secondArray[j++];
            }
        }
        int[] restArray = new int[(firstArray.length-i) + (secondArray.length-j)];
        if (i < firstArray.length){
            restArray  =  Arrays.copyOfRange(firstArray, i, firstArray.length);
        }
        else if (j < secondArray.length){
            restArray  =  Arrays.copyOfRange(secondArray, j, secondArray.length);
        }
        for (int k=0; k < restArray.length; k++) {
            returnValue[i+j+k] = restArray[k];
        }
        return returnValue;

    }
}
