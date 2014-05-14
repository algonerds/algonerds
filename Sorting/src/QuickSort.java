import java.lang.System;
import java.util.Arrays;

/**
 * Created by sergey on 5/10/14.
 */
public class QuickSort implements Sortable {
    @Override
    public int[] sort(int[] numbers){
        int[] returnValue;
        if (numbers.length==0){
            returnValue = new int[]{};
        }
        else if ( numbers.length == 1){
            returnValue = numbers;
        }
        else
        {
            int medium = (numbers.length-1)/2;
            int[] lessThanMedium = new int[numbers.length-1];
            int   lessThanMediumSize = 0;

            int[] moreThanMedium = new int[numbers.length-1];
            int   moreThanMediumSize = 0;

            int[] equalsMedium   = new int[numbers.length];
            int   equalsMediumSize = 0;
            equalsMedium[equalsMediumSize++] = numbers[medium];

            for (int i=0; ((i) < medium); i++){
                if (numbers[i] < numbers[medium])
                    lessThanMedium[lessThanMediumSize++] = numbers[i];
                else if (numbers[i] > numbers[medium])
                    moreThanMedium[moreThanMediumSize++] = numbers[i];
                else
                    equalsMedium[equalsMediumSize++]     = numbers[i];


                if (numbers[numbers.length-1-i] < numbers[medium])
                    lessThanMedium[lessThanMediumSize++] = numbers[numbers.length-1-i];
                else if (numbers[numbers.length-1-i] > numbers[medium])
                    moreThanMedium[moreThanMediumSize++] = numbers[numbers.length-1-i];
                else
                    equalsMedium[equalsMediumSize++]     = numbers[numbers.length-1-i];
            }
            //we might missed the after medium element
            //and we need to check it
            if ((numbers.length-1) % 2==1){
                if (numbers[medium+1] < numbers[medium])
                    lessThanMedium[lessThanMediumSize++] = numbers[medium+1];
                else if (numbers[medium+1] > numbers[medium])
                    moreThanMedium[moreThanMediumSize++] = numbers[medium+1];
                else
                    equalsMedium[equalsMediumSize++]     = numbers[medium+1];
            }


        returnValue = new int[lessThanMediumSize + moreThanMediumSize + equalsMediumSize];
        lessThanMedium = (lessThanMediumSize >= 2) ? sort(Arrays.copyOfRange(lessThanMedium, 0, lessThanMediumSize)) :
                                                            Arrays.copyOfRange(lessThanMedium, 0, lessThanMediumSize);
        moreThanMedium = (moreThanMediumSize >=2)  ? sort(Arrays.copyOfRange(moreThanMedium, 0, moreThanMediumSize)) :
                                                        Arrays.copyOfRange(moreThanMedium, 0, moreThanMediumSize);
        equalsMedium   = Arrays.copyOfRange(equalsMedium, 0, equalsMediumSize);

        System.arraycopy(lessThanMedium, 0, returnValue, 0, lessThanMediumSize);
        System.arraycopy(equalsMedium, 0, returnValue, lessThanMediumSize, equalsMediumSize);
        System.arraycopy(moreThanMedium, 0, returnValue, lessThanMediumSize + equalsMediumSize, moreThanMediumSize);

        }
        return returnValue;
    }


}
