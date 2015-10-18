package com.toucheqt.pso.entity;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

/**
 * 
 * Singleton object for managing thread synchronization. Built-in semaphore is always created with one permit.
 * 
 * @author Ondøej Krpecm, xkrpecqt@gmail.com
 *
 */
public class GUILock {

    private Semaphore semaphore = new Semaphore(1);

    private GUILock() {}

    private static class SingletonHolder {

        static GUILock instance = new GUILock();
    }

    public static GUILock getInstance() {
        return SingletonHolder.instance;
    }

    public void acquire() {
        try {
            semaphore.acquire();
        } catch (InterruptedException ie) {
            Logger.getLogger(getClass()).log(Level.SEVERE, "Could not acquire semaphore permit.");
        }
    }

    public void release() {
        semaphore.release();
    }
}
