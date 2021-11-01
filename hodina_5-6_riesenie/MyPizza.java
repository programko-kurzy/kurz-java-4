public class MyPizza {
    private String name;
    private Double price;
    private String description = "";

    public static final Double CATCHUP_PRICE = 0.4;
    public static final Double GARLIC_PRICE = 0.3;

    public MyPizza(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice(){
        return price;

    }

    public String toString(){
        return name + " " + price;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
}
