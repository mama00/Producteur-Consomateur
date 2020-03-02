import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Fenetre extends JFrame {
	private JPanel pan=new JPanel();
	private JButton boutonComencer=new JButton("Commencer");
	private JLabel valeurRecipientText=new JLabel("Contenu du recipient:");
	private JLabel valeurRecipient=new JLabel("1000");
	private JLabel debitProducteurText=new JLabel("Debit Producteur:");
	private JLabel debitProducteur=new JLabel("5");
	private JLabel debitConsomateurText=new JLabel("Debit Consomateur:");
	private JLabel debitConsomateur=new JLabel("5");
	private JLabel valeurTimeText=new JLabel("Time");
	private JLabel valeurTime=new JLabel("0");
	private JSlider sliderRecipient=new JSlider(0,2000);
	private JSlider sliderConsomateur=new JSlider(0,10);
	private JSlider sliderProducteur=new JSlider(0,10);
	private JLabel valeurActuelContenuText=new JLabel("valeur actuel");
	private JLabel valeurActuelContenu=new JLabel("0");

	private Consomateur consomateur;
	private Recipient recipient;
	private Producteur producteur;

	
	
	
	
	public Fenetre(Consomateur c,Recipient r,Producteur p)
	{
		this.consomateur=c;
		this.recipient=r;
		this.producteur=p;
		this.setTitle("Producteur-Consomateur");
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addButton();
		this.setContentPane(pan);
		this.setVisible(true);
		this.addEventListener(this);
	}
	
	public void addButton() {
		pan.add(debitProducteurText,BorderLayout.EAST);
		pan.add(debitProducteur,BorderLayout.EAST);
		pan.add(valeurRecipientText,BorderLayout.CENTER);
		pan.add(valeurRecipient,BorderLayout.CENTER);
		pan.add(debitConsomateurText,BorderLayout.WEST);
		pan.add(debitConsomateur,BorderLayout.WEST);
		
		pan.add(valeurActuelContenuText,BorderLayout.SOUTH);
		pan.add(valeurActuelContenu,BorderLayout.SOUTH);
		pan.add(sliderProducteur,BorderLayout.SOUTH);
		pan.add(sliderConsomateur,BorderLayout.SOUTH);
		pan.add(sliderRecipient,BorderLayout.SOUTH);
		pan.add(valeurTimeText,BorderLayout.SOUTH);
		pan.add(valeurTime,BorderLayout.SOUTH);


		

	}
	
	public void updateDebitProducteur(Producteur prod) {
		debitProducteur.setText(Integer.toString(sliderProducteur.getValue()));
	}
	
	public void updateDebitConsomateur(Consomateur cons) {
		debitConsomateur.setText(Integer.toString(sliderConsomateur.getValue()));

	}
	
	public void updateCapaciteRecipient(Recipient rec) {
		valeurRecipient.setText(Integer.toString(sliderRecipient.getValue()));

	}
	
	public void addEventListener(Fenetre f) {
		class SliderConsomateurListener implements ChangeListener{
			public void stateChanged(ChangeEvent e) {
				JSlider source=(JSlider)e.getSource();
				f.consomateur.setDebit(source.getValue());
				f.debitConsomateur.setText(Integer.toString(source.getValue()));
			}
		}
		
		class SliderProducteurListener implements ChangeListener{
			public void stateChanged(ChangeEvent e) {
				JSlider source=(JSlider)e.getSource();
				f.producteur.setDebit(source.getValue());
				f.debitProducteur.setText(Integer.toString(source.getValue()));
			}
		}
		
		class SliderRecipientListener implements ChangeListener{
			public void stateChanged(ChangeEvent e) {
				JSlider source=(JSlider)e.getSource();
				f.recipient.setCapacite(source.getValue());
				f.valeurRecipient.setText(Integer.toString(source.getValue()));
			}
		}
		
		
		sliderConsomateur.addChangeListener(new SliderConsomateurListener());
		sliderProducteur.addChangeListener(new SliderProducteurListener());
		sliderRecipient.addChangeListener(new SliderRecipientListener());
		
		
	}
	
	public void updateValeurContenu(double contenu) {
		this.valeurActuelContenu.setText(Integer.toString((int)contenu));
	}
	public void updateTime(double time)
	{
		this.valeurTime.setText(Integer.toString((int)time));
	}
	
}
