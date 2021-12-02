package org.example.used;


import com.google.common.eventbus.Subscribe;

/**
 * TODO
 *
 * @author chenrong
 * @version 1.0
 * @since 2021/6/3
 **/
public class LongObserver {

    @Subscribe
    public void a(long userId) {
        System.out.println("Test01Observer a user_id: " + userId);
    }

}
