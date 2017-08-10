package org.cmonitor.processor;

import org.cmonitor.core.CMonitorContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.RuntimeMXBean;
import java.util.Map;

/**
 * Created by LJT on 17-8-9.
 * email: ljt1343@gmail.com
 */
public class CollectMaster {

    private Runtime runtime = Runtime.getRuntime();

    private Process master;

    private CMonitorContext context;

    private void initProcessInfo() {

    }

    public void handler() {

        try {
            master = Runtime.getRuntime().exec("jps -vVml");
            BufferedReader reader = new BufferedReader(new InputStreamReader(master.getInputStream()));
            String line = null;

            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            master.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        CollectMaster collectMaster = new CollectMaster();
        while (true) {
            collectMaster.handler();
            System.out.println("\033[H\033[2J");
            System.out.flush();
            Thread.sleep(2000);
        }
    }
}
