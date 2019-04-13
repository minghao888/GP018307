package com.gopaoedu.abserverPattern.events;


import com.gopaoedu.abserverPattern.events.mouseEvent.Mouse;
import com.gopaoedu.abserverPattern.events.mouseEvent.MouseEventCallback;
import com.gopaoedu.abserverPattern.events.mouseEvent.MouseEventType;

/**
 * Created by Tom on 2019/3/17.
 */
public class MouseEventTest {
    public static void main(String[] args) {

        MouseEventCallback callback = new MouseEventCallback();

        Mouse mouse = new Mouse();

        //@谁？  @回调方法  注册
        mouse.addLisenter(MouseEventType.ON_CLICK,callback);
        mouse.addLisenter(MouseEventType.ON_FOCUS,callback);

        mouse.click();

        mouse.focus();


    }
}
