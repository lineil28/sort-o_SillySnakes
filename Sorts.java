import java.util.ArrayList;
public class Sorts{
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
    boolean isSorted = true;
    ArrayList<Comparable> data = input;
    int size = data.size();
    for (int i = 0; i < size; i++) {
      for (int j = size - 1; j > 0; j--) {
        //swapping
        isSorted = true;
        if (data.get(j).compareTo(data.get(j - 1)) < 0) {
          isSorted = false; //you swap at least once
          int temp = (int) data.get(j);
          int temp2 = (int) data.get(j - 1);
          data.remove(j);
          data.add(j, temp2);
          data.remove(j - 1);
          data.add(j - 1, temp);
         
        }
        
      }
      if (isSorted) {
        break;
        
      }
    }
  return data;  
  }

  public static ArrayList<Comparable> selection( ArrayList<Comparable> input) {
    //maxPos will point to position of SELECTION (greatest value)
    int maxPos = 0;
    ArrayList<Comparable> data = input;
    for(int pass = data.size(); pass > 0; pass--) {
      System.out.println( "\nbegin pass " + (data.size()-pass) );//diag

      //check for greatest
      Comparable greatest = 0;
      for(int index = 0; index < pass; index++) {
        if(data.get(index).compareTo(greatest) > 0) {
          greatest = data.get(index);
          maxPos = index;
        }
        System.out.println( "maxPos: " + maxPos );//diag
        System.out.println( data );//diag
      }

      //shift
      data.add(pass, data.get(maxPos));
      data.remove(data.get(maxPos));

      
      System.out.println( "after swap: " +  data );//diag
    }
    return data;
  }

  public static ArrayList<Comparable> insertion (ArrayList<Comparable> input ){
   ArrayList<Comparable> data = input;
   for(int partition = 0; partition < data.size() - 1; partition++  ) {
     //partition marks first item in unsorted region

     System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
     System.out.println( data );

     //traverse sorted region from right to left
     for(int j = partition + 1; j > 0; j--) {

       // "walk" the current item to where it belongs
       // by swapping adjacent items
       if ( data.get(j).compareTo( data.get(j - 1) ) < 0  ) {

         System.out.println( "swap indices "+ (j) +" & "+ (j - 1) +"..." ); //diag
         
         Comparable temp = data.get(j);
         data.set(j, data.get(j - 1));
         data.set(j - 1, temp);
         
       }
       else
         break;
     }
   }
   return data;
 }
 
}

