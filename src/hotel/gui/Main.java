package hotel.gui;

import javax.swing.JOptionPane;

import hotel.Agenda;

public class Main {
	public static void main(String[] args) {
		boolean connected = false /* LoginForm.showDialog() */;
		
		if (connected) {
			java.awt.EventQueue.invokeLater(new Runnable() {

	            public void run() {
	                new ReservationList(Agenda.getInstance()).setVisible(true);
	            }
	        });
		}
	}
}
