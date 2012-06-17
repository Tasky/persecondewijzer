package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import net.miginfocom.swing.MigLayout;
import views.components.NiceButton;
import views.components.NicePanel;
import controllers.Spel;

public class Highscore extends NicePanel {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 800, 600);
					frame.setVisible(true);
					Highscore ko = new Highscore(null);
					frame.setContentPane(ko);
					ko.updateUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable	table;

	/**
	 * Create the frame.
	 */
	public Highscore(final Spel spel) {
		setBounds(0, 0, 800, 600);
		setLayout(new MigLayout("", "[grow][400px:n][grow]", "[80.00][10.00,grow][][450.00,grow][40.00][10.00,grow]"));

		JLabel lblNewLabel = new JLabel("Highscores");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		add(lblNewLabel, "cell 1 0,alignx center,aligny center");

		NiceButton btnTerug = new NiceButton("Terug");
		btnTerug.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				spel.backToMainMenu();
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Rang         Naam        Punten      Tijd");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		//add(lblNewLabel_1, "cell 1 2");

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] { { "1", "Jodi", "7500", "5:00" },
				{ "2", "Nanne", "300", "0:10" }, { "3", "Bas", "1", "0:01" }, }, new String[] { "Rang", "Naam",
				"Prijzengeld", "Tijd over" }));
		
		//table = new JTable(model);
		table.setRowHeight(60);
		
		TableCellRenderer renderer = new TableCellRenderer() {
	        JLabel label = new JLabel();
	        public Component getTableCellRendererComponent(JTable table,
	                Object value, boolean isSelected, boolean hasFocus,
	                int row, int column) {
	            label.setOpaque(true);
	            label.setText("" + value);
	            label.setForeground(new Color(255,255,255));
	            if (row % 2 == 0) {
	            	label.setBackground(new Color(31, 31, 31));
	            	//label.setBackground(new Color(255, 255, 255));
	            } else {
	            	label.setBackground(new Color(41, 41, 41));
	            	//label.setBackground(new Color(242, 242, 242));
	            }
	            label.setFont(new Font("Arial", Font.PLAIN, 20));
	            Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
	            
	            if(column == 0) {
	            	label.setForeground(new Color(168, 168, 168));
	            	label.setFont(new Font("Arial", Font.BOLD, 30));
	            }
	            label.setBorder(paddingBorder);
//	            if (row == 0) {
//	                label.setHorizontalAlignment(SwingConstants.CENTER);
//	            } else {
	            	label.setHorizontalAlignment(SwingConstants.LEFT);
//	            }
	            return label;
	        }
	    };
	    table.setDefaultRenderer(Object.class, renderer);
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setShowGrid(false);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setBorder(null);
		
		add(table, "cell 1 3,grow");
		add(btnTerug, "cell 1 4,grow");

	}
}
