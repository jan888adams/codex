package codex.repository;


import codex.modell.*;
import codex.utils.exception.ModelNotFoundException;

import java.net.ConnectException;
import java.sql.SQLDataException;
import java.util.List;


public interface RepositoryInterface {
      ModelInterface create(ModelInterface modelToSave) throws SQLDataException, ConnectException;
      ModelInterface update(ModelInterface modelToSave) throws SQLDataException, ConnectException;
      ModelInterface delete(ModelInterface modelToDelete) throws SQLDataException, ConnectException;
      List<ModelInterface> findByModel(ModelInterface modelToSave) throws SQLDataException,
              ConnectException, ModelNotFoundException;
      ModelInterface findByKey(String key) throws SQLDataException, ConnectException, ModelNotFoundException;
}
