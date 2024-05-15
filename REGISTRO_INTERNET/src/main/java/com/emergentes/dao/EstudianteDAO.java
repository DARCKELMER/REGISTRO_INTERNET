
package com.emergentes.dao;

import com.emergentes.model.Estudiante;
import java.util.List;

public interface EstudianteDAO {
    public void insert(Estudiante estudiante) throws Exception;
    public void update(Estudiante estudiante) throws Exception;
    public void delete(int id) throws Exception;
    public Estudiante getById(int id) throws Exception;
    public List<Estudiante> getAll() throws Exception;
}
