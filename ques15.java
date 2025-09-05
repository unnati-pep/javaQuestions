//Handle null values safely with Optional.

import java.util.Optional;

public class ques15 {

    public static Optional<String> getUsername(String input) {
        // Simulate a method that might return null
        if (input == null || input.isBlank()) {
            return Optional.empty();
        }
        return Optional.of(input.trim());
    }

    public static void main(String[] args) {
        String rawInput = null;

        // Safe handling using Optional
        Optional<String> usernameOpt = getUsername(rawInput);

        // Option 1: Provide default value
        String username = usernameOpt.orElse("Guest");
        System.out.println("Hello, " + username);

        // Option 2: Use ifPresent
        usernameOpt.ifPresent(name -> System.out.println("Welcome back, " + name));

        // Option 3: Throw exception if absent
         String mustExist = usernameOpt.orElseThrow(() -> new IllegalArgumentException("Username required"));
    }
}
