package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import net.miginfocom.swing.MigLayout;
import views.components.NiceButton;
import views.components.NicePanel;
import controllers.Spel;

public class Highscore extends NicePanel {

	private JTable	table;

	/**
	 * Create the frame.
	 */
	public Highscore(final Spel spel) {
		setBounds(0, 0, 800, 600);
		setLayout(new MigLayout("", "[grow][400px:n][grow]", "[80.00][450.00,grow][40.00][10.00,grow]"));

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

		JLabel lblNewLabel_1 = new JLabel("Rang         Naam        Prijs      Tijd");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);


		
		final ArrayList<logic.Highscore> highscores = spel.getHighscores(10);
		DefaultTableModel model = new DefaultTableModel();
		
		
		//model.addRow(new Object[]{"","","",""});
		int i = 1;
		for (logic.Highscore score : highscores) {
			model.addColumn(score.getSpelerNaam());
			System.out.println(score.getSpelerNaam());
			/*model.addRow(new Object[]{
					i + "",
					score.getSpelerNaam(),
					score.getScore(),
					score.getTijdOver()+" s"});*/
			i++;
		}
		final String[] columnNames = {"Rang", "Naam", "Prijs", "Tijd"};
		table = new JTable(new AbstractTableModel() {
		    public String getColumnName(int col) {
		        return columnNames[col].toString();
		    }
		    public int getRowCount() { return highscores.size(); }
		    public int getColumnCount() { return columnNames.length; }
		    public Object getValueAt(int row, int col) {
		    	switch(col) {
		    		case 0: return (row + 1) + "";
		    		case 1: return highscores.get(row).getSpelerNaam();
		    		case 2: return highscores.get(row).getScore();
		    		case 3: return highscores.get(row).getTijdOver() + "s";
		    		default: return "";
		    	}
		    }
		    public boolean isCellEditable(int row, int col){ return false; }
		    public void setValueAt(Object value, int row, int col) {}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		// table = new JTable(model);
		table.setRowHeight(60);

		TableCellRenderer renderer = new TableCellRenderer() {
			JLabel	label	= new JLabel();

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				label.setOpaque(true);
				label.setText("" + value);
				label.setForeground(new Color(255, 255, 255));
				if (row % 2 == 0)
					label.setBackground(new Color(31, 31, 31));
				else label.setBackground(new Color(41, 41, 41));
				label.setFont(new Font("Arial", Font.PLAIN, 20));
				Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

				if (column == 0) {
					label.setForeground(new Color(168, 168, 168));
					label.setFont(new Font("Arial", Font.BOLD, 30));
				}
				label.setBorder(paddingBorder);
				label.setHorizontalAlignment(SwingConstants.LEFT);
				return label;
			}
		};
		table.setDefaultRenderer(Object.class, renderer);
		table.setEnabled(true);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setShowGrid(false);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.setBorder(null);
		
		add(table, "cell 1 1,grow");
		add(btnTerug, "cell 1 2,grow");
		
	}
}
