// Task018:

package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.lang.Integer;

class MyConsumer implements Consumer<Integer>{

    public void accept(Integer t) {
        System.out.println("Consumer impl Value::"+t);
    }
}

public class Task018 {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i< 10; i++){
            myList.add(i);
        }

        for (Integer i : myList) {
            System.out.println("Iterator Value::" + i);
        }

        myList.forEach(t ->
                System.out.println("forEach anonymous class Value::"+t));

        MyConsumer action = new MyConsumer();
        myList.forEach(action);
    }
}