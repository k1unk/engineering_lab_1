import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestConverter {

    public String test(String inputData) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

        Converter.main(new String[0]);

        System.setIn(stdin);
        System.setOut(stdout);

        return byteArrayOutputStream.toString();
    }

    public void testFC(String inputData, String result) {
        String outputText = test(inputData);
        String key = "result:";
        String output = outputText.substring(outputText.indexOf(key) + key.length()).trim();
        Assert.assertEquals(output, result);
    }

    @Test
    public void testFahrenheitToCelsius() {
        Assert.assertEquals(Converter.countTemperatureFahrenheitToCelsius(12), -11.1, 0.05);
        Assert.assertEquals(Converter.countTemperatureFahrenheitToCelsius(-123.3), -86.3,0.05);
        Assert.assertEquals(Converter.countTemperatureFahrenheitToCelsius(0), -17.8,0.05);
        Assert.assertEquals(Converter.countTemperatureFahrenheitToCelsius(32), 0,0.05);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        Assert.assertEquals(Converter.countTemperatureCelsiusToFahrenheit(-11.1), 12, 0.05);
        Assert.assertEquals(Converter.countTemperatureCelsiusToFahrenheit(-86.3), -123.3,0.05);
        Assert.assertEquals(Converter.countTemperatureCelsiusToFahrenheit(-17.8), 0,0.05);
        Assert.assertEquals(Converter.countTemperatureCelsiusToFahrenheit(0), 32,0.05);
    }

    @Test
    public void testCheckModeCorrectness() {
        Assert.assertTrue(Converter.checkModeCorrectness("f"));
        Assert.assertTrue(Converter.checkModeCorrectness("F"));
        Assert.assertTrue(Converter.checkModeCorrectness("c"));
        Assert.assertTrue(Converter.checkModeCorrectness("C"));
        Assert.assertFalse(Converter.checkModeCorrectness("ф"));
        Assert.assertFalse(Converter.checkModeCorrectness("Ф"));
        Assert.assertFalse(Converter.checkModeCorrectness("d"));
        Assert.assertFalse(Converter.checkModeCorrectness("12"));
    }

    @Test
    public void testCheckValueCorrectness() {
        Assert.assertTrue(Converter.checkValueCorrectness("12.2"));
        Assert.assertTrue(Converter.checkValueCorrectness("-11.3"));
        Assert.assertTrue(Converter.checkValueCorrectness("0.0"));
        Assert.assertTrue(Converter.checkValueCorrectness("0"));
        Assert.assertTrue(Converter.checkValueCorrectness("1"));
        Assert.assertFalse(Converter.checkValueCorrectness("1."));
        Assert.assertFalse(Converter.checkValueCorrectness("1.4.4"));
        Assert.assertFalse(Converter.checkValueCorrectness("asd"));
        Assert.assertFalse(Converter.checkValueCorrectness("123-1"));
    }

    @Test
    public void incorrectInputLetter() {
        incorrectInputLetterHelper("d\nc\n0\n");
        incorrectInputLetterHelper("D\nZ\nF\n-12\n");
        incorrectInputLetterHelper("A\nf\n0\n");
    }

    public void incorrectInputLetterHelper(String inputData) {
        String outputText = test(inputData);
        String key = "error. No such mode (C or F)";
        Assert.assertTrue(outputText.contains(key));
    }

    @Test
    public void correctInputLetter() {
        correctInputLetterHelper("c\n0\n");
        correctInputLetterHelper("C\n0\n");
        correctInputLetterHelper("f\n0\n");
        correctInputLetterHelper("F\n0\n");
    }

    public void correctInputLetterHelper(String inputData) {
        String outputText = test(inputData);
        String key = "error. No such mode (C or F)";
        Assert.assertFalse(outputText.contains(key));
    }

    @Test
    public void incorrectInputNumber() {
        incorrectInputNumberHelper("c\nfd\n0\n");
        incorrectInputNumberHelper("F\n12d\n-12\n");
        incorrectInputNumberHelper("f\n \n0\n");
    }

    public void incorrectInputNumberHelper(String inputData) {
        String outputText = test(inputData);
        String key = "Wrong input value";
        Assert.assertTrue(outputText.contains(key));
    }


}