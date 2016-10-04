package myapp.stringGenerators;

public class ConfirmationTokenGenerator extends StringGenerator {

    public ConfirmationTokenGenerator()
    {
        super(15, Alphabets.ENG_CHARS + Alphabets.NUMBERS);
    }
}
