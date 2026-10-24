package com.kkpa;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

/**
 * Shared helpers for tests of classes that print to System.out
 * or keep their logic in private static methods.
 */
public final class TestSupport {

  @FunctionalInterface
  public interface Action {
    void run() throws Exception;
  }

  private TestSupport() {
  }

  /**
   * Runs the action and returns what it printed to System.out. Line endings are normalized to "\n".
   */
  public static String captureOutput(Action action) {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    try {
      System.setOut(new PrintStream(output, true));
      action.run();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      System.setOut(originalOut);
    }
    return output.toString().replace("\r\n", "\n");
  }

  /**
   * Calls a static method of any visibility. Exceptions thrown by the method are rethrown unwrapped
   * when they are unchecked, so tests can expect them directly.
   */
  @SuppressWarnings("unchecked")
  public static <T> T invokeStatic(Class<?> type, String methodName, Class<?>[] parameterTypes, Object... args) {
    try {
      Method method = type.getDeclaredMethod(methodName, parameterTypes);
      method.setAccessible(true);
      return (T) method.invoke(null, args);
    } catch (InvocationTargetException e) {
      Throwable cause = e.getCause();
      if (cause instanceof RuntimeException) {
        throw (RuntimeException) cause;
      }
      if (cause instanceof Error) {
        throw (Error) cause;
      }
      throw new RuntimeException(cause);
    } catch (ReflectiveOperationException e) {
      throw new IllegalStateException(type.getSimpleName() + "." + methodName + " not found", e);
    }
  }
}
