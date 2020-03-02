
public class Main {

	
	public static void main(String[] args) {
		//Object declaration
		Time t=new Time();
		Recipient recipient=new Recipient(2000,1000);
		Consomateur consomateur=new Consomateur(5,t,recipient);
		Producteur producteur=new Producteur(5,t,recipient);
		
		//Threads declaration
		Thread consomateurThread=new Thread(consomateur);
		Thread producteurThread=new Thread(producteur);
		Thread recipientThread=new Thread(recipient);
		Thread timeThread=new Thread(t);

		Fenetre fen=new Fenetre(consomateur,recipient,producteur);
		recipient.setFen(fen);
		t.setFen(fen);

		//Start
		consomateurThread.start();
		producteurThread.start();
		recipientThread.start();
		timeThread.start();
	}


}
