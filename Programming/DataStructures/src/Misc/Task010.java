// Task010: Print the corner nodes of a binary search tree.

package Misc;

import Trees.PublicBST;

public class Task010 {
    public static void main(String[] args) {
        PublicBST tree = new PublicBST();
        for (int i = 1; i < 16; i++) {
            tree.insert(i);
        }
    }
}
