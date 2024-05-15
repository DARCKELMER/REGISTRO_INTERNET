
package com.emergentes.dao;

import com.emergentes.config.Conexion;
import com.emergentes.model.Estudiante;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOimpl extends Conexion implements EstudianteDAO {

    @Override
    public void insert(Estudiante estudiante) throws Exception {        
        try {
            this.conectar();          
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO estudiantes(nombres,apellidos,seminarios,confirmado,fecha) VALUES(?,?,?,?,?)");
            ps.setString(1,estudiante.getNombres());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getSeminario());
            ps.setInt(4, estudiante.getConfirmado());
            ps.setString(5, estudiante.getFecha());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    
    }

    @Override
    public void update(Estudiante estudiante) throws Exception {

        System.out.println("id "+estudiante.getId());
        System.out.println("id "+estudiante.getNombres());
        System.out.println("id "+estudiante.getConfirmado());
        System.out.println("id "+estudiante.getFecha());
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE estudiantes SET nombres = ?, apellidos = ?, seminarios = ?, confirmado = ?, fecha = ? WHERE id = ?");
            ps.setString(1, estudiante.getNombres());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getSeminario());
            ps.setInt(4, estudiante.getConfirmado());
            ps.setString(5,estudiante.getFecha());
            ps.setInt(6, estudiante.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void delete(int id) throws Exception {


        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM estudiantes WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        
    }

    @Override
    public Estudiante getById(int id) throws Exception {

    Estudiante estudiante = new Estudiante();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiantes WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombres(rs.getString("nombres"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setSeminario(rs.getString("seminarios"));
                estudiante.setConfirmado(rs.getInt("confirmado"));
                estudiante.setFecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        
        
        return estudiante;
        
    }

    @Override
    public List<Estudiante> getAll() throws Exception {


        List<Estudiante> lista = null;
        try {
            this.conectar();
            
            System.out.println("antes de la consulta");
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiantes");
            
            System.out.println("hola mundo");
            ResultSet rs = ps.executeQuery();
            

            lista = new ArrayList<Estudiante>();
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();

                estudiante.setId(rs.getInt("id"));
                estudiante.setNombres(rs.getString("nombres"));
                estudiante.setApellidos(rs.getString("apellidos"));
                estudiante.setSeminario(rs.getString("seminarios"));
                estudiante.setConfirmado(rs.getInt("confirmado"));
                estudiante.setFecha(rs.getString("fecha"));
                
                lista.add(estudiante);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }

        return lista;
        
    }
    
}
