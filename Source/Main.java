import Products.Pizza;
import Products.Burger;
import StoreRepository.StoreRepository;
import Enums.Size;
import Enums.Payments;
import Enums.PizzaTypes;
import Enums.BurgerTypes;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.math.BigDecimal;
import ServiceLayer.BurgerService;
import ServiceLayer.PizzaService;

public class Main {
    static StoreRepository repository = new StoreRepository();
    static PizzaService pizzaservice = new PizzaService(repository);
    static BurgerService burgerservice = new BurgerService(repository);

    public static void main(String[] args) {
        try{
            takeOrder();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thank you for Ordering -- Your Order Placed Successfully -- Visit Again ");
        }
    }

    public static void takeOrder() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to MACDONALD'S\nTo Order --- PRESS ENTER ");

        List<Pizza> pizzaOrders = new ArrayList<>();
        List<Burger> burgerOrders = new ArrayList<>();
        String continueOrdering = "yes";

        while (continueOrdering.equalsIgnoreCase("yes")) {
            int menuChoice = -1;
            while (true) {
                System.out.println("MENU: 1 - Pizza | 2 - Burger");
                if (scan.hasNextInt()) {
                    menuChoice = scan.nextInt();
                    scan.nextLine();
                if (menuChoice == 1 || menuChoice == 2) break;
                } else {
                    scan.nextLine();
                }
                System.out.println("Invalid menu choice. Please enter 1 for Pizza or 2 for Burger.");
                }
            if (menuChoice == 1) {
                    int type = -1;
                    while (true) {
                        System.out.println("Select Pizza Type:"
                            + "\n1 -- " + PizzaTypes.CHICKEN_PIZZA.name()
                            + "\n2 -- " + PizzaTypes.MUTTON_PIZZA.name()
                            + "\n3 -- " + PizzaTypes.CHEESE_PIZZA.name()
                            + "\n4 -- " + PizzaTypes.VEG_PIZZA.name());
                        if (scan.hasNextInt()) {
                            type = scan.nextInt();
                            scan.nextLine();
                            if (type >= 1 && type <= 4) break;
                        } else {
                            scan.nextLine();
                        }
                        System.out.println("Invalid pizza type. Please enter 1, 2, 3, or 4.");
                    }
                PizzaTypes pizzatype;
                switch (type) {
                    case 1: pizzatype = PizzaTypes.CHICKEN_PIZZA; break;
                    case 2: pizzatype = PizzaTypes.MUTTON_PIZZA; break;
                    case 3: pizzatype = PizzaTypes.CHEESE_PIZZA; break;
                    case 4: pizzatype = PizzaTypes.VEG_PIZZA; break;
                    default: System.out.println("Invalid Option"); continue;
                }
                System.out.println("Select Size:\n1 -- SMALL\n2 -- MEDIUM\n3 -- LARGE");
                int size = -1;
                while(true){
                    if(scan.hasNextInt()){
                        size = scan.nextInt();
                        scan.nextLine();
                        if(size == 1 || size == 2 || size == 3) break;
                    }else{
                        scan.nextLine();
                    }
                    System.out.println("Invalid pizza type. Please enter 1, 2, 3, or 4.");
                    }

                Size sizes;
                switch (size) {
                    case 1: sizes = Size.SMALL; break;
                    case 2: sizes = Size.MEDIUM; break;
                    case 3: sizes = Size.LARGE; break;
                    default: System.out.println("Invalid Option"); continue;
                }
                int count = -1;
                while (true) {
                    System.out.println("How many PIZZAS?");
                    if (scan.hasNextInt()) {
                        count = scan.nextInt();
                        scan.nextLine();
                        if (count > 0) break;
                    } else {
                        scan.nextLine();
                    }
                    System.out.println("Invalid count. Please enter a positive number.");
                }
                String id = String.valueOf(new Random().nextInt(10000));
                BigDecimal basePrice = getPizzaBasePrice(pizzatype, sizes);
                BigDecimal totalPrice = basePrice.multiply(new BigDecimal(count));
                Pizza pizza = new Pizza(id, totalPrice, sizes, pizzatype, count);
                pizzaOrders.add(pizza);

            } else if (menuChoice == 2) {
                int type = -1;
                    while (true) {
                        System.out.println("Select Burger Type:"
                            + "\n1 -- " + BurgerTypes.CHICKEN_BURGER.name()
                            + "\n2 -- " + BurgerTypes.MUTTON_BURGER.name()
                            + "\n3 -- " + BurgerTypes.VEG_BURGER.name());
                        if (scan.hasNextInt()) {
                            type = scan.nextInt();
                            scan.nextLine();
                            if (type >= 1 && type <= 3) break;
                        } else {
                            scan.nextLine();
                        }
                        System.out.println("Invalid Burger type. Please enter 1, 2, 3, or 4.");
                    }
                BurgerTypes burgertype;
                switch (type) {
                    case 1: burgertype = BurgerTypes.CHICKEN_BURGER; break;
                    case 2: burgertype = BurgerTypes.MUTTON_BURGER; break;
                    case 3: burgertype = BurgerTypes.VEG_BURGER; break;
                    default: System.out.println("Invalid Option"); continue;
                }
                System.out.println("Select Size:\n1 -- SMALL\n2 -- MEDIUM\n3 -- LARGE");
                int size = -1;
                while(true){
                    if(scan.hasNextInt()){
                        size = scan.nextInt();
                        scan.nextLine();
                        if(size == 1 || size == 2 || size == 3) break;
                    }else{
                        scan.nextLine();
                    }
                    System.out.println("Invalid Burger type. Please enter 1, 2, 3, or 4.");
                    }
                Size sizes;
                switch (size) {
                    case 1: sizes = Size.SMALL; break;
                    case 2: sizes = Size.MEDIUM; break;
                    case 3: sizes = Size.LARGE; break;
                    default: System.out.println("Invalid Option"); continue;
                }
                int count = -1;
                while (true) {
                    System.out.println("How many BURGERS?");
                    if (scan.hasNextInt()) {
                        count = scan.nextInt();
                        scan.nextLine();
                        if (count > 0) break;
                    } else {
                        scan.nextLine();
                    }
                    System.out.println("Invalid count. Please enter a positive number.");
                }
                String id = String.valueOf(new Random().nextInt(10000));
                BigDecimal basePrice = getBurgerBasePrice(burgertype, sizes);
                BigDecimal totalPrice = basePrice.multiply(new BigDecimal(count));
                Burger burger = new Burger(id, totalPrice, sizes, burgertype, count);
                burgerOrders.add(burger);
            } else {
                System.out.println("Invalid menu choice.");
            }
            System.out.println("Order more items? yes/no");
            continueOrdering = scan.nextLine();
        }
            int payment = -1;
            while (true) {
                System.out.println("PAYMENT GATEWAY\n1 -- CASH\n2 -- CARD");
                if (scan.hasNextInt()) {
                    payment = scan.nextInt();
                    scan.nextLine();
                    if (payment == 1 || payment == 2) break;
                } else {
                    scan.nextLine();
                }
                System.out.println("Invalid Payment Type. Please enter 1 for CASH or 2 for CARD.");
        }
        Payments paymentType;
        switch (payment) {
            case 1: paymentType = Payments.CASH; break;
            case 2: paymentType = Payments.CARD; break;
            default: System.out.println("Invalid Option"); paymentType = Payments.CASH;
        }

