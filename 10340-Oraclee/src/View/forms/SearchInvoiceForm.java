package view.forms;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import view.MainFrame;
import model.*;


/**
 * 
 * @author 	Ariel Levin
 * 			<br/><a href="http://about.me/ariel.levin">about.me/ariel.levin</a>
 * 			<br/><a href="mailto:ariel.lvn89@gmail.com">ariel.lvn89@gmail.com</a><br/><br/>
 * 
 * 			Matan Shulman
 * 			<br/><a href="mailto:matan.shulman87@gmail.com">matan.shulman87@gmail.com</a>
 *
 */
public class SearchInvoiceForm extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private MainFrame 	mainFrame;
	

	public SearchInvoiceForm(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e1) {}
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {


			}
		});
		
		setTitle("Search Invoice");
		setSize(new Dimension(320,130));
		
		initFrame();
		
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setVisible(true);
	}
	
	private void initFrame() {
		
		ArrayList<Invoice> invoices = mainFrame.getDB().getAllInvoice(false);
		JComboBox<Invoice> cb_invoice = new JComboBox<Invoice>();
		for (Invoice inv : invoices)
			cb_invoice.addItem(inv);

		getContentPane().setLayout(new BorderLayout());
		
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.PAGE_AXIS));
		
		pnlMain.add(Box.createRigidArea(new Dimension(0,10)));
		
		JLabel lblorder = new JLabel("Select an Invoice");
		lblorder.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlMain.add(lblorder);
		
		pnlMain.add(Box.createRigidArea(new Dimension(0,5)));
		
		pnlMain.add(cb_invoice);
		
		pnlMain.add(Box.createRigidArea(new Dimension(0,10)));

		JPanel pnlBtn = new JPanel();
		JButton btnCommit = new JButton("Commit");
		btnCommit.setPreferredSize(new Dimension(120,25));
		pnlBtn.add(btnCommit);
		pnlBtn.setBorder(new EmptyBorder(0, 20, 5, 20));
		add(pnlBtn, BorderLayout.SOUTH);
		
		add(pnlMain, BorderLayout.CENTER);
		add(Box.createRigidArea(new Dimension(15,0)), BorderLayout.EAST);
		add(Box.createRigidArea(new Dimension(15,0)), BorderLayout.WEST);
		
		btnCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mainFrame.showInvoice( (Invoice)cb_invoice.getSelectedItem() );
				dispose();
			}
		});
	}
	
}
