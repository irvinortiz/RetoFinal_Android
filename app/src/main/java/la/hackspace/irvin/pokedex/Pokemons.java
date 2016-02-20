package la.hackspace.irvin.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Pokemons extends AppCompatActivity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemons);

        lista = (ListView)findViewById(R.id.listaPokemon);

        ApiImplementation.getService().capturarPokemons(new Callback<List<Pokemon>>() {
            @Override
            public void success(List<Pokemon> pokemons, Response response) {
                AdaptadorPokemon adaptadorPokemon = new AdaptadorPokemon(Pokemons.this, pokemons);
                lista.setAdapter(adaptadorPokemon);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Toast.makeText(Pokemons.this, "Error de Conexión", Toast.LENGTH_LONG).show();
            }
        });

    }
}
