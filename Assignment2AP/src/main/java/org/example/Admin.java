package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Admin extends Zoo {
    private static final String Admin_username = "admin";
    private static final String Admin_password = "admin123";
   public Admin() {
    //  attractions_map = new HashMap<>();
      //animals_map = new HashMap<>();
      //discount_map = new HashMap<>();
      //deal_map = new HashMap<>();
    }
    static boolean authenticate(String username, String password) {
        return Admin_username.equals(username) && Admin_password.equals(password);
    }
    public void showMenu() {
        System.out.print("---------------------- ");
        System.out.println("\nAdmin Menu:");
        System.out.println("1. Manage Attractions");
        System.out.println("2. Manage Animals");
        System.out.println("3. Schedule Events");
        System.out.println("4. Set Discounts");
        System.out.println("5. Set Special Deal");
        System.out.println("6. View Visitor Stats");
        System.out.println("7. View Feedback");
        System.out.println("8. Exit");
        System.out.print("---------------------- ");
        System.out.print("\nEnter your choice: ");
    }
    public void showAttractionMenu() {
        System.out.println("\nManage Attractions:");
        System.out.println("1. Add Attraction");
        System.out.println("2. View Attractions");
        System.out.println("3. Modify Attraction");
        System.out.println("4. Remove Attraction");
        System.out.println("5. Exit");
        System.out.print("\nEnter your choice: ");
    }
    public void showAnimalMenu() {
        System.out.println("\nManage Animals:");
        System.out.println("1. Add Animal");
        System.out.println("2. Update Animal Details");
        System.out.println("3. Remove Animal");
        System.out.println("4. Exit");
        System.out.print("\nEnter your choice: ");

    }
    public void addAttraction(int id,Zoo zoo, Scanner scanner) {
        System.out.print("Enter Attraction Name: ");
        String name = scanner.next();
        System.out.print("Enter Attraction Description: ");
        String description = scanner.next();
        Attraction newAttraction = new Attraction(name, description, id);
        zoo.attractions_map.put(id, newAttraction);
        System.out.println("Attraction added successfully with id : "+id);

    }
    public static void viewAttractions(Zoo zoo) {
//        for (Attraction attraction : attractions_map.values()) {
//            System.out.println(attraction);
//        }
        System.out.println("\nAttractions:");
        for (Map.Entry<Integer, Attraction> entry : zoo.attractions_map.entrySet()) {
            int attractionId = entry.getKey();
            Attraction attraction = entry.getValue();
            System.out.println(attractionId + ". " + attraction.getName() + ": " + attraction.getPrice());
        }
    }
    public void modifyAttraction(int id, String name, String description,Zoo zoo) {
        Attraction modify_object = zoo.attractions_map.get(id);
        modify_object.setDescription(description);
        modify_object.setName(name);
    }
    public void removeAttraction(int rid,Zoo zoo) {
       zoo.attractions_map.remove(rid);
    }
    public void defaultAnimals(Zoo zoo) {
        Animal newAnimal = new Mammal("Elephant", "Trumpet", "Elephants are strong");
        zoo.animals_map.put("Elephant", newAnimal);

        newAnimal = new Mammal("Lion", "Roar", "Lions are healthy");
        zoo.animals_map.put("Lion", newAnimal);

        newAnimal = new Reptile("Snake", "Hiss", "Snakes are weak");
        zoo.animals_map.put("Snake", newAnimal);

        newAnimal =new Reptile("Turtle", "None", "Turtles are slow");
        zoo.animals_map.put("Turtle", newAnimal);

        newAnimal =new Amphibian("Frog", "Tur Tur", "Frogs are big");
        zoo.animals_map.put("Frog", newAnimal);

        newAnimal =new Amphibian("Toad", "Croak", "Toads are aged");
        zoo.animals_map.put("Toad", newAnimal);
    }
    public void addAnimal(Scanner scanner,Zoo zoo) {
        System.out.print("Enter Animal Name: ");
        String name = scanner.next();
        scanner.nextLine();
        System.out.print("Enter Animal Type: ");
        String type = scanner.next();
        scanner.nextLine();
        System.out.print("Enter Animal Sound: ");
        String sound = scanner.next();
        scanner.nextLine();
        System.out.print("Enter Animal history: ");
        String history = scanner.nextLine();
        if (Objects.equals(type, "Mammal") || Objects.equals(type, "mammal")) {
            Animal newAnimal = new Mammal(name, sound, history);
            System.out.println("Animal added to the zoo.");
            zoo.animals_map.put(name, newAnimal);
        } else if (Objects.equals(type, "Amphibian") || Objects.equals(type, "amphibian")) {
            Animal newAnimal = new Amphibian(name, sound, history);
            System.out.println("Animal added to the zoo.");
            zoo.animals_map.put(name, newAnimal);
        } else if (Objects.equals(type, "Reptile") || Objects.equals(type, "reptile")) {
            Animal newAnimal = new Reptile(name, sound, history);
            System.out.println("Animal added to the zoo.");
            zoo.animals_map.put(name, newAnimal);
        } else {
            System.out.println("Wrong animal type entered");
        }

    }
    public void removeAnimal(String name,Zoo zoo) {
        zoo.animals_map.remove(name);
    }
    public void modifyAnimal(String name, String new_sound, String new_history,Zoo zoo) {
        Animal an = zoo.animals_map.get(name);
        if(an==null){
            System.out.println("No such animal exists");
            return;
        }
        an.setNoise(new_sound);
        an.setHistory(new_history);
    }
    public void scheduleEvents(Scanner scanner,Zoo zoo) {
        System.out.print("Enter Attraction ID: ");
        int attraction_id = scanner.nextInt();
        scanner.nextLine();
        Attraction attraction_schedule = zoo.attractions_map.get(attraction_id);

        if (attraction_schedule != null) {

            System.out.print("Is the event open (true/false): ");
            boolean isOpen = scanner.nextBoolean();
            attraction_schedule.setOpen(isOpen);

            System.out.print("Enter ticket price: ");
            int price = scanner.nextInt();
            attraction_schedule.setPrice(price);

            System.out.println("Event scheduled successfully.");
            int visitorCount =attraction_schedule.getTicketCount();
            System.out.print("number of visitors: "+visitorCount+"\n");
        } else {
            System.out.println("Attraction not found.");
        }


//        System.out.print("Enter Attraction ID: ");
//        int attraction_id = scanner.nextInt();
//        System.out.println("Entered Attraction ID: " + attraction_id);
//
//        Attraction attraction_schedule = attractions_map.get(attraction_id);
//
//        if (attraction_schedule != null) {
//            // ... rest of your code
//        } else {
//            System.out.println("Attraction not found.");
//        }


    }
    public void defaultDiscount(Zoo zoo) {
        Discount discount = new Discount("Minor",10);
        zoo.discount_map.put("Minor", discount);
        discount = new Discount("Senior citizen",20);
        zoo.discount_map.put("Senior citizen", discount);
        System.out.print(" Minor discount set : Every minor visitor to the zoo (<18) will get a 10% discount on their tickets and membership amount.\n ");
        System.out.print("Senior citizen discount set: Every senior citizen (>60) will get a 20% discount on their tickets and membership amount\n ");
    }
    public void addDiscount(Scanner scanner,Zoo zoo) {
        System.out.print("Enter Discount Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Discount Percentage : ");
        int percentage = scanner.nextInt();
        scanner.nextLine();
        Discount discount = new Discount(category, percentage);
        zoo.discount_map.put(category,discount);
        System.out.println("Discount added successfully.");
    }
    public void modifyDiscount(Scanner scanner,Zoo zoo) {
        System.out.print("Enter Discount Category to be changed ");
        String category_modify = scanner.nextLine();
        if (zoo.discount_map.containsKey(category_modify)) {
            Discount discount = zoo.discount_map.get(category_modify);
            System.out.print("Enter new Discount Category: ");
            String newcat = scanner.nextLine();
            System.out.print("Enter new Discount Percentage: ");
            int newperc = scanner.nextInt();
            scanner.nextLine();
            discount.setCategory(newcat);
            discount.setPercentage(newperc);
            //discount_map.replace(category_modify, newPercentage);
            System.out.println("Discount modified successfully.");
        } else {
            System.out.println("Discount category not found.");
        }

    }
    public void removeDiscount(Scanner scanner,Zoo zoo) {
        System.out.print("Enter Discount Category to remove: ");
        String category = scanner.nextLine();
        if (zoo.discount_map.containsKey(category)) {
            zoo.discount_map.remove(category);
            System.out.println("Discount removed successfully.");
        } else {
            System.out.println("Discount category not found.");
        }
    }
    public void addDeal(Scanner scanner,Zoo zoo) {
        System.out.print("Enter number of visitor to avail deal ");
        int vis_count = scanner.nextInt();
        System.out.print("Enter Discount percentage ");
        int discount = scanner.nextInt();
        zoo.deal_map.put(vis_count, discount);
        System.out.println("Deal added successfully.");
    }
    public void modifyDeal(Scanner scanner,Zoo zoo) {
        System.out.print("Enter number of visitor to avail deal ");
        int vis_count = scanner.nextInt();
        System.out.print("Enter Discount percentage ");
        int discount = scanner.nextInt();
        zoo.deal_map.replace(vis_count, discount);
        System.out.print("Deal modified ");
    }
    public void removeDeal(Integer number,Zoo zoo){
    zoo.deal_map.remove(number);
    }
}