        BigDecimal finalBill = BigDecimal.ZERO;
        for (Pizza p : pizzaOrders) {
            pizzaservice.createItemOrder(p);
            finalBill = finalBill.add(p.getBill());
        }
        for (Burger b : burgerOrders) {
            burgerservice.createItemOrder(b);
            finalBill = finalBill.add(b.getBill());
        }

        if (paymentType == Payments.CASH) {
            for (Pizza p : pizzaOrders) {
                pizzaservice.payViaCash(p.getId(), p.getBill());
            }
            for (Burger b : burgerOrders) {
                burgerservice.payViaCash(b.getId(), b.getBill());
            }
        } else if (paymentType == Payments.CARD) {
            for (Pizza p : pizzaOrders) {
                pizzaservice.payViaCard(p.getId(), p.getBill());
            }
            for (Burger b : burgerOrders) {
                burgerservice.payViaCard(b.getId(), b.getBill());
            }
        }

        System.out.println("\nOrder Summary:");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-8s %-16s %-8s %-8s %-10s\n", "Item", "Type", "Size", "Count", "Bill");
        for (Pizza p : pizzaOrders) {
            System.out.printf("%-8s %-16s %-8s %-8d %-10s\n", 
                "Pizza", 
                p.getType().name(), 
                p.getSize().name(), 
                p.getCount(), 
                p.getBill().toString()
            );
        }
        for (Burger b : burgerOrders) {
            System.out.printf("%-8s %-16s %-8s %-8d %-10s\n", 
                "Burger", 
                b.getType().name(), 
                b.getSize().name(), 
                b.getCount(), 
                b.getBill().toString()
            );
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("Your final bill: " + finalBill);

    }

    public static BigDecimal getPizzaBasePrice(PizzaTypes type, Size size) {
        if (type == null || size == null) return BigDecimal.ZERO;
        switch (type) {
            case CHICKEN_PIZZA:
                switch (size) {
                    case SMALL: return new BigDecimal("200");
                    case MEDIUM: return new BigDecimal("300");
                    case LARGE: return new BigDecimal("400");
                }
                break;
            case MUTTON_PIZZA:
                switch (size) {
                    case SMALL: return new BigDecimal("250");
                    case MEDIUM: return new BigDecimal("350");
                    case LARGE: return new BigDecimal("450");
                }
                break;
            case CHEESE_PIZZA:
                switch (size) {
                    case SMALL: return new BigDecimal("180");
                    case MEDIUM: return new BigDecimal("280");
                    case LARGE: return new BigDecimal("380");
                }
                break;
            case VEG_PIZZA:
                switch (size) {
                    case SMALL: return new BigDecimal("150");
                    case MEDIUM: return new BigDecimal("250");
                    case LARGE: return new BigDecimal("350");
                }
                break;
        }
        return BigDecimal.ZERO;
    }

    public static BigDecimal getBurgerBasePrice(BurgerTypes type, Size size) {
        if (type == null || size == null) return BigDecimal.ZERO;
        switch (type) {
            case CHICKEN_BURGER:
                switch (size) {
                    case SMALL: return new BigDecimal("130");
                    case MEDIUM: return new BigDecimal("180");
                    case LARGE: return new BigDecimal("230");
                }
                break;
            case MUTTON_BURGER:
                switch (size) {
                    case SMALL: return new BigDecimal("150");
                    case MEDIUM: return new BigDecimal("210");
                    case LARGE: return new BigDecimal("280");
                }
                break;
            case VEG_BURGER:
                switch (size) {
                    case SMALL: return new BigDecimal("110");
                    case MEDIUM: return new BigDecimal("160");
                    case LARGE: return new BigDecimal("210");
                }
                break;
        }
        return BigDecimal.ZERO;
    }
}
