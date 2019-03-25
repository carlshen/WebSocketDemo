package com.zhangke.websocket.request;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.zhangke.websocket.util.TextUtil;

import org.java_websocket.client.WebSocketClient;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * String 类型的请求
 * <p>
 * Created by ZhangKe on 2019/3/22.
 */
public class StringRequest implements Request<String> {

    private static Queue<StringRequest> CACHE_QUEUE = new ArrayDeque<>(10);

    public static StringRequest obtain() {
        StringRequest request = CACHE_QUEUE.poll();
        if (request == null) {
            request = new StringRequest();
        }
        return request;
    }

    public static void release(StringRequest request) {
        CACHE_QUEUE.offer(request);
    }

    private String requestText;

    @Override
    public void setRequestData(String data) {
        this.requestText = data;
    }

    @Override
    public String getRequestData() {
        return requestText;
    }

    @Override
    public void send(WebSocketClient client) {
        client.send(requestText);
    }

    @Override
    public void release() {
        release(this);
    }

    @NonNull
    @Override
    public String toString() {
        return String.format("@StringRequest%s,requestText:%s",
                hashCode(),
                TextUtil.isEmpty(requestText) ?
                        "null" :
                        requestText);
    }
}