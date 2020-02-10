
public class Producteur implements Runnable{
	private double debit;
	private Time time;
	private Recipient recipient;
	
	public Producteur(double debit,Time time,Recipient recipient)
	{
		this.debit=debit;
		this.time=time;
		this.recipient=recipient;
	}
	public void setDebit(double debit)
	{
		this.debit=debit;
	}
	
	public double getDebit()
	{
		return this.debit;
	}
	
	public void run()
	{
		while(1==1) {
			this.recipient.ajouter(this.debit*this.time.getDifferentialTime());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
