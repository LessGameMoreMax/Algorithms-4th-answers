package myCharpter5_1;

public class Student {
		private String name;
		private int key;
		public Student(String name,int key)
		{ this.name = name; this.key = key;}
		
		public int key()
		{ return key;}
		public String name()
		{ return name;}
		
		public String toString()
		{ return key + " : "+ name;}
}
