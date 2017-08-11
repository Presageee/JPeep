package org.jpeep.processor;

import org.jpeep.resource.Memory;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.assertTrue;

/**
 * Created by LJT on 17-8-11.
 * email: ljt1343@gmail.com
 */
public class GCCapacityWorkerTest {

    @Test
    public void handlerTest() {
        ProcessInfo info = new ProcessInfo();

        try {
            Process process = Runtime.getRuntime().exec("jps -vVml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;

            while((line = reader.readLine()) != null) {
                info.setPid(line.split(" ")[0]);
            }

            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Memory memory = new Memory();
        info.setMemory(memory);

        GCCapacityWorker worker = new GCCapacityWorker();
        worker.setProcessInfo(info);
        worker.handler();

        assertTrue(info.getMemory().getMaxHeap() == info.getMemory().getMaxNewGeneration() + info.getMemory().getMaxOldSpace());
    }
}
