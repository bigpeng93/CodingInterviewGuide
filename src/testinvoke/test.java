package testinvoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        pushhook pushhook = new pushhook();
        checkAndPushString(pushhook, "Project", "name");
        checkAndPushInt(pushhook, "Project", "id");
        System.out.println(pushhook);
    }

    public static void checkAndPushString(pushhook pushhook, String object, String name) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (pushhook.getProject_name() == null) {
            Method method = pushhook.getClass().getMethod("set" + object + "_" + name, String.class);
            method.invoke(pushhook, "wuxiaofang");
        }
    }

    public static void checkAndPushInt(pushhook pushhook, String object, String id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (pushhook.getProject_id() == 0) {
            Method method = pushhook.getClass().getMethod("set" + object + "_" + id, int.class);
            method.invoke(pushhook, 222);
        }
    }
}
