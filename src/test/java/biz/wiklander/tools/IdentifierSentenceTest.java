package biz.wiklander.tools;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class IdentifierSentenceTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public final void testParse() {
        String knownSentence = "8 mad orcs stomp loudly";
        int id = IdentifierSentence.parse(knownSentence);

        Assert.assertEquals(id, 23569896);
    }

    @Test
    public final void testRandomSentence() {
        String randomSentence = IdentifierSentence.random();

        Assert.assertNotSame(randomSentence, "");

        System.out.println(
          String.format(
            "The sentence \"%s\" corresponds to the id %d",
            randomSentence, IdentifierSentence.parse(randomSentence)
          )
        );
    }
}
