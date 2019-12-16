package com.apcs.handwrite.module;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.benmu.framework.constant.WXEventCenter;
import com.benmu.framework.manager.ManagerFactory;
import com.benmu.framework.manager.impl.dispatcher.DispatchEventManager;
import com.benmu.framework.model.WeexEventBean;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.bridge.JSCallback;

import java.util.ArrayList;

@WeexModule(name = "bmPaint", lazyLoad = true)
public class PaintModule extends WXModule {
    @JSMethod
    public void openPrintPage(String params, JSCallback successCallback, JSCallback
            failedCallback) {
        WeexEventBean weexEventBean = new WeexEventBean();
        weexEventBean.setKey(WXEventCenter.EVENT_RELAYTOFRIEND);
        weexEventBean.setContext(mWXSDKInstance.getContext());
        weexEventBean.setJsParams(params);
        ArrayList<JSCallback> callbacks = new ArrayList<>();
        callbacks.add(successCallback);
        callbacks.add(failedCallback);
        weexEventBean.setCallbacks(callbacks);
        ManagerFactory.getManagerService(DispatchEventManager.class).getBus().post(weexEventBean);
    }
}
