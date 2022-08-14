package myCharpter3_1;

public class Time implements Comparable<Time>{
	private final int hour;
	private final int minute;
	private final int second;
	
	public Time(String str) {
		String[] time = str.split(":");
		hour = Integer.parseInt(time[0]);
		minute = Integer.parseInt(time[1]);
		second = Integer.parseInt(time[2]);
	}
	
	public String toString() {
		String hourString = hour+"";
		String minuteString = hour+"";
		String secondString = hour+"";
		if(hour/10==0) hourString = "0"+hourString;
		if(minute/10==0) minuteString = "0"+minuteString;
		if(second/10==0) secondString = "0"+secondString;
		return hourString+":"+minuteString+":"+secondString;
	}
	
	public int compareTo(Time that) {
		if(this.hour<that.hour) return -1;
		if(this.hour>that.hour) return +1;
		if(this.minute<that.minute) return -1;
		if(this.minute>that.minute) return +1;
		if(this.second<that.second) return -1;
		if(this.second>that.second) return +1;
		return 0;
	}

}
