package fr.beber.test;
import fr.beber.test.dao.Movie;
import fr.beber.test.service.Movies;
import junit.framework.TestCase;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.util.List;
import java.util.Properties;

/**
 *
 * Permet de tester un @PersistenceContext avec création et suppression de film.
 *
 * @author BLafage
 * @date 20/06/2014
 */
public class MoviesTest extends TestCase {

    /**
     *
     * Permet de tester les 3 méthodes de {@link Movies}.
     *
     * @throws Exception
     */
    @Test
    public void testThreeMethodsMovies() throws Exception {

        final Properties p = new Properties();
        //p.put("movieDatabase", "new://Resource?type=DataSource");

        final EJBContainer container = EJBContainer.createEJBContainer(p);
        final Context context = container.getContext();

        final Movies movies = (Movies) context.lookup("java:global/testMariaDB/Movies");

        movies.addMovie(new Movie("Quentin Tarantino", "Reservoir Dogs", 1992));
        movies.addMovie(new Movie("Joel Coen", "Fargo", 1996));
        movies.addMovie(new Movie("Joel Coen", "The Big Lebowski", 1998));

        final List<Movie> list = movies.getMovies();
        assertEquals("List.size()", 3, list.size());

        for (final Movie movie : list) {
            movies.deleteMovie(movie);
        }

        assertEquals("Movies.getMovies()", 0, movies.getMovies().size());

        container.close();
    }
}