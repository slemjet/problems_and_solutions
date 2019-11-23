package pl.slemjet.katas.nesting;

import java.util.Stack;

public class StoneWall {

    public static int solution(int[] H) {
        // write your code in Java SE 8
        int result = 0;

        Stack<Integer> storedBlocks = new Stack<>();

        for (int i = 0; i < H.length; i++) {
            // we check if previous block is not equal (it is the only case where we do not add new block)

            while (!storedBlocks.isEmpty() && storedBlocks.peek() > H[i]) {
                // previous block was bigger - we need to cut it thus creating new block
                storedBlocks.pop();
                result++;
            }

            if (storedBlocks.isEmpty() || storedBlocks.peek() < H[i]) // add new block if is bigger thn previous
                storedBlocks.push(H[i]);
        }

        return result + storedBlocks.size();
    }
}
