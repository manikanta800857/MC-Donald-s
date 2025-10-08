package ServiceLayer;
import Products.Pizza;
import StoreRepository.StoreRepository;
import java.math.BigDecimal;

public class PizzaService implements BillingService {

    private StoreRepository repository;
    
    @Override 
        public void payViaCash(String id,BigDecimal amount){
            Pizza pizza = retriveItemOrder(id);
            if(pizza.getSize().name().equals("SMALL")){
                pizza.setBill(BigDecimal.valueOf(20).multiply(BigDecimal.valueOf(pizza.getCount())));
            updateItemOrder(pizza);
            }else if(pizza.getSize().name().equals("MEDIUM")){
                pizza.setBill(BigDecimal.valueOf(40).multiply(BigDecimal.valueOf(pizza.getCount())));
            updateItemOrder(pizza);
            }else if(pizza.getSize().name().equals("LARGE")){
                pizza.setBill(BigDecimal.valueOf(60).multiply(BigDecimal.valueOf(pizza.getCount())));
            updateItemOrder(pizza);
            }else{
                System.out.println("Invalid Size");
            }
        }
        
    @Override 
        public void payViaCard(String id,BigDecimal amount){
            Pizza pizza = retriveItemOrder(id);
            if(pizza.getSize().name().equals("SMALL")){
                pizza.setBill(BigDecimal.valueOf(20).multiply(BigDecimal.valueOf(pizza.getCount())));
            updateItemOrder(pizza);
            }else if(pizza.getSize().name().equals("MEDIUM")){
                pizza.setBill(BigDecimal.valueOf(40).multiply(BigDecimal.valueOf(pizza.getCount())));
            updateItemOrder(pizza);
            }else if(pizza.getSize().name().equals("LARGE")){
                pizza.setBill(BigDecimal.valueOf(60).multiply(BigDecimal.valueOf(pizza.getCount())));
            updateItemOrder(pizza);
            }else{
                System.out.println("Invalid Size");
            }
        }

    public PizzaService(StoreRepository repository){
        this.repository = repository;
    }
    
     public void createItemOrder(Pizza pizza){
        this.repository.createItemOrder(pizza);
    }

    public Pizza retriveItemOrder(String id){
        return (Pizza)this.repository.retriveItemOrder(id);
    }

    public void updateItemOrder(Pizza pizza){
        this.repository.updateItemOrder(pizza);
    }

    public void removeItemOrder(String id){
        this.repository.removeItemOrder(id);
    }   
}
