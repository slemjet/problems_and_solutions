package pl.slemjet.kata.tapeequilibrium;

public class FrogJmp {

    public static int jumps(int X, int Y, int D){
        int result = (Y - X - 1 + D) / D;

        return result;
    }
}
