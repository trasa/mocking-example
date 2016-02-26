package com.meancat.mocking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Test the CoolService using Mocks
 */
@RunWith(MockitoJUnitRunner.class)
public class CoolServiceTest {

    @Mock
    Random mockRandom; // our mocked Random class

    @InjectMocks
    CoolService coolService; // the class under test

    @Test
    public void serviceIsCoolEnough() {
        // Arrange:
        // when our mockRandom.nextInt() gets called, return 42.
        when(mockRandom.nextInt()).thenReturn(42);

        // Act:
        int result = coolService.getCoolNumber();
        System.out.println("result was " + result);

        // Assert:
        assertEquals(42, result);
    }

    @Test
    public void serviceIsVeryUncool() {
        // Arrange:
        // when our mockRandom.nextInt() gets called, throw an exception to be surprising.
        when(mockRandom.nextInt()).thenThrow(new NullPointerException("so uncool it threw an exception"));

        // Act:
        boolean caught = false;
        try {
            coolService.getCoolNumber();
        } catch(NullPointerException e) {
            caught = true;
            System.out.println("Exception: " + e.getMessage());
        }

        // Assert:
        assertTrue("should have caught exception", caught);
    }
}
