package com.kkpa;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Shared helpers for tests of classes that print to System.out.
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
}
