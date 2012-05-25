package hotel.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hotel.Room;

public class TestGui extends JPanel {
	public TestGui() {
		super(new BorderLayout());
		ArrayList<Room.Categorie> v = new ArrayList<Room.Categorie>();
		
		comboBox = new JComboBox();
		comboBox.addItem(new Room.Categorie("Cheap"));
		comboBox.addItem(new Room.Categorie("Normal"));
		comboBox.addItem(new Room.Categorie("Deluxe"));

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

	}
	
	private JComboBox comboBox;
	
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
