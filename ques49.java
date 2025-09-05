import java.util.random.RandomGenerator;

public class ques49 {
    public static void main(String[] args) {
        // Get the default random generator (uses SplitMix64 by default)
        RandomGenerator random = RandomGenerator.getDefault();

        // Generate random integers
        int randomInt = random.nextInt(); // Any int
        int randomIntBounded = random.nextInt(100); // 0 to 99

        // Generate random doubles
        double randomDouble = random.nextDouble(); // 0.0 to 1.0

        // Generate random booleans
        boolean randomBoolean = random.nextBoolean();

        // Print results
        System.out.println("Random int: " + randomInt);
        System.out.println("Random int (0-99): " + randomIntBounded);
        System.out.println("Random double: " + randomDouble);
        System.out.println("Random boolean: " + randomBoolean);
    }
}
