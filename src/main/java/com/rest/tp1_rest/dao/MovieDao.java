package com.rest.tp1_rest.dao;

import com.rest.tp1_rest.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends CrudRepository<Movie, Integer> {



}





/*public interface MovieDao {
        List<Movie> findAll();
        Movie findById(int id);
        Movie save(Movie movie);


}
*/
