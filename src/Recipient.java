
public class Recipient implements Runnable {
	private double capacite;
	private double valeur;
	private Fenetre fen;
	
	public Recipient(double capacite,double valeur)
	{
		this.capacite=capacite;
		this.valeur=valeur;
	}
	public void setFen(Fenetre fen) {
		this.fen=fen;

	}
	public synchronized double getValeur()
	{
		return this.valeur;
	}
	
	public double getCapacite()
	{
		return this.capacite;
	}
	
	public void setCapacite(double capacite) {
		this.capacite=capacite;
	}
	public synchronized  void enlever(double quantite)
	{
		double val=getValeur();

		if((val-=quantite)>=0) {
			System.out.println("enleve"+quantite);
			updateValeur(-quantite);


		}
		else
			System.out.println("Impossible d'enlever le recipient est vide");
	}
	public synchronized  void ajouter(double quantite)
	{
		double val=getValeur();

		if((val+=quantite)<this.capacite) {
			updateValeur(quantite);
			System.out.println("ajout"+quantite);
		}
		else
			System.out.println("Impossible d'ajouter le recipient est plein");
	}
	
	public synchronized void updateValeur(double val) {
		this.valeur+=val;
	}
	
	public void run()
	{
		while(1==1) {
			this.fen.updateValeurContenu(this.getValeur());
		}
			
	}

}
