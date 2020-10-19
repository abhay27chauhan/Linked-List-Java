class IntersectionPtOfTwoLinkedList{

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
        int IntersectionPtOfLinkedList(MyLinkedList l1, MyLinkedList l2){
            int delta = Math.abs(l1.size - l2.size);

            Node n1 = l1.head;
            Node n2 = l2.head;

            if(l1.size > l2.size){
                for(int i=0; i<delta; i++){
                    n1 = n1.next;
                }
            }else{
                for(int i=0; i<delta; i++){
                    n2 = n2.next;
                }
            }

            while(n1.data != n2.data){
                n1 = n1.next;
                n2 = n2.next;
            }

            return n1.data;
        }
    }

    public static void main(String[] args){
        MyLinkedList l1 = new MyLinkedList();
        MyLinkedList l2 = new MyLinkedList();
        MyLinkedList list = new MyLinkedList();

        for(int i=0; i<7; i++){
            l1.addLast(i);
        }

        l2.addLast(9);
        l2.addLast(8);
        l2.addLast(4);
        l2.addLast(5);
        l2.addLast(6);

        l1.display();
        l2.display();
        int res = l1.IntersectionPtOfLinkedList(l1, l2);
        System.out.println(res);
    }
}
