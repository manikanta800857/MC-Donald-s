package Products;

import java.math.BigDecimal;

import Enums.PizzaTypes;
import Enums.Size;


public class Pizza extends Item{
    private PizzaTypes pizza;
    private int count;

    public Pizza(String id,BigDecimal Bill,Size size,PizzaTypes pizza,int count){
        super(id,Bill,size);
        this.pizza = pizza;
        this.count = count;
    }


    public PizzaTypes getType() {
        return this.pizza;
    }

    public void setType(PizzaTypes pizza) {
        this.pizza = pizza;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        if(count<0){
            throw new IllegalArgumentException("Sorry,Count should not be 0");
        }
        this.count = count;
    }
    
    public String toString(){
        return " "+ super.getId() +" "+ super.getSize() +" "+ super.getBill() +" "+ this.pizza +" "+ this.count;
    }

    @Override
    public Item clone(){
        return new Pizza(super.getId(),super.getBill(),super.getSize(),this.pizza,this.count);
    }

    
}


