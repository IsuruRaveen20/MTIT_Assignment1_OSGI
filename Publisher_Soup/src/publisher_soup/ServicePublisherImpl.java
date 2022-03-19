package publisher_soup;

import java.util.HashMap;

public class ServicePublisherImpl implements SoupPublisher {
	
	HashMap<String, Double> chicken_Soup = new HashMap<String, Double>();
	HashMap<String, Double> vegitable_Soup = new HashMap<String, Double>();
	HashMap<String, Double> noodles_soup= new HashMap<String, Double>();
	HashMap<String, Double> seaFood_soup = new HashMap<String, Double>();
	
	public ServicePublisherImpl() {
		
		chicken_Soup.put("Cream Chiken Soup", 300.0);
		chicken_Soup.put("Galic Chiken Soup", 1250.0);
		chicken_Soup.put("BBQ Chicken Soup", 1500.0);
		
		vegitable_Soup.put("Carrtot Soup", 970.0);
		vegitable_Soup.put("Beans Soup", 1150.0);
		vegitable_Soup.put("Mixed Vegatable Soup", 1250.0);

		noodles_soup.put("Thai Red Curry Chicken Noodles Soup", 250.0);
		noodles_soup.put("Italian Noodles Soup", 280.0);
		noodles_soup.put("Asian Chicken Corn Noodles Soup", 290.0);
		
		seaFood_soup.put("Fish Soup", 750.0);
		seaFood_soup.put("Oyster Soup", 550.0);
		seaFood_soup.put("Lobster Soup", 900.0);
	}

	@Override
	public void displaySoup(int a) {
		// TODO Auto-generated method stub
		int count ;
		switch (a) {
		case 1:
			count = 1 ;
			for(String name1 : chicken_Soup.keySet()) {
				String key1 = name1.toString();
				String value1 = chicken_Soup.get(name1).toString();
				System.out.println(count + ". " + key1 + " :- Rs" +value1);
				count++;
			};
			break;
		case 2:
			count = 1 ;
			for(String name2 : vegitable_Soup.keySet()) {
				String key2 = name2.toString();
				String value2 = vegitable_Soup.get(name2).toString();
				System.out.println(count + ". " + key2 + " :- Rs" +value2);
				count++;
			};
			break;
			
		case 3: 
			count = 1 ;
			for(String name3 : noodles_soup.keySet()) {
				String key3 = name3.toString();
				String value3 = noodles_soup.get(name3).toString();
				System.out.println(count + ". " + key3 + " :- Rs" +value3);
				count++;
			};
			break;
			
		case 4:
			count = 1 ;
			for(String name4 : seaFood_soup.keySet()) {
				String key4 = name4.toString();
				String value4 = seaFood_soup.get(name4).toString();
				System.out.println(count + ". " + key4 + " :- Rs" +value4);
				count++;
			};
			break;
		}
	}

	@Override
	public double getPrice(int type, int soup) {
		// TODO Auto-generated method stub
		double price = 0; 
		if(type == 1) {
			switch (soup) {
			case 1:
				price = chicken_Soup.get("Cream Chiken Soup");
				break;
			case 2:
				price = chicken_Soup.get("Galic Chiken Soup");
				break;
			case 3:
				price = chicken_Soup.get("BBQ Chicken Soup");
				break;
			}
		}else if(type == 2) {
			switch (soup) {
			case 1:
				price = vegitable_Soup.get("Carrtot Soup");
				break;
			case 2:
				price = vegitable_Soup.get("Beans Soup");
				break;
			case 3:
				price = vegitable_Soup.get("Mixed Vegatable Soup");
				break;
			}
			
		}else if(type == 3) {
			switch (soup) {
			case 1:
				price = noodles_soup.get("Thai Red Curry Chicken Noodles Soup");
				break;
			case 2:
				price = noodles_soup.get("Italian Noodles Soup");
				break;
			case 3:
				price = noodles_soup.get("Asian Chicken Corn Noodles Soup");
				break;
			}
			
		}else if(type == 4) {
			switch (soup) {
			case 1:
				price = seaFood_soup.get("Fish Soup");
				break;
			case 2:
				price = seaFood_soup.get("Oyster Soup");
				break;
			case 3:
				price = seaFood_soup.get("Lobster Soup");
				break;
			}	
		}
		return price;
	}

	@Override
	public String getName(int type, int soup) {
		// TODO Auto-generated method stub
		String name = ""; 
		if(type == 1) {
			switch (soup) {
			case 1:
				name = "Cream Chiken Soup";
				break;
			case 2:
				name = "Galic Chiken Soup";
				break;
			case 3:
				name = "BBQ Chicken Soup";
				break;
			}
		}else if(type == 2) {
			switch (soup) {
			case 1:
				name = "Carrtot Soup";
				break;
			case 2:
				name = "Beans Soup";
				break;
			case 3:
				name = "Mixed Vegatable Soup";
				break;
			}
			
		}else if(type == 3) {
			switch (soup) {
			case 1:
				name = "Thai Red Curry Chicken Noodles Soup";
				break;
			case 2:
				name = "Italian Noodles Soup";
				break;
			case 3:
				name = "Asian Chicken Corn Noodles Soup";
				break;
			}
			
		}else if(type == 4) {
			switch (soup) {
			case 1:
				name = "Fish Soup";
				break;
			case 2:
				name = "Oyster Soup";
				break;
			case 3:
				name = "Lobster Soup";
				break;
			}	
		}
		return name;	
	}

}
