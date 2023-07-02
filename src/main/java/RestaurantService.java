import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        if(restaurants != null && restaurants.size() >0) {
            for(Restaurant res: restaurants) {
                if(res.getName().equalsIgnoreCase(restaurantName))
                    return res;
            }
        }

        throw new restaurantNotFoundException("Restaurant not found: " + restaurantName);

    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if (restaurantToBeRemoved == null) {
            throw new restaurantNotFoundException(restaurantName);
        }
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
