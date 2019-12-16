package com.cescristorey.appmovie;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cescristorey.appmovie.ModeloPelicula.MovieDetail;
import com.cescristorey.appmovie.ModeloPelicula.TVShowDetail;
import com.squareup.picasso.Picasso;

/*
    Defino un adaptador que hereda de RecyclerView.Adaptar y que definirá una clase aninada llamada moviesViewHolder
 */
public class FavoritosAdapterSeries extends RecyclerView.Adapter<FavoritosAdapterSeries.moviesViewHolder> {
    /*
    Atributos
    */
    public final Context context; //Almacena el contexto donde se ejecutará
    private Cursor list; //Almacenará las películas a mostrar
    private OnItemClickListener listener; //Listener para cuando se haga click
    public TVShowDetail movierecycle = new TVShowDetail();



    //Defino un interface con el OnItemClickListener
    public interface OnItemClickListener {
        void onItemClick(TVShowDetail movie);
    }

    /*
    Constructor
    */
    public FavoritosAdapterSeries(Context context, Cursor cursor) {
        this.list = cursor;
        this.context = context;
        setListener();
    }

    /*
    Asocio al atributo listener el onItemClickListener correspondiente y sobreescribo el método onItemClick pasando como
    argumento una película
    */
    private void setListener () {
        this.listener = new OnItemClickListener() {
            @Override
            public void onItemClick(TVShowDetail movie) {
                Intent intent = new Intent(context, Serie_Actividad.class);
                int id = (int) movie.getId();
                intent.putExtra("id", id);
                context.startActivity(intent);
            }
        };
    }

    /*
    Sobreescribo onCreateViewHolder, donde  "inflo" la vista de cada item  y devuelve el viewholder que se crea pasándole la vista
    como parámetro
    */
    @Override
    public moviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_favoritos_item, parent, false);
        moviesViewHolder tvh = new moviesViewHolder(itemView);
        return tvh;
    }

    /*
    Sobreescribe onViewHolder, haciendo que muestre la película que hay en el arraylist list en la posición que pasamos como
    parámetro
     */
    @Override
    public void onBindViewHolder(moviesViewHolder holder, int position) {
        String name;
        String photo;
        float id = Float.parseFloat(list.getString(0));
        name = list.getString(1);
        photo= list.getString(2);
        movierecycle.setId(id);
        holder.bindMovie(name, photo,movierecycle, listener);
        list.moveToNext();

    }

    /*
    Sobreescribe getItemCount devolviendo el número de películas que tenemos en el arraylist list.
     */
    @Override
    public int getItemCount() {
        return list.getCount();
    }

    /*
    Defino el viewHolder anidado que hereda de Recycler.ViewHolder necesario para que funcione el adaptador
     */
    public class moviesViewHolder extends RecyclerView.ViewHolder {
        /*
        Atributos
         */
        TextView tvName;
        ImageView imageView;

        /*
            Constructor, enlazo los atributos con los elementos del layout
         */
        public moviesViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            imageView=(ImageView) itemView.findViewById(R.id.imageView2);

        }

        /*
        Defino un método que servirá para poner los datos de la película en los correspondientes textviews del layout e
        invocará al listener del adaptador cuando se haga click sobre la vista del viewHolder.
         */
        public void bindMovie(String nombre, String foto, final TVShowDetail id, final OnItemClickListener listener) {
            tvName.setText(nombre);
            Picasso.get().load("https://image.tmdb.org/t/p/w500"+foto).into(imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(id);
                }
            });

        }
    }

    /*
    Método que limpia el array list de contenidos, carga los nuevos contenidos que se le pasan por parámetro e invoca a
    notifyDataSetChanged para hacer que se refresque la vista del RecyclerView
     */
    public void swap(Cursor cursor) {
        list.equals(cursor);
        notifyDataSetChanged();
    }
}