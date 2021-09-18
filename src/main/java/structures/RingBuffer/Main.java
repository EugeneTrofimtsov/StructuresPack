package structures.RingBuffer;

public class Main {

    public static void main(String[] args) {
	    RingBufferImpl<Integer> buf = new RingBufferImpl<Integer>(Integer.class, 5);
	    buf.add(1);
	    buf.add(2);
	    buf.add(4);
        System.out.println(buf.getSize());
        for (int i: buf) {
            System.out.println(i);
        }
        System.out.println(buf.peek());
        System.out.println(buf.poll());
        System.out.println(buf.poll());
        System.out.println(buf.poll());
        System.out.println(buf.getSize());
        for (int i: buf) {
            System.out.println(i);
        }
        buf.add(1);
        buf.add(2);
        buf.add(3);
        buf.add(5);
        buf.add(6);
        buf.add(7);
        buf.add(9);
        for (int i: buf) {
            System.out.println(i);
        }
        System.out.println(buf.getSize());
        System.out.println(buf.peek());
    }
}
