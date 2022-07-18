package com.clipboard.objects;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jitendra.pisal
 */
public final class InstanceRecording {

    private static Map<Class<?>, Object> instanceRecorder = new HashMap();

    public InstanceRecording() {
    }

    public static <T> T getInstance(Class<T> type) {
        return type.cast(instanceRecorder.get(type));
    }

    public static <T> void recordInstance(Class<T> type, T object) {
        instanceRecorder.put((Class) Objects.requireNonNull(type), Objects.requireNonNull(object));
    }

    public static <T> void flushInstance() {
        instanceRecorder.clear();
    }

    public static <T> void restrictObjectCreation(Class<T> type) {
        if (getInstance(type) != null) {
            try {
                throw new IllegalAccessException("Instance creation is restricted");
            } catch (IllegalAccessException var2) {
                var2.printStackTrace();
            }
        }
    }
}
