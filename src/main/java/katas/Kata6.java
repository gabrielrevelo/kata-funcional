package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        Optional<String> resultMovies = movies.stream().map(movie -> movie.getBoxarts()).flatMap(boxArts -> boxArts.stream()).reduce((largest, element)->{
            if (element.getUrl().length() > largest.getUrl().length()) {
                return element;
            }else {
                return largest;
            }
        }).map(boxArt -> boxArt.getUrl());

        return resultMovies.orElse("");
    }
}
