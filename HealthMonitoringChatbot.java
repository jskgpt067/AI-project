import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HealthMonitoringChatbot {
    
    private static Map<String, String> symptomAdvice;

    public static void main(String[] args) {
        initializeSymptomAdvice();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Health Monitoring Chatbot!");
        System.out.println("You can ask about your health symptoms. Type 'exit' to quit.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Chatbot: Stay healthy! Goodbye!");
                break;
            }

            String response = getResponse(userInput);
            System.out.println("Chatbot: " + response);
        }
        
        scanner.close();
    }

    private static void initializeSymptomAdvice() {
        symptomAdvice = new HashMap<>();
        symptomAdvice.put("fever", "You might be experiencing a common illness. Stay hydrated and rest.");
        symptomAdvice.put("cough", "A cough can be a sign of many things. Monitor it and consult a doctor if it persists.");
        symptomAdvice.put("headache", "Try to relax and hydrate. If it continues, consider consulting a healthcare professional.");
        symptomAdvice.put("fatigue", "Make sure to get enough sleep and consider stress management techniques.");
        symptomAdvice.put("nausea", "Avoid greasy foods and stay hydrated. Consult a doctor if it continues.");
    }

    private static String getResponse(String userInput) {
        for (String symptom : symptomAdvice.keySet()) {
            if (userInput.toLowerCase().contains(symptom)) {
                return symptomAdvice.get(symptom);
            }
        }
        return "I'm not sure about that symptom. Please consult a healthcare professional.";
    }
}
