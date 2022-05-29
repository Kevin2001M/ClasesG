package DAO;

import Entidades.Estudiante;
import Entidades.Materia;
import Entidades.Nota;
import com.william.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Materias {

    ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConecction();

    public ArrayList<Materia> ListadoMaterias() {
        ArrayList<Materia> listado = null;

        try {
            listado = new ArrayList<Materia>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MATERIA()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Materia es = new Materia();
                es.setIdmateria(resultado.getInt("idmateria"));
                es.setNombreMateria(resultado.getString("nombreMateria"));
                listado.add(es);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }

    public void AddMateria(Nota usr) {

        Connection conexion = con.getConecction();
        try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_NOTA(?,?,?)}");
            cb.setString("PNota", usr.getNota());
            cb.setInt("PIdMateria", usr.getIdmateria());
            cb.setInt("PIdEstudiante", usr.getIdEstudiante());

            cb.execute();

            JOptionPane.showMessageDialog(null, "Nota Agregada");

            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }

    }
}
