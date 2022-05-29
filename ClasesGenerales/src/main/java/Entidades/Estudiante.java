
package Entidades;

import java.util.Date;


public class Estudiante extends Materia {

    int idEstudiante;
    String Nombre;
    String Apellido;
    Date FechadeNcimiento;

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Date getFechadeNcimiento() {
        return FechadeNcimiento;
    }

    public void setFechadeNcimiento(Date FechadeNcimiento) {
        this.FechadeNcimiento = FechadeNcimiento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

}
