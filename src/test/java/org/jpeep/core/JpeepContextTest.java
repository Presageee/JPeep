package org.jpeep.core;

import org.junit.Test;

/**
 * Created by LJT on 17-8-11.
 * email: ljt1343@gmail.com
 */
public class JpeepContextTest {

    @Test
    public void getInstanceTest() {
        JPeepContext ctx1 = JPeepContext.getInstance();

        JPeepContext ctx2 = JPeepContext.getInstance();

        assert ctx1 == ctx2;
    }
}
