/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.gui;

import hotel.Reservation;
import hotel.ReservationSystem;
import hotel.Room;
import hotel.util.ValidationException;

import java.awt.Component;
import java.awt.Frame;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ReservationDetailForm extends JDialog {

	private static ReservationDetailForm dialog;
	private boolean saved = false;
	private ReservationSystem reservationSystem;
	private static final String ISO_8601_EXTENDED = "yyyy-MM-dd";
	
	public static boolean showDialog(Component frameComponent, Component locationComponent, ReservationSystem system) {
		Frame frame = JOptionPane.getFrameForComponent(frameComponent);
		dialog = new ReservationDetailForm(frame, locationComponent, system);
		dialog.setVisible(true);
		return dialog.saved;
	}
	
    /**
     * Creates new form ReservationDetailForm
     */
    private ReservationDetailForm(Frame frame, Component locationComponent, ReservationSystem system) {
    	super(frame, "Détail de réservation", true);
    	reservationSystem = system;
    	GUI.initLookAndFeel();
        initComponents();
        setLocationRelativeTo(locationComponent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ComboBoxCategorie = new hotel.gui.ComboBox<Room.Category>(hotel.Hotel.getInstance().getRoomCategories());
        SpinnerQuantity = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(0, 0, 9999, 1));
        DateArrival = new com.toedter.calendar.JDateChooser();
        DateDeparture = new com.toedter.calendar.JDateChooser();
        ButtonCancel = new javax.swing.JButton();
        ButtonOk = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter une chambre");
        setResizable(false);
        
        jLabel1 = new JLabel("Catégorie :");
        jLabel2 = new JLabel("Quantité :");
        jLabel3 = new JLabel("Date d'arrivée :");
        jLabel4 = new JLabel("Date de départ :");
        
        ComboBoxCategorie = new hotel.gui.ComboBox<Room.Category>(hotel.Hotel.getInstance().getRoomCategories());
        SpinnerQuantity = new JSpinner(new SpinnerNumberModel(Reservation.Detail.QUANTITY_MIN_VALUE, Reservation.Detail.QUANTITY_MIN_VALUE - 10, Reservation.Detail.QUANTITY_MAX_VALUE, 1));
        DateArrival = new com.toedter.calendar.JDateChooser(new Date(), ISO_8601_EXTENDED);
        Calendar cal = GregorianCalendar.getInstance();
        cal.add(Calendar.DATE, 1);
        DateDeparture = new com.toedter.calendar.JDateChooser(cal.getTime(), ISO_8601_EXTENDED);
        
        ButtonCancel = new javax.swing.JButton("Annuler");
        ButtonOk = new javax.swing.JButton("Ok");

        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        ButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboBoxCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SpinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateArrival, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonCancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ComboBoxCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(SpinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DateArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(DateDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancel)
                    .addComponent(ButtonOk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Code qui permet la gestion du bouton ok
     * @param evt
     */
    private void ButtonOkActionPerformed(java.awt.event.ActionEvent evt) {
    	try {
			reservationSystem.addLine(ComboBoxCategorie.getSelectedItem().getId(), ((Number)SpinnerQuantity.getValue()).intValue(), DateArrival.getDate(), DateDeparture.getDate());
			saved = true;
			dispose();
		} catch (ValidationException e) {
			JOptionPane.showMessageDialog(null, "Les données entrées sont incorrectes.");
		}
    }
    
    /**
     * Code qui permet la gestion du bouton cancel
     * @param evt
     */
    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
    	dispose();
    }
    
    public static void main(String args[]) {
        /*
		* Create and display the form
		*/
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                ReservationDetailForm.showDialog(null, null, new ReservationSystem());
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonOk;
    private hotel.gui.ComboBox<Room.Category> ComboBoxCategorie;
    private com.toedter.calendar.JDateChooser DateArrival;
    private com.toedter.calendar.JDateChooser DateDeparture;
    private javax.swing.JSpinner SpinnerQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
