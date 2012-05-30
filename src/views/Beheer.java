package views;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class Beheer extends JPanel {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 800, 600);
					frame.setVisible(true);
					Beheer ko = new Beheer();
					frame.setContentPane(ko);
					ko.updateUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the panel.
	 */
	public Beheer() {
		setBounds(0, 0, 800, 600);
		setLayout(new MigLayout("", "[pref!,grow,left][200.00,grow]", "[200.00,grow][-92.00]"));
		
		JPanel panel = new JPanel();
		add(panel, "flowx,cell 0 0,alignx left,growy");
		panel.setLayout(new MigLayout("", "[grow,fill]", "[][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Onderwerpen:");
		panel.add(lblNewLabel, "cell 0 0");
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Topografie", "Mensen", "Techniek"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(1);
		panel.add(list, "cell 0 1,grow");
		
		JButton btnToevoegen = new JButton("Toevoegen");
		panel.add(btnToevoegen, "cell 0 2");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 1 0,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow][grow]"));
		
		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Wie is deze bekende Nederlander?"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_1.add(list_1, "cell 0 0,grow");
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "cell 0 1,grow");
		
	}

}
