package myCharpter3_4;
public class DateWithHash
{
	private int month;
	private int day;
	private int year;
	public DateWithHash() {
		
	}
	public DateWithHash(int month, int day,int year) {
		if(year<0) throw new RuntimeException("Year can not be smaller than zero!");
		if(month<=0) throw new RuntimeException("Month must be bigger than zero!");
		if(day<=0) throw new RuntimeException("Day must be bigger than zero!");	
		if(month == 1 || month == 3 || month == 5||month == 7||month == 8||month == 10|| month == 12)
			if(day>31) throw new RuntimeException("Big month's days can't be bigger than 31");
		if(month == 4||month == 6||month==9||month==11)
			if(day>30) throw new RuntimeException("Small month's days can't be bigger than 30");
		if(year % 4 == 0) if(month==2&&day>28) throw new RuntimeException("Leap year's February days can't be bigger than 28");
		else              if(month==2&&day>29) throw new RuntimeException("Not leap year's February month's days can't be bigger than 29");
		this.month = month;
		this.day = day;
		this.year = year;
	}
	public int month() {
		return month;
	}
	public int day() {
		return day;
	}
	public int year() {
		return year;
	}
	public String dayOfTheWeek() {
		if(this.year<2000||this.year>=2100) throw new RuntimeException("Year has to be 21th century");
		int[] chart = {6,2,2,5,0,3,5,1,4,6,2,4};
		if(this.year%4==0) {
			chart[0] = 5;
			chart[1] = 1;
		}
		int a = this.year%2000;
		int b = this.month-1;
		int result = (a+a/4+chart[b]+day)%7;
		switch (result) {
		case 1: return "Monday";
		case 2: return "Tuesday";
		case 3: return "Wednesday";
		case 4: return "Thursday";
		case 5: return "Friday";
		case 6: return "Saturday";
		default: return "Sunday";
		}
	}
	public boolean equals(Object x) {
		if(this==x) return true;
		if(x==null) return false;
		if(this.getClass()!=x.getClass()) return false;
		DateWithHash that = (DateWithHash) x;
		if(this.day!=that.day) return false;
		if(this.month!=that.month) return false;
		if(this.year!=that.year) return false;
		return true;
	}
	public String toString() {
		return month()+"/"+day()
		        +"/"+year()+" "+dayOfTheWeek();
	}
	
	public int hashCode() {
		return (((day*5+month)%31)*5+year)%31;
	}
}