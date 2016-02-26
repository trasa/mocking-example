package com.meancat.mocking;

import java.util.Random;

/**
 * This is a nifty service that does cool things.
 */
public class CoolService {

    /**
     * java.util.Random to generate randomness.
     */
    Random random = new Random();


    /**
     * Cool numbers are neat.
     *
     * @return some random number
     */
    public int getCoolNumber() {
        return  random.nextInt();
    }
}
