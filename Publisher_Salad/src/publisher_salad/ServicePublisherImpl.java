package publisher_salad;

import java.util.HashMap;

public class ServicePublisherImpl implements SaladPublisher {
	
	HashMap<String, Double> dinner_Salad = new HashMap<String, Double>();
	HashMap<String, Double> taco_Salad = new HashMap<String, Double>();
	HashMap<String, Double> Chiken_Salad = new HashMap<String, Double>();
	HashMap<String, Double> fruit_salad = new HashMap<String, Double>();
	
	public ServicePublisherImpl() {
		dinner_Salad.put("Slaw Salad", 250.0);
		dinner_Salad.put("Honey Lime Rainbow Salad", 550.0);
		
		taco_Salad.put("Cabeza Taco Salad", 400.0);
		taco_Salad.put("Campechanos Taco Salad", 500.0);
		taco_Salad.put("Chorizo Taco Salad", 700.0);
		
		Chiken_Salad.put("Grilled Chiken Salad", 1500.0);
		Chiken_Salad.put("Fried Chiken Salad", 1200.0);
		
		fruit_salad.put("Spinach Apple Salad", 250.0);
		fruit_salad.put("Mixed Fruit Salad", 300.0);
		fruit_salad.put("Perfect Summer Fruit Salad", 350.0);
		
	}
	
	@Override
	public void displaySalad(int a) {
		int count ;
		switch (a) {
		case 1:
			count = 1 ;
			for(String name1 : dinner_Salad.keySet()) {
				String key1 = name1.toString();
				String value1 = dinner_Salad.get(name1).toString();
				System.out.println(count + ". " + key1 + " :- Rs" +value1);
				count++;
			};
			break;
		case 2:
			count = 1 ;
			for(String name2 : taco_Salad.keySet()) {
				String key2 = name2.toString();
				String value2 = taco_Salad.get(name2).toString();
				System.out.println(count + ". " + key2 + " :- Rs" +value2);
				count++;
			};
			break;
			
		case 3: 
			count = 1 ;
			for(String name3 : Chiken_Salad.keySet()) {
				String key3 = name3.toString();
				String value3 = Chiken_Salad.get(name3).toString();
				System.out.println(count + ". " + key3 + " :- Rs" +value3);
				count++;
			};
			break;
			
		case 4:
			count = 1 ;
			for(String name4 : fruit_salad.keySet()) {
				String key4 = name4.toString();
				String value4 = fruit_salad.get(name4).toString();
				System.out.println(count + ". " + key4 + " :- Rs" +value4);
				count++;
			};
			break;
		}
		count = 0;
}
		
	@Override
	public double getPrice(int type, int salad) {
		// TODO Auto-generated method stub
				double price = 0; 
				if(type == 1) {
					switch (salad) {
					case 1:
						price = dinner_Salad.get("Slaw Salad");
						break;
					case 2:
						price = dinner_Salad.get("Honey Lime Rainbow Salad");
						break;
					}
				}else if(type == 2) {
					switch (salad) {
					case 1:
						price = taco_Salad.get("Cabeza Taco Salad");
						break;
					case 2:
						price = taco_Salad.get("Campechanos Taco Salad");
						break;
					case 3:
						price = taco_Salad.get("Chorizo Taco Salad");
						break;
					}
					
				}else if(type == 3) {
					switch (salad) {
					case 1:
						price = Chiken_Salad.get("Grilled Chiken Salad");
						break;
					case 2:
						price = Chiken_Salad.get("Fried Chiken Salad");
						break;
					}
					
				}else if(type == 4) {
					switch (salad) {
					case 1:
						price = fruit_salad.get("Spinach Apple Salad");
						break;
					case 2:
						price = fruit_salad.get("Mixed Fruit Salad");
						break;
					case 3:
						price = fruit_salad.get("Perfect Summer Fruit Salad");
						break;
					}	
				}
				return price;	
	}

	@Override
	public String getName(int type, int salad) {
		// TODO Auto-generated method stub
		String name = ""; 
		if(type == 1) {
			switch (salad) {
			case 1:
				name = "Slaw Salad";
				break;
			case 2:
				name = "Honey Lime Rainbow Salad";
				break;
			}
		}else if(type == 2) {
			switch (salad) {
			case 1:
				name = "Cabeza Taco Salad";
				break;
			case 2:
				name = "Campechanos Taco Salad";
				break;
			case 3:
				name = "Chorizo Taco Salad";
				break;
			}
			
		}else if(type == 3) {
			switch (salad) {
			case 1:
				name = "Grilled Chiken Salad";
				break;
			case 2:
				name = "Fried Chiken Salad";
				break;
			}
			
		}else if(type == 4) {
			switch (salad) {
			case 1:
				name = "Spinach Apple Salad";
				break;
			case 2:
				name = "Mixed Fruit Salad";
				break;
			case 3:
				name = "Perfect Summer Fruit Salad";
				break;
			}	
		}
		return name;	
	}
}


