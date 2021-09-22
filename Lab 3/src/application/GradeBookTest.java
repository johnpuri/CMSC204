package application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GradeBookTest
{
    private GradeBook gradebook1;
    private GradeBook gradebook2;
    
    @Before
    public void setUp()
    {
        gradebook1 = new GradeBook(5);
        gradebook2 = new GradeBook(5);
        
      
        gradebook1.addScore(85.0);
        gradebook1.addScore(92.0);
        gradebook1.addScore(100.0);
        gradebook2.addScore(65.0);
        gradebook2.addScore(70.0);
        gradebook2.addScore(75.0);
    }
    
    @After
    public void tearDown()
    {
      
        gradebook1 = null;
        gradebook2 = null;
    }
    @Test
    public void testSum()
    {
        assertEquals(gradebook2.sum(), 210.0, 0.1);
    }
    @Test
    public void testMinimum()
    {
        assertEquals(gradebook2.minimum(), 65.0, 0.1);
    }
    
    
    @Test
    public void testAddScore()
    {
        assertEquals(gradebook1.toString(), "85.0 92.0 100.0 0.0 0.0");
        assertEquals(gradebook1.getScoresSize(), 3);
    }
  
    @Test
    public void testFinalScore()
    {
        assertEquals(gradebook2.finalScore(), 145.0, 0.1);
    }
}