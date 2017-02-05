import java.util.List;

/**
 * Created by ekaterina on 31.01.17.
 */
public class ArrayList<E>{
    private E[] data;
    private int size = 0;


    public ArrayList(){
        data = (E[]) new Object[1];
    }

    public int size(){
        return size;
    }

    public E get(int index){
        return data[index];
    }

    public boolean isEmpty(){
        return data[0] == null;
    }

    public void add(E value){
        if(data[data.length - 1] == null){
            for (int i = 0; i < data.length; i++) {
                if(data[i] == null){
                    data[i] = value;
                    size++;
                    break;
                }
            }
        }else{
            extend();
            add(value);
        }

    }

    public void remove(E value){
        for (int i = 0; i < data.length; i++) {
            if((data[i] != null) && (data[i].equals(value))){
                for (int j = i; j < data.length - 1; j++) {
                    if(data[j+1] != null){
                        data[j] = data[j+1];
                    }else data[j] = null;
                }
                break;
            }
        }
        size--;
    }

    public boolean isContain(E value){
        for (E dataV : data) {
            if((dataV != null)&&(dataV.equals(value))){
                System.out.println(dataV);
                return true;}
        }
        return false;
    }

    public void showAll(){
        for (E elem : data) {
            System.out.print(elem + " ");
        }
    }

    private void extend() {
        E[] tempArray = (E[]) new Object[data.length*2];
        System.arraycopy(data, 0, tempArray, 0, data.length);
        data = tempArray;
    }
}
