package com.barracuda.rtdict.util.random;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author artur
 */
public class RandomizerTest {
    
    public RandomizerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of shuffle method, of class Randomizer.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        List list = null;
        Randomizer.shuffle(list);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffleRx method, of class Randomizer.
     */
    @Test
    public void testShuffleRx() {
        System.out.println("shuffleRx");
        List expResult = null;
        List result = Randomizer.shuffleRx(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffleCopy method, of class Randomizer.
     */
    @Test
    public void testShuffleCopy() {
        System.out.println("shuffleCopy");
        List expResult = null;
        List result = Randomizer.shuffleCopy(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Randomizer.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Randomizer.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
