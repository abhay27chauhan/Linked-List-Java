// addLast, removefirst, getfirst
import java.util.LinkedList;
class linkedListToQueueAdapter{

    public static class LLToQueueAdapter{
        LinkedList<Integer> ll;

        public LLToQueueAdapter(){
            ll = new LinkedList<>();
        }

        void add(int val){
            ll.addLast(val);
        }

        int size(){
            return ll.size();
        }

        int remove(){
            return ll.removeFirst();
        }

        int top(){
            return ll.getFirst();
        }
    }

    public static void main(String[] args){
        LLToQueueAdapter list = new LLToQueueAdapter();
        for(int i=10; i<100; i += 10){
            list.add(i);
        }
        System.out.println("size -> " + list.size());
        System.out.println("top -> " + list.top());
        System.out.println("remove -> " + list.remove());
        System.out.println("remove -> " + list.remove());
        System.out.println("top -> " + list.top());
        System.out.println("size -> " + list.size());
    }
}