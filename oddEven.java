class oddEven{

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

        void oddEven(){
            MyLinkedList odd = new MyLinkedList();
            MyLinkedList even = new MyLinkedList();

            while(this.size >0){
                int val = this.getFirst();
                this.removeFirst();

                if(val % 2 == 1){
                    odd.addLast(val);
                }else{
                    even.addLast(val);
                }
            }

            odd.tail.next = even.head;
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;
        }
        
    }

    public static void main(String[] args){
        MyLinkedList list = new MyLinkedList();
        list.addLast(9);
        list.addLast(7);
        list.addLast(8);
        list.addLast(1);
        list.addLast(6);
        list.addLast(5);
        list.addLast(4);

        list.display();
        list.oddEven();
        list.display();
    }
}