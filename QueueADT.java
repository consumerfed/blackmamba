/**
 * Implementing queue in java using 
 * 
 * Here i wrote a sample program to implement queue in java
 * 
 */
package com.belazy.algorithm;

/**
 * @author consumerfed Triveni kozhikode
 * 
 */
public class QueueADT {

	private Object[] queueArray = null;
	private int MAX_SIZE = 5;
	int front = 0;
	int rear = 0;
	int size = 0;

	public QueueADT() {
		queueArray = new Object[MAX_SIZE];
	}

	public void enqueue(Object value) {
		if (!isFull()) {
			queueArray[rear] = value;
			rear = rear - 1;
			if (rear < 0) {
				rear = MAX_SIZE - 1;
			}
			size = size + 1;
			System.out.println(" value :"+value + " front :"+front + "rear : "+rear);
		} else {
			System.out.println(" The Queue is full ");
		}

	}

	public Object dequeue() {
		Object obj = null;
		if (isEmpty()) {
			System.out.println(" The Queue is empty ");
		} else {
			obj = queueArray[front];
			queueArray[front] = null;
			front = front - 1;
			if (front < 0) {
				front = MAX_SIZE - 1;
			}
			size = size - 1;
			System.out.println(" value :"+obj + " front :"+front + "rear : "+rear);
			System.out.println(" The element removed is "+obj);
		}
		return obj;
	}

	public void peek() {
		if (!isEmpty())
			System.out.println(" The front element is " + queueArray[front]);
	}

	private boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;

	}

	private boolean isFull() {
		if (size == MAX_SIZE) {
			return true;
		}
		return false;
	}

	public void showElements() {
		int i = 0;
		for (Object obj : queueArray) {
			System.out.println(i + " th position element is " + obj);
			i++;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueADT queueADT = new QueueADT();
		queueADT.enqueue(new Integer(1));
		queueADT.enqueue(new Integer(2));
		queueADT.enqueue(new Integer(3));
		queueADT.enqueue(new Integer(4));
		queueADT.enqueue(new Integer(5));
		queueADT.enqueue(new Integer(6));

		queueADT.peek();

//		queueADT.showElements();

		queueADT.dequeue();
		queueADT.dequeue();
		queueADT.dequeue();
		queueADT.dequeue();
		queueADT.dequeue();
		queueADT.dequeue();

		queueADT.peek();

//		queueADT.showElements();
		queueADT.enqueue(new Integer(6));
		queueADT.peek();

	}

}
