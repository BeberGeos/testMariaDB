package fr.beber.test.service;

import fr.beber.test.dao.Movie;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * Permet d'ajouter, de supprimer et de récupérer des films.
 *
 * @author BLafage
 * @date 20/06/2014
 */
@Stateful
public class Movies {

    @PersistenceContext(unitName = "movie-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    /**
     * Permet d'ajouter une film.
     *
     * @param movie
     * @throws Exception
     */
    public void addMovie(Movie movie) throws Exception {
        entityManager.persist(movie);
    }

    /**
     * Permet de supprimer une film.
     *
     * @param movie
     * @throws Exception
     */
    public void deleteMovie(Movie movie) throws Exception {
        entityManager.remove(movie);
    }

    /**
     * Permet de lister les films présent en base.
     *
     * @return {@link List}<{@link Movie}> trouvé en base.
     * @throws Exception
     */
    public List<Movie> getMovies() throws Exception {
        Query query = entityManager.createQuery("SELECT m from Movie as m");
        return query.getResultList();
    }

}