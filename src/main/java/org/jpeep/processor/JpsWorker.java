package org.jpeep.processor;

import org.jpeep.core.JPeepContext;
import org.jpeep.resource.Memory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.jpeep.core.JPeepConstant.FULL_NAME;
import static org.jpeep.core.JPeepConstant.PARAM_OR_OPTS;
import static org.jpeep.core.JPeepConstant.PID;

/**
 * Created by LJT on 17-8-9.
 * email: ljt1343@gmail.com
 */
public class JpsWorker extends Worker {
    private static final Logger log = LoggerFactory.getLogger(JpsWorker.class);

    private JPeepContext context;

    public void setContext(JPeepContext context) {
        this.context = context;
        processInfoMap = context.getProcessMap();
    }

    private Map<String, ProcessInfo> processInfoMap;

    private Runtime runtime = Runtime.getRuntime();

    @Override
    public void run() {

    }

    public void handler() {
        try {
            Process process = runtime.exec("jps -vVml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;

            while((line = reader.readLine()) != null) {
                log.debug("[debug] >>> {}", line);
                parseInfo(line);
            }

            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseInfo(String line) {
        String[] data = line.split(" ");

        String pid = data[PID];

        //check
        if (processInfoMap.containsKey(pid))
            return;

        String fullName = data[FULL_NAME];
        String name = getName(fullName);

        List<String> cmdParams = new ArrayList<>();
        List<String> opts = new ArrayList<>();

        int i = PARAM_OR_OPTS;
        for (; i < data.length; i++) {
            if (data[i].startsWith("-"))
                break;

            cmdParams.add(data[i]);
        }

        for (; i < data.length; i++) {
            opts.add(data[i]);
        }

        ProcessInfo processInfo = new ProcessInfo(pid, name, fullName, cmdParams, opts);

        setMemory(processInfo);

        processInfoMap.put(pid, processInfo);
    }

    private void setMemory(ProcessInfo info) {
        Memory memory = null;

//        StringBuilder sb = new StringBuilder();
//        boolean haveHeapOpts = info.getOpts().stream().anyMatch(e -> {
//            if (e.contains("Xmx")) {
//                sb.append(e.replaceAll("-Xmx", ""));
//                return true;
//            }
//            return false;
//        });
//
//        if (haveHeapOpts) {
//            String heap = sb.toString();
//            float maxHeap = 0.0f;
//
//            switch (heap.charAt(heap.length() - 1)) {
//                case 'g':
//                    maxHeap = getDigital(heap) * 1024 * 1024;
//                    break;
//                case 'm':
//                    maxHeap = getDigital(heap) * 1024;
//                    break;
//                default:
//                    maxHeap = getDigital(heap);
//
//            }
//
//            memory = new Memory(maxHeap);
//            info.setMemory(memory);
//        } else {
            memory = new Memory();
            info.setMemory(memory);

            GCCapacityWorker worker = new GCCapacityWorker();
            worker.setProcessInfo(info);
            CompletableFuture.runAsync(worker);
//        }
    }

    private float getDigital(String val) {
        return Float.valueOf(val.substring(0, val.length() - 1));
    }

    private String getName(String fullName) {
        if (fullName.startsWith("/")) {
            String[] data = fullName.split("/");
            return data[data.length - 1];
        } else {
            String[] data = fullName.split("\\.");
            return data[data.length - 1];
        }
    }
}
