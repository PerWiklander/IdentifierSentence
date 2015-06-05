package biz.wiklander.tools;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class IdentifierSentenceTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public final void testParse() {
        String knownSentence = "8 mad orcs stomp loudly";
        long id = IdentifierSentence.parseSentence(knownSentence);

        Assert.assertEquals(id, 2271002600L);
    }

    @Test
    public final void testRandomSentence() {
      String randomSentence = IdentifierSentence.random();

      Assert.assertNotSame(randomSentence, "");

      System.out.printf(
        "The sentence \"%s\" corresponds to the id %d%n",
        randomSentence, IdentifierSentence.parseSentence(randomSentence)
      );
    }
}
