package com.miapp.controlador;

import com.miapp.modelo.Estudiante;
import com.miapp.vista.EstudianteView;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador: gestiona la lógica entre la Vista y el Modelo.
 * Contiene el array de estudiantes y responde a las búsquedas.
 */
public class EstudianteController {

    // ── Vista ─────────────────────────────────────────────────────────────────
    private EstudianteView vista;

    // ── Array de estudiantes (fuente de datos) ────────────────────────────────
    private Estudiante[] estudiantes;

    // ── Constructor ───────────────────────────────────────────────────────────

    public EstudianteController(EstudianteView vista) {
        this.vista = vista;
        this.vista.setControlador(this);
        cargarDatos();
    }

    // ── Carga de datos iniciales ──────────────────────────────────────────────

    /**
     * Inicializa el array de estudiantes con datos de ejemplo.
     * En un proyecto real este array vendría de una base de datos o servicio.
     */
    private void cargarDatos() {
        estudiantes = new Estudiante[] {
            new Estudiante(1,  "Ana"," García",        "Ingeniería de Sistemas",  4.5),
            new Estudiante(2,  "Carlos"," López",      "Ingeniería Civil",        3.8),
            new Estudiante(3,  "María", " Rodríguez",   "Medicina",                4.9),
            new Estudiante(4,  "José", " Martínez",     "Derecho",                 3.5),
            new Estudiante(5,  "Laura", " Sánchez",     "Administración",          4.1),
            new Estudiante(6,  "Andrés", " Torres",     "Ingeniería de Sistemas",  3.9),
            new Estudiante(7,  "Valentina" , " Gómez",   "Psicología",              4.3),
            new Estudiante(8,  "Luis" , " Herrera",      "Economía",                3.7),
            new Estudiante(9,  "Sofía", " Díaz",        "Ingeniería Civil",        4.6),
            new Estudiante(10, "Juliana", " Morales",   "Medicina",                4.8),
            new Estudiante(11, "Ana" , " Milena Ruiz",   "Derecho",                 4.0),
            new Estudiante(12, "Carlos", " Andrés Paz", "Administración",          3.6)
        };
    }

    // ── Lógica de búsqueda ────────────────────────────────────────────────────

    /**
     * Busca estudiantes cuyo nombre contenga el criterio (sin distinción de mayúsculas).
     * Luego llama a vista.mostrarEstudiante(e) para cada coincidencia,
     * o a vista.mostrarEstudiantes(lista) cuando hay varias.
     *
     * @param criterio texto ingresado por el usuario en la Vista
     */
    public void buscarEstudiante(String criterio) {

        // Validación básica
        if (criterio == null || criterio.isEmpty()) {
            vista.mostrarError("Por favor ingrese un nombre para buscar.");
            return;
        }

        List<Estudiante> resultados = new ArrayList<>();
        String criterioBajo = criterio.toLowerCase();

        for (Estudiante e : estudiantes) {
            if (e.getNombre().toLowerCase().contains(criterioBajo) || e.getApellido().toLowerCase().contains(criterioBajo) ) {
                resultados.add(e);
            }
        }

        if (resultados.isEmpty()) {
            vista.mostrarEstudiantes(resultados); // mostrará mensaje vacío
        } else if (resultados.size() == 1) {
            // Un solo resultado: usar vista.mostrarEstudiante(e)
            vista.mostrarEstudiante(resultados.get(0));
        } else {
            // Varios resultados: mostrar lista completa
            vista.mostrarEstudiantes(resultados);
        }
    }

    // ── Punto de entrada de la aplicación ─────────────────────────────────────

    public static void main(String[] args) {
        // Lanza la Vista en el hilo de Swing (buena práctica)
        javax.swing.SwingUtilities.invokeLater(() -> {
            EstudianteView vista = new EstudianteView();
            new EstudianteController(vista);   // el controlador conecta todo
            vista.setVisible(true);
        });
    }
}
