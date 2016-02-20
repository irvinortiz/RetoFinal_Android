package la.hackspace.irvin.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Autor Irvin on 19/02/2016.
 */
public class AdaptadorPokemon extends ArrayAdapter {

    List<Pokemon> lisPokemon;

    public AdaptadorPokemon(Context context, List<Pokemon> lisPokemon) {
        super(context, R.layout.card_pokemon ,lisPokemon);
        this.lisPokemon = lisPokemon;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.card_pokemon, null);

        TextView nombre = (TextView)item.findViewById(R.id.nombrePokemon);
        TextView tipo = (TextView)item.findViewById(R.id.tipoPokemon);
        TextView id = (TextView)item.findViewById(R.id.idPokemon);
        ImageView imagen = (ImageView)item.findViewById(R.id.imgPokemon);

        nombre.setText(lisPokemon.get(position).getNombre());
        tipo.setText(lisPokemon.get(position).getTipo());
        id.setText(lisPokemon.get(position).getId());
        Picasso.with(getContext())
                .load(lisPokemon.get(position).getImagen())
                .into(imagen);

        return item;
    }
}
