class mergeSortLinkedList{

     public static class Node{
        int data;
        Node next;
    }

    public static class MyLinkedList{
        Node head;
        Node tail;
        int size;

        void addLast(int val){
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if(size == 0){
                head = tail = temp;
            }else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        void addFirst(int val){
            Node temp = new Node();
            temp.data = val;

            if(size == 0){
                temp.next = null;
                head = tail = temp;
            }else{
                temp.next = head;
                head = temp;
            }
            size++;
        }

        void addAt(int idx, int val){
            if(idx<0 || idx > size){
                System.out.println("Invalid Argument");
            }else if(idx == 0){
                addFirst(val);
            }else if(idx == size){
                addLast(val);
            }else{
                Node node = new Node();
                node.data = val;

                Node temp = head;

                for(int i=0; i<idx-1; i++){
                    temp = temp.next;
                }

                node.next = temp.next;
                temp.next = node;
                size++;


            }
        }

        int size(){
            return size;
        }

        void display(){
            Node temp = head;

            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        void removeFirst(){
            if(size == 0){
                System.out.println("List is Empty");
            }else if(size ==1){
                head = tail = null;
                size = 0;
            }else{
                head = head.next;
                size--;
            }
        }

        void removeLast(){
            if(size == 0){
                System.out.println("List is Empty");
            }else if(size == 1){
                head = tail = null;
                size = 0;
            }else{
                Node temp = head;
                for(int i=0; i<size-2; i++){
                    temp = temp.next;
                }

                tail = temp;
                tail.next = null;
                size--;
            }
        }

        void removeAt(int idx){
            if(size == 0){
                System.out.println("List is Empty");
            }else if(idx < 0 || idx >= size){
                System.out.println("Invalid Argument");
            }else if(idx == 0){
                removeFirst();
            }else if(idx == size-1){
                removeLast();
            }else{
                Node temp = head;

                for(int i=0; i<idx-1; i++){
                    temp = temp.next;
                }

                temp.next = temp.next.next;
                size--;
            }
        }

        int getFirst(){
            if(size == 0){
                System.out.println("List is Empty");
                return -1;
            }else{
                return head.data;
            }
        }

        int getLast(){
            if(size == 0){
                System.out.println("List is Empty");
                return -1;
            }else{
                return tail.data;
            }
        }

        int getAt(int idx){
            if(size == 0){
                System.out.println("List is Empty");
                return -1;
            }else if(idx<0 || idx>=size){
                System.out.println("Invalid Argument");
                return -1;
            }else{
                Node temp = head;
                for(int i=0; i<idx; i++){
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        Node getMidNode(Node head, Node tail){
            Node s = head;
            Node f = head;

            while(f != tail && f.next != tail){
                f = f.next.next;
                s = s.next;
            }

            return s;
        }

        MyLinkedList merge2SortedLists(MyLinkedList l1, MyLinkedList l2){
            MyLinkedList res = new MyLinkedList();

            Node n1 = l1.head;
            Node n2 = l2.head;

            while(n1 != null && n2!= null){
                if(n1.data < n2.data){
                    res.addLast(n1.data);
                    n1 = n1.next;
                }else{
                    res.addLast(n2.data);
                    n2 = n2.next;
                }
            }

            while(n1 != null){
                res.addLast(n1.data);
                n1 = n1.next;
            }

            while(n2 != null){
                res.addLast(n2.data);
                n2 = n2.next;
            }

            return res;
        }

        MyLinkedList mergeSort(Node head, Node tail){
            if(head == tail){
               MyLinkedList bl = new MyLinkedList();
               bl.addLast(head.data);
               return bl;
            }

            Node mid = getMidNode(head, tail);
            MyLinkedList fh = mergeSort(head, mid);
            MyLinkedList sh = mergeSort(mid.next, tail);
            MyLinkedList cl = merge2SortedLists(fh, sh);

            return cl;
        }
        
    }

    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        list.addLast(2);
        list.addLast(7);
        list.addLast(1);
        list.addLast(6);
        list.addLast(5);
        list.addLast(3);
        list.addLast(4);

        list.display();
        MyLinkedList sorted = list.mergeSort(list.head, list.tail);
        sorted.display();
    }
}