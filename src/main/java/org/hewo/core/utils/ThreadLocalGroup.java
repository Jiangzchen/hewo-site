package org.hewo.core.utils;

public class ThreadLocalGroup {
    private static final String USERID = "userId";
    private static final String TOKEN = "token";

    public ThreadLocalGroup() {
    }

    public static void set(String key, Object value) {
        ThreadLocalGroupUtil.put(key, value);
    }

    public static Object get(String key) {
        return ThreadLocalGroupUtil.get(key);
    }

    public static void remove() {
        ThreadLocalGroupUtil.remove();
    }

    public static void setUserId(String userId) {
        ThreadLocalGroupUtil.put("userId", userId);
    }

    public static String getUserId() {
        return returnObjectValueInteger(ThreadLocalGroupUtil.get("userId"));
    }

    public static void setToken(String token) {
        ThreadLocalGroupUtil.put("token", token);
    }

    public static String getToken() {
        return ThreadLocalGroupUtil.get("token") == null ? null : String.valueOf(ThreadLocalGroupUtil.get("token"));
    }

    public static String getStringValue(String key) {
        return returnObjectValue(ThreadLocalGroupUtil.get(key));
    }

    private static String returnObjectValue(Object value) {
        return value == null ? null : value.toString();
    }

    private static String returnObjectValueInteger(Object value) {
        return value == null ? null : String.valueOf(value.toString());
    }
}
