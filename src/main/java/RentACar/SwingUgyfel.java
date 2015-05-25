package RentACar;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SwingUgyfel extends JFrame {

	
	private JPanel contentPane;
	private JLabel labelÜgyfelek;
	private JRadioButton radioButtonÜgyT;
	private JButton buttonVissza;
	private JButton buttonOk;
	private JTable table;
	private JLabel labelBekapcs;

	
	public SwingUgyfel() {
		
		LinkedList<Berles> lista = new LinkedList<Berles>();
		Adatbazis a = new Adatbazis();
		
		setTitle("RentACar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		labelÜgyfelek = new JLabel("Ügyfelek:");
		labelÜgyfelek.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelÜgyfelek.setBounds(24, 11, 94, 18);
		contentPane.add(labelÜgyfelek);
		
		lista = a.bérlésTáblaLekérdezése();
		a.kapcsolatZárása();
		
		String s[] = { "Ugyfel kod", "Auto kod", "Berles kezdete", "Berles vege"};
		Object [][]o = new Object[lista.size()][4];
		
		int i = 0;
		for(Berles b : lista){
			o[i][0] = b.a.azonosító;
			o[i][1] = b.u.ügyfelAzon;
			o[i][2] = b.bérlésKezd;
			o[i][3] = b.bérlésVége;
			
			++i;
		}
		
		table = new JTable(o, s);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(20, 40, 390, 157);
		contentPane.add(table);
		
		radioButtonÜgyT = new JRadioButton("Ügyfél lista törlése");
		radioButtonÜgyT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		radioButtonÜgyT.setBounds(24, 204, 156, 23);
		contentPane.add(radioButtonÜgyT);
		
		buttonVissza = new JButton("Vissza");
		buttonVissza.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonVissza.setBounds(237, 215, 89, 36);
		contentPane.add(buttonVissza);
		buttonVissza.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				start1();
			}
		});
		
		labelBekapcs = new JLabel("");
		labelBekapcs.setForeground(Color.RED);
		labelBekapcs.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelBekapcs.setBounds(24, 234, 174, 17);
		contentPane.add(labelBekapcs);
		
		buttonOk = new JButton("Törlés");
		buttonOk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonOk.setBounds(335, 215, 89, 36);
		contentPane.add(buttonOk);
		buttonOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				start2();
			}
		});
	}
	
	public void start1(){
		dispose();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 SwingKezdo frameK = new SwingKezdo();
					 frameK.setVisible(true);
					 frameK.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void start2(){
		if(radioButtonÜgyT.isSelected()){
			Adatbazis a = new Adatbazis();
			a.bérlésTáblaEldobása();
			a.ügyfélTáblaEldobása();
			a.ügyfélTáblaLétrehozása();
			a.bérlésTáblaLétrehozása();
			a.kapcsolatZárása();
			start1();
		}
		labelBekapcs.setText("Törléshez bekapcs...");
		Logger.getLogger(SwingUgyfel.class.getName()).log(Level.SEVERE, "Törléshez bekapcs...");
	}
}

