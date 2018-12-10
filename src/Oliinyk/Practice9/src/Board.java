import java.util.ArrayList; 


public class Board{
	// ����������� ����� � ������ ����������� ������ N �� N
    // (blocks[i][j] =���� � ���� i, ������� j)
	int [][] blocks;
	int dimension;
    public Board(int[][] blocks){
    	this.blocks=blocks;
    	dimension= blocks.length;
    	}
    
 // ��������� ����� N
    public int dimension()   {
		return dimension;
    }
    
 // ������� ����� �� �� ����� ����
    public int hamming()     {
    	int counter=0;
    	int right=1;
    	for( int i=0; i<dimension; i++) {
    		for(int j=0; j<dimension; j++) {
    			if(i==dimension-1 && j==dimension-1) right=0;
    			if(blocks[i][j]!=right) { 
    				counter++; 
    			
    			}
    			right++;
    		}
    	}
		return counter;
    	
    }
 // ���� ������������� �������� �� ������� � �������� ������ 
    public int manhattan(){
    	int counter=0;
    	int curVal=0;
    	int hor=0, ver=0;
    	for( int i=0; i<dimension; i++) {
    		for(int j=0; j<dimension; j++) {
    			curVal=blocks[i][j]; 
    			hor=Math.abs(((curVal/dimension)-1)-i);
    			ver=Math.abs(((curVal%dimension)+dimension-1)-j);
    			counter+=hor+ver;
    		}
    	}
    	   return counter;  
    }
    
 // �� � �� ����� �������� ������
    public boolean isGoal()    {
    	int counter=1;
    	for( int i=0; i<dimension; i++) {
    		for(int j=0; j<dimension; j++) {
    			if(i==dimension-1 && j==dimension-1) counter=0;
    			if(blocks[i][j]!=counter) return false; 
    			counter++;
    		}
    	}
		return true;
    	
    }
 // �� �� ����� ���� y?
    public boolean equals(Object y) {
    	if(y == null) return false;
    	if(y.getClass()!=this.getClass()) return false;
    	if(dimension!=((Board)y).dimension) return false;
    	for(int i =0; i<dimension; i++) {
    		for(int j=0; j<dimension; j++) {
    			if(blocks[i][j]!=((Board)y).blocks[i][j]) return false;
    		}
    	}
    	return true;
    }
 // �� ����� �����
    public Iterable<Board> neighbors(){
    	ArrayList<Board> n= new ArrayList<Board>();
    	int row=0;
    	int column=0;
    	boolean stop=false;
		for( int i=0; i<dimension && !stop; i++) {
			for(int j=0; j<dimension; j++) {
				if(blocks[i][j]==0) {
					row=i;
					column=j;
					stop=true;
					break;
				}
			}
		}
		
		if(row!=0) n.add(createWithSwap(row, column, row-1, column));
		if(row!=dimension-1)  n.add(createWithSwap(row, column, row+1, column));
		if(column!=0) n.add(createWithSwap(row, column, row, column-1));
		if(column!=dimension-1)  n.add(createWithSwap(row, column, row, column+1));
    	return n;
    }
    
 private Board createWithSwap(int row, int column, int row1, int column1) {
	 int [][] bl=new int[dimension][dimension];
	 for( int i=0; i<dimension; i++) {
			for(int j=0; j<dimension; j++) {
				bl[i][j]=blocks[i][j];
			}
		}
	 Board b= new Board(bl);
		b.blocks[row][column]=b.blocks[row1][column1];
		b.blocks[row1][column1]=0;
	return b;	
}

// �������� �������
    public String toString() {
    	String str="";
    	for( int i=0; i<dimension; i++) {
    		for(int j=0; j<dimension; j++) {
    			str+=" "+blocks[i][j];
    		}
    		str+="\n";
    	}
		return str;
    	
    }
}

