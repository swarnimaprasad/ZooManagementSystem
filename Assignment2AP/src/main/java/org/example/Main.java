package org.example;
import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void ManageAttractions(Admin admin, Zoo zoo,Scanner scanner){

        int manage_attraction_choice=0;
        int attraction_id=0;
        while(true) {
            if(manage_attraction_choice==5){
                break;
            }
            admin.showAttractionMenu();

            manage_attraction_choice = scanner.nextInt();
            switch (manage_attraction_choice) {
                case 1:
                    attraction_id++;
                    //System.out.println(attraction_id);
                    admin.addAttraction(attraction_id,zoo ,scanner);
                    break;
                case 2:
                    //Zoo z=new Zoo();
                    zoo.view_Attractions(zoo);
                    break;
                case 3:
                    System.out.println("Enter Attraction Id to be modified");
                    int change_id = scanner.nextInt();
                    ;
                    System.out.print("Enter Attraction Name: ");
                    String new_name = scanner.next();
                    System.out.print("Enter Attraction Description: ");
                    String new_description = scanner.next();
                    admin.modifyAttraction(change_id, new_name, new_description,zoo);
                    break;
                case 4:
                    int rid;
                    System.out.println("Enter Attraction Id to be removed");
                    rid = scanner.nextInt();
                    admin.removeAttraction(rid,zoo);
                    break;
                case 5:
                    System.out.println("Exiting Manage Attractions.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

    }
    public static void ManageAnimals(Admin admin, Scanner scanner,Zoo zoo) {
        int animal_choice =0;



        //scanner.nextLine(); // Consume the newline character
        while (true){
            admin.showAnimalMenu();
            animal_choice = scanner.nextInt();
            if(animal_choice==4){
                break;
            }
            switch (animal_choice) {
                case 1:
                admin.addAnimal(scanner,zoo);
                break;
                case 2:
                System.out.println("Enter Animal name to be modified");
                String update_name = scanner.next();
                System.out.print("Enter Animal Sound: ");
                String new_sound = scanner.next();
                scanner.nextLine();
                System.out.print("Enter Animal history: ");
                String new_history = scanner.nextLine();

                admin.modifyAnimal(update_name, new_sound, new_history,zoo);
                break;
                case 3:
                String remove_animal;
                System.out.println("Enter Animal name to be removed");
                remove_animal = scanner.next();
                scanner.nextLine();
                admin.removeAnimal(remove_animal,zoo);
                break;
                case 4:
                System.out.println("Exiting Manage Animals.");
                break;
                default:
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    public static void setDiscounts(Admin admin, Scanner scanner,Zoo zoo){

            int discount_choice=0;
            while (true) {

                System.out.println("\nSet Discounts:");
                System.out.println("1. Add Discount");
                System.out.println("2. Modify Discount");
                System.out.println("3. Remove Discount");
                System.out.println("4. Exit");
                System.out.print("\nEnter your choice: ");

                discount_choice= scanner.nextInt();
                scanner.nextLine();
                if (discount_choice==4){
                    System.out.println("Exiting Set Discounts.");
                    break;
                }
                switch (discount_choice) {
                    case 1:
                        admin.addDiscount(scanner,zoo);
                        break;
                    case 2:
                        admin.modifyDiscount(scanner,zoo);
                        break;
                    case 3:
                        admin.removeDiscount(scanner,zoo);
                        break;
                    case 4:
                        System.out.println("Exiting Set Discounts.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
    }
    public static void Explore(Zoo zoo,Visitor visitor,Scanner scanner){
        int explore_choice=0;
        while(true) {
            if(explore_choice==3){
                break;
            }
            Zoo.printVisitorViewMenu();
            System.out.print("\nEnter your choice: ");
            explore_choice = scanner.nextInt();
            scanner.nextLine();

            switch (explore_choice) {
                case 1:
                    Zoo.view_Attractions(zoo);
                    break;
                case 2:
                    Zoo.viewAnimals(zoo);
                    break;
                case 3:
                    System.out.println("Exiting Visitor View Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    public static void setDeal(Admin admin, Scanner scanner,Zoo zoo){

        int discount_choice=0;
        while (true) {

            System.out.println("\nSet Deals:");
            System.out.println("1. Add Deals");
            System.out.println("2. Modify Deal");
            System.out.println("3. Remove Deal");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            discount_choice = scanner.nextInt();
            scanner.nextLine();
            if(discount_choice==4){
                System.out.println("Exiting Set Deal.");
                break;
            }

            switch (discount_choice) {
                case 1:
                    admin.addDeal(scanner,zoo);
                    break;
                case 2:
                    admin.modifyDeal(scanner,zoo);
                case 3:
                    System.out.println("enter number of visitor for the deal to be removed");
                    int no = scanner.nextInt();
                    admin.removeDeal(no,zoo);
                    break;
                case 4:
                    System.out.println("Exiting Set Deal.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    public static void BuyTicket(Scanner scanner,Visitor visitor,Zoo zoo){
        //Admin admin=new Admin();
        System.out.println("Select Attraction to Buy ticket.Enter 0 to exit");
        Admin.viewAttractions(zoo);
        int attraction_choice=scanner.nextInt();
        if(attraction_choice==0){
            System.out.println("Exiting");
            return;
        }
        if(zoo.attractions_map.containsKey(attraction_choice)){
            Attraction attraction=zoo.attractions_map.get(attraction_choice);
            int cost=attraction.getPrice();
            //String name=
            if(Objects.equals(visitor.getMembershipType(), "Premium")){
                System.out.println("Your ticket is free as you have premium membership");
            }
            else {
                System.out.println("Enter the number of tickets:");
                int no=scanner.nextInt();


                zoo.viewDiscounts(zoo);
                System.out.print("Apply discount code (input null if none)");
                String code=scanner.nextLine();
                int disc=0;
                int flag=0;
                for(Discount d :zoo.discount_map.values()){
                    if(Objects.equals(d.getDiscountCode(), code)){
                        disc=d.getPercentage();
                        flag=1;
                        break;
                    }
                }
                if (flag==0){
                    System.out.print("No discount applied");
                }
                visitor.visitor_attraction_list.put(attraction_choice,no);
                // }
                int dealperc=0;
                if(zoo.deal_map.containsValue(no)){
                    dealperc=zoo.deal_map.get(no);
                }
                int finalprice=((100-disc)/100)*(cost-dealperc);
                visitor.setBalance(visitor.getBalance()-finalprice);
                int oldrevenue=zoo.getRevenue();
                zoo.setRevenue(oldrevenue+finalprice);
            }

        }
        else{
            System.out.println("Invalid choice");
        }
    }
    public static void VisitAttraction(Scanner scanner,Visitor visitor,Zoo zoo){
        System.out.println("Select Attraction number to visit.Enter 0 to exit");
        Zoo.view_Attractions(zoo);
        int att_choice=scanner.nextInt();
        if(Objects.equals(visitor.getMembershipType(), "Premium")){
            System.out.println("You are a premium member .Thanks for Visiting. ");
            return;
        }
        if(att_choice==0){
            System.out.println("Exiting");
        }
        if(zoo.attractions_map.containsKey(att_choice)){
            if(visitor.visitor_attraction_list.get(att_choice)==0){
                System.out.println("No tickets to visit here. Basic Members need to buy separate tickets for the attractions.\n");
            }
            else {
                int decrease=visitor.visitor_attraction_list.get(att_choice)-1;
                visitor.visitor_attraction_list.put(att_choice,decrease);
                System.out.println("1 Ticket used .Thanks for Visiting. ");
            }
        }
        else{
            System.out.println("Invalid choice");
        }
    }
    public static void LoginAdmin(Scanner scanner,Zoo zoo,Admin admin) {

        System.out.print("Enter Admin Username: ");
        String username = scanner.next();
        System.out.print("Enter Admin Password: ");
        String password = scanner.next();

        if (Admin.authenticate(username,password)) {
            System.out.println("Logged in as Admin.");
            admin.defaultDiscount(zoo);
            int admin_choice=0;
            while(true){
                admin.showMenu();
                admin_choice = scanner.nextInt();
                if(admin_choice==8){
                    break;
                }

                switch (admin_choice) {
                    case 1:
                        ManageAttractions(admin,zoo,scanner);
                        break;
                    case 2:
                        ManageAnimals(admin,scanner,zoo);
                        break;
                    case 3:
                        admin.scheduleEvents(scanner,zoo);
                        break;
                    case 4:
                        setDiscounts(admin,scanner,zoo);
                        break;
                    case 5:
                        setDeal(admin,scanner,zoo);
                        break;
                    case 6:
                        admin.viewVisitorStats();
                        break;
                    case 7:
                        admin.viewFeedback(zoo);
                        break;
                    case 8:
                        System.out.println("Logged out.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }

        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }
    public static void LoginVisitor(Scanner scanner,Zoo zoo){

        int visitor_choice=0;
        scanner.nextLine();
        while (true){
            if (visitor_choice==3){
                break;
            }
            zoo.showVisitorLogin();
            visitor_choice = scanner.nextInt();
            switch (visitor_choice) {
            case 1:
                zoo.registerVisitor(scanner);
                break;
            case 2:
                Visitor visitor = zoo.loginVisitor(scanner);
                if(visitor==null){
                    break;
                }
                int vis_choice = 0;
                while (true) {
                    if (vis_choice == 9) {
                        break;
                    }
                    zoo.showVisitorMenu();
                    System.out.println("\nEnter choice");
                    vis_choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (vis_choice) {
                        case 1:
                            System.out.println("Explore the Zoo...");
                            Explore(zoo, visitor, scanner);
                            break;
                        case 2:
                            System.out.println("Buying Membership...");
                            zoo.buyMembership(visitor,zoo,scanner);
                            break;
                        case 3:
                            BuyTicket(scanner,visitor,zoo);
                            break;
                        case 4:
                            System.out.println("Discounts:");
                            Zoo.viewDiscounts(zoo);
                            break;
                        case 5:
                            System.out.println("Special Deals:");
                            Zoo.viewDeals(zoo);
                            break;
                        case 6:
                            zoo.visitAnimal(scanner,zoo);
                            break;
                        case 7:
                            VisitAttraction(scanner,visitor,zoo);
                            break;
                        case 8:
                            System.out.println("Add Feedback");
                            zoo.addFeedback(visitor, scanner,zoo);
                            break;
                        case 9:
                            System.out.println("Logging Out. Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }
                }
            case 3:
                System.out.println("Exiting Zoo. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to ZOOtopia!");
        while(true) {
            System.out.println("\n1. Enter as Admin\n2. Enter as a Visitor\n3. View Special Deals\n4. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            if(choice==4){
                System.out.print("\nExiting .GOOD BYE ");
                break;
            }
            Admin admin = new Admin();
            admin.defaultAnimals(zoo);
                switch (choice) {
                    case 1:
                        LoginAdmin(scanner,zoo,admin);
                        break;
                    case 2:
                        LoginVisitor(scanner,zoo);
                        break;
                    case 3:

                        Zoo.viewDeals(zoo);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }

        }


    }
}


