package hotel.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Observer;


/**
 * Container adapter informing listeners when a new element is inserted or remove from the list.
 *
 * @param <T> Type of the list elements.
 */
public class ObservableList<T>
	implements List<T> {
	
	// --------------------------------------------------
	// Constructor(s)
	
	public ObservableList() {
		this(new ArrayList<T>());
	}
	
	public ObservableList(List<T> list) {
		data = list;
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	@Override
	public boolean contains(Object o) {
		return data.contains(o);
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		return data.containsAll(c);
	}
	
	@Override
	public int indexOf(Object o) {
		return data.indexOf(o);
	}
	
	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	@Override
	public int lastIndexOf(Object o) {
		return data.lastIndexOf(o);
	}
	
	public int size() {
		return data.size();
	}
	
	public T get(int index) {
		return data.get(index);
	}
	
	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return data.subList(fromIndex, toIndex);
	}
	
	@Override
	public Object[] toArray() {
		return data.toArray();
	}
	
	@Override
	public <U> U[] toArray(U[] a) {
		return data.toArray(a);
	}
	// --------------------------------------------------
	// Mutators(s)
	
	@Override
	public boolean add(T element) {
		boolean result = data.add(element);
		elementAdded.notifyObservers(element);
		return result;
	}
	
	@Override
	public void add(int index, T element) {
		data.add(index, element);
		elementAdded.notifyObservers(element);
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c) {
		if (c.isEmpty())
			return false;
		
		for (T t : c) {
			data.add(t);
			elementAdded.notifyObservers(t);
		}
		
		return true;
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		if (c.isEmpty())
			return false;
		
		for (T t : c) {
			data.add(index++, t);
			elementAdded.notifyObservers(t);
		}
		
		return true;
	}
	
	@Override
	public void clear() {
		for (T t : data) {
			data.remove(t);
			elementRemoved.notifyObservers(t);
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return data.iterator();
	}
	
	@Override
	public ListIterator<T> listIterator() {
		return data.listIterator();
	}
	
	@Override
	public ListIterator<T> listIterator(int index) {
		return data.listIterator(index);
	}
	
	@Override
	public boolean remove(Object element) {
		boolean result = data.remove(element);
		elementRemoved.notifyObservers(element);
		return result;
	}
	
	@Override
	public T remove(int index) {
		T element = data.remove(index);
		elementRemoved.notifyObservers(element);
		return element;
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean listChanged = false;
		
		for (Object o : c) {
			if (data.contains(o)) {
				data.remove(o);
				elementRemoved.notifyObservers(o);
				listChanged = true;
			}
		}
		
		return listChanged;
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		boolean listChanged = false;
		
		for (Object o : data) {
			if (!c.contains(o)) {
				data.remove(o);
				elementRemoved.notifyObservers(o);
				listChanged = true;
			}
		}
		
		return listChanged;
	}
	
	@Override
	public T set(int index, T element) {
		return data.set(index, element);
	}
	
	// --------------------------------------------------
	// Method(s)
	
	public void AddElementAddedListener(Observer observer) {
		elementAdded.addObserver(observer);
	}
	
	public void AddElementRemovedListener(Observer observer) {
		elementRemoved.addObserver(observer);
	}
	
	// --------------------------------------------------
	// Attribute(s)
	
	private List<T>               data;
	private hotel.util.Observable elementAdded = new hotel.util.Observable();
	private hotel.util.Observable elementRemoved = new hotel.util.Observable();
}
