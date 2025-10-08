package Products;
import Enums.Size;
import java.math.BigDecimal;

public abstract class Item {
    
    private String id;
    private Size size;
    private BigDecimal Bill;

    public Item(String id,BigDecimal Bill,Size size){
        this.id = id;
        this.Bill = Bill;
        this.size = size;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if(id.equals(null) || id.isBlank()){
            throw new IllegalArgumentException("Sorry,ID should not be Null or Blank");
        }
        this.id = id;
    }

    public Size getSize() {
        return this.size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public BigDecimal getBill() {
        return this.Bill;
    }

    public void setBill(BigDecimal Bill) {
        if (Bill == null || Bill.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Sorry, price should not be null or negative");
        }
        this.Bill = Bill;
    }
    
     public String toString(){
        return id + size + Bill ;
    }

    public abstract Item clone();


}
