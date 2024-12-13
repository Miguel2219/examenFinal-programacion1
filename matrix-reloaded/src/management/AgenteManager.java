package management;

import entities.Agente;
import utils.ConsoleUtils;
import java.util.Scanner;

import java.util.ArrayList;

public class AgenteManager {
    private int nivel;
    Scanner escanner=new Scanner(System.in);
    
    private ArrayList<Agente> agentes;
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void incrementarNivel(){
        this.nivel++;
    }


    public AgenteManager() {
        this.agentes = new ArrayList<>();
    }

    public void registrarAgente() {
        
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente: ");
        ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

        String nombre = ConsoleUtils.leerTexto("Ingrese el nombre del agente: ");
        String habilidad = ConsoleUtils.leerTexto("Ingrese la habilidad especial del agente: ");
        System.out.print("Ingrese el nivel del agente ");
        nivel=escanner.nextInt();
        
        

        Agente nuevoAgente = new Agente(id, nombre, habilidad);
        agentes.add(nuevoAgente);
        System.out.println("Agente registrado con éxito.");
        
    }

    public void mostrarAgentes() {
        
        if (agentes.isEmpty()) {
            System.out.println("No hay agentes registrados.");
            return;
        }
        System.out.println("=== Lista de Agentes ===");
        for (Agente agente : agentes) {
            System.out.println(agente);
        }
        System.out.println("El nivel es: "+nivel);;
        
        
    }

   
    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Agentes ===");
            System.out.println("1. Registrar Agente");
            System.out.println("2. Mostrar Agentes");
            System.out.println("3. Incrementar Nivel de Agente");
            System.out.println("4. Salir");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
            ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

            switch (opcion) {
                case 1 -> registrarAgente();
                case 2 -> mostrarAgentes();
                case 3 -> incrementarNivel();
                case 4 -> continuar=false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}