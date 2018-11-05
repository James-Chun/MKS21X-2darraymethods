public class ArrayMethods{

   /*
   *PART 1
   */
   public static int rowSum(int[][] ary, int x){
     int sum = 0;
     for (int i = 0;i < ary[x].length;i++){
       sum = sum + ary[x][i];
     }
     return sum;
   }
    //returns the sum of the elements in Row x of ary.

   public static int columnSum(int[][] ary, int x){
     int sum = 0;
     for (int i = 0;i < ary.length; i ++){
       if (x < ary[i].length){
         sum = sum + ary[i][x];
       }
     }
     return sum;
   }
    //returns the sum of the elements in Column x of ary (careful with rows of different lengths!).

   /*
   *PART 2 - use prior methods where appropriate
   */
   public static int[] allRowSums(int[][] ary){
     int[] s = new int[ary.length];
     for (int i = 0;i<ary.length;i++){
       int sum = 0;
       for (int i2=0;i2<ary[i].length;i2++){
         sum = sum + ary[i][i2];
       }
       s[i]=sum;
       sum = 0;
     }
     return s;
   }
    //returns an array of the row sums for each row of ary.
    //Index i of the return array contains the sum of elements in row i.

  public static int[] allColSums(int[][] ary){
    int longestRow = 0;
    for (int i = 0;i <ary.length;i++){
      if (ary[i].length>longestRow){
        longestRow = ary[i].length;
      }
    }

    int[][] temp = new int[longestRow][ary.length];
    for (int i =0;i<longestRow;i++){
      for (int i2=0;i2<ary.length;i2++){
        if (i < ary[i2].length){
          temp[i][i2]=ary[i2][i];
        }

      }

    }
    return allRowSums(temp);
  }
    //Returns an array with the column sum of each column of ary.
    //When a row is not long enough to reach the column count it as a zero. (NO indexOutOfBounds should ever occur)
    //Index i of the return array contains the sum of elements in column i, ignoring any rows that are too short.
    //The length of the returned array should be the length of the LONGEST array in ary.


   /*
   *PART 3 - use prior methods where appropriate
   */
   public static boolean isRowMagic(int[][] ary){
     int[] temp = allRowSums(ary);
     for (int i =0;i<temp.length-1;i++){
       if (temp[i]!=temp[i+1]){
         return false;
       }
     }
     return true;
   }
     //checks if the array is row-magic (this means that every row has the same row sum).

   public static boolean isColumnMagic(int[][] ary){
     int[] temp = allColSums(ary);
     for (int i =0;i<temp.length-1;i++){
       if (temp[i]!=temp[i+1]){
         return false;
       }
     }
     return true;
   }
    //checks if the array is column-magic (this means that every column has the same column sum).

}
