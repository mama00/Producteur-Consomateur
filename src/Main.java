
public class Main {

	
	public static void main(String[] args) {
		Time t=new Time();
		Recipient r=new Recipient(300,50);
		Consomateur consomateur=new Consomateur(5,t,r);
		Producteur producteur=new Producteur(5,t,r);
		Thread consomateurThread=new Thread(consomateur);
		Thread producteurThread=new Thread(producteur);
		Thread recipientThread=new Thread(r);
		Thread timeThread=new Thread(t);

		Fenetre fen=new Fenetre(consomateur,r,producteur);
		r.setFen(fen);
		t.setFen(fen);

		consomateurThread.start();
		producteurThread.start();
		recipientThread.start();
		timeThread.start();
	}


}
