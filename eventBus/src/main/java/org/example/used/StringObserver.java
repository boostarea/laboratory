package org.example.used;


import com.google.common.eventbus.Subscribe;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/3
 **/
public class StringObserver {

    @Subscribe
    public void b(String userId) {
        System.out.println("StringObserver b user_id:" + userId);
    }
}
