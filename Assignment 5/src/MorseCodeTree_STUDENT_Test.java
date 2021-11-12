

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeTree_STUDENT_Test {

	MorseCodeTree tree;
	String lnrTreeArray;
	
	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
		lnrTreeArray = "[h, s, v, i, f, u, e, l, r, a, p, w, j, , b, d, x, n, c, k, y, t, z, g, q, m, o]";
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
		lnrTreeArray = null;
	}


	@Test
	public void testFetch()
	{
		
		assertEquals(tree.fetch(".-"),"a");
		assertEquals(tree.fetch("-..."), "b");
		assertEquals(tree.fetch("-.-."),"c");
		
	}
	@Test
	public void testToArrayList()
	{
		assertEquals(tree.toArrayList().toString(), lnrTreeArray);
	}
	

	
	

}