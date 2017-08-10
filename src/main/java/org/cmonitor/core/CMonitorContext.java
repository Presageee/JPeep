package org.cmonitor.core;

import org.cmonitor.processor.ProcessInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LJT on 17-8-9.
 * email: ljt1343@gmail.com
 */
public class CMonitorContext {

    private CMonitorContext() {

    }

    public static CMonitorContext getInstance() {
        return CMonitorContextHelper.context;
    }

    private static class CMonitorContextHelper {
        private static CMonitorContext context = new CMonitorContext();
    }

    private Map<String, ProcessInfo> processMap = new HashMap<>();

    public Map<String, ProcessInfo> getProcessMap() {
        return processMap;
    }
}
