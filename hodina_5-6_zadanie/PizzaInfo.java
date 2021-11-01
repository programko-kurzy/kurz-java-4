import java.util.HashMap;

/**
 * Enumerates available pizzas
 */
enum Pizza {
    Gazdovska,
    Hawai,
    Sampinonova,
    Provinciale
}

public class PizzaInfo {
    /**
     * Maps pizza to its price
     */
    private HashMap<Pizza, Double> priceMap;

    /**
     * Maps pizza to its description
     */    
    private HashMap<Pizza, String> descriptionMap;

    private double garlicPrice;
    private double catchupPrice;

    public PizzaInfo(){
        garlicPrice = 0.00;
        catchupPrice = 0.00;

        priceMap = new HashMap<>();
        priceMap.put(Pizza.Gazdovska, 0.00);
        priceMap.put(Pizza.Hawai, 0.00);
        priceMap.put(Pizza.Sampinonova, 0.00);        
        priceMap.put(Pizza.Provinciale, 0.00);

        String gazdovskaDescription = "Syr, paradajkovy zaklad, klobasa, vajce, salama, cibula";
        String hawaiDescription = "Syr, paradajkovy zaklad, ananas, sunka";
        String sampinonovaDescription = "Syr, paradajkovy zaklad, sunka, sampinony";
        String provincialeDescription = "Syr, paradajkovy zaklad, kukurica, slanina, baranie rohy, cibula";

        descriptionMap = new HashMap<>();
        descriptionMap.put(Pizza.Gazdovska, gazdovskaDescription);
        descriptionMap.put(Pizza.Hawai, hawaiDescription);
        descriptionMap.put(Pizza.Sampinonova, sampinonovaDescription);
        descriptionMap.put(Pizza.Provinciale, provincialeDescription);
    }
    
    public HashMap<Pizza, Double> getPriceMap() {
        return priceMap;
    }

    public HashMap<Pizza, String> getDescriptionMap() {
        return descriptionMap;
    }

    public double getGarlicPrice() {
        return garlicPrice;
    }

    public double getCatchupPrice() {
        return catchupPrice;
    }         
}
