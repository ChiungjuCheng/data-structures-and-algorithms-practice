package heap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Heap<Q> extends AbstractPriorityQueue<Q> {
	
	List<Entry> heap = new ArrayList<>();
	
	public Heap(Collection c) {
		heapify();
	}
	
	/**
	 * 將傳入的陣列整理成heap
	 */
	private void heapify() {
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Q insert(Q q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Q min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Q removeMin() {
		// TODO Auto-generated method stub
		return null;
	}


}
