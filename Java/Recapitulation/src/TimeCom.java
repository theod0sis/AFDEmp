
public class TimeCom {
	
	private int hour;
	private int minute;
	private int second;
	
	
	TimeCom(){
		
	}
	TimeCom(int h, int m, int s){
		this.setHour(h);
		this.setMinute(m);
		this.setSecond(s);
	}
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if (hour>23){
			this.hour=00;
		}
		else {
			this.hour = hour;
		}
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if (minute>59){
			this.minute=0;
		}
		else this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if (second>59){
			this.second =0;
		}
		else this.second = second;
	}
	
	public void setTime(int h, int m , int s){
		setHour(h);
		setMinute(m);
		setSecond(s);
	}
	public String toString(){
		return( hour + ":" + minute + ":" + second );
	}
}
