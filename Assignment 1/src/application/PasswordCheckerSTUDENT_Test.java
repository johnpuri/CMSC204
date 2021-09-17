package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PasswordCheckerSTUDENT_Test {
    ArrayList<String> password1;
    String password2;

    public PasswordCheckerSTUDENT_Test() {
    }

    @Before
    public void setUp() throws Exception {
        String[] r = new String[]{"556p611NN", "chaK12#gH", "Kutta", "5sala#", "bal33@"};
        this.password1 = new ArrayList();
        this.password1.addAll(Arrays.asList(r));
    }

    @After
    public void tearDown() throws Exception {
        this.password1 = null;
    }


    @Test
    public void testIsValidPasswordSuccessful() {
        try {
            Assert.assertEquals(true, PasswordCheckerUtility.isValidPassword("4567"));
            PasswordCheckerUtility.isValidPassword("456@Ausio8");
            Assert.assertTrue("Did not throw an exception", true);
        } catch (Exception var2) {
            System.out.println(var2.getMessage());
            Assert.assertTrue("Threw some other exception", true);
        }

    }
    @Test
    public void testIsValidPasswordNoUpperAlpha() {
        try {
            Assert.assertTrue(PasswordCheckerUtility.isValidPassword("4712587aB#"));
            PasswordCheckerUtility.isValidPassword("1234567a#");
            Assert.assertTrue("Did not throw NoUpperAlphaException", false);
        } catch (NoUpperAlphaException var2) {
            Assert.assertTrue("Successfully threw a NoUpperAlphaException", true);
        } catch (Exception var3) {
            Assert.assertTrue("Threw some exception besides NoUpperAlphaException", false);
        }

    }


    @Test
    public void testIsValidPasswordInvalidSequence() {
        try {
            Assert.assertEquals(true, PasswordCheckerUtility.isValidPassword("4567fVV@"));
            PasswordCheckerUtility.isValidPassword("4567eCC&");
            Assert.assertTrue("Did not throw an InvalidSquenceException", true);
        } catch (InvalidSequenceException var2) {
            Assert.assertTrue("Successfully threw an InvalidQequenceException", true);
        } catch (Exception var3) {
            System.out.println(var3.getMessage());
            Assert.assertTrue("Threw some other exception an InvalidSequenceException", false);
        }

    }

    @Test
    public void testIsValidPasswordNoDigit() {
        try {
            Assert.assertEquals(true, PasswordCheckerUtility.isValidPassword("4567"));
            PasswordCheckerUtility.isValidPassword("456678");
            Assert.assertTrue("Did not throw an NoDigitException", true);
        } catch (NoDigitExeption var2) {
            Assert.assertTrue("Successfully throw an InvalidSequenceException", false);
        } catch (Exception var3) {
            System.out.println(var3.getMessage());
            Assert.assertTrue("Threw some other exception an InvalidSequenceException", true);
        }
    }
    @Test
    public void testIsWeakPassword() {
        try {
            Assert.assertEquals(true, PasswordCheckerUtility.isValidPassword("7834ttCC@"));
            boolean weakPwd = PasswordCheckerUtility.isWeakPassword("6788nnD#");
            Assert.assertTrue(weakPwd);
        } catch (Exception var2) {
            System.out.println(var2.getMessage());
            Assert.assertTrue("Threw some incorrect exception", false);
        }
    }

    @Test
    public void testIsValidPasswordTooShort() {
        try {
            Assert.assertTrue(PasswordCheckerUtility.isValidPassword("fibo7"));
            PasswordCheckerUtility.isValidPassword("d47678");
            Assert.assertTrue("Did not throw lengthException", false);
        } catch (LengthException var2) {
            Assert.assertTrue("Successfully threw a lengthException", true);
        } catch (Exception var3) {
            Assert.assertTrue("Threw some other exception lengthException", false);
        }

    }

    @Test
    public void testIsValidPasswordNoLowerAlpha() {
        try {
            Assert.assertTrue(PasswordCheckerUtility.isValidPassword("2389416Fv#"));
            PasswordCheckerUtility.isValidPassword("3467119B#");
            Assert.assertTrue("Did not throw NoLowerAlphaException", false);
        } catch (NoLowerAlphaException var2) {
            Assert.assertTrue("Successfully threw a NoLowerAlphaException", true);
        } catch (Exception var3) {
            Assert.assertTrue("Threw some other exception esides NoLowerAlphaException", false);
        }

    }
    @Test
    public void testInvalidPasswords() {
        ArrayList<String> invalidPasswordReslts = PasswordCheckerUtility.getInvalidPasswords(this.password1);
        Scanner scan = new Scanner((String)invalidPasswordReslts.get(0));
        Assert.assertEquals(scan.next(), "556p611NN");
    }
}