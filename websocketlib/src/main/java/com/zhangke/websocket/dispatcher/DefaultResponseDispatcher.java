package com.zhangke.websocket.dispatcher;

import com.zhangke.websocket.response.ErrorResponse;
import com.zhangke.websocket.response.Response;

import org.java_websocket.framing.Framedata;

import java.nio.ByteBuffer;

/**
 * 通用消息调度器，没做任何数据处理
 * Created by ZhangKe on 2018/6/26.
 */
public class DefaultResponseDispatcher implements IResponseDispatcher {

    @Override
    public void onConnected(ResponseDelivery delivery) {
        if (delivery == null) return;
        delivery.onConnected();
    }

    @Override
    public void onConnectFailed(Throwable cause, ResponseDelivery delivery) {
        if (delivery == null) return;
        delivery.onConnectFailed(cause);
    }

    @Override
    public void onDisconnect(ResponseDelivery delivery) {
        if (delivery == null) return;
        delivery.onDisconnect();
    }

    @Override
    public void onMessage(String message, ResponseDelivery delivery) {
        if (delivery == null) return;
        delivery.onMessage(message, null);
    }

    @Override
    public void onMessage(ByteBuffer byteBuffer, ResponseDelivery delivery) {
        if (delivery == null) return;
        delivery.onMessage(byteBuffer, null);
    }

    @Override
    public void onPing(Framedata framedata, ResponseDelivery delivery) {
        if (delivery == null) return;
        delivery.onPing(framedata);
    }

    @Override
    public void onPong(Framedata framedata, ResponseDelivery delivery) {
        if (delivery == null) return;
        delivery.onPong(framedata);
    }

    @Override
    public void onSendDataError(ErrorResponse error, ResponseDelivery delivery) {
        if (delivery == null) return;
        delivery.onSendDataError(error);
    }
}
