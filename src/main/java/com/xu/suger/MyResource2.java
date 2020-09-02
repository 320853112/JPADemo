package com.xu.suger;

import java.io.Closeable;
import java.io.IOException;

public class MyResource2 implements AutoCloseable {
    @Override
    public void close() throws IOException {
        System.out.println("close2");
    }
}
