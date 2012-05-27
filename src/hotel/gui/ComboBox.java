package hotel.gui;

import java.util.Observable;
import java.util.Observer;

import hotel.util.ObservableList;

import javax.swing.JComboBox;

public class ComboBox<T extends Observable> extends JComboBox {
	// --------------------------------------------------
	// Constructor(s)
	
	public ComboBox(ObservableList<T> l) {
		data = l;
		
		for (T t : data) {
			addItem(t);
			t.addObserver(new Observer() {
				@Override
				public void update(Observable o, Object arg) {
					T item = getSelectedItem();
					
					removeAll();
					
					for (T t : data)
						addItem(t);
					
					setSelectedItem(item);
				}
			});
		}
		
		data.AddElementAddedListener(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				addItem(arg);
			}
		});
		
		data.AddElementRemovedListener(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				removeItem(arg);
			}
		});
	}
	
	// --------------------------------------------------
	// Accessor(s)
	
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
