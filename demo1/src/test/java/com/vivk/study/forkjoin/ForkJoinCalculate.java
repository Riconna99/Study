package com.vivk.study.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {
    private long start;
    private long end;
    private static final  long THRESHOLD=10000;
    @Override
    protected Long compute() {
        return null;
    }
}
