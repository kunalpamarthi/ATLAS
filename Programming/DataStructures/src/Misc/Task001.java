// Task001: Hashing

package Misc;

import java.util.LinkedList;

class Hash{
    LinkedList<Entry>[] data = new LinkedList[10];

    public void put(String keyVal, int value) {
        int index = Math.abs(keyVal.hashCode() % data.length);

        if (data[index] == null) {
            data[index] = new LinkedList<>();
        }
        for (Entry e : data[index]) {
            if (e.keyVal.equals(keyVal)) {
                e.value = value;
                return;
            }
        }

        data[index].add(new Entry(keyVal, value));
    }

    static class Entry {
        String keyVal;
        int value;

        Entry(String k, int v) {
            keyVal = k;
            value = v;
        }
    }
    void printData(){
        for (LinkedList<Entry> entries: data){
            if (entries != null){
                for (Entry entry: entries){
                    System.out.print(entry.keyVal+ ": "+entry.value+", ");
                }
            } else {
                System.out.print("NULL");
            }
            System.out.println();
        }
    }
}

public class Task001 {
    public static void main(String[] args) {
        Hash hash = new Hash();
        for (int i = 1; i <= 10; i++) {
            hash.put((i*i)+" ", i);
        }
        hash.printData();
    }
}
