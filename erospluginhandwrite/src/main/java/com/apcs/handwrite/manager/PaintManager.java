package com.apcs.handwrite.manager;

import android.content.Context;
import android.content.Intent;

import com.apcs.handwrite.activity.PaintActivity;
import com.benmu.framework.constant.Constant;
import com.benmu.framework.manager.Manager;

import java.util.HashMap;

public class PaintManager extends Manager {

//    private List<NotificationBean> notifications;

    @Override
    public HashMap<String, HashMap<String, String>> getComponentsAndModules() {
        HashMap<String, HashMap<String, String>> result = new HashMap<>();

        HashMap<String, String> writeModules = new HashMap<>();
        writeModules.put("hwmodule", "com.apcs.handwrite.module.PaintModule");

        result.put(Constant.CUSTOMER_MODULES, writeModules);

        return result;
    }

//    public void handlePush(Context context, String data) {
//        //判断当前应用是在前台还是后台
////        boolean isForeground = BaseCommonUtil.isAPPRunningForeground(context);
////        ParseManager parseManager = ManagerFactory.getManagerService(ParseManager.class);
////        NotificationBean bean = parseManager.parseObject(data, NotificationBean.class);
////        if (isForeground) {
//        //在前台 通知js
//        Activity activity = RouterTracker.peekActivity();
//        BaseEventBean eventBean = new BaseEventBean();
//        eventBean.context = activity;
//        eventBean.type = WXEventCenter.EVENT_PUSHMANAGER;
//        eventBean.clazzName = "com.eros.framework.event.GlobalEvent";
//        bean.trigger = false;
//        ParseManager param = ManagerFactory.getManagerService(ParseManager.class);
//        String json = param.toJsonString(bean);
//        eventBean.param = json;
//        ManagerFactory.getManagerService(DispatchEventManager.class).getBus().post
//                (eventBean);
//
////        } else {
////            //在后台  显示通知
////            showNotification(context, bean);
////        }
//    }


    public void openHandWritePage(Context context) {
        Intent resultIntent = new Intent(context, PaintActivity.class);
        context.startActivity(resultIntent);
    }
}
