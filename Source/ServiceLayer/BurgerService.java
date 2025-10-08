package ServiceLayer;
import Products.Burger;
import StoreRepository.StoreRepository;
import java.math.BigDecimal;

public class BurgerService implements BillingService{

    private StoreRepository repository;
    
    @Override 
        public void payViaCash(String id,BigDecimal amount){
            Burger burger = retriveItemOrder(id);
            if(burger.getSize().name().equals("SMALL")){
                burger.setBill(BigDecimal.valueOf(20).multiply(BigDecimal.valueOf(burger.getCount())));
            updateItemOrder(burger);
            }else if(burger.getSize().name().equals("MEDIUM")){
                burger.setBill(BigDecimal.valueOf(40).multiply(BigDecimal.valueOf(burger.getCount())));
            updateItemOrder(burger);
            }else if(burger.getSize().name().equals("LARGE")){
                burger.setBill(BigDecimal.valueOf(60).multiply(BigDecimal.valueOf(burger.getCount())));
            updateItemOrder(burger);
            }else{
                System.out.println("Invalid Size");
            }
        }
        
    @Override 
        public void payViaCard(String id,BigDecimal amount){
            Burger burger = retriveItemOrder(id);
            if(burger.getSize().name().equals("SMALL")){
                burger.setBill(BigDecimal.valueOf(20).multiply(BigDecimal.valueOf(burger.getCount())));
            updateItemOrder(burger);
            }else if(burger.getSize().name().equals("MEDIUM")){
                burger.setBill(BigDecimal.valueOf(40).multiply(BigDecimal.valueOf(burger.getCount())));
            updateItemOrder(burger);
            }else if(burger.getSize().name().equals("LARGE")){
                burger.setBill(BigDecimal.valueOf(60).multiply(BigDecimal.valueOf(burger.getCount())));
            updateItemOrder(burger);
            }else{
                System.out.println("Invalid Size");
            }
        }

    public BurgerService(StoreRepository repository){
        this.repository = repository;
    }
    
     public void createItemOrder(Burger burger){
        this.repository.createItemOrder(burger);
    }

    public Burger retriveItemOrder(String id){
        return (Burger)this.repository.retriveItemOrder(id);
    }

    public void updateItemOrder(Burger burger){
        this.repository.updateItemOrder(burger);
    }

    public void removeItemOrder(String id){
        this.repository.removeItemOrder(id);
    }   
}
