package com.amannmalik.components.jetty.test;

import com.amannmalik.components.jetty.Entrypoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EntrypointTest {

    @Test
    public void testStartup() {
        var entrypoint = new Entrypoint();
        Assertions.assertDoesNotThrow(()->{
            try {
                CompletableFuture.runAsync(entrypoint::start).get(5L, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                Assertions.assertNotNull(e);
            }
        });
    }
}
