package myapp.stringGenerators;

public class PasswordSaltGenerator extends StringGenerator {
    public PasswordSaltGenerator()
    {
        super(10, Alphabets.ENG_CHARS + Alphabets.NUMBERS);
    }
}
