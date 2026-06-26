class DynamicArray {

    int capacity;
    int size;
    int arr[];

    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if(this.size != this.capacity){
            this.arr[size] = n;
        }else{
            resize();
            this.arr[size] = n;
        }
        size += 1;
    }

    public int popback() {
        int element = arr[size-1];
        this.size -= 1;
        return element;
    }

    private void resize() {
        this.capacity = this.capacity * 2;
        this.arr = Arrays.copyOf(arr, capacity);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
