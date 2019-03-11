public class ArrayQueue<E>{
     private E[] d;
     private int f;
     private int sz;
     public ArrayQueue(){
          this(10);
     }
     public ArrayQueue(int c){
          d = (E[]) new Object[c];
          f = 0;
          sz = 0;
     }
     public void enqueue(E e){
          if (sz == d.length) throw new IllegalStateException("Full");
          int end = (f+sz++) % d.length;
          d[end] = e;
     }
     public boolean isEmpty(){
          return sz == 0;
     }
     public E first(){
          if (isEmpty()) return null;
          return d[f];
     }
     public E dequeue(){
          if (isEmpty()) throw new IllegalStateException("Empty");
          E ans = d[f];
          d[f] = null;
          f = (f+1) % d.length;
          if (--sz == 0) f = 0;
          return ans;
     }
     public void print(){
          if (isEmpty()) return;
          for (int i = 0; i < sz; i++){
               System.out.print(d[(f + i) % d.length] +  ",");
          }
          System.out.println();
     }
     public static void main(String[] args){
          ArrayQueue<Integer> q = new ArrayQueue<Integer>();
          q.enqueue(1);
          q.enqueue(2);
          q.print();
          System.out.println("removing: " + q.dequeue());
          q.enqueue(3);
          q.print();
          System.out.println("removing: " + q.dequeue());
          System.out.println("peek: " + q.first());
          q.print();
     }
}
