package com.kkpa.hackerrank.java.strings;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TagContentExtractorTests {

  private TagContentExtractor contentExtractor;

  @Before
  public void setup() {
    contentExtractor = new TagContentExtractor();
  }

  @Test
  @Ignore
  public void givenHTMLContentThenShouldExtractContent() {
    String word = "<SA premium>Imtiaz has a secret crush</SA premium>";

    List<String> contentExtract = contentExtractor.extract(word);

    assertEquals(Collections.singletonList("Imtiaz has a secret crush"), contentExtract);

  }

  @Test
  public void givenBadHTMLContentThenShouldExtractContent() {
    String word = "<Amee>safat codes like a ninja</amee>";

    List<String> contentExtract = contentExtractor.extract(word);

    assertEquals(Collections.emptyList(), contentExtract);

  }

  @Test
  public void givenInnerHTMLContentThenShouldExtractContent() {
    String word = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";

    List<String> contentExtract = contentExtractor.extract(word);

    assertEquals(Arrays.asList("Sanjay has no watch", "So wait for a while"), contentExtract);

  }

  @Test
  public void givenInnerXHTMLContentThenShouldExtractContent() {
    String word = "<h1><h1>Sanjay has no watch</h1></h2><par>So wait for a while</par>";

    List<String> contentExtract = contentExtractor.extract(word);

    assertEquals(Arrays.asList("Sanjay has no watch", "So wait for a while"), contentExtract);

  }

}
