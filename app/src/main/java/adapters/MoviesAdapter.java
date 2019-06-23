package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ariemay.filmcategory_submission1_made.R;

import java.util.ArrayList;

import models.Movies;

public class MoviesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movies> movies;

    public MoviesAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    public void setMovies(ArrayList<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.movie_list_items, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        Movies hero = (Movies) getItem(position);
        viewHolder.bind(hero);
        return convertView;
    }

    private class ViewHolder {

        private TextView name;
        private TextView date;
        private ImageView poster;

        ViewHolder(View view) {
            name = view.findViewById(R.id.name);
            date = view.findViewById(R.id.date);
            poster = view.findViewById(R.id.movie_poster);
        }

        void bind(Movies movies) {
            name.setText(movies.getName());
            date.setText(movies.getDate());
            poster.setImageResource(movies.getPhoto());
        }
    }
}
