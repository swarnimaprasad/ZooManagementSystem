package org.example;
import java.util.*;


public class Zoo {
    protected  HashMap<Integer, Integer> deal_map;
    private Map<String, Visitor> visitorsMap;
    protected  HashMap<Integer, Attraction> attractions_map;
    protected  HashMap<String, Animal> animals_map;
    protected  HashMap<String, Discount> discount_map;
    private List<Feedback> feedbackList;
    private  int revenue;
    public Zoo() {
        attractions_map = new HashMap<>();
        animals_map = new HashMap<>();
        this.discount_map = new HashMap<>();
        this.deal_map = new HashMap<>();
        this.visitorsMap = new HashMap<>();
        this.feedbackList= new ArrayList<>();
        this.revenue=0;
    }
    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
    private void feedAnimal(Animal animalName) {
        System.out.println("Feeding " + animalName.name + ". It makes a sound: "+ animalName.getNoise());
    }
    protected void viewVisitorStats(){

        int maxtick = 0;
        String maxattr = null;

        for (Map.Entry<Integer, Attraction> entry : attractions_map.entrySet()) {
            String attractionName = entry.getValue().getName();
            Attraction attraction = entry.getValue();

            if (attraction.getTicketCount() > maxtick) {
                maxtick = attraction.getTicketCount();
                maxattr = attractionName;
            }
        }
        System.out.println("Total visitors : "+ visitorsMap.size());
        System.out.println("Total revenue : "+ revenue);
        System.out.println("Most popular attraction : "+ maxattr);
    }
    private void readAboutAnimal(Animal animalName) {
        System.out.println("Reading about " + animalName.name + "'s history :"+animalName.getHistory() );
    }
    public void addFeedback(Visitor visitor, Scanner scanner,Zoo zoo) {
        System.out.print("Enter your feedback: ");
        String feedbackMessage = scanner.nextLine();

        Feedback newFeedback = new Feedback(visitor.getName(), feedbackMessage);
        zoo.feedbackList.add(newFeedback);

        System.out.println("Thank you for your feedback!");
    }
    public void viewFeedback(Zoo zoo) {
        System.out.println("\nFeedbacks:");

        if (zoo.feedbackList.isEmpty()) {
            System.out.println("No feedback available.");
        } else {
            for (Feedback feedback : zoo.feedbackList) {
                System.out.println("Visitor: " + feedback.getVisitorName());
                System.out.println("Message: " + feedback.getMessage());
                System.out.println();
            }
        }
    }
    public void registerVisitor(Scanner scanner) {
        System.out.print("Enter Visitor Name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter Visitor Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Visitor Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Visitor Initial Balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Visitor Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Visitor Password: ");
        String password = scanner.nextLine();

        Visitor newVisitor = new Visitor(name, age, phoneNumber, balance, email, password);
        visitorsMap.put(email, newVisitor);
        System.out.println("Registration is successful.");
    }
    public Visitor loginVisitor(Scanner scanner) {
        System.out.print("Enter Visitor Email: ");
        String email = scanner.next();
        scanner.nextLine();
        System.out.print("Enter Visitor Password: ");
        String password = scanner.next();
        scanner.nextLine();

        if (visitorsMap.containsKey(email)) {
            Visitor visitor = visitorsMap.get(email);
            if (visitor.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + visitor.getName() + "!");
                return visitor;
            } else {
                System.out.println("Incorrect password. Login failed.");
            }
        } else {
            System.out.println("Visitor with email " + email + " not found. Login failed.");
        }

