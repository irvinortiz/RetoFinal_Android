package la.hackspace.irvin.pokedex;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Autor Irvin on 19/02/2016.
 */
public interface ApiService {
    @GET("/lista_pokemons.php")
    void capturarPokemons(Callback<List<Pokemon>> callback);
}
