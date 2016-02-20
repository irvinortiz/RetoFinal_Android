package la.hackspace.irvin.pokedex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nomPokemon;
    EditText tipPokemon;
    public String[] usuarios = new String[]{"bulbasaur", "ivysaur", "venusaur", "charmander", "charmeleon"};
    public String[] tipo = new String[]{"planta", "fuego"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomPokemon = (EditText)findViewById(R.id.nomPokemon);
        tipPokemon = (EditText)findViewById(R.id.tipPokemon);

    }

    public void login(View view) {

        if (validarNombre(nomPokemon.getText().toString()) && validarTipo(tipPokemon.getText().toString())){
            Intent intent = new Intent(this, Pokemons.class);
            startActivity(intent);
            limpiar();
        }else{
            Toast.makeText(MainActivity.this, "Dato(s) Incorrectos", Toast.LENGTH_LONG).show();
            limpiar();
        }

    }

    public boolean validarNombre (String dato){
        for (String cadena : usuarios){
            if(cadena.equals(dato)){
                return true;
            }
        }
        return false;
    }

    public boolean validarTipo (String dato){
        for (String cadena : tipo){
            if(cadena.equals(dato)){
                return true;
            }
        }
        return false;
    }

    public void limpiar(){
        nomPokemon.setText("");
        tipPokemon.setText("");
    }
}
