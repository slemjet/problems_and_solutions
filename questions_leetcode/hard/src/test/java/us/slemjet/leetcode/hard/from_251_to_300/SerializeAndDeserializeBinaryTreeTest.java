package us.slemjet.leetcode.hard.from_251_to_300;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.slemjet.leetcode.hard.from_251_to_300.SerializeAndDeserializeBinaryTree.TreeNode;

import java.util.stream.Stream;

class SerializeAndDeserializeBinaryTreeTest {

    private static Stream<Arguments> parameters() {
        return Stream.of(
                // Input: root = [1,2,3,null,null,4,5]
                Arguments.of(new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)))),
                // Input: root = []
                Arguments.of((Object) null),
                // Input: root = [1]
                Arguments.of(new TreeNode(1)),
                // Input: root = [1,2]
                Arguments.of(new TreeNode(1, new TreeNode(2), null)),
                // Input: root = [1,null,2]
                Arguments.of(new TreeNode(1, null, new TreeNode(2))),
                // Input: root = [1,2,3,null,null,4,5,6,7]
                Arguments.of(new TreeNode(1,
                        new TreeNode(2),
                        new TreeNode(3,
                                new TreeNode(4,
                                        new TreeNode(6),
                                        new TreeNode(7)),
                                new TreeNode(5)))),
                // Input: root = [4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
                Arguments.of(new TreeNode(4,
                        new TreeNode(-7),
                        new TreeNode(-3,
                                new TreeNode(-9,
                                        new TreeNode(9,
                                                new TreeNode(6, new
                                                        TreeNode(0, null, new TreeNode(-1)),
                                                        new TreeNode(6, new TreeNode(-4), null)),
                                                null),
                                        new TreeNode(-7,
                                                new TreeNode(-6, new TreeNode(5), null),
                                                new TreeNode(-6,
                                                        new TreeNode(9, new TreeNode(2), null),
                                                        null))),
                                new TreeNode(-3, new TreeNode(-4), null))))
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    /**
     * Your Codec object will be instantiated and called as such:
     * Codec ser = new Codec();
     * Codec deser = new Codec();
     * TreeNode ans = deser.deserialize(ser.serialize(root));
     */
    void testCodecDfs(TreeNode input) {

        // Given
        SerializeAndDeserializeBinaryTree.CodecDfs ser = new SerializeAndDeserializeBinaryTree.CodecDfs();
        SerializeAndDeserializeBinaryTree.CodecDfs deser = new SerializeAndDeserializeBinaryTree.CodecDfs();

        // When
        TreeNode result = deser.deserialize(ser.serialize(input));

        // Then
        Assertions.assertThat(result).isEqualTo(input);
    }

    @ParameterizedTest
    @MethodSource("parameters")
    /**
     * Your Codec object will be instantiated and called as such:
     * Codec ser = new Codec();
     * Codec deser = new Codec();
     * TreeNode ans = deser.deserialize(ser.serialize(root));
     */
    void testCodecBfs(TreeNode input) {

        // Given
        SerializeAndDeserializeBinaryTree.CodecBfs ser = new SerializeAndDeserializeBinaryTree.CodecBfs();
        SerializeAndDeserializeBinaryTree.CodecBfs deser = new SerializeAndDeserializeBinaryTree.CodecBfs();

        // When
        TreeNode result = deser.deserialize(ser.serialize(input));

        // Then
        Assertions.assertThat(result).isEqualTo(input);
    }
}