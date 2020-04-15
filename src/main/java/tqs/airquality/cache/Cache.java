package tqs.airquality.cache;

import java.util.HashMap;
import tqs.airquality.model.Data;
public class Cache<city_name> {
    private Integer cache_true;
    private Integer cache_false;

    private HashMap<Double, city_name> cities_on_cache;

    public Cache() {
        cache_true = 0;
        cache_false = 0;
        cities_on_cache = new HashMap<>();
    }

    public void incrementCacheHit() {
        cache_true++;
    }

    public void incrementCacheMiss() {
        cache_false++;
    }




    public void setCitiesCache(city_name city) {
       //error... cities_on_cache.put(city.getCity_name, city);

        //System.out.println("CITIES CACHE HASHMAP: " + cities_cache);
        System.out.println("CITY ADDED: " + cities_on_cache );
    }

    public HashMap<Double, city_name> getCitiesCache() {
        return cities_on_cache;
    }

    public city_name getCityCachedById(Double aqi){
        return cities_on_cache.get(aqi);
    }

    public void cachenotValid(Double aqi){

//not implemented...
    }

    public Integer getCacheTrue() {
        return cache_true;
    }

    public Integer getCacheFalse() {
        return cache_false;
    }

    @Override
    public String toString() {
        return "Cache{" +"cache_true=" + cache_true + ", cache_miss=" + cache_false + ", cities_cache=" + cities_on_cache + '}';
    }
}