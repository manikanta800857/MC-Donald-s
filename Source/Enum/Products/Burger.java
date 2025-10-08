package Products;
import java.lang.IllegalArgumentException;
import java.math.BigDecimal;

import Enums.BurgerTypes;
import Enums.Size;

public class Burger extends Item{
    private BurgerTypes burger;
    private int count;

   public Burger(String id,BigDecimal Bill,Size size,BurgerTypes burger,int count){
        super(id,Bill,size);
        this.burger = burger;
        this.count = count;
    }

    public BurgerTypes getType() {
        return this.burger;
    }

    public void setType(BurgerTypes burger) {
        this.burger = burger;
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
        return super.getId() + super.getSize() + super.getBill() + this.burger + this.count;
    }

    @Override
    public Item clone(){
        return new Burger(super.getId(),super.getBill(),super.getSize(),this.burger,this.count);
    }
}
