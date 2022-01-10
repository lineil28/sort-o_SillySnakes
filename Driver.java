import java.util.ArrayList;
public class Driver{

  public static void main (String[] args){
    ArrayList coco = Sorts.populate( 10, 1, 1000 );
    Sorts.selection(coco);

  }

}
