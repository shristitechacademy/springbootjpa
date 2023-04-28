package com.restaurantapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restaurantapp.model.Item;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.service.IRestaurantService;

@SpringBootApplication
public class SpringJpaOnetomanyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetomanyApplication.class, args);
	}
	@Autowired
	private IRestaurantService restaurantService;
	

	@Override
	public void run(String... args) throws Exception {
//		Item itemOne= new Item("Panneer 65","Starters", "NI", 100);
//		Item itemTwo= new Item("Wanton Soup","Soup", "Chinese", 200);
//		Item itemThree= new Item("Veg Momos","MainCourse", "Chinese", 200);
//		
//		//List<Item> itemsList = Arrays.asList(itemOne,itemTwo,itemThree);
//		Set<Item> items = new HashSet<>(Arrays.asList(itemOne,itemTwo,itemThree));
//		Restaurant restaurant = new Restaurant("Mainland", "veg", "Bangalore", items);
//		
//		restaurantService.addRestaurant(restaurant);
		
//		restaurantService.getByCity("Bangalore").forEach(System.out::println);
		
//		restaurantService.getByItemName("FriedRice").forEach((rest)->{
//			System.out.println(rest.getRestaurantName());
//			System.out.println(rest.getCity());
//			System.out.println(rest.getType());
//		});
		
		restaurantService.getByCuisine("Chinese").forEach((rest)->{
			System.out.println(rest.getRestaurantName());
			System.out.println(rest.getCity());
			System.out.println();
			Set<Item> items = rest.getItems();
			items.forEach((item)->{
				System.out.println(item.getItemName()+" "+item.getPrice()+" "+item.getCategory());
			});
			
		});
		
		
	}

}
