package validadorCorrelativasTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import validadorCorrelativas.Alumno;
import validadorCorrelativas.Inscripcion;
import validadorCorrelativas.Materia;

public class InscripcionTest {

    @Test
    public void diegoSePuedeAnotarAJavaIntermedio(){
        Alumno diego = new Alumno("Diego", "12345");
        Materia javaIntermedio = new Materia("Java Intermedio");
        Inscripcion inscripcionDiegoAJavaIntermedio = new Inscripcion(diego, javaIntermedio);

        Assertions.assertTrue(inscripcionDiegoAJavaIntermedio.aprobada());
    }
    @Test
    public void diegoNoSePuedeAnotarAJavaAvanzado(){
        Alumno diego = new Alumno("Diego", "12345");
        Materia javaIntermedio = new Materia("Java Intermedio");
        Materia javaAvanzado = new Materia("Java Avanzado");

        javaAvanzado.agregarCorrelativas(javaIntermedio);

        Inscripcion inscripcionDiegoAJavaAvanzado = new Inscripcion(diego, javaAvanzado);

        Assertions.assertFalse(inscripcionDiegoAJavaAvanzado.aprobada());
    }
    @Test
    public void diegoSePuedeAnotarAJavaAvanzado() {
        Alumno diego = new Alumno("Diego", "12345");
        Materia javaIntermedio = new Materia("Java Intermedio");
        Materia javaAvanzado = new Materia("Java Avanzado");

        javaAvanzado.agregarCorrelativas(javaIntermedio);

        diego.agregarMateriaAprobada(javaIntermedio);

        Inscripcion inscripcionDiegoAJavaAvanzado = new Inscripcion(diego, javaAvanzado);

        Assertions.assertTrue(inscripcionDiegoAJavaAvanzado.aprobada());
    }
}
