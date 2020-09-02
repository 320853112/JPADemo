package com.xu.suger;

import java.io.Closeable;
import java.io.IOException;

public class MyResource1 implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("close1");
    }
}
