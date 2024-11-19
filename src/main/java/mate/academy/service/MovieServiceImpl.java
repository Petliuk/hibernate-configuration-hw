package mate.academy.service;

import mate.academy.dao.MovieDao;
import mate.academy.lib.Inject;
import mate.academy.lib.Service;
import mate.academy.model.Movie;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) throws Throwable {
        return (Movie) movieDao.get(id).orElseThrow(() ->
                new IllegalArgumentException("Movie with id " + id + " not found")
        );
    }
}