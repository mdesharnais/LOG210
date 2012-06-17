package hotel.gui;

import hotel.util.Observable;
import hotel.util.ObservableList;
import hotel.util.Observer;

import javax.swing.JComboBox;

public class ComboBox<T extends Observable<T>> extends JComboBox {
	// --------------------------------------------------
	// Constructor(s)
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComboBox(ObservableList<T> l) {
		data = l;
		
		for (T t : data) {
			addItem(t);
			t.addObserver(new Observer<T>() {
				@Override
				public void update(T arg) {
					T item = getSelectedItem();
					
					removeAll();
					
					for (T t : data)
						addItem(t);
					
					setSelectedItem(item);
				}
			});
		}
		
		data.AddElementAddedListener(new Observer<T>() {
			@Override
			public void update(T obj) {
				addItem(obj);
			}
		});
		
		data.AddElementRemovedListener(new Observer<T>() {
			@Override
			public void update(T arg) {
				removeItem(arg);
			}
		});
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
	@SuppressWarnings("unchecked")
	@Override
	public T getSelectedItem() {
		return (T)super.getSelectedItem();
	}
	
	// --------------------------------------------------
	// Mutators(s)
	
	// --------------------------------------------------
	// Method(s)
	
	// --------------------------------------------------
	// Attribute(s)
	
	ObservableList<T> data;
}
