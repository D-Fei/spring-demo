package com.boss.learning.springerr.common;

public class MyThrowsException {


    public  static  void throwErr(IMyException myException) {
        throw new MyRunTimeException(myException);
    }

    public static void throwErr(final Exception e) {
        throw new MyRunTimeException(new IMyException() {
            public int code() {
                return -1;
            }

            public String msg() {
                return e.toString();
            }
        });
    }
}
