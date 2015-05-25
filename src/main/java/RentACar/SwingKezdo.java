package RentACar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SwingKezdo extends JFrame {

	private JPanel contentPane;
	private JButton buttonFelhasználó;
	private JButton buttonBérlések;
	

	public static void main(String[] args) {
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

	
	public SwingKezdo() {
		
		setTitle("RentACar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		buttonFelhasználó = new JButton("Auto bérlés");
		buttonFelhasználó.setBounds(60, 32, 117, 40);
		contentPane.add(buttonFelhasználó);
		buttonFelhasználó.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				start1();
			}
		});
		
		buttonBérlések = new JButton("Bérlések");
		buttonBérlések.setBounds(60, 97, 117, 40);
		contentPane.add(buttonBérlések);
		buttonBérlések.addActionListener(new ActionListener() {
			
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
					SwingBerles frame = new SwingBerles();
					frame.getContentPane().setLayout(new BorderLayout());
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void start2(){
		dispose();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    SwingUgyfel frame = new SwingUgyfel();
				    frame.getContentPane().setLayout(new BorderLayout());
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}