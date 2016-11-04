package my.question.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensPuzzle {
	private int n;
	private List<int[]> result; // each result contains the column indexes of all rows
	
	public static QueensPuzzle of(int n){
		if (n <= 3) throw new AssertionError("Invalid number of queens!");
		return new QueensPuzzle(n);
	}
	
	private QueensPuzzle(int n){
		this.n = n;
	}
	
	public List<int[]> solvePuzzle(){
	   result = new ArrayList<>();
	   int[] pre = new int[n];
	   for(int j = 0; j < n; ++j){
	     pre[0] = j;
	     btSolution(pre, 1);
	   }
	   return result;
	}
	
	private void btSolution(int[] pre, int usedQueenCnt){
	  if(usedQueenCnt == n){
	    System.out.println(Arrays.toString(pre));
	    result.add(Arrays.copyOf(pre, pre.length));
	  }else{
	    for(int j = 0; j < n; ++j){
	      boolean putAble = true;
	      for(int i = 0; i < usedQueenCnt; ++i){
	        if(pre[i] == j || pre[i] == (j-usedQueenCnt+i) || pre[i] == (j+usedQueenCnt-i)){
	          putAble = false;
	          break;
	        }
	      }
	      if(putAble){
	        pre[usedQueenCnt] = j;
            btSolution(pre, usedQueenCnt+1);
	      }
	    }
	  }
	}
	
	public static void main(String[] argv){
	  QueensPuzzle qp = QueensPuzzle.of(18);
	  System.out.println(qp.solvePuzzle().size());
	}
}
