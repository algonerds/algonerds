public class BubbleSort implements Sortable {
    public int[] sort(int[] numbers) {
        Integer temp=null;
        for (int i=0; i<=numbers.length-2;i++){
            for (int j=0; j<=numbers.length-2-i;j++){
                if (numbers[j]>numbers[j+1]){
                    temp         = numbers[j];
                    numbers[j]   = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
            //if no swaps in internal cycle => nothing to sort there
            if (temp == null){
                break;
            }
        }
        return numbers;
    }
}
