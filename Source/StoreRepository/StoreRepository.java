package StoreRepository;
import java.util.HashMap;
import java.util.Map;
import Products.Item;

public class StoreRepository {

    private Map<String, Item> datastore = new HashMap<>();

    public void createItemOrder(Item item){
        this.datastore.put(item.getId(),item.clone());
    }

    public Item retriveItemOrder(String id){
        return this.datastore.get(id)==null ? null : this.datastore.get(id).clone();
    }

    public void updateItemOrder(Item item){
        this.datastore.put(item.getId(),item.clone());
    }

    public void removeItemOrder(String id){
        this.datastore.remove(id);
    }
}
