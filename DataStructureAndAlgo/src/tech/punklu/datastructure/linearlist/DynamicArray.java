package tech.punklu.datastructure.linearlist;

/**
 * 动态数组
 */
public class DynamicArray<T> {

    private Object[] array = null;

    private int size = 0;

    private int count = 0;


    public DynamicArray(){
        array = new Object[10];
        size = 10;
    }

    public DynamicArray(int size){
        array = new Object[size];
        this.size = size;
    }

    public static void main(String[] args) {
        DynamicArray<Integer> nums = new DynamicArray<>();
        for (int i = 0; i < 10; i++) {
            nums.addItem(i);
        }
        // 删除
        System.out.println(nums.remove(5));
        // 更新
        System.out.println(nums.update(5,7));
        // 查询
        System.out.println(nums.get(3));
        // 增加
        nums.addItem(100);
        System.out.println("-----------");
        for (int i = 0; i < 10; i++) {
            System.out.println(nums.get(i));
        }
    }

    public void addItem(T item){
        if (this.count == size){
            // 先扩容
            increaseCapacity();
        }
        this.array[this.count++] = item;
    }

    public T remove(int index){
        T value =(T) array[index];
        for (int i = index; i < this.size-1; i++) {
            this.array[i] = this.array[i+1];
        }
        this.array[size-1] = null;
        count--;
        return value;
    }

    public T update(int index,T newValue){
        T oldValue = (T)this.array[index];
        this.array[index] = newValue;
        return oldValue;
    }

    public T get(int i){
        return (T) this.array[i];
    }


    private void increaseCapacity(){
        Object[] newArray = new Object[2*this.size];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
        this.size = 2*this.size;
    }
}
