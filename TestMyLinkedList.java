/**
 * Created by zunlin on 3/3/17.
 */
import java.util.Arrays;
public class TestMyLinkedList {
    public static void main(String[] args){
        MyLinkedList<String> stringList;

        stringList = new MyLinkedList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("pineapple");
        stringList.add("orange");
        stringList.add("kiwi");
        stringList.add("blueberry");
        stringList.add("orange");
        stringList.add("strawberry");


        System.out.println(stringList);

        System.out.println(stringList.get(4));
        stringList.add(0,"yellow-berry");
        System.out.println(stringList);
        stringList.remove(1);
        System.out.println(stringList);
        System.out.println(stringList.indexOf("orange"));
        stringList.remove("yellow-berry");
        System.out.println(stringList);
        System.out.println(stringList.remove("berry"));

        try {
            System.out.println(stringList.remove(null));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(stringList);
        try {
            System.out.println(stringList.get(10));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        System.out.println(stringList.lastIndexOf("orange"));

        System.out.println(Arrays.toString(stringList.toArray()));
    }
}
