package heap;

public interface PriorityQueue<Q> {
	int size();

	boolean isEmpty();

	Q insert(Q q);

	Q min();

	Q removeMin();
}
