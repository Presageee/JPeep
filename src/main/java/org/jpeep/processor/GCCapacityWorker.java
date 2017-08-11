package org.jpeep.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.jpeep.core.JPeepConstant.GC_CAPACITY_CMD;
import static org.jpeep.core.JPeepConstant.GC_CAPACITY_NGCMX;
import static org.jpeep.core.JPeepConstant.GC_CAPACITY_OGCMX;

/**
 * Created by LJT on 17-8-10.
 * email: ljt1343@gmail.com
 */
public class GCCapacityWorker extends JStatWorker {
    private static final Logger log = LoggerFactory.getLogger(GCCapacityWorker.class);

    private ProcessInfo processInfo;

    public GCCapacityWorker() {

    }

    public void setProcessInfo(ProcessInfo processInfo) {
        this.processInfo = processInfo;
    }

    @Override
    public void run() {
        handler();
    }

    @Override
    public void handler() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(String.format(GC_CAPACITY_CMD, processInfo.getPid()));

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = null;
            int time = 0;
            while ((line = reader.readLine()) != null) {
                log.debug("[debug] >>> {}", line);

                if (time == 1) {
                    setMemory(line);
                }

                time ++;
            }

        } catch (IOException e) {
            e.printStackTrace();
            log.error("[error] >>> exce cmd {} error!!!", String.format(GC_CAPACITY_CMD, processInfo.getPid()));
        } finally {
            if (process != null)
                process.destroyForcibly();
        }

    }

    private void setMemory(String line) {
        List<Float> data = parseOutput(line);

        processInfo.getMemory().setMaxNewGeneration(data.get(GC_CAPACITY_NGCMX));
        processInfo.getMemory().setMaxOldSpace(data.get(GC_CAPACITY_OGCMX));
        processInfo.getMemory().setMaxHeap(processInfo.getMemory().getMaxNewGeneration()
                + processInfo.getMemory().getMaxOldSpace());
    }

    private List<Float> parseOutput(String line) {
        StringBuilder builder = new StringBuilder();
        List<Float> data = new ArrayList<>();

        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                builder.append(chars[i]);
            } else {
                String val = builder.toString();

                if (val.length() > 0) {
                    data.add(Float.valueOf(val));
                    builder = new StringBuilder();
                }
            }
        }

        String val = builder.toString();
        if (val.length() > 0) {
            data.add(Float.valueOf(val));
        }

        return data;
    }

}
