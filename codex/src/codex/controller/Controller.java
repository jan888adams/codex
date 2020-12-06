package codex.controller;


import codex.modell.ModelInterface;
import codex.repository.RepositoryInterface;
import codex.utils.exception.ModelNotFoundException;
import codex.utils.sorter.Sequenzer;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * rdms
 *
 * @author Jan Adams
 * @version 17.11.2020
 */

public class Controller {

    private ModelInterface model;
    private final List<RepositoryInterface> repositorys;

    public Controller() {
        model = null;
        repositorys = new ArrayList<>();
    }

    protected void addRepository(RepositoryInterface repository) {
        repositorys.add(repository);
    }

    protected void setModel(ModelInterface model) {
        this.model = model;
    }

    public void apply(Queue<String> values) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        try {
            for (Method method : new Sequenzer((Serializable) model).getSeatableMethods()) {
                method.invoke(model, values.poll());
            }
        }catch (ClassCastException e){
            throw new ClassCastException("Model do not implement Interface Serializable ");
        }

    }


    public boolean persist() throws SQLDataException, ConnectException {
        for (RepositoryInterface repository : repositorys) {
            if (repository.create(model) == null) {
                return false;
            }
        }
        return true;
    }

    public boolean update() throws SQLDataException, ConnectException {
        for (RepositoryInterface repository : repositorys) {
            if (repository.update(model) == null) {
                return false;
            }
        }
        return true;
    }

    public boolean delete() throws SQLDataException, ConnectException {
        for (RepositoryInterface repository : repositorys) {
            if (repository.delete(model) == null) {
                return false;
            }
        }
        return true;
    }

    public List<ModelInterface> getDataSets(String key) throws SQLDataException, ConnectException, ModelNotFoundException {
        List<ModelInterface> list = new ArrayList<>();

        for (RepositoryInterface repository : repositorys) {
          list.add(repository.findByKey(key));
        }
        return list;
    }

    public ModelInterface getModel(){
        return model;
    }

    public List<RepositoryInterface> getRepositorys() {
        return repositorys;
    }

}
