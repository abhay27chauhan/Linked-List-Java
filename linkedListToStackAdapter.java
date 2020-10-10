// addFirst, removeFirst, getFirst
import java.util.LinkedList;
class linkedListToStackAdapter{

    public static class LLToStackAdapter{
        LinkedList<Integer> ll;

        public LLToStackAdapter(){
            ll = new LinkedList<>();
        }

        void push(int val){
            ll.addFirst(val);
        }

        int size(){
            return ll.size();
        }

        int pop(){
            return ll.removeFirst();
        }

        int peek(){
            return ll.getFirst();
        }
    }

    public static void main(String[] args){
        LLToStackAdapter list = new LLToStackAdapter();
        for(int i=10; i<100; i += 10){
            list.push(i);
        }
        System.out.println("size -> " + list.size());
        System.out.println("peek -> " + list.peek());
        System.out.println("pop -> " + list.pop());
        System.out.println("pop -> " + list.pop());
        System.out.println("peek -> " + list.peek());
        System.out.println("size -> " + list.size());

    }
}