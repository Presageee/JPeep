package org.jpeep.processor;

import org.jpeep.resource.Memory;

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

    private Memory memory;

    public ProcessInfo() {
    }

    public ProcessInfo(String pid, String mainClassName, String fullClassName,
                       List<String> commandParams, List<String> opts) {
        this.pid = pid;
        this.mainClassName = mainClassName;
        this.fullClassName = fullClassName;
        this.commandParams = commandParams;
        this.opts = opts;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

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
