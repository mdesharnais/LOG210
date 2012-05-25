package hotel.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Observer;

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
		elementAdded.notifyObservers(this);
		return result;
	}
	
	@Override
	public void add(int index, T element) {
		data.add(index, element);
		elementAdded.notifyObservers(this);
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean result = data.addAll(c);
		elementAdded.notifyObservers(this);
		return result;
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		boolean result = data.addAll(index, c);
		elementAdded.notifyObservers(this);
		return result;
	}
	
	@Override
	public void clear() {
		data.clear();
		elementRemoved.notifyObservers(this);
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
	public boolean remove(Object o) {
		boolean result = data.remove(o);
		elementRemoved.notifyObservers(this);
		return result;
	}
	
	@Override
	public T remove(int index) {
		T result = data.remove(index);
		elementRemoved.notifyObservers(this);
		return result;
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		boolean result = data.removeAll(c);
		elementRemoved.notifyObservers(this);
		return result;
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		boolean result = data.retainAll(c);
		elementRemoved.notifyObservers(this);
		return result;
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
