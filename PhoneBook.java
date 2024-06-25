import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления номера телефона к определенному имени
    public void addPhoneNumber(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    // Метод для получения отсортированного списка контактов
    public List<Map.Entry<String, Set<String>>> getSortedContacts() {
        List<Map.Entry<String, Set<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        sortedList.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        return sortedList;
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        
        // Пример добавления номеров телефонов
        phoneBook.addPhoneNumber("Alexei", "89514545453");
        phoneBook.addPhoneNumber("Boris", "89225631653");
        phoneBook.addPhoneNumber("Alexei", "89656778452");
        phoneBook.addPhoneNumber("Egor", "89546783452");
        phoneBook.addPhoneNumber("Egor", "89572356367");
        phoneBook.addPhoneNumber("Egor", "89673462467");

        // Получение и вывод отсортированного списка контактов
        List<Map.Entry<String, Set<String>>> sortedContacts = phoneBook.getSortedContacts();
        
        for (Map.Entry<String, Set<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}