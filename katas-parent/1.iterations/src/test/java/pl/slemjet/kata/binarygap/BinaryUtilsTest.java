package pl.slemjet.kata.binarygap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryUtilsTest {

    @Test
    void findLargestBinaryGap() {
        assertEquals(5, BinaryUtils.findLargestBinaryGap(1041));
        assertEquals(0, BinaryUtils.findLargestBinaryGap(15));
        assertEquals(0, BinaryUtils.findLargestBinaryGap(1));
        assertEquals(1, BinaryUtils.findLargestBinaryGap(5));
        assertEquals(0, BinaryUtils.findLargestBinaryGap(2147483647));
        assertEquals(0, BinaryUtils.findLargestBinaryGap(6));
        assertEquals(2, BinaryUtils.findLargestBinaryGap(328));
        assertEquals(0, BinaryUtils.findLargestBinaryGap(16));
        assertEquals(0, BinaryUtils.findLargestBinaryGap(1024));
        assertEquals(2, BinaryUtils.findLargestBinaryGap(9));
        assertEquals(1, BinaryUtils.findLargestBinaryGap(11));
        assertEquals(2, BinaryUtils.findLargestBinaryGap(19));
        assertEquals(1, BinaryUtils.findLargestBinaryGap(42));
        assertEquals(3, BinaryUtils.findLargestBinaryGap(1162));
        assertEquals(2, BinaryUtils.findLargestBinaryGap(51712));
        assertEquals(1, BinaryUtils.findLargestBinaryGap(20));
        assertEquals(1, BinaryUtils.findLargestBinaryGap(42));
        assertEquals(3, BinaryUtils.findLargestBinaryGap(561892));
        assertEquals(9, BinaryUtils.findLargestBinaryGap(66561));
        assertEquals(20, BinaryUtils.findLargestBinaryGap(6291457));
        assertEquals(4, BinaryUtils.findLargestBinaryGap(74901729));
        assertEquals(27, BinaryUtils.findLargestBinaryGap(805306369));
        assertEquals(5, BinaryUtils.findLargestBinaryGap(1376796946));
        assertEquals(29, BinaryUtils.findLargestBinaryGap(1073741825));
        assertEquals(28, BinaryUtils.findLargestBinaryGap(1610612737));
    }

    @Test
    void findLargestBinaryGapNoString() {
        assertEquals(5, BinaryUtils.findLargestBinaryGapNoString(1041));
        assertEquals(0, BinaryUtils.findLargestBinaryGapNoString(15));
        assertEquals(0, BinaryUtils.findLargestBinaryGapNoString(1));
        assertEquals(1, BinaryUtils.findLargestBinaryGapNoString(5));
        assertEquals(0, BinaryUtils.findLargestBinaryGapNoString(2147483647));
        assertEquals(0, BinaryUtils.findLargestBinaryGapNoString(6));
        assertEquals(2, BinaryUtils.findLargestBinaryGapNoString(328));
        assertEquals(0, BinaryUtils.findLargestBinaryGapNoString(16));
        assertEquals(0, BinaryUtils.findLargestBinaryGapNoString(1024));
        assertEquals(2, BinaryUtils.findLargestBinaryGapNoString(9));
        assertEquals(1, BinaryUtils.findLargestBinaryGapNoString(11));
        assertEquals(2, BinaryUtils.findLargestBinaryGapNoString(19));
        assertEquals(1, BinaryUtils.findLargestBinaryGapNoString(42));
        assertEquals(3, BinaryUtils.findLargestBinaryGapNoString(1162));
        assertEquals(2, BinaryUtils.findLargestBinaryGapNoString(51712));
        assertEquals(1, BinaryUtils.findLargestBinaryGapNoString(20));
        assertEquals(1, BinaryUtils.findLargestBinaryGapNoString(42));
        assertEquals(3, BinaryUtils.findLargestBinaryGapNoString(561892));
        assertEquals(9, BinaryUtils.findLargestBinaryGapNoString(66561));
        assertEquals(20, BinaryUtils.findLargestBinaryGapNoString(6291457));
        assertEquals(4, BinaryUtils.findLargestBinaryGapNoString(74901729));
        assertEquals(27, BinaryUtils.findLargestBinaryGapNoString(805306369));
        assertEquals(5, BinaryUtils.findLargestBinaryGapNoString(1376796946));
        assertEquals(29, BinaryUtils.findLargestBinaryGapNoString(1073741825));
        assertEquals(28, BinaryUtils.findLargestBinaryGapNoString(1610612737));
    }
}
