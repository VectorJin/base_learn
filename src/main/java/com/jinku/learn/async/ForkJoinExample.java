package com.jinku.learn.async;

import java.util.concurrent.ForkJoinTask;

public class ForkJoinExample {


    public static class CalculateTask extends ForkJoinTask {

        @Override
        public Object getRawResult() {
            return null;
        }

        @Override
        protected void setRawResult(Object value) {

        }

        @Override
        protected boolean exec() {
            return false;
        }


    }
}
