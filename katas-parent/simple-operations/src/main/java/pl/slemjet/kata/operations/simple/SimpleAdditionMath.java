package pl.slemjet.kata.operations.simple;

/**
 *  Provides arithmetical operations using addition only
 */
public class SimpleAdditionMath implements BasicMath {

    /**
     * increase result so many times as input is decreased by module
     * @param a
     * @return
     */
    @Override
    public int negate(int a){
        int basic = a > 0 ? -1 : 1;

        int result = 0;

        while(a != 0){
            a = a + basic;
            result = result + basic;
        }

        return result;
    }

    /**
     * Sum with negated value
     * @param a
     * @param b
     * @return
     */
    @Override
    public int subtract(int a, int b){
        return a + negate(b);
    }

    /**
     * summing a times b
     * @param a
     * @param b
     * @return
     */
    @Override
    public int multiply(int a, int b){
        if(b > a){
            return multiply(b, a);
        }

        int result = 0;

        for(int i = 0; i < abs(b); i++){
            result = result + a;
        }

        return b < 0 ? negate(result) : result;

    }

    /**
     * Return always positive
     * @param a
     * @return
     */
    @Override
    public int abs(int a){
        return a < 0 ? negate(a): a;
    }

    /**
     * sum b that many times untill it is less than or equal to a
     * @param a
     * @param b
     * @return
     */
    @Override
    public int divide(int a, int b){
        if(b == 0){
            throw  new IllegalArgumentException("cannot divide by 0");
        }else if (a == 0){
            return 0;
        }

        int absa = abs(a);
        int absb = abs(b);

        int result = 0;
        int tempRes = absb;

        while(tempRes <= absa){
            result = result + 1;
            tempRes = tempRes + absb;
        }

        if((a > 0 && b > 0) || (a < 0 && b < 0)){
            return result;
        }else{
            return negate(result);
        }
    }
}
