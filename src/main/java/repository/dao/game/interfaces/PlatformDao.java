package repository.dao.game.interfaces;

import pojo.game.Platform;

public interface PlatformDao {

    boolean add(Platform platform);

    Platform getById(Integer id);
}
