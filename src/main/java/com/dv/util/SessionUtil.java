package com.dv.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    private static SessionUtil instance;

    private SessionUtil() {
    }

    public static SessionUtil getInstance() {
        if (instance == null) {
            instance = new SessionUtil();
        }
        return instance;
    }

    public Object getValue(HttpServletRequest req, String key) {
        HttpSession session = req.getSession();
        Object value = session.getAttribute(key);
        return value;
    }

    public void setValue(HttpServletRequest req, String key, Object value) {
        HttpSession session = req.getSession();
        session.setAttribute(key, value);
    }

    public void removeValue(HttpServletRequest req, String key) {
        HttpSession session = req.getSession();
        session.removeAttribute(key);
    }
}
