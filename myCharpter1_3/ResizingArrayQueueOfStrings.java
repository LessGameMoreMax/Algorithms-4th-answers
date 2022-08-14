package myCharpter1_3;

public class ResizingArrayQueueOfStrings {
	private String[] arr = new String[1];
	private int queueHead = 0;
	private int queueTail = 0;
	
	public boolean isEmpty() { return arr[queueHead] == null;}
	public int size()        { return (queueTail-queueHead+1); }
	
	public void enqueue(String unit) {
		if(queueTail==arr.length) {
			String[] temp =new String[2*(queueTail-queueHead+1)];
			for(int i = 0;i<(queueTail-queueHead);i++) {
				temp[i] = arr[queueHead+i];
			}
			if(queueTail == queueHead) temp[0] = arr[queueHead];
			arr = temp;
			queueTail = queueTail - queueHead;
			queueHead = 0;
		}
		arr[queueTail] = unit;
		queueTail++;
	}
	
	public String dequeue() {
//		if(queueHead==queueTail) {
//			if(arr[queueHead]==null) throw new RuntimeException("Queue is empty!");
//			else {
//				String temp = arr[queueHead];
//				arr[queueHead] = null;
//				return temp; 
//			}
//		}
//		else {
//			String temp = arr[queueHead];
//			arr[queueHead] = null;
//			queueHead++;
//			return temp;
//		}
		
		if(arr[queueHead]==null) throw new RuntimeException("Queue is empty!");
		else {
			if((queueTail-queueHead)<queueTail/2) {
				String[] temp =new String[queueTail/2+1];
				for(int i = 0;i<(queueTail-queueHead);i++) {
					temp[i] = arr[queueHead+i];
				}
				if(queueTail == queueHead) temp[0] = arr[queueHead];
				arr = temp;
				queueTail = queueTail - queueHead;
				queueHead = 0;
			}
			String temp = arr[queueHead];
			arr[queueHead] = null;
			if(queueHead<queueTail) queueHead++;
			return temp; 
		}
	}
}
