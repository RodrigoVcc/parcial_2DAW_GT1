package libcode.webapp.controladores;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;
import libcode.webapp.entidades.Alumno;
import libcode.webapp.entidades.Materia;
import libcode.webapp.entidades.Inscripcion;
import libcode.webapp.negocio.DataService;
import libcode.webapp.negocio.MateriaService;
import libcode.webapp.negocio.InscripcionService;

@Named
@RequestScoped
public class IndexController {
    private List<Alumno> alumnosList = new ArrayList<>();
    private List<Materia> materiasList = new ArrayList<>();
    private List<Inscripcion> inscripcionesList = new ArrayList<>();
    
    private Alumno alumno = new Alumno();
    private Materia materia = new Materia();
    private Inscripcion inscripcion = new Inscripcion();
    
    
    @Inject
    private DataService servicio;
    
    @Inject
    private MateriaService servicioMateria;
    
    @Inject
    private InscripcionService servicioInscripcion;
    
    @PostConstruct
    public void cargarDatos(){
        try {
            alumnosList = servicio.getAlumnos();
            materiasList = servicioMateria.getMaterias();
            inscripcionesList = servicioInscripcion.getInscripciones();
        } catch (Exception e) {
            // Manejar la excepción de manera apropiada (por ejemplo, registrarla o mostrar un mensaje de error)
            e.printStackTrace();
        }
    }
    
   
    
    // Método para guardar una inscripción
    public void guardarInscripcion(){
        // Guardar la inscripción
        java.sql.Date fechaSistema = new java.sql.Date(System.currentTimeMillis());//captura la fecha del pc
        inscripcion.setFechaInscripcion(fechaSistema);
        servicioInscripcion.saveInscripcion(inscripcion);        
        inscripcion = new Inscripcion();
        cargarDatos();
       
    }

    // Método para guardar un alumno
    public void guardarAlumno() {
        if (alumno.getId() != null) {
            servicio.editAlumno(alumno);
        } else {
            servicio.saveAlumno(alumno);
        }

        alumno = new Alumno();
        cargarDatos();
    }

    // Método para guardar una materia
    public void guardarMateria() {
        if (materia.getId() != null) {
            servicioMateria.editMateria(materia);
        } else {
            servicioMateria.saveMateria(materia);
        }

        materia = new Materia();
        cargarDatos();
    }

    // Método para llenar el formulario de edición de inscripción
    public void llenarFormeEditarInscripcion(Inscripcion inscripcion){
        this.inscripcion = inscripcion;
    }
    public void llenarFormeEditar(Alumno alumno){
        this.alumno.setId(alumno.getId());
        this.alumno.setNombre(alumno.getNombre());
        this.alumno.setCarnet(alumno.getCarnet());
        
    }public void llenarFormeEditarMateria(Materia materia){
        this.materia.setId(materia.getId());
        this.materia.setNombre(materia.getNombre());
        this.materia.setDescripcion(materia.getDescripcion());
        this.materia.setCodigo(materia.getCodigo());
        
    }
    
    // Método para eliminar una inscripción
    public void eliminarInscripcion(Inscripcion inscripcion){
        servicioInscripcion.deleteInscripcion(inscripcion);
        cargarDatos();
    }
    
    
    
    // *** GETTERS Y SETTERS ***
    
    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }

    public List<Inscripcion> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripcion> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
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

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
    
    public void eliminarAlumno(Alumno alumno){
        servicio.deleteAlumno(alumno);
        cargarDatos();
    }
    public void eliminarMateria(Materia materia){
        servicioMateria.deleteMateria(materia);
        cargarDatos();
    }

 
    
 
    
}
