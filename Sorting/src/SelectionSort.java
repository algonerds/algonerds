public class SelectionSort implements Sortable {
    public int[] sort(int[] numbers) {
        int min;
        int temp;
        for (int i=0; i < numbers.length-1; i++){
            min = i;
            for (int j=i+1; j<=numbers.length-1; j++){
                if (numbers[j]<numbers[min]){
                    min = j;
                }
            }
            temp        = numbers[min];
            numbers[min]= numbers[i];
            numbers[i]  = temp;
        }
        return numbers;
    }
}
