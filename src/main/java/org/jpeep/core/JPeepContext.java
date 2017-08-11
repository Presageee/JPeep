package org.jpeep.core;

import org.jpeep.processor.ProcessInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LJT on 17-8-9.
 * email: ljt1343@gmail.com
 */
public class JPeepContext {

    private JPeepContext() {

    }

    public static JPeepContext getInstance() {
        return CMonitorContextHelper.context;
    }

    private static class CMonitorContextHelper {
        private static JPeepContext context = new JPeepContext();
    }

    private Map<String, ProcessInfo> processMap = new HashMap<>();

    public Map<String, ProcessInfo> getProcessMap() {
        return processMap;
    }
}
