import org.junit.Assert;
import org.junit.Test;

public class TestConverter {

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

}