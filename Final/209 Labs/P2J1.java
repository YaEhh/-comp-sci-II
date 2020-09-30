
public class P2J1 {
	
	 public static int countInversions(int[] arr) {
		 int inversionCounter = 0;
		 
		 if (arr.length <= 1) {
			 return inversionCounter;
		 }
		 
		 for (int i = 0; i < arr.length -1; i++) {
			 for (int j= i+1;  j < arr.length;  j++ ) {
				 if (arr[i] > arr[j]) {
					 inversionCounter++;
				 }
			 }
		 }
		 
		 return inversionCounter;
	 }

	 public static int fallingPower (int n,  int k) {
		 int fpVal = 1;
		 
		 for (int i = 0 ; i  < k ;  i++) {
			fpVal *= n - i;
		 }
		 
		 return fpVal;
	 }
	 
	 public static int[ ] everyOther(int [ ] arr) {
		int [ ] newArr;
		int index = 0;
		
		if (arr.length % 2 == 0) {
			newArr = new int [ arr.length / 2];
		} else {
			newArr = new int [(arr.length + 1) /2 ];
		}
		 
		 for (int i = 0;  i < arr.length ; i++ ) {
			 if (i % 2 == 0) {
				 newArr[index] = arr[i];
				 index++;
			 }
		 }
		 
		 return newArr;
	 }
	 
	 public static int[][] createZigZag(int rows, int cols, int start) {
		  int [] [] newArr = new  int [rows] [cols];
		  int rowIndex = 0;
		  int columnIndex = 0;
		  
		  for (int  row = 0;  row < rows;  row ++ ) {
			  
			  if (row % 2 == 0) {
				  for (int col = start + (cols * row );  col < start + (cols * (row + 1) )  ;   col++ ) {
					  newArr[rowIndex] [columnIndex] =  col; 
					  columnIndex++;
				  }
				  rowIndex++ ;
				  columnIndex = 0 ;
			  } else {
				  for (int col = (start + (cols * (row +1)) - 1);  col >=  start + (cols * (row));  col--  ) {
					  newArr[rowIndex] [columnIndex] = col;
					  columnIndex++;
				  }
				  rowIndex++ ;
				  columnIndex = 0;
			  }
		  }
		  
		  return newArr; 
	 }
}
