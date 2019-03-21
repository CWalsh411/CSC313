import java.util.*;
public class BTree<E>{
   private static class BNode<E>{
      E data;
      BNode<E> parent;
      BNode<E> left;
      BNode<E> right;
      BNode(){
         this(null);
      }
      BNode(E e){
         data = e;
	 parent = null;
	 left = null;
	 right = null;
      }
   }
   private BNode<E> root;
   private int size;
   BTree(){
      root = null;
      size = 0;
   }
   public BNode<E> createNode(E e){
      return new BNode<E>(e);
   }
   public BNode<E> addLeft(BNode<E> n, E e) throws IllegalArgumentException{
      if (n.left != null) throw new IllegalArgumentException("Left is full");
      n.left = createNode(e);
      n.left.parent = n;
      size++;
      return n.left;
   }
   public BNode<E> addRight(BNode<E> n, E e) throws IllegalArgumentException{
      if (n.right != null) throw new IllegalArgumentException("Right is full");
      n.right = createNode(e);
      n.right.parent = n;
      size++;
      return n.right;
   }
   public BNode<E> addRoot(E e) throws IllegalArgumentException{
      if (root != null) throw new IllegalArgumentException("Root is full");
      root = createNode(e);
      size++;
      return root;
   }
   public void levelOrder(){
        List<List<TNode<E>>> queue = new LinkedList<List<TNode<E>>>();
        List<TNode<E>> first = new LinkedList<TNode<E>>();
        fist.add (root);
        queue.add(first);
        levelPrint(queue);
        System.out.println();
   }
   private void levelPrint(List<List<TNode<E>>> q){
        if(q.isEmpty)
          return;
        List<TNode<E>> tempP = q.remove(0);
        for(TNode<E> tn : temp){
             System.out.print(tn.data);
             if(tn.children != null)
               q.add(tn.children);
        }
   }
   public void make(E[] values){
      BNode<E> rt = addRoot(values[0]);
      BNode<E> lt = addLeft(rt, values[1]);
      addLeft(addRight(rt,values[2]),values[5]);
      addRight(addLeft(lt,values[3]),values[6]);
      addRight(lt,values[4]);
   }
   public static void main(String[] args){
      BTree<Integer> bt = new BTree<Integer>();
      Integer[] v = new Integer[]{1,2,3,4,5,6,7};
      bt.make(v);
      bt.levelOrder();
   }
}
