
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStack<T> {
        private Queue<T> queue = new LinkedList<>();

        public void push(T value) {
            queue.offer(value);


        }

        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }

            int size = queue.size();
            T poppedItem =queue.poll();


            ArrayList<T>arrayList  = new ArrayList<>();
            arrayList.add(poppedItem);
            for (int i = 1; i < size; i++) {
                arrayList.add(queue.poll());
                if(i== size-1)
                {
                     poppedItem = queue.poll();
                }
            }





            queue.addAll(arrayList);

            return poppedItem;
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            int size = queue.size();
            T top = null;
            Stack<T>tempStack = new Stack<>();
            tempStack.addAll(queue);

            for (int i = 0; i < size-1; i++) {
                T item = tempStack.pop();}
            top = tempStack.pop();



            return top;
        }

        public int search(T value) {
            int index = -1;
            int size = queue.size();
            Queue<T> tempQueue = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                T item = queue.poll();
                if (item.equals(value) && i+1 >index) {
                    index = i + 1;
                }
                tempQueue.offer(item);
            }

            for(int j = 0; j< size;j++) {

                queue.offer(tempQueue.poll());
            }

            return size-index+1;
        }

        public T findMultiple() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            int size = queue.size();
            T most = null;
            int max = 0;
            ArrayList<T> findMax = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                T item = queue.poll();

                int frekans = 1;


                for (int j = i; j < size - 1; j++) {
                    T nextItem = queue.poll();
                    if (item.equals(nextItem)) {
                        frekans++;
                    }
                    queue.offer(nextItem);
                }

                if (frekans > max || (frekans == max && i == size - 1)) {
                    max = frekans;
                    most = item;
                }
                queue.offer(item);
            }
            return most;
        }




        public void reverse() {
            int size = queue.size();
            MyStack<T> tempStack = new MyStack<>();

            for (int i = 0; i < size; i++) {
                tempStack.push(queue.poll());
            }

           // queue.clear(); // Kuyruğu temizle

            while (!tempStack.isEmpty()) {
                queue.offer(tempStack.pop());
            }
        }






        public String toString() {
            StringBuilder sb = new StringBuilder();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                T item = queue.poll();
                sb.append(item);
                sb.append(" ");
                queue.offer(item);
            }
            return sb.substring(0,sb.length()-1);
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }



