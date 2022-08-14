package myCharpter3_1;

public class WordAndNumber {
	public String word;
	public Integer number;
	
	public WordAndNumber(String word,Integer number) {
		this.word = word;
		this.number = number;
	}
	
	public Integer getNumber()
	{return this.number;}
	
	public String toString()
	{ return word+":"+number;}
	
	public int compareTo(WordAndNumber that) {
		return this.number.compareTo(that.getNumber());
	}
}
