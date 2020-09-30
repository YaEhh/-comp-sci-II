import java.util.ArrayList;

public class AccessCountArrayList<E> extends ArrayList<E> {
	private int counter;
	
	public AccessCountArrayList() {
		this.counter = 0;
	}
	@Override
	public E get(int idx) {
		counter++;
		return super.get(idx);
	}
	
	@Override
	public E set(int idx, E element) {
		counter++;
		return super.set(idx, element); 
	}
	
	public int getAccessCount() {
		return counter;
	}
	
	public void resetCount() {
		counter = 0 ;
	}

}
