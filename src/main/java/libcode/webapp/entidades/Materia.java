package libcode.webapp.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "materia")
public class Materia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_id_seq")
    @SequenceGenerator(name = "materia_id_seq", sequenceName = "materia_id_seq", allocationSize = 1)
    
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "codigo")
    private String codigo;

    @OneToMany
    @JoinColumn(name = "id_materia", referencedColumnName = "id")
    private List<Inscripcion> inscripcion;
    
    // Constructor vacío
    public Materia() {
    }

    // Constructor con todos los atributos   

    public Materia(Integer id, String nombre, String descripcion, String codigo, List<Inscripcion> inscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.inscripcion = inscripcion;
    }
    
    // Constructor con solo el id
    public Materia(Integer id) {
        this.id = id;
    }

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Inscripcion> getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(List<Inscripcion> inscripcion) {
        this.inscripcion = inscripcion;
    }

    
    

    // HashCode, equals y toString

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Materia other = (Materia) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.inscripcion, other.inscripcion);
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", codigo=" + codigo + ", inscripcion=" + inscripcion + '}';
    }

  

   
}
