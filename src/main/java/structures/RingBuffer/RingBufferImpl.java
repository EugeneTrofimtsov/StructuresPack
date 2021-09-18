package structures.RingBuffer;

import java.lang.reflect.Array;
import java.util.Iterator;

public class RingBufferImpl<E> implements RingBuffer<E> {
    private final int capacity;
    private int writePos = 0;
    private int available = 0;
    private final E[] buf;

    public RingBufferImpl(Class<E> clazz, int capacity) {
        this.capacity = capacity;
        buf = (E[]) Array.newInstance(clazz, capacity);
    }

    public void add(E item) {
        if (writePos >= capacity) {
            writePos = 0;
        }
        buf[writePos] = item;
        writePos++;
        if (available < capacity) {
            available++;
        }
    }

    public E poll() {
        if (available == 0) {
            return null;
        }
        E elem = buf[getStartPos()];
        available--;
        return elem;
    }

    public E peek() {
        if (available == 0) {
            return null;
        }
        return buf[getStartPos()];
    }

    public int getSize() {
        return available;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int currentCount = available;
            private int currentIndex = getStartPos();

            public boolean hasNext() {
                return currentCount != 0;
            }

            public E next() {
                --currentCount;
                if (currentIndex == capacity)
                    currentIndex = 0;
                return buf[currentIndex++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private int getStartPos() {
        int startPos = writePos - available;
        if (startPos < 0) {
            startPos += capacity;
        }
        return startPos;
    }
}
