/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.gui;

import hotel.Client;
import hotel.Reservation;
import hotel.ReservationSystem;
import hotel.Room;
import hotel.Room.Category;
import hotel.util.ObservableList;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Marc-Andre
 */
public class ReservationForm extends javax.swing.JFrame {

    /**
     * Creates new form Reservation
     */
    public ReservationForm() {
    	GUI.initLookAndFeel();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        //ComboBoxClient = new javax.swing.JComboBox();
        ComboBoxClient = new hotel.gui.ComboBox<hotel.Client>(hotel.Hotel.getInstance().getClients());
        jScrollPane1 = new javax.swing.JScrollPane();
        TableReservation = new javax.swing.JTable();
        ButtonAdd = new javax.swing.JButton();
        ButtonDelete = new javax.swing.JButton();
        ButtonClose = new javax.swing.JButton();
        ButtonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Réservation");
        setResizable(false);

        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Client:");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        ComboBoxClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxClientActionPerformed(evt);
            }
        });

        TableReservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] { },
            new String [] { "ID", "Catégorie", "Quantité", "Date d'arrivé", "Date de départ"}) {
        	
            Class[] types = new Class [] {
                Integer.class, Room.Category.class, String.class, Object.class, Object.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int row, int column) {
            	return false;
            }
        });

        TableReservation.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TableColumn column = TableReservation.getColumnModel().getColumn(0);
        TableReservation.getColumnModel().removeColumn(column);
        
        reservationSystem.addReservationDetailAddedListener(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				Reservation.Detail detail = (Reservation.Detail) arg;
				DefaultTableModel model = (DefaultTableModel) TableReservation.getModel();
				
				model.addRow(new Object[] {detail.getId(), detail.getCategory(), detail.getQuantity(), detail.getArrival(), detail.getDeparture()});
			}
        });
        
        reservationSystem.addReservationDetailRemovedListener(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				Reservation.Detail detail = (Reservation.Detail) arg;
				DefaultTableModel model = (DefaultTableModel) TableReservation.getModel();
				
				for (int i = 0; i < model.getRowCount(); ++i) {
					if (detail.getId() == (Integer) model.getValueAt(i, 0)) {
						model.removeRow(i);
						break;
					}
				}
			}
        });

        jScrollPane1.setViewportView(TableReservation);

        ButtonAdd.setText("+");
        ButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionPerformed(evt);
            }
        });

        ButtonDelete.setText("-");
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });

        ButtonClose.setText("Fermer");
        ButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCloseActionPerformed(evt);
            }
        });

        ButtonSave.setText("Enregistrer");
        ButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxClient, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ComboBoxClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonAdd)
                    .addComponent(ButtonDelete)
                    .addComponent(ButtonSave)
                    .addComponent(ButtonClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void ComboBoxClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxClientActionPerformed

    private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionPerformed
    	ReservationDetailForm.showDialog(this, this, reservationSystem);
    }//GEN-LAST:event_ButtonAddActionPerformed

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
    	int rowIndex = TableReservation.getSelectedRow();
    	if (rowIndex != -1) {
    		javax.swing.table.DefaultTableModel model = (DefaultTableModel) TableReservation.getModel();
    		int id = (Integer) model.getValueAt(rowIndex, 0);
    		reservationSystem.removeLine(id);
    	}
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void ButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCloseActionPerformed
    	Client client = ComboBoxClient.getSelectedItem();
        reservationSystem.confirm(client.getName(), client.getTelephoneNumber());
        dispose();
    }//GEN-LAST:event_ButtonCloseActionPerformed
    
    private void ButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCloseActionPerformed
    	dispose();
    }//GEN-LAST:event_ButtonCloseActionPerformed
    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        javax.swing.JOptionPane.showMessageDialog(null, "test");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ReservationForm().setVisible(true);
            }
        });
    }
    private hotel.ReservationSystem reservationSystem = new hotel.ReservationSystem();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonClose;
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonSave;
    private hotel.gui.ComboBox<hotel.Client> ComboBoxClient;
    private com.toedter.calendar.JDateChooser DateChooserArrival;
    private com.toedter.calendar.JDateChooser DateChooserDeparture;
    private javax.swing.JTable TableReservation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}