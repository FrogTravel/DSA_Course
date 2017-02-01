/**
 * Created by ekaterina on 18.01.17.
 */
public class BubbleSort {
    private int a[];
    private int numberOfItems;

    public BubbleSort(int max){
        a = new int[max];
        numberOfItems = 0;
    }

    public void insert(int elem){
        a[numberOfItems] = elem;
        numberOfItems++;
    }

    public void show(){
        for (int i = 0; i < numberOfItems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }

    public void sort(){
        for (int i = numberOfItems; i > 0; i--) {//до какого будем крутиться
            for (int j = 1; j < i; j++) {//current element
                if(a[j-1]>a[j]){
                    swap(j-1,j);
                }
            }
        }
    }

    private void swap(int first, int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

}
