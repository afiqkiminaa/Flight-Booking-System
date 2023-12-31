
package flightsystem;

class QueueWaitingList<T>{
    private int head;
    private int tail;
    private int maxSize;
    private T[] arr;
    
    public QueueWaitingList(int size){
        this.head = 0;
        this.tail = 0;
        this.maxSize = size;
        this.arr = (T[]) new Object[maxSize];
    }
    public boolean isEmpty(){
        return tail == 0;
    }
    public boolean isFull(){
        return tail >= maxSize;
    }
    public void enqueue(T passenger){
        if(!isFull()){
            arr[tail] = passenger;
            tail++;
            System.out.println("Adding passenger: "+passenger);
        }
        else{
            System.out.println("Queue is full.");
        }
    }
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        }

        T temp = arr[head];
        for (int i = 0; i < tail; i++) {
            arr[i] = arr[i + 1];
        }
        arr[tail - 1] = null;
        tail--;

        System.out.println("Removing passenger: " + temp);
        return temp;
    }
    public void peek(){
        System.out.println("First passenger of queue: "+arr[head]);
    }
    boolean containsPassenger(String passportNumber) {
        for (int i = 0; i < tail; i++) {
            String passengerInfo = (String) arr[i];
            String[] parts = passengerInfo.split(",");
            String passengerPassportNumber = parts[1].trim();

            if (passengerPassportNumber.equals(passportNumber)) {
                System.out.println("Passenger found in the waiting list.");
                return true;
            }
        }
        System.out.println("Passenger not found in the waiting list.");
        return false;
    }
}
