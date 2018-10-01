package repository.dao.game.interfaces;

import pojo.game.Genre;

import java.util.List;

public interface GenreDao {

    boolean add(Genre genre);

    Genre getById(Integer id);

    List<Genre> getAll();
}
