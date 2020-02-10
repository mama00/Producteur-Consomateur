
public class Time implements Runnable{
	private double time;
	private Fenetre fen;
	private double dt;
	
	public Time()
	{
		this.time=0;
		this.dt=0.01;
	}
	
	public double getTime() {
		return this.time;
	}
	
	public double getDifferentialTime()
	{
		return this.dt;
	}
	
	public void setTime(double time)
	{
		this.time=time;
	}
	
	public void setFen(Fenetre fen)
	{
		this.fen=fen;
	}
	public void setRatio(double ratio)
	{
		this.dt=ratio;
	}
	public void run()
	{
		while(1==1) {
			this.time+=this.dt;
			this.fen.updateTime(this.time);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
