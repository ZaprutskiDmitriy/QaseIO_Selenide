package models;

import com.github.javafaker.Faker;

public class TestCaseFactory {

    static Faker faker;

    public static TestCase get() {
        faker = new Faker();
        return new TestCase(faker.country().capital(), "Actual", "Test cases without suite", "Major", "High",
                "Functional", "Unit", "No", "Not set", "Positive", "Automated");
    }

/*    public TestCase(String title, String status, String suite, String severity, String priority, String type,
                    String layer, String isFlaky, String milestone, String behavior, String automationStatus) {
        this.title = title;
        this.status = status;
        this.suite = suite;
        this.severity = severity;
        this.priority = priority;
        this.type = type;
        this.layer = layer;
        this.isFlaky = isFlaky;
        this.milestone = milestone;
        this.behavior = behavior;
        this.automationStatus = automationStatus;
    }*/
}
