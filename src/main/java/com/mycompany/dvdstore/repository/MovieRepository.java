/*package com.mycompany.dvdstore.repository;

import com.mycompany.dvdstore.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MovieRepository implements MovieRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Movie add(Movie movie) {
        KeyHolder kh = new GeneratedKeyHolder();

        String sql = "INSERT INTO movie (TITLE, GENRE, DESCRIPTION) VALUES (?,?,?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getGenre());
            pstmt.setString(3, movie.getDescription());
            return pstmt;
        }, kh);

        movie.setId(kh.getKey().longValue());
        return movie;
    }

    @Override
    public List<Movie> list() {
        String sql = "SELECT ID, TITLE, GENRE FROM movie";
        return jdbcTemplate.query(sql, (rs, i) -> new Movie(rs.getLong("ID"), rs.getString("TITLE"),
                rs.getString("GENRE")));
    }

    @Override
    public Movie getById(Long id) {
        String sql = "SELECT ID, TITLE, GENRE, DESCRIPTION FROM movie WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id},
                (rs, i) -> new Movie(rs.getLong("ID"), rs.getString("TITLE"),
                        rs.getString("GENRE"), rs.getString("DESCRIPTION")));
    }
}
*/