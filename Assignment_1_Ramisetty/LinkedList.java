public class LinkedList {
    static class Node {
        int data;
        Node next;
    }
    static Node head;
    public static void insert(int data) {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = head;
        head = new_node;
    }

    public static void printList() {
        Node h = head;
        boolean y = true; 
        while (y){
            if (h.next!=null){
               System.out.print(h.data + " -> ");
               h=h.next;                
            }
            else{
               System.out.print(h.data + "\n");
               y = false;
            }
        }

    }
  public static void bubbleSort() {
      Node current = null;
      Node new_head = null;
      Node current2 = null;
      do{
        Node prev = null;
        current = head;
        current2 = head;
        while (current != null) {
          if (current.next != null && current.next.data > current2.data) {
            current2 = current.next;
            prev = current;
          }
          current = current.next;
        }
        if (current2 == head) {
          head = (head).next;
        }
        if (prev != null) {
          prev.next = current2.next;
        }
        current2.next = new_head;
        new_head = current2;
      }while(head != null);
      head = new_head;
  }


    public static void main(String[] args) {
        insert(1);
        insert(7);
        insert(5);
        insert(6);
        insert(13);
        insert(9);
        insert(7);
        insert(34);
        insert(16);
        insert(65);
        insert(2);
        insert(8);
        insert(3);
        insert(4);
        insert(19);
        System.out.println("Before sorting:");
        printList();
        bubbleSort();
        System.out.println("After sorting using BubbleSort:");
        printList();
    }
    
}




