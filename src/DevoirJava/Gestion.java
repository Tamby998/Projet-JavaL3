package DevoirJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Gestion extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtnom;
	private JTextField txtprenom;
	private JTextField txtnote;
	private JTable table;
	private JTextField txtrecherche;

	/**
	 * Launch the application.
	 */
	Connecter conn = new Connecter();
	Statement stm;
	ResultSet rs;
	DefaultTableModel model = new DefaultTableModel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion frame = new Gestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnRecherche = new JButton("Recherche : ");
		GridBagConstraints gbc_btnRecherche = new GridBagConstraints();
		gbc_btnRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecherche.gridx = 1;
		gbc_btnRecherche.gridy = 0;
		contentPane.add(btnRecherche, gbc_btnRecherche);
		
		txtrecherche = new JTextField();
		GridBagConstraints gbc_txtrecherche = new GridBagConstraints();
		gbc_txtrecherche.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtrecherche.insets = new Insets(0, 0, 5, 0);
		gbc_txtrecherche.gridx = 2;
		gbc_txtrecherche.gridy = 0;
		contentPane.add(txtrecherche, gbc_txtrecherche);
		txtrecherche.setColumns(10);
		
		JLabel lblId = new JLabel("id :");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 2;
		contentPane.add(lblId, gbc_lblId);
		
		txtid = new JTextField();
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtid.gridx = 1;
		gbc_txtid.gridy = 2;
		contentPane.add(txtid, gbc_txtid);
		txtid.setColumns(10);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 2;
		gbc_table.gridy = 2;
		contentPane.add(table, gbc_table);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 3;
		contentPane.add(lblNom, gbc_lblNom);
		
		txtnom = new JTextField();
		txtnom.setColumns(10);
		GridBagConstraints gbc_txtnom = new GridBagConstraints();
		gbc_txtnom.insets = new Insets(0, 0, 5, 5);
		gbc_txtnom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnom.gridx = 1;
		gbc_txtnom.gridy = 3;
		contentPane.add(txtnom, gbc_txtnom);
		
		JButton button = new JButton("Actualiser");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 2;
		gbc_button.gridy = 3;
		contentPane.add(button, gbc_button);
		
		JLabel lblPreenom = new JLabel("Prenom :");
		lblPreenom.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblPreenom = new GridBagConstraints();
		gbc_lblPreenom.anchor = GridBagConstraints.EAST;
		gbc_lblPreenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreenom.gridx = 0;
		gbc_lblPreenom.gridy = 4;
		contentPane.add(lblPreenom, gbc_lblPreenom);
		
		txtprenom = new JTextField();
		GridBagConstraints gbc_txtprenom = new GridBagConstraints();
		gbc_txtprenom.insets = new Insets(0, 0, 5, 5);
		gbc_txtprenom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtprenom.gridx = 1;
		gbc_txtprenom.gridy = 4;
		contentPane.add(txtprenom, gbc_txtprenom);
		txtprenom.setColumns(10);
				
				JButton btnModifier = new JButton("Modifier");
				GridBagConstraints gbc_btnModifier = new GridBagConstraints();
				gbc_btnModifier.insets = new Insets(0, 0, 5, 0);
				gbc_btnModifier.gridx = 2;
				gbc_btnModifier.gridy = 4;
				contentPane.add(btnModifier, gbc_btnModifier);
		
				
				JLabel lblNote = new JLabel("Note :");
				lblNote.setFont(new Font("Times New Roman", Font.BOLD, 14));
				GridBagConstraints gbc_lblNote = new GridBagConstraints();
				gbc_lblNote.anchor = GridBagConstraints.EAST;
				gbc_lblNote.insets = new Insets(0, 0, 5, 5);
				gbc_lblNote.gridx = 0;
				gbc_lblNote.gridy = 5;
				contentPane.add(lblNote, gbc_lblNote);
		
		txtnote = new JTextField();
		GridBagConstraints gbc_txtnote = new GridBagConstraints();
		gbc_txtnote.insets = new Insets(0, 0, 5, 5);
		gbc_txtnote.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnote.gridx = 1;
		gbc_txtnote.gridy = 5;
		contentPane.add(txtnote, gbc_txtnote);
		txtnote.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 0);
		gbc_btnAjouter.gridx = 2;
		gbc_btnAjouter.gridy = 5;
		contentPane.add(btnAjouter, gbc_btnAjouter);
		
		JButton btnAnnuler = new JButton("Annuler");
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 1;
		gbc_btnAnnuler.gridy = 6;
		contentPane.add(btnAnnuler, gbc_btnAnnuler);
		
		JButton btnSupprimer = new JButton("Supprimer");
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimer.gridx = 2;
		gbc_btnSupprimer.gridy = 6;
		contentPane.add(btnSupprimer, gbc_btnSupprimer);
		
		model.addColumn("id");
		model.addColumn("nom");
		model.addColumn("prenom");
		model.addColumn("branche");
		model.addColumn("note");
		try {
		stm = conn.obtenirConnexion().createStatement();
		ResultSet res = stm.executeQuery("Select * from etudient");
		while(res.next()){
		model.addRow(new Object[]{res.getString("id"),res.getString("Nom"),res.getString("Prenom"),res.getString("branche"),res.getString("note")});

		}
		}catch(Exception e){System.err.println(e);}
		table.setModel(model);
	}
	private void deplace(int i) {
		try {
			txtid.setText(model.getValueAt(i, 0).toString());
			txtnom.setText(model.getValueAt(i, 0).toString());
			txtprenom.setText(model.getValueAt(i, 0).toString());
			txtnote.setText(model.getValueAt(i, 0).toString());

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			JOptionPane.showMessageDialog(null, "erreur de deplaceent"+ e.getLocalizedMessage());
		}
	}
}
