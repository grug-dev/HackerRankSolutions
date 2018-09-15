package com.kkpa.hackerrank.java.strings;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
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

    String contentExtract = contentExtractor.extract(word);

    assertEquals("Imtiaz has a secret crush", contentExtract);

  }

  @Test
  @Ignore
  public void givenBadHTMLContentThenShouldExtractContent() {
    String word = "<Amee>safat codes like a ninja</amee>";

    String contentExtract = contentExtractor.extract(word);

    assertEquals(TagContentExtractor.NONE, contentExtract);

  }

  @Test
  public void givenInnerHTMLContentThenShouldExtractContent() {
    String word = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";

    String contentExtract = contentExtractor.extract(word);

    assertEquals("Sanjay has no watch", contentExtract);

  }

  @Test
  public void givenInnerXHTMLContentThenShouldExtractContent() {
    String word = "<h1><h1>Sanjay has no watch</h1></h2><par>So wait for a while</par>";

    String contentExtract = contentExtractor.extract(word);

    assertEquals("Sanjay has no watch", contentExtract);

  }

}
