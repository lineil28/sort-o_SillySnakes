import java.util.ArrayList;
public class Sorts{
  public static int numComparisons, numSwaps;

  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  public static void shuffle( ArrayList al ) {
   int randomIndex;
   for( int i = al.size()-1; i > 0; i-- ) {
     //pick an index at random
     randomIndex = (int)( (i+1) * Math.random() );
     //swap the values at position i and randomIndex
     al.set( i, al.set( randomIndex, al.get(i) ) );
   }
  }

  public static ArrayList<Comparable> bubble (ArrayList<Comparable> input )  {
    numComparisons = 0; numSwaps = 0;
    ArrayList<Comparable> data = input;

    boolean isSorted = true;
    int size = data.size();
    Comparable temp;
    while(!isSorted){
      for (int j = size - 1; j > 0; j--) {
        numComparisons++; // Each time a for loop is run, there's a comparison being made
        //swapping
        isSorted = true;
        if (data.get(j).compareTo(data.get(j - 1)) < 0) {
          isSorted = false;
          temp = data.get(j);
          data.set(j, data.get(j - 1));
          data.set(j - 1, temp);
          numSwaps++;
        }
        numComparisons++; // data.get(j).compareTo(data.get(j - 1)) < 0 is a comparison
      }

    }
    System.out.println("# of Comparisons: " + numComparisons);
    System.out.println("# of Swaps: " + numSwaps);
  return data;

  }

  public static ArrayList<Comparable> selection( ArrayList<Comparable> input) {
    numComparisons = 0; numSwaps = 0;
    ArrayList<Comparable> data = input;

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos = 0;

    numComparisons = 0; numSwaps = 0;
    for(int pass = data.size(); pass > 0; pass--) {
      numComparisons++;   // Each time a for loop is run, there's a comparison being made
      System.out.println( "\nbegin pass " + (data.size()-pass) );//diag

      //check for greatest

      for(int index = 0; index < pass; index++) {

        numComparisons++;   // Each time a for loop is run, there's a comparison being made        if(data.get(index).compareTo( data.get(maxPos)  ) > 0) {

          if (data.get(index).compareTo( data.get(maxPos) ) > 0 ) {maxPos = index;}
      }
        numComparisons++;
        System.out.println( "maxPos: " + maxPos );//diag
        System.out.println( data );//diag
      //}

      //shift
        data.add(pass, data.get(maxPos));
        data.remove(data.get(maxPos));
        numSwaps++;

      }

      System.out.println( "after swap: " +  data );//diag
      System.out.println("# of Comparisons: " + numComparisons);
      System.out.println("# of Swaps: " + numSwaps);
      return data;
    }


  public static ArrayList<Comparable> insertion (ArrayList<Comparable> input ){
    numComparisons = 0; numSwaps = 0;
   ArrayList<Comparable> data = input;
   for(int partition = 0; partition < data.size() - 1; partition++  ) {
     numComparisons++;   // Each time a for loop is run, there's a comparison being made
     //partition marks first item in unsorted region

     System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
     System.out.println( data );

     //traverse sorted region from right to left
     for(int j = partition + 1; j > 0; j--) {
       numComparisons++;
       // "walk" the current item to where it belongs
       // by swapping adjacent items
       if ( data.get(j).compareTo( data.get(j - 1) ) < 0  ) {

         System.out.println( "swap indices "+ (j) +" & "+ (j - 1) +"..." ); //diag

         Comparable temp = data.get(j);
         data.set(j, data.get(j - 1));
         data.set(j - 1, temp);
         numSwaps++;
       }
       else

         break;
     }
   }
   System.out.println("# of Comparisons: " + numComparisons);
   System.out.println("# of Swaps: " + numSwaps);
   return data;
 }

}
