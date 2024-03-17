package com.example.project2.ui.movie_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.project2.R;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GalleryFragment extends Fragment
{
    //Widgets in the layout
    private RecyclerView recyclerView;
    private List<Movies> moviesList;
    //Called when the fragment is first created.
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //Tells the system this fragment has its own menu.
        setHasOptionsMenu(true);
    }
    //Called to create the view hierarchy.
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment.
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        //Get the RecyclerView from the layout.
        recyclerView = view.findViewById(R.id.moviesRecyclerView);
        //Set the layout manager to position the items.
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //Create and set the adapter for the RecyclerView.
        moviesList = createMovieList();
        MoviesAdaptor adapter = new MoviesAdaptor(getContext(), moviesList, movie ->
        {

            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
            Bundle bundle = new Bundle();
            bundle.putSerializable("movie", movie);
            navController.navigate(R.id.action_nav_gallery_to_nav_movie_details, bundle);
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    //Handles clicks on menu items.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        //Check if the random movie menu item was clicked.
        if (item.getItemId() == R.id.randomMovieButton)
        {
            //Generate a random number and scroll to that position.
            int randomIndex = new Random().nextInt(moviesList.size());
            recyclerView.smoothScrollToPosition(randomIndex);

            //Navigate to the details of the randomly selected movie.
            recyclerView.post(() ->
            {
                Movies movie = moviesList.get(randomIndex);
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
                Bundle bundle = new Bundle();
                bundle.putSerializable("movie", movie);
                navController.navigate(R.id.action_nav_gallery_to_nav_movie_details, bundle);
            });

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Creates a list of Movies.
    private List<Movies> createMovieList()
{

        List<Movies> moviesList = new ArrayList<>();
        moviesList.add(new Movies("The Shawshank Redemption", "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", "1994-09-23", 9.3, "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg"));
        moviesList.add(new Movies("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", "1972-03-24", 9.2, "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"));
        moviesList.add(new Movies("The Dark Knight", "When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.", "2008-07-18", 9.0, "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg"));
        moviesList.add(new Movies("Pulp Fiction", "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", "1994-10-14", 8.9, "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"));
        moviesList.add(new Movies("Schindler's List", "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.", "1993-12-15", 8.9, "https://m.media-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg"));
        moviesList.add(new Movies("12 Angry Men", "A jury holdout attempts to prevent a miscarriage of justice by forcing his colleagues to reconsider the evidence.", "1957-04-10", 8.9, "https://upload.wikimedia.org/wikipedia/commons/b/b5/12_Angry_Men_%281957_film_poster%29.jpg"));
        moviesList.add(new Movies("Parasite", "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.", "2019-05-30", 8.6, "https://m.media-amazon.com/images/M/MV5BYWZjMjk3ZTItODQ2ZC00NTY5LWE0ZDYtZTI3MjcwN2Q5NTVkXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_.jpg"));
        moviesList.add(new Movies("Interstellar", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", "2014-11-07", 8.6, "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"));
        moviesList.add(new Movies("Spirited Away", "During her family's move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts.", "2001-07-20", 8.6, "https://m.media-amazon.com/images/M/MV5BMjlmZmI5MDctNDE2YS00YWE0LWE5ZWItZDBhYWQ0NTcxNWRhXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"));
        moviesList.add(new Movies("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.", "2010-07-16", 8.8, "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg"));
        moviesList.add(new Movies("Fight Club", "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.", "1999-10-15", 8.8, "https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"));
        moviesList.add(new Movies("Forrest Gump", "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.", "1994-07-06", 8.8, "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_FMjpg_UX1000_.jpg"));
        moviesList.add(new Movies("The Matrix", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.", "1999-03-31", 8.7, "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg"));
        moviesList.add(new Movies("Goodfellas", "The story of Henry Hill and his life in the mob, covering his relationship with his wife Karen Hill and his mob partners Jimmy Conway and Tommy DeVito in the Italian-American crime syndicate.", "1990-09-19", 8.7, "https://m.media-amazon.com/images/M/MV5BY2NkZjEzMDgtN2RjYy00YzM1LWI4ZmQtMjIwYjFjNmI3ZGEwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"));
        moviesList.add(new Movies("The Lord of the Rings: The Return of the King", "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.", "2003-12-17", 8.9, "https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_FMjpg_UX1000_.jpg"));
        moviesList.add(new Movies("Avatar", "A paraplegic Marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.", "2009-12-18", 7.8, "https://m.media-amazon.com/images/M/MV5BZDA0OGQxNTItMDZkMC00N2UyLTg3MzMtYTJmNjg3Nzk5MzRiXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_FMjpg_UX1000_.jpg"));
        moviesList.add(new Movies("Titanic", "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.", "1997-12-19", 7.8, "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_FMjpg_UX1000_.jpg"));
        moviesList.add(new Movies("Star Wars: Episode V - The Empire Strikes Back", "After the rebels are brutally overpowered by the Empire on the ice planet Hoth, Luke Skywalker begins Jedi training with Yoda, while his friends are pursued by Darth Vader and a bounty hunter named Boba Fett all over the galaxy.", "1980-05-21", 8.7, "https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"));
        moviesList.add(new Movies("The Lion King", "A young lion prince flees his kingdom only to learn the true meaning of responsibility and bravery.", "1994-06-24", 8.5, "https://m.media-amazon.com/images/M/MV5BYTYxNGMyZTYtMjE3MS00MzNjLWFjNmYtMDk3N2FmM2JiM2M1XkEyXkFqcGdeQXVyNjY5NDU4NzI@._V1_.jpg"));
        moviesList.add(new Movies("Back to the Future", "Marty McFly, a 17-year-old high school student, is accidentally sent thirty years into the past in a time-traveling DeLorean invented by his close friend, the eccentric scientist Doc Brown.", "1985-07-03", 8.5, "https://m.media-amazon.com/images/M/MV5BZmU0M2Y1OGUtZjIxNi00ZjBkLTg1MjgtOWIyNThiZWIwYjRiXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg"));
        moviesList.add(new Movies("The Silence of the Lambs", "A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.", "1991-02-14", 8.6, "https://m.media-amazon.com/images/M/MV5BNjNhZTk0ZmEtNjJhMi00YzFlLWE1MmEtYzM1M2ZmMGMwMTU4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg"));

        return moviesList;
    }
}
