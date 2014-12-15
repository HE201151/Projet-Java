package Model;

import java.io.Serializable;


/*
 * Chaque case à une coordonée X et Y afin de pouvoir la cibler
 * 
 */
public class Case implements Serializable{
	public int X;
	public int Y;
	
	public Case(){	
	}
	
	public Case(int i, int j) {
		this.X=i;
		this.Y=j;
	}
}
