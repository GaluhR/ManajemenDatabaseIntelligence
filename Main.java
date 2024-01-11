import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String USERNAME = "sayadba";
    private static final String PASSWORD = "12345678";
    private static ArrayList<IntelligenceMember> intelligenceMembers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome Data Database Administrator to Data Intelligence");

        // Login
        if (login()) {
            int choice;
            do {
                // Display menu
                displayMenu();
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Process user's choice
                switch (choice) {
                    case 1:
                        addIntelligenceMember();
                        break;
                    case 2:
                        editIntelligenceMemberData();
                        break;
                    case 3:
                        deleteIntelligenceMemberData();
                        break;
                    case 4:
                        displayAllIntelligenceMembers();
                        break;
                    case 5:
                        giveIntelligenceAssignments();
                        break;
                    case 6:
                        System.out.println("Logging out of the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                        break;
                }
            } while (choice != 6);
        } else {
            System.out.println("Login failed. Exiting program.");
        }
    }

    private static boolean login() {
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        return USERNAME.equals(enteredUsername) && PASSWORD.equals(enteredPassword);
    }

    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("1. Add Intelligence Members");
        System.out.println("2. Edit Intelligence Member Data");
        System.out.println("3. Delete Intelligence Member Data");
        System.out.println("4. Display All Intelligence Members");
        System.out.println("5. Give Intelligence Assignments");
        System.out.println("6. Log out of the program");
    }

    private static void addIntelligenceMember() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter unique member code: ");
        String code = scanner.nextLine();

        System.out.print("Enter skill level (Beginner/Intermediate/Advanced/Expert): ");
        String skillLevel = scanner.nextLine();

        IntelligenceMember member = new IntelligenceMember(name, code, skillLevel);
        intelligenceMembers.add(member);

        System.out.println("Intelligence member added successfully.");
    }

    private static void editIntelligenceMemberData() {
        System.out.print("Enter member code to edit: ");
        String codeToEdit = scanner.nextLine();

        IntelligenceMember memberToEdit = findIntelligenceMemberByCode(codeToEdit);

        if (memberToEdit != null) {
            System.out.println("Current data:\n" + memberToEdit.toString());

            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();

            System.out.print("Enter new skill level: ");
            String newSkillLevel = scanner.nextLine();

            // Update member data
            memberToEdit.setNama(newName);
            memberToEdit.setTingkatKeahlian(newSkillLevel);

            System.out.println("Intelligence member data updated successfully.");
        } else {
            System.out.println("Intelligence member with the given code not found.");
        }
    }

    private static void deleteIntelligenceMemberData() {
        System.out.print("Enter member code to delete: ");
        String codeToDelete = scanner.nextLine();

        IntelligenceMember memberToDelete = findIntelligenceMemberByCode(codeToDelete);

        if (memberToDelete != null) {
            intelligenceMembers.remove(memberToDelete);
            System.out.println("Intelligence member data deleted successfully.");
        } else {
            System.out.println("Intelligence member with the given code not found.");
        }
    }

    private static void displayAllIntelligenceMembers() {
        for (IntelligenceMember member : intelligenceMembers) {
            System.out.println(member.toString());
            System.out.println("---------------");
        }
    }

    private static void giveIntelligenceAssignments() {
        System.out.print("Enter member code to assign a mission: ");
        String codeToAssignMission = scanner.nextLine();

        IntelligenceMember memberToAssignMission = findIntelligenceMemberByCode(codeToAssignMission);

        if (memberToAssignMission != null) {
            System.out.print("Enter mission for intelligence member: ");
            String mission = scanner.nextLine();

            memberToAssignMission.setMisi(mission);

            System.out.println("Mission assigned successfully.");
        } else {
            System.out.println("Intelligence member with the given code not found.");
        }
    }

    private static IntelligenceMember findIntelligenceMemberByCode(String code) {
        for (IntelligenceMember member : intelligenceMembers) {
            if (member.getKodeAnggota().equals(code)) {
                return member;
            }
        }
        return null;
    }
}
