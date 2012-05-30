package views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import views.components.NicePanel;

public class ResultatenScherm extends NicePanel {
	private JTextField txtAthene;
	private JTextField txtAthene_1;
	private JTextField txtAthene_2;
	private JTextField txtAthene_3;
	private JTextField txtAthene_4;
	private JTextField txtAthene_5;
	private JTextField txtAthene_6;
	private JTextField txtAthene_7;
	private JTextField txtGoed;
	private JTextField txtFout;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtFout_1;
	private JTextField textField_4;
	private JTextField txtFout_2;
	private JTextField txtFout_3;

	/**
	 * Create the panel.
	 * @param mainWindow 
	 */
	public ResultatenScherm(MainWindow mainWindow) {
		
		JButton btnNewButton = new JButton("Verder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		txtAthene = new JTextField();
		txtAthene.setText("Athene");
		txtAthene.setColumns(10);
		
		txtAthene_1 = new JTextField();
		txtAthene_1.setText("Athene");
		txtAthene_1.setColumns(10);
		
		JEditorPane dtrpnScore = new JEditorPane();
		dtrpnScore.setEditable(false);
		dtrpnScore.setText("Aantal goed: 5 \r\n Aantal fout: 4 \r\n Aantal joker gebruikt: 0     \r\n \r\n Score: 1500 \r\n \r\n Tijd: 90 sec");
		
		txtAthene_2 = new JTextField();
		txtAthene_2.setText("Athene");
		txtAthene_2.setColumns(10);
		
		txtAthene_3 = new JTextField();
		txtAthene_3.setText("Athene");
		txtAthene_3.setColumns(10);
		
		txtAthene_4 = new JTextField();
		txtAthene_4.setText("Athene");
		txtAthene_4.setColumns(10);
		
		txtAthene_5 = new JTextField();
		txtAthene_5.setText("Athene");
		txtAthene_5.setColumns(10);
		
		txtAthene_6 = new JTextField();
		txtAthene_6.setText("athene");
		txtAthene_6.setColumns(10);
		
		txtAthene_7 = new JTextField();
		txtAthene_7.setText("athene");
		txtAthene_7.setColumns(10);
		
		txtGoed = new JTextField();
		txtGoed.setText("Goed");
		txtGoed.setColumns(10);
		
		txtFout = new JTextField();
		txtFout.setText("Fout");
		txtFout.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("Goed");
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setText("Goed");
		textField_2.setColumns(10);
		
		txtFout_1 = new JTextField();
		txtFout_1.setText("Fout");
		txtFout_1.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setText("Goed");
		textField_4.setColumns(10);
		
		txtFout_2 = new JTextField();
		txtFout_2.setText("Fout");
		txtFout_2.setColumns(10);
		
		txtFout_3 = new JTextField();
		txtFout_3.setText("fout");
		txtFout_3.setColumns(10);
		
		JButton btnStoppen = new JButton(" Stoppen");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(115)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtAthene_5, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtAthene_4, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFout_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(txtAthene, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtAthene_7, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtAthene_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtAthene_3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtAthene_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(txtGoed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtFout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtFout_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(txtAthene_6, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtFout_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
							.addComponent(dtrpnScore, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(btnStoppen, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addGap(70))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(dtrpnScore, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnStoppen, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtGoed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAthene, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAthene_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAthene_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAthene_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAthene_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFout_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAthene_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAthene_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFout_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAthene_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFout_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(140))
		);
		setLayout(groupLayout);

	}
}
