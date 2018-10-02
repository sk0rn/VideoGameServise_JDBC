package repository.dao.game.interfaces;

import pojo.game.Developer;

import java.util.List;

public interface DeveloperDao {

    boolean add(Developer dev);

    Developer getById(Integer id);

    List<Developer> getAll();
}
