package com.amannmalik.components.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class Entrypoint {
    public static void main(String[] args) {
        var entrypoint = new Entrypoint();
        entrypoint.start();
    }
    public void start() {
        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setName("server");
        Server server = new Server(threadPool);
        Connector connector = new ServerConnector(server);
        server.addConnector(connector);
        server.setHandler(new Handler.Abstract() {
            @Override
            public boolean handle(Request request, Response response, Callback callback) {
                callback.succeeded();
                return true;
            }
        });
        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
