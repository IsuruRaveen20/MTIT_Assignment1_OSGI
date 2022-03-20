package publisher_milkshake;

import java.util.HashMap;
import java.util.Iterator;

public class ServicePublisherImpl implements MilkShakePublisher {
	
	HashMap<String, Double> nutella_milkShake = new HashMap <String, Double>();
    HashMap<String, Double> choclate_milkShake = new HashMap <String, Double>();
    HashMap<String, Double> vanila_milkShake = new HashMap <String, Double>();
    HashMap<String, Double> oreo_milkShake = new HashMap <String, Double>();
    
    public ServicePublisherImpl() {
        this.nutella_milkShake.put("Glass", 740.00);
        this.nutella_milkShake.put("TakeAway", 800.00);
        
        this.choclate_milkShake.put("Glass", 600.00);
        this.choclate_milkShake.put("TakeAway", 750.00);
        
        this.vanila_milkShake.put("Glass", 600.00);
        this.vanila_milkShake.put("TakeAway", 700.00);
        
        this.oreo_milkShake.put("Glass", 740.00);
        this.oreo_milkShake.put("TakeAway", 800.00);
    }
    
    public void displayMilkShake(int type) {
        int count;
        switch(type) {
        case 1:
            count = 1;

            for(String nutellaMilkShake_Name : nutella_milkShake.keySet()) {
//            	String key1 = name1.toString();
				String nutella_Price = nutella_milkShake.get(nutellaMilkShake_Name).toString();
				System.out.println(count + ". " + nutellaMilkShake_Name + " :- Rs" +nutella_Price);
				count++;
            };
            break;
            
        case 2:
            count = 1;

            for(String choclateMilkShake_Name : choclate_milkShake.keySet()) {
//            	String key2 = name2.toString();
				String choclate_Price = choclate_milkShake.get(choclateMilkShake_Name).toString();
				System.out.println(count + ". " + choclateMilkShake_Name + " :- Rs" +choclate_Price);
				count++;
            };
            break;
            
        case 3:
            count = 1;

            for(String vanilaMilkShake_Name : vanila_milkShake.keySet()) {
//            	String key3 = vanilaMilkShake_Name.toString();
            	String vanila_Price = vanila_milkShake.get(vanilaMilkShake_Name).toString();
				System.out.println(count + ". " + vanilaMilkShake_Name + " :- Rs" +vanila_Price);
				count++;
            };
            break;
            
        case 4:
            count = 1;

            for(String oreoMilkShake_Name : oreo_milkShake.keySet()) {
//            	String key4 = oreoMilkShake_Name.toString();
				String oreo_Price = oreo_milkShake.get(oreoMilkShake_Name).toString();
				System.out.println(count + ". " + oreoMilkShake_Name + " :- Rs" +oreo_Price);
				count++;
            };
            break;
        }
    }
    
    public double getPrice(int type, int milkShake) {
       
    	double price = 0.00;
        if (type == 1) {
            switch(milkShake) {
            	case 1:
            		price = (Double)this.nutella_milkShake.get("TakeAway");
            		break;
                
            	case 2:
            		price = (Double)this.nutella_milkShake.get("Glass");
            		break;
                  }
        } 
        else if (type == 2) {
            switch(milkShake) {
            	case 1:
            		price = (Double)this.choclate_milkShake.get("TakeAway");
            		break;
            	case 2:
            		price = (Double)this.choclate_milkShake.get("Glass");
            		break;
            	}
        } 
        else if (type == 3) {
            switch(milkShake) {
            	case 1:
            		price = (Double)this.vanila_milkShake.get("TakeAway");
            		break;
            	case 2:
            		price = (Double)this.vanila_milkShake.get("Glass");
            		break;
            	}
        } else if (type == 4) {
            	switch(milkShake) {
            		case 1:
            			price = (Double)this.oreo_milkShake.get("TakeAway");
            			break;
            		case 2:
            			price = (Double)this.oreo_milkShake.get("Glass");
            			break;
            	}
        }   
        return price;       
}
    
    public String getName(int type, int milkShake) {
        String name = "";
        
        if (type == 1) {
            switch(milkShake) {
            	case 1:
            		name = "TakeAway";
            		break;
            		
            	case 2:
            		name = "Glass";
            		break;
            }
        } 
        
        else if (type == 2) {
            switch(milkShake) {
            	case 1:
            		name = "TakeAway";
            		break;
            	case 2:
            		name = "Glass";
            		break;
            }
        }
        
        else if (type == 3) {
            switch(milkShake) {
            	case 1:
            		name = "TakeAway";
            		break;
            	case 2:
            		name = "Glass";
            		break;
            	}
        } 
        else if (type == 4) {
            switch(milkShake) {
            	case 1:
            		name = "TakeAway";
            		break;
            	case 2:
            		name = "Glass";
            		break;
            }
        }
        return name;
    }
    
}
