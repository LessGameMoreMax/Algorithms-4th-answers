package myCharpter3_1;

public class Event {
	private String address;
	private Time time;
	
	public Event(String time,String address) {
		this.time = new Time(time);
		this.address = address; 
	}
	
	public String toString()
	{return time+" "+address;}
	
	public int compareTo(Event that) {
		return this.time.compareTo(that.time);
	}
}
