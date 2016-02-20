package la.hackspace.irvin.pokedex;

import retrofit.RestAdapter;

/**
 * Autor Irvin on 19/02/2016.
 */
public class ApiImplementation {
    private static RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://victorcasass.com/api")
            .build();
    public static ApiService getService(){
        return restAdapter.create(ApiService.class);
    }
}
