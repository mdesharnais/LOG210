package hotel.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import hotel.Reservation;
import hotel.Room;
import hotel.Room.Categorie;
import hotel.util.ObservableList;

public class TestGui extends JPanel {
	public TestGui() {
		super(new BorderLayout()); 
		
		comboBox = new ComboBox<Room.Categorie>(roomCategories);
		
		roomCategories.add(new Room.Categorie("Cheap"));
		roomCategories.add(new Room.Categorie("Normal"));
		roomCategories.add(new Room.Categorie("Deluxe"));
		

		//comboBox.setSelectedIndex(4);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox)event.getSource();
				Room.Categorie categorie = (Room.Categorie)comboBox.getSelectedItem();
				JOptionPane.showMessageDialog(null, "Room categorie with id " + categorie.getId() + " selected.", "title", JOptionPane.INFORMATION_MESSAGE);
			}
		});

        //Lay out the demo.
        add(comboBox, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        
        table = new JTable(new MyTableModel(reservationDetails));
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
        
        JPanel buttonsPannel = new JPanel();
        buttonsPannel.setLayout(new BoxLayout(buttonsPannel, BoxLayout.LINE_AXIS));
        
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				reservationDetails.add(new Reservation.Detail());
			}
        });
        
        buttonsPannel.add(addButton);
        
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				reservationDetails.remove(table.getSelectedRow());
			}
        });
        
        buttonsPannel.add(removeButton);
        
        JButton testButton = new JButton("test");
        testButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!reservationDetails.isEmpty())
					reservationDetails.get(0).setQuantity(10);
				
				if (!roomCategories.isEmpty())
					roomCategories.get(0).setName("test");
			}
        });
        
        buttonsPannel.add(testButton);
        
        LinkLabel testLinkLabel = new LinkLabel("test");
        testLinkLabel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(TestGui.this, "test", "test", JOptionPane.INFORMATION_MESSAGE);
			}
        });
        
        buttonsPannel.add(testLinkLabel);
        
        add(buttonsPannel, BorderLayout.PAGE_END);
        
	}
	
	class MyTableModel extends AbstractTableModel {
		
		// +-----------+----------+
		// | Categorie | Quantite |
		// +-----------+----------+
		// |           |          |
		
        private String[] columnNames = {"Categorie", "Quantite"};
        private ObservableList<Reservation.Detail> data;
        private Observer reservationDetailChanged;
        
        public MyTableModel(ObservableList<Reservation.Detail> reservationDetails) {
        	data = reservationDetails;
        	reservationDetailChanged = new Observer() {
				@Override
				public void update(Observable o, Object arg) {
					Reservation.Detail obj = (Reservation.Detail)o;
					
					for (int i = 0; i < data.size(); ++i) {
						if (obj.getId() == data.get(i).getId())
							fireTableRowsUpdated(i,i);
					}
				}
    		};
        	
        	data.AddElementAddedListener(new Observer() {
				@Override
				public void update(java.util.Observable arg0, Object arg1) {
					for (Reservation.Detail detail : data) {
						detail.deleteObserver(reservationDetailChanged);
		        		detail.addObserver(reservationDetailChanged);
					}
					fireTableDataChanged();
				}
        	});
        	
        	data.AddElementRemovedListener(new Observer() {
				@Override
				public void update(java.util.Observable arg0, Object arg1) {
					fireTableDataChanged();
				}
        	});
        	
        	for (Reservation.Detail detail : data) {
        		detail.addObserver(reservationDetailChanged);
        	}
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
        	Object result = null;
        	Reservation.Detail detail = data.get(row);
        	
            switch (col) {
            	case 0: result = detail.getCategorie(); break;
            	case 1: result = detail.getQuantity();  break;
            }
            
            return result;
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int col) {
        	Class result = null;
        	
            switch (col) {
            	case 0: result = Room.Categorie.class; break;
            	case 1: result = Integer.class;        break;
            }
            
            return result;
        }

        public boolean isCellEditable(int row, int col) {
            return true;
        }

        public void setValueAt(Object value, int row, int col) {
        	Reservation.Detail detail = data.get(row);
        	
            switch (col) {
        		case 0: detail.setCaterorie((Categorie)value);           break;
        		case 1: detail.setQuantity(((Integer)value).intValue()); break;
            }
        	
            fireTableCellUpdated(row, col);
        }
    }
	
	private JTable                            table;
	private ComboBox<Room.Categorie>          comboBox;
	private ObservableList<Room.Categorie>    roomCategories = new ObservableList<Room.Categorie>();
	private ObservableList<Reservation.Detail> reservationDetails = new ObservableList<Reservation.Detail>();
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ComboBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new TestGui();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

	
	public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