        return null;
    }
    public void showVisitorLogin() {
        System.out.println("\nVisitor Entry:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        System.out.print("\nEnter your choice: ");
    }
    public void showVisitorMenu() {
        System.out.println("\nVisitor Menu:");
        System.out.println("1. Explore the Zoo");
        System.out.println("2. Buy Membership");
        System.out.println("3. Buy Tickets");
        System.out.println("4. View Discounts");
        System.out.println("5. View Special Deals");
        System.out.println("6. Visit Animals");
        System.out.println("7. Visit Attractions");
        System.out.println("8. Leave Feedback");
        System.out.println("9. Log Out");
    }
    public static void view_Attractions(Zoo zoo) {

        System.out.println("\nAttractions:");
        for (Map.Entry<Integer, Attraction> entry : zoo.attractions_map.entrySet()) {
            int attractionId = entry.getKey();
            Attraction attraction = entry.getValue();
            System.out.println(attractionId + ". " + attraction.getName() + ": " + attraction.getDescription());
        }
    }
    public static void viewDiscounts(Zoo zoo) {
        System.out.println("DISCOUNT TYPES:");
        for (Map.Entry<String,Discount> entry : zoo.discount_map.entrySet()) {
            String disccat = entry.getKey();
            int disc = entry.getValue().getPercentage();
            String name=disccat.toUpperCase()+disc;
            System.out.println(disccat +"("+ disc+"% Discount)- "+ name );
        }
    }
    public static void viewAnimals(Zoo zoo) {
        System.out.println("\nAnimals:");
        for (Map.Entry<String, Animal> entry : zoo.animals_map.entrySet()) {
            String animalId = entry.getKey();
            Animal animal = entry.getValue();
            System.out.println("Animal name : "+ animalId + "\t Animal Type : "  + animal.getType()+  " \tAnimal sound: "+animal.getNoise()+"\t Animal history : "+animal.getHistory());
        }
    }
    public static void viewDeals(Zoo zoo) {
        System.out.println("\nDeals:");
        if(zoo.deal_map.isEmpty()){
            System.out.println("\nAdmin has not set any deals yet");
        }
        for (Map.Entry<Integer, Integer> entry : zoo.deal_map.entrySet()) {
            int person_number = entry.getKey();
            int deal = entry.getValue();
            System.out.println("number of persons to get  " + deal + "% off is : " + person_number);
        }
    }
    public static void printVisitorViewMenu() {
        System.out.println("\nVisitor View Menu:");
        System.out.println("1. View Attractions");
        System.out.println("2. View Animals");
        System.out.println("3. Exit");
    }
    public void buyMembership(Visitor visitor,Zoo zoo, Scanner scanner) {
        System.out.println("\nMembership Options:");
        System.out.println("1. Basic Membership (Rs20)");
        System.out.println("2. Premium Membership (Rs50)");

        System.out.print("Enter your choice: ");
        int membershipChoice = scanner.nextInt();
        scanner.nextLine();
        viewDiscounts(zoo);
        System.out.print("Apply discount code (input null if none)");
        String code=scanner.nextLine();
        scanner.nextLine();
        int disc=0;
        int flag=0;
        for(Discount d :discount_map.values()){
            if(Objects.equals(d.getDiscountCode(), code)){
                disc=d.getPercentage();
                flag=1;
                break;
            }
        }
        if (flag==0){
            System.out.print("No discount applied");
        }

        scanner.nextLine();
        int finalprice;
        switch (membershipChoice) {
            case 1:
                visitor.setMembershipType("Basic");
                finalprice= ((100-disc)/100)*20;
                visitor.setBalance(visitor.getBalance() - finalprice);
                System.out.println("You have successfully purchased a Basic Membership.");
                setRevenue(getRevenue()+finalprice);
                break;
            case 2:
                visitor.setMembershipType("Premium");
                finalprice= ((100-disc)/100)*50;
                visitor.setBalance(visitor.getBalance() - finalprice);
                System.out.println("You have successfully purchased a Premium Membership.");
                setRevenue(getRevenue()+finalprice);
                break;
            default:
                System.out.println("Invalid choice. No membership purchased.");
        }
        System.out.println("Your balance is : "+visitor.getBalance());
    }
    public void visitAnimal(Scanner scanner,Zoo zoo) {
        System.out.println("\nAnimals Available:");
        viewAnimals(zoo);

        System.out.print("Choose an animal name to visit: ");

        String selectedAnimal=scanner.nextLine();

        if (!animals_map.containsKey(selectedAnimal)) {
            System.out.println("Animal does not exist in zoo");
        }
        else{
            Animal animal = animals_map.get(selectedAnimal);
        System.out.println("1. Feed the animal");
        System.out.println("2. Read about the animal");

        System.out.print("Enter your choice: ");
        int actionChoice = scanner.nextInt();
        scanner.nextLine();

        switch (actionChoice) {
            case 1:
                feedAnimal(animal);
                break;
            case 2:
                readAboutAnimal(animal);
                break;
            default:
                System.out.println("Invalid choice. No action taken.");
        }
        }
    }
}