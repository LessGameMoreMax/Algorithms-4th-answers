package myCharpter2_4;

public class MaxPQWithNode<Key extends Comparable<Key>> {
	private class Node{
		Key key;
		Node last;
		Node left;
		Node right;
	}
	private int N = 0;
	private Node current = null;
	private Node root = null;
	
	public boolean isEmpty()
	{return N==0;}
	
	public int size()
	{return N;}
	
	public void insert(Key v)
	{
		Node node = new Node();
		node.key = v;
		node.left = null;
		node.right = null;
		
		if(N==0) {
			root = node;
			current = node;
			node.last = null;
			N++;
			return;
		}else if(N==1) {
			current.left = node;
			node.last = current;
			current = current.left;
			swim(current);
			N++;
			return;
		}
		N++;
		if(current==current.last.left) {
			current.last.right = node;
			node.last = current.last;
			current = current.last.right;
			swim(current);
			return;
		}
		
		if(current==current.last.right) {
			while(true) {
				current = current.last;
				if(current==root) {
					while(current.left!=null)
						current = current.left;
					current.left = node;
					node.last = current;
					current = current.left;
					swim(current);
					return;
				}
				if(current.last.left == current) {
					current = current.last;
					current = current.right;
					while(current.left!=null)
						current = current.left;
					current.left = node;
					node.last = current;
					current = current.left;
					swim(current);
					return;
				}
			}
		}
	}
	
	public Key delMax()
	{	
        {
            Key result = this.root.key;
            exch(root,current);

            if (N == 2)
            {
                this.root.left = null;
                this.current = this.root;
                this.N--;
                return result;
            }
            else if (N == 1)
            {
                this.current = null;
                this.root = null;
                this.N--;
                return result;
            }
            Node newCurrent = current;
            if (newCurrent == this.current.last.right)
                newCurrent = this.current.last.left;
            else
            {
                while (newCurrent != this.root)
                {
                    if (newCurrent != newCurrent.last.left)
                        break;
                    newCurrent = newCurrent.last;
                }
                if (newCurrent == this.root)
                {
                    while (newCurrent.right != null)
                        newCurrent = newCurrent.right;
                }
                else
                {
                    newCurrent = newCurrent.last.left;
                    while (newCurrent.right != null)
                        newCurrent = newCurrent.right;
                }
            }
            if (this.current.last.left == this.current)
            	this.current.last.left = null;
            else
            	this.current.last.right = null;

            sink(this.root);
            this.current = newCurrent;
            this.N--;
            return result;
        }
	}
	
	private void exch(Node v,Node w) {
		Key temp = v.key;
		v.key = w.key;
		w.key = temp;
	}
	
	private void swim(Node w)
	{
		while(w.last!=null&&less(w.last,w)) {
			exch(w.last,w);
			w = w.last;
		}
	}
	
    private void sink(Node k)
    {
        while (k.left != null || k.right != null)
        {
            Node toExch = null;
            if (k.left != null && k.right != null)
                toExch = less(k.left, k.right) ? k.right : k.left;
            else if (k.left != null)
                toExch = k.left;
            else
                toExch = k.right;

            if (less(k, toExch))
                exch(k, toExch);
            else
                break;
            k = toExch;
        }
    }
	
	private boolean less(Node w,Node v)
	{ return w.key.compareTo(v.key)<0;}
	
	public static void main(String[] args)
	{
		MaxPQWithNode<Integer> test = new MaxPQWithNode<Integer>();
		test.insert(7);
		test.insert(4);
		test.insert(8);
		test.insert(2);
		test.insert(2);
		test.insert(2);
		test.insert(2);
		test.insert(4);
		test.insert(9);
		test.insert(9);
		test.insert(9);
		while(!test.isEmpty())
			System.out.print(test.delMax()+" ");
	}
}
