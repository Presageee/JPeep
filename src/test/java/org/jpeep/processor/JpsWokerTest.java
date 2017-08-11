package org.jpeep.processor;

import org.jpeep.core.JPeepContext;
import org.junit.Test;

/**
 * Created by LJT on 17-8-11.
 * email: ljt1343@gmail.com
 */
public class JpsWokerTest {

    @Test
    public void testHandler() throws InterruptedException {
        JPeepContext context = JPeepContext.getInstance();

        JpsWorker worker = new JpsWorker();
        worker.setContext(context);

        worker.handler();

        Thread.sleep(1999);
        assert context.getProcessMap().size() > 0;
    }
}
