package myapp.stringGenerators;

import java.util.Random;

public class StringGenerator {

    private final int length;
    private final String chars;

    StringGenerator(int length, String chars)
    {
        this.length = length;
        this.chars = chars;
    }

    public String generate()
    {
        int length = chars.length();

        Random random = new Random();

        String result = "";

        for (int i = 0; i < this.length; i++)
        {
            result += chars.charAt(random.nextInt(length));
        }

        return result;

    }
}
