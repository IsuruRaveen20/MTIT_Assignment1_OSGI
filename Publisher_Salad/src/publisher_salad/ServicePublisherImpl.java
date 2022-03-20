package publisher_salad;

import java.util.HashMap;

public class ServicePublisherImpl implements SaladPublisher {
	
	HashMap<String, Double> dinner_Salad = new HashMap<String, Double>();
	HashMap<String, Double> taco_Salad = new HashMap<String, Double>();
	HashMap<String, Double> Chiken_Salad = new HashMap<String, Double>();
	HashMap<String, Double> fruit_salad = new HashMap<String, Double>();
	
	public ServicePublisherImpl() {
		//Salad Types and Prices
		dinner_Salad.put("Slaw Salad", 250.00);
		dinner_Salad.put("Honey Lime Rainbow Salad", 550.00);
		
		taco_Salad.put("Cabeza Taco Salad", 400.00);
		taco_Salad.put("Campechanos Taco Salad", 500.00);
		taco_Salad.put("Chorizo Taco Salad", 700.00);
		
		Chiken_Salad.put("Grilled Chiken Salad", 1500.00);
		Chiken_Salad.put("Fried Chiken Salad", 1200.00);
		
		fruit_salad.put("Spinach Apple Salad", 250.00);
		fruit_salad.put("Mixed Fruit Salad", 300.00);
		fruit_salad.put("Perfect Summer Fruit Salad", 350.00);
	}
	
	@Override
	public void displaySalad(int salad) {
		int count ;
		switch (salad) {
			case 1:
				count = 1 ;
				for(String dinnerSalad_Name : dinner_Salad.keySet()) {
//					String key1 = dinnerSalad_Name.toString();
					String value1 = dinner_Salad.get(dinnerSalad_Name).toString();
					System.out.println(count + ". " + dinnerSalad_Name + " :- Rs" + value1);
					count++;
				};
				break;
			case 2:
				count = 1 ;
				for(String tacoSalad_Name : taco_Salad.keySet()) {
//					String key2 = name2.toString();
					String value2 = taco_Salad.get(tacoSalad_Name).toString();
					System.out.println(count + ". " + tacoSalad_Name + " :- Rs" +value2);
					count++;
				};
				break;
			
			case 3: 
				count = 1 ;
				for(String chikenSalad_Name : Chiken_Salad.keySet()) {
//					String key3 = name3.toString();
					String value3 = Chiken_Salad.get(chikenSalad_Name).toString();
					System.out.println(count + ". " + chikenSalad_Name + " :- Rs" +value3);
					count++;
				};
				break;
			
			case 4:
				count = 1 ;
				for(String fruitSalad_Name : fruit_salad.keySet()) {
//					String key4 = name4.toString();
					String value4 = fruit_salad.get(fruitSalad_Name).toString();
					System.out.println(count + ". " + fruitSalad_Name + " :- Rs" +value4);
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
			}
			
			else if(type == 2) {
				switch (salad) {
					case 1:
						price = taco_Salad.get("Chorizo Taco Salad");
						break;
					case 2:
						price = taco_Salad.get("Campechanos Taco Salad");
						break;
					case 3:
						price = taco_Salad.get("Cabeza Taco Salad");
						break;
				}	
			}
			
			else if(type == 3) {
				switch (salad) {
					case 1:
						price = Chiken_Salad.get("Fried Chiken Salad");
						break;
					case 2:
						price = Chiken_Salad.get("Grilled Chiken Salad");
						break;
				}	
			}
			
			else if(type == 4) {
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
				name = "Chorizo Taco Salad";
				break;
			case 2:
				name = "Campechanos Taco Salad";
				break;
			case 3:
				name = "Cabeza Taco Salad";
				break;
			}
			
		}else if(type == 3) {
			switch (salad) {
			case 1:
				name = "Fried Chiken Salad";
				break;
			case 2:
				name = "Grilled Chiken Salad";
				break;
			}
			
		}else if(type == 4) {
			switch (salad) {
			case 1:
				name = "Mixed Fruit Salad";
				break;
			case 2:
				name = "Spinach Apple Salad";
				break;
			case 3:
				name = "Perfect Summer Fruit Salad";
				break;
			}	
		}
		return name;	
	}
}



