package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Optional;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        Optional<Double> resultMovies = movies.stream().reduce((rating, movie)-> {
            if (movie.getRating() > rating.getRating()) {
                return movie;
            }else {
                return rating;
            }
        }).map(movie -> movie.getRating());


        return resultMovies.orElse(0.0);

    }
}
