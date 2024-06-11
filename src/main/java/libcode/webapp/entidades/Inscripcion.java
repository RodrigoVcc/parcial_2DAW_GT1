package libcode.webapp.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * Entidad Inscripcion
 * 
 * Representa la inscripción de un alumno a una materia.
 * 
 * @autor RodriCruz
 */
@Entity
@Table(name="inscripcion")
public class Inscripcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripcion_id_seq")
    @SequenceGenerator(name = "inscripcion_id_seq", sequenceName = "inscripcion_id_seq", allocationSize = 1)
    
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne (fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_alumno",referencedColumnName = "id")
    private Alumno alumno = new Alumno();
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_materia", referencedColumnName = "id")
    private Materia materia = new Materia();
    
    @Column(name = "ciclo")
    private String ciclo;
    
    @Column(name = "año")
    private String año;
    
    @Column(name = "fechaInscripcion")
    private Date fechaInscripcion;

    public Inscripcion(Integer id) {
        this.id = id;
    }

    
    
    public Inscripcion() {
    }
    

    public Inscripcion(Integer id, String ciclo) {
        this.id = id;
        this.ciclo = ciclo;
    }

    public Inscripcion(Integer id, String ciclo, String año) {
        this.id = id;
        this.ciclo = ciclo;
        this.año = año;
    }

    public Inscripcion(Integer id, String ciclo, String año, Date fechaInscripcion) {
        this.id = id;
        this.ciclo = ciclo;
        this.año = año;
        this.fechaInscripcion = fechaInscripcion;
    }

   
    //getter y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    public void setAlumnoId(Integer id){
        this.alumno.setId(id);
    }
    
    public Integer getAlumnoId(){
        return alumno.getId();
    }
    
    public Integer getMateriaId(){
        return materia.getId();
    }
    public void setMateriaId(Integer id){
        this.materia.setId(id);
    }
    
    
    // HashCode, equals y toString

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.id, other.id);
    }

    

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", alumno=" + alumno + ", materia=" + materia + ", ciclo=" + ciclo + ", a\u00f1o=" + año + ", fechaInscripcion=" + fechaInscripcion + '}';
    }

   

    

    
    
}
