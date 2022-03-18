package publisher_milkshake;

import java.util.HashMap;
import java.util.Iterator;

public class ServicePublisherImpl implements MilkShakePublisher {
	
	HashMap<String, Double> nutella_milkShake = new HashMap();
    HashMap<String, Double> choclate_milkShake = new HashMap();
    HashMap<String, Double> vanila_milkShake = new HashMap();
    HashMap<String, Double> oreo_milkShake = new HashMap();
    
    public ServicePublisherImpl() {
        this.nutella_milkShake.put("Glass", 740.0);
        this.nutella_milkShake.put("TakeAway", 800.0);
        this.choclate_milkShake.put("Glass", 600.0);
        this.choclate_milkShake.put("TakeAway", 750.0);
        this.vanila_milkShake.put("Glass", 600.0);
        this.vanila_milkShake.put("TakeAway", 700.0);
        this.oreo_milkShake.put("Glass", 740.0);
        this.oreo_milkShake.put("TakeAway", 800.0);
    }
    
    public void displayMilkShake(int mValue) {
        int count;
        String name;
        Iterator i;
        String key4;
        String value4;
        
        switch(mValue) {
        case 1:
            count = 1;

            for(i = this.nutella_milkShake.keySet().iterator(); i.hasNext(); ++count) {
                name = (String)i.next();
                key4 = name.toString();
                value4 = ((Double)this.nutella_milkShake.get(name)).toString();
                System.out.println(count + ". " + key4 + " :- Rs" + value4);
            }

            return;
        case 2:
            count = 1;

            for(i = this.choclate_milkShake.keySet().iterator(); i.hasNext(); ++count) {
                name = (String)i.next();
                key4 = name.toString();
                value4 = ((Double)this.choclate_milkShake.get(name)).toString();
                System.out.println(count + ". " + key4 + " :- Rs" + value4);
            }

            return;
        case 3:
            count = 1;

            for(i = this.vanila_milkShake.keySet().iterator(); i.hasNext(); ++count) {
                name = (String)i.next();
                key4 = name.toString();
                value4 = ((Double)this.vanila_milkShake.get(name)).toString();
                System.out.println(count + ". " + key4 + " :- Rs" + value4);
            }

            return;
        case 4:
            count = 1;

            for(i = this.oreo_milkShake.keySet().iterator(); i.hasNext(); ++count) {
                name = (String)i.next();
                key4 = name.toString();
                value4 = ((Double)this.oreo_milkShake.get(name)).toString();
                System.out.println(count + ". " + key4 + " :- Rs" + value4);
            }
        }

    }
    
    public double getPrice(int type, int milkShake) {
       
    	double price = 0.0D;
        if (type == 1) {
            switch(milkShake) {
            case 1:
                price = (Double)this.nutella_milkShake.get("Glass");
                break;
            case 2:
                price = (Double)this.nutella_milkShake.get("TakeAway");
                break;
            }
        } else if (type == 2) {
            switch(milkShake) {
            case 1:
                price = (Double)this.choclate_milkShake.get("Glass");
                break;
            case 2:
                price = (Double)this.choclate_milkShake.get("TakeAway");
                break;
            }
        } else if (type == 3) {
            switch(milkShake) {
            case 1:
                price = (Double)this.vanila_milkShake.get("Glass");
                break;
            case 2:
                price = (Double)this.vanila_milkShake.get("TakeAway");
                break;
            }
        } else if (type == 4) {
            switch(milkShake) {
            case 1:
                price = (Double)this.oreo_milkShake.get("Glass");
                break;
            case 2:
                price = (Double)this.oreo_milkShake.get("TakeAway");
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
                name = "Glass";
                break;
            case 2:
                name = "TakeAway";
                break;
            }
        } else if (type == 2) {
            switch(milkShake) {
            case 1:
                name = "Glass";
                break;
            case 2:
                name = "TakeAway";
                break;
            }
        } else if (type == 3) {
            switch(milkShake) {
            case 1:
                name = "Glass";
                break;
            case 2:
                name = "TakeAway";
                break;
            }
        } else if (type == 4) {
            switch(milkShake) {
            case 1:
                name = "Glass";
                break;
            case 2:
                name = "TakeAway";
                break;
            }
        }
        return name;
    }
    
}
