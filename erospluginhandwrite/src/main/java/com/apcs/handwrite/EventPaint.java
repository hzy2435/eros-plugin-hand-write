package com.apcs.handwrite;

import android.content.Context;
import android.print.PrintManager;

import com.apcs.handwrite.manager.PaintManager;
import com.benmu.framework.manager.ManagerFactory;
import com.benmu.framework.manager.impl.dispatcher.DispatchEventManager;
import com.benmu.framework.model.WeexEventBean;
import com.benmu.wxbase.EventGate;
import com.taobao.weex.bridge.JSCallback;

public class EventPaint extends EventGate {
    @Override
    public void perform(Context context, WeexEventBean weexEventBean) {
        paint(context, weexEventBean.getJscallback());
    }

    public void paint(Context context, JSCallback jscallback) {
        if (context == null) return;
        PaintManager printManager = ManagerFactory.getManagerService(PaintManager.class);
        printManager.openHandWritePage(context);
        ManagerFactory.getManagerService(DispatchEventManager.class).getBus().register(this);
    }
}
