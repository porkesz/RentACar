package RentACar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SwingBerles extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldVezetékNév;
	private JTextField textFieldKeresztNév;
	private JTextField textFieldKor;
	private JTextField textFieldKezdet;
	private JTextField textFieldVége;
	private JTextField textFieldVáros;
	private JTextField textFieldUtca;
	private JTextField textFieldHsz;
	
	private JLabel labelJárműveink;
	private JComboBox<String> comboBox;
	private JRadioButton radioButtonGps;
	private JRadioButton radioButtonKülföld;
	private JRadioButton radioButtonBizt;
	private JLabel labelKezdet;
	private JLabel labelVége;
	private JLabel labelÜgyfélAdatok;
	private JLabel labelVezetékNév;
	private JLabel labelKeresztNév;
	private JLabel labelKor;
	private JLabel labelVáros;
	private JLabel labelUtca;
	private JLabel labelHsz;
	private JLabel labelFizetendő;
	private JLabel labelÖsszeg;
	private JButton buttonOk;
	private JLabel labelHiba1;
	private JLabel labelHiba2;
	private JCheckBox chckbxAutoklubKártya;
	
	private boolean kalkulál = false;
	private double full = 0;
	private int ügyfélAzon = 0;
	
	private Berles bérlés;
	

	
	public SwingBerles() {
		
		LinkedList<Autok> lista= new LinkedList<Autok>();
		Adatbazis adatbazis = new Adatbazis();
		
		adatbazis.autokTáblaEldobása();
		
		//adatbazis.ugyfelTablaLetrehozasa();
		adatbazis.autokTáblaLétrehozása();
		adatbazis.autokTáblaFeltöltése();
		
		setTitle("RentACar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelJárműveink = new JLabel("Jarműveink:");
		labelJárműveink.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelJárműveink.setBounds(33, 11, 104, 27);
		contentPane.add(labelJárműveink);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setBounds(33, 36, 458, 34);
		contentPane.add(comboBox);
		
		lista = adatbazis.autokTáblaLekérdezése();
		for(Autok a : lista){
			if(a.azonosító == 1)
				comboBox.addItem("  "+a.márka+"    "+a.típus+"   Évjárat: "+a.évjárat+"   Kölcsönzési díj: "+a.kölcsönzésiDíjPerNap+"  Ft/nap   ");
			else if(a.azonosító == 6)
				comboBox.addItem("  "+a.márka+"  "+a.típus+"  Évjárat: "+a.évjárat+"   Kölcsönzési díj: "+a.kölcsönzésiDíjPerNap+"Ft/nap   ");
			else
				comboBox.addItem("  "+a.márka+"    "+a.típus+"   Évjárat: "+a.évjárat+"   Kölcsönzési díj: "+a.kölcsönzésiDíjPerNap+"Ft/nap   ");
		}
		
		radioButtonGps = new JRadioButton("GPS (500Ft/nap)");
		radioButtonGps.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		radioButtonGps.setBounds(33, 77, 138, 34);
		contentPane.add(radioButtonGps);
		
		radioButtonKülföld = new JRadioButton("Külföldi használat (+10%)");
		radioButtonKülföld.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		radioButtonKülföld.setBounds(169, 77, 182, 34);
		contentPane.add(radioButtonKülföld);
		
		radioButtonBizt = new JRadioButton("Biztosítás(1500 Ft/nap)");
		radioButtonBizt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		radioButtonBizt.setBounds(353, 77, 175, 34);
		contentPane.add(radioButtonBizt);
		
		labelKezdet = new JLabel("Bérlés kezdete:");
		labelKezdet.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelKezdet.setBounds(16, 124, 121, 17);
		contentPane.add(labelKezdet);
		
		textFieldKezdet = new JTextField();
		textFieldKezdet.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldKezdet.setBounds(138, 122, 104, 20);
		contentPane.add(textFieldKezdet);
		textFieldKezdet.setColumns(10);
		
		labelVége = new JLabel("Bérlés vége:");
		labelVége.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelVége.setBounds(260, 124, 99, 17);
		contentPane.add(labelVége);
		
		textFieldVége = new JTextField();
		textFieldVége.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldVége.setBounds(363, 122, 104, 20);
		contentPane.add(textFieldVége);
		textFieldVége.setColumns(10);
		
		labelHiba1 = new JLabel("");
		labelHiba1.setForeground(Color.RED);
		labelHiba1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelHiba1.setBounds(41, 152, 431, 17);
		contentPane.add(labelHiba1);
		
		labelÜgyfélAdatok = new JLabel("Ügyfél adatok:");
		labelÜgyfélAdatok.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelÜgyfélAdatok.setBounds(16, 176, 121, 27);
		contentPane.add(labelÜgyfélAdatok);
		
		labelVezetékNév = new JLabel("Vezeték név:");
		labelVezetékNév.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelVezetékNév.setBounds(16, 214, 79, 17);
		contentPane.add(labelVezetékNév);
		
		textFieldVezetékNév = new JTextField();
		textFieldVezetékNév.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldVezetékNév.setBounds(95, 212, 86, 20);
		contentPane.add(textFieldVezetékNév);
		textFieldVezetékNév.setColumns(10);
		
		labelKeresztNév = new JLabel("Kereszt név:");
		labelKeresztNév.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelKeresztNév.setBounds(221, 214, 79, 17);
		contentPane.add(labelKeresztNév);
		
		textFieldKeresztNév = new JTextField();
		textFieldKeresztNév.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldKeresztNév.setBounds(297, 212, 86, 20);
		contentPane.add(textFieldKeresztNév);
		textFieldKeresztNév.setColumns(10);
		
		labelKor = new JLabel("Kor:");
		labelKor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelKor.setBounds(425, 215, 32, 15);
		contentPane.add(labelKor);
		
		textFieldKor = new JTextField();
		textFieldKor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldKor.setBounds(459, 212, 32, 20);
		contentPane.add(textFieldKor);
		textFieldKor.setColumns(10);
		
		labelVáros = new JLabel("Város:");
		labelVáros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelVáros.setBounds(16, 242, 46, 17);
		contentPane.add(labelVáros);
		
		textFieldVáros = new JTextField();
		textFieldVáros.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldVáros.setBounds(58, 240, 86, 20);
		contentPane.add(textFieldVáros);
		textFieldVáros.setColumns(10);
		
		labelUtca = new JLabel("Utca:");
		labelUtca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelUtca.setBounds(186, 242, 39, 17);
		contentPane.add(labelUtca);
		
		textFieldUtca = new JTextField();
		textFieldUtca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldUtca.setBounds(221, 240, 86, 20);
		contentPane.add(textFieldUtca);
		textFieldUtca.setColumns(10);
		
		labelHsz = new JLabel("H.sz.:");
		labelHsz.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelHsz.setBounds(353, 242, 39, 17);
		contentPane.add(labelHsz);
		
		textFieldHsz = new JTextField();
		textFieldHsz.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldHsz.setBounds(394, 240, 86, 20);
		contentPane.add(textFieldHsz);
		textFieldHsz.setColumns(10);
		
		labelHiba2 = new JLabel("");
		labelHiba2.setForeground(Color.RED);
		labelHiba2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		labelHiba2.setBounds(16, 270, 367, 25);
		contentPane.add(labelHiba2);
		
		labelFizetendő = new JLabel("Fizetendő:");
		labelFizetendő.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelFizetendő.setBounds(16, 306, 128, 27);
		contentPane.add(labelFizetendő);
		
		labelÖsszeg = new JLabel("");
		labelÖsszeg.setForeground(Color.RED);
		labelÖsszeg.setFont(new Font("Times New Roman", Font.BOLD, 17));
		labelÖsszeg.setBounds(146, 306, 269, 27);
		contentPane.add(labelÖsszeg);
		
		buttonOk = new JButton("Kalkulál");
		buttonOk.setFont(new Font("Times New Roman", Font.BOLD, 15));
		buttonOk.setBounds(416, 284, 112, 33);
		contentPane.add(buttonOk);
		buttonOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				start();	
			}
		});
		
		
		JButton buttonMegrendel = new JButton("Megrendel");
		buttonMegrendel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		buttonMegrendel.setBounds(416, 320, 112, 40);
		contentPane.add(buttonMegrendel);
		
		chckbxAutoklubKártya = new JCheckBox("AutoKlub kártya");
		chckbxAutoklubKártya.setBounds(383, 176, 145, 23);
		contentPane.add(chckbxAutoklubKártya);
		buttonMegrendel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				start2();				
			}
		});
		
		
		adatbazis.kapcsolatZárása();
	}
	
	protected void start(){
		boolean GPS = false;
		boolean külföld = false;
		boolean bizt = false;
		boolean hiba1 = true;
		boolean hiba2 = true;
		boolean szabad = true;
		int napokSzáma = 0;
		int gpsDíj = 0;
		int összeg = 0;
		int napiDíj = 0;
		int biztosítás = 0;
		int teljesÁr = 0;
		int végösszeg = 0;
		
		
		
		Ugyfel ügyfel = new Ugyfel();
		LinkedList <Ugyfel> lista = new LinkedList<Ugyfel>(); 
		Adatbazis adatb = new Adatbazis();
		Autok auto;
		
		
		if((!textFieldVezetékNév.getText().equals("")) && (!textFieldKeresztNév.getText().equals("")) &&
				(!textFieldKor.getText().equals("")) && (!textFieldVáros.getText().equals("")) &&
				(!textFieldUtca.getText().equals("")) && (!textFieldHsz.getText().equals("")) && 
				(!textFieldKezdet.getText().equals("")) && (!textFieldVége.getText().equals(""))){
			try{
				ügyfel.vezetékNév = textFieldVezetékNév.getText();
				ügyfel.vezetékNév = textFieldKeresztNév.getText();
				ügyfel.életkor = Integer.valueOf(textFieldKor.getText());
				ügyfel.város = textFieldVáros.getText();
				ügyfel.utca = textFieldUtca.getText();
				ügyfel.házszám = textFieldHsz.getText();
				ügyfel.autoKód = comboBox.getSelectedIndex()+1;
				hiba2 = false;
				labelHiba2.setText("");
			} catch (NumberFormatException e){
				labelHiba2.setText("Hibás formátum...");
				hiba2 = true;
				Logger.getLogger(SwingBerles.class.getName()).log(Level.SEVERE, "Hibás formátum ...");
				e.getMessage();
			}	
		} else {
			labelHiba2.setText("Minden mező kitöltése kötelező ...");
		}
		
		if(Ugyfel.megfelelőDátumFormátum(textFieldKezdet.getText()) && Ugyfel.megfelelőDátumFormátum(textFieldVége.getText())){
			if(Ugyfel.megfelelőDátum(textFieldKezdet.getText(), textFieldVége.getText())){
				
				ügyfel.bérlésKezdete = textFieldKezdet.getText();
				ügyfel.bérlésVége = textFieldVége.getText();
				hiba1 = false;
				labelHiba1.setText("");
			} else {
				labelHiba1.setText("A dátum nem megfelelő ...");
				Logger.getLogger(SwingBerles.class.getName()).log(Level.SEVERE, "A dátum nem megfelelő ...");
			}
		} else {
			labelHiba1.setText("Hibás dátum formátum (YYYY.MM.DD) ...");
			Logger.getLogger(SwingBerles.class.getName()).log(Level.SEVERE, "Hibás dátum formátum (YYYY.MM.DD) ...");
		}
		
		if(!hiba1 && !hiba2){
			GPS = radioButtonGps.isSelected();
			külföld = radioButtonKülföld.isSelected();
			bizt = radioButtonBizt.isSelected();
			
			lista = adatb.ügyfélTáblaLekérdezése();
			
			if(lista.isEmpty())
				ügyfélAzon = 1;
			else{ 
				ügyfélAzon = lista.size() + 1;
			}
			
			ügyfel.ügyfelAzon = ügyfélAzon;
			ügyfel.akk = chckbxAutoklubKártya.isSelected();
			
			for(Ugyfel u : lista){
				if(ügyfel.autoKód == u.autoKód){
					if(!Ugyfel.szabadDátum(ügyfel.bérlésKezdete, u.bérlésKezdete, ügyfel.bérlésVége, u.bérlésVége))
						szabad = false;
				}
			}
			
			
			
			if(szabad){
				adatb.felvitelÜgyfélTáblába(ügyfel);
				
				auto = adatb.autokTáblaLekérdezéseAzon(comboBox.getSelectedIndex()+1);
				
				bérlés = new Berles(auto, ügyfel, ügyfel.bérlésKezdete, ügyfel.bérlésVége, ügyfel.akk, radioButtonKülföld.isSelected(), GPS, bizt, "");
				
				napokSzáma = Berles.napokSzáma(bérlés.bérlésKezd, bérlés.bérlésVége);
		
				if(bérlés.gps == true)
					gpsDíj = Berles.gpsDíj(napokSzáma);
				
				if(bérlés.bizt == true)
					biztosítás = Berles.biztÖsszeg(napokSzáma);
		
				napiDíj = bérlés.a.kölcsönzésiDíjPerNap;
				összeg = Berles.osszeg(napiDíj, napokSzáma);
				teljesÁr = Berles.összegPlusGps(összeg, gpsDíj);
				végösszeg = (int)Berles.végÖsszeg(teljesÁr, bérlés.u.életkor, külföld, biztosítás);
				full =Berles.fullÁrPlusAk( Berles.fullÁr(végösszeg, napokSzáma), bérlés.autoKlub);
		
				labelÖsszeg.setText(" "+végösszeg+" Lenne!");
				kalkulál = true;
			} else {
				labelÖsszeg.setText("Az auto ebben az idopontban foglalt!");
				Logger.getLogger(SwingBerles.class.getName()).log(Level.SEVERE, "Az auto ebben az idopontban foglalt!");
			}
		} else {
			labelÖsszeg.setText("");
		}
		adatb.kapcsolatZárása();
	}
	
	protected void start2(){
		Adatbazis aa = new Adatbazis(); 
		if(kalkulál == true){
			aa.bérlésTáblaAdd(bérlés);
			
			
			labelÖsszeg.setText("  "+full);
			kalkulál = false;
		} else {
			labelÖsszeg.setText("Előbb kalkulálj ... !!!");
			Logger.getLogger(SwingBerles.class.getName()).log(Level.SEVERE, "Előbb kalkulálj ... !!!!");
		}
		
		
	}
}


