package it.slowik.processor;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by suowik
 * 01.02.14.
 */
@Test
public class ProcessorTest {

    @BeforeTest
    public void setup() {
    }

    public void shouldBeConstructedProperly() {
        String facade = "TestFacadeRemote";
        String replace = facade.replace("FacadeRemote","");
        assertEquals(replace,"Test");
    }

}
