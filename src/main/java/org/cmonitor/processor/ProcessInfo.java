package org.cmonitor.processor;

import java.util.List;

/**
 * Created by LJT on 17-8-9.
 * email: ljt1343@gmail.com
 */
public class ProcessInfo {
    private String pid;

    private String mainClassName;

    private String fullClassName;

    private String systemClassPath = "";

    private List<String> commandParams;

    private List<String> opts;

    public String getSystemClassPath() {
        return systemClassPath;
    }

    public void setSystemClassPath(String systemClassPath) {
        this.systemClassPath = systemClassPath;
    }

    public List<String> getCommandParams() {
        return commandParams;
    }

    public void setCommandParams(List<String> commandParams) {
        this.commandParams = commandParams;
    }

    public List<String> getOpts() {
        return opts;
    }

    public void setOpts(List<String> opts) {
        this.opts = opts;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getMainClassName() {
        return mainClassName;
    }

    public void setMainClassName(String mainClassName) {
        this.mainClassName = mainClassName;
    }

    public String getFullClassName() {
        return fullClassName;
    }

    public void setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
    }
}
