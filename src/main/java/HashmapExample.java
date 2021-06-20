import java.util.HashMap;

public class HashmapExample {

    public static void main(String[] args) {

        HashMap<Integer,String> hashmap = new HashMap<Integer,String>();

        Integer key1 = 1;
        String value1 = "Iphone";

        Integer key2 = 16;
        String value2 = "Mac M1";

        hashmap.put(key1,value1);
        hashmap.put(key2,value2);

        System.out.println("Value Searched for Key1 is " + hashmap.get(1));
        System.out.println("Value Searched for Key2 is " + hashmap.get(16));
    }
}
