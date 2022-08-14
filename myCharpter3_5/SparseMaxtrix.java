package myCharpter3_5;

import edu.princeton.cs.algs4.ST;

public class SparseMaxtrix {
	private ST<Integer,Double> Row;
	private ST<Integer,ST<Integer,Double>> Rank;
	
	public SparseMaxtrix() {
		Row = new ST<Integer,Double>();
		Rank = new ST<Integer,ST<Integer,Double>>();
	}
	
	public int sizeRank() {
		return Rank.size();
	}
	
	public int sizeRow(int rank) {
		if(!Rank.contains(rank))
			return 0;
		return Rank.get(rank).size(); 
	}
	
	public int sizeCount() {
		int sum = 0;
		for(Integer rank : Rank.keys())
			sum+= Rank.get(rank).size();
		return sum;
	}
	
	public int maxRank() {
		return Rank.max();
	}
	
	public int maxRow(int rank) {
		return Rank.get(rank).max();
	}
	
	public void put(int rank,int row,double x) {
		if(Rank.contains(rank)) {
			Rank.get(rank).put(row, x);
		}else {
			ST<Integer,Double> temp = new ST<Integer,Double>();
			temp.put(row, x);
			Rank.put(rank, temp);
		}
	}
	
	public double get(int rank,int row) {
		if(!Rank.contains(rank)) return 0.0;
		if(!Rank.get(rank).contains(row)) return 0.0;
		return Rank.get(rank).get(row);
	}
	
	public ST<Integer,Double> getRow(int rank){
		if(!Rank.contains(rank)) return null;
		else					 return Rank.get(rank);
	}
	
	public SparseMaxtrix sum(SparseMaxtrix that) {
		SparseMaxtrix temp = new SparseMaxtrix();
		int rankMax = this.maxRank()>that.maxRank() ? this.maxRank() : that.maxRank();
		for(int i = 0;i<rankMax;i++) {
			if(this.getRow(i)==null&&that.getRow(i)!=null) {
				for(Integer row : that.getRow(i))
				temp.put(i, row, that.get(i, row));
			}else if(this.getRow(i)!=null&&that.getRow(i)==null) {
				for(Integer row : this.getRow(i))
				temp.put(i, row, this.get(i, row));
			}else if(this.getRow(i)!=null&&that.getRow(i)!=null) {
				int rowMax = this.getRow(i).size()>that.getRow(i).size()?this.getRow(i).size():that.getRow(i).size();
				for(int j = 0;j<=rowMax;j++) {
					if(this.getRow(i).contains(j)&&!that.getRow(i).contains(j))
						temp.put(i, j, this.get(i, j));
					if(!this.getRow(i).contains(j)&&that.getRow(i).contains(j))
						temp.put(i, j, that.get(i, j));
					if(this.getRow(i).contains(j)&&that.getRow(i).contains(j))
						temp.put(i, j, this.get(i, j)+that.get(i, j));
				}
			}
		}
		return temp;
	}
	
	public double multiply(SparseMaxtrix that) {
		double sum = 0.0;
		for(int i = 0;i < this.maxRank();i++) {
			for(int j = 0;j<that.maxRank();j++) {
				if(that.getRow(j)!=null&&that.getRow(j).contains(i)&&this.getRow(i).contains(j))
					sum += this.get(i, j)*that.get(j, i);
			}
		}
		return sum;
	}
}
