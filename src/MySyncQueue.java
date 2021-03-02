import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MySyncQueue<E> {

    private volatile AtomicInteger capacity;
    private volatile AtomicInteger size = new AtomicInteger(0);

    public MySyncQueue(AtomicInteger capacity) {
        this.capacity = capacity;
        head = tail = new Node<>(null);
    }

    Lock takeLock = new ReentrantLock();
    Lock putLock = new ReentrantLock();
    Condition fullCondition = putLock.newCondition();
    Condition notEmptyCondition = takeLock.newCondition();

    Node<E> head;

    Node<E> tail;

    //    private void enqueue(E e){
//        Node<E> next = new Node<>(e);
//        tail.next = next;
//        tail = next;
//    }
//
//    private E dequeue(){
//        Node<E> next = head.next;
//        head.next = next.next;
//        return next.getElement();
//    }
    private void enqueue(Node<E> item) {
        tail.next = item;
        tail = tail.next;
    }

    private E dequeue() {
        Node<E> firstDataNode = head.next;
        head.next = null;
        head = firstDataNode;
        E result = firstDataNode.element;
        firstDataNode.element = null;
        return result;
    }


    public boolean put(E e) throws InterruptedException {
        try {
            putLock.lock();
            while (!Thread.currentThread().isInterrupted() && capacity.get() <= size.get()) {
                fullCondition.await();
            }
            if(Thread.currentThread().isInterrupted()){
                throw new InterruptedException();
            }
            enqueue(new Node<>(e));
            size.getAndIncrement();
            signalTake();
            return true;
        } finally {
            putLock.unlock();
        }
    }

    private void signalTake() {
        takeLock.lock();
        notEmptyCondition.signalAll();
        takeLock.unlock();
    }

    private void signalPut() {
        putLock.lock();
        fullCondition.signalAll();
        putLock.unlock();
    }


    public E poll() throws InterruptedException {
        try {
            takeLock.lock();
            while (!Thread.currentThread().isInterrupted() && size.get() == 0) {
                notEmptyCondition.await();
            }
            if(Thread.currentThread().isInterrupted()){
                throw new InterruptedException();
            }
            E e = dequeue();
            size.getAndDecrement();
            signalPut();
            return e;
        } finally {
            takeLock.unlock();
        }
    }


    class Node<E> {

        private E element;

        private Node next;

        Node(E e) {
            this.element = e;
        }

        public E getElement() {
            return element;
        }
    }


}
