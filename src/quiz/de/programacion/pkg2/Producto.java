/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz.de.programacion.pkg2;

import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
import javax.swing.JOptionPane;

public class Producto {


    public void informacionProducto() {
 //Solicitamos la informacion al cliente
        String nombreSuper = JOptionPane.showInputDialog("Digite el nombre del supermercado");
        String codSupermercado = JOptionPane.showInputDialog("Digite el código del supermercado");
        String nombreEmpleado = JOptionPane.showInputDialog("Digite el nombre del empleado");
        String cedEmpleado = JOptionPane.showInputDialog("Digite la cédula del empleado");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de productos"));
//Ponemos los arreglos
        int[] codProducto = new int[cantidad];
        String[] nombreProducto = new String[cantidad];
        String[] tipoProducto = new String[cantidad];
        int[] precioBase = new int[cantidad];
        int[] precioBruto = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            nombreProducto[i] = JOptionPane.showInputDialog("Digite el nombre del producto");
            codProducto[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite el código del producto"));
            tipoProducto[i] = JOptionPane.showInputDialog("Digite el tipo de producto (Alimentos, Bebidas, Higiene, Limpieza)");
            precioBase[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite el precio base del producto"));

   
            precioBruto[i] = calcularPrecioBruto(precioBase[i], tipoProducto[i]);
        }
        for (int i = 0; i < cantidad; i++) {
            JOptionPane.showMessageDialog(null,
                    "Código Producto: " + codProducto[i] + "\n"
                    + "Nombre Producto: " + nombreProducto[i] + "\n"
                    + "Nombre Empleado: " + nombreEmpleado + "\n"
                    + "Cédula Empleado: " + cedEmpleado + "\n"
                    + "Precio Base: " + precioBase[i] + "\n"
                    + "Tipo Producto: " + tipoProducto[i] + "\n"
                    + "Precio Bruto: " + precioBruto[i] + "\n");
        }
    }

    // calculamos el tipo de producto
    private int calcularPrecioBruto(int precioBase, String tipoProducto) {
        int precioBruto = precioBase;
        switch (tipoProducto.toLowerCase()) {
            case "alimentos":
                precioBruto += precioBase * 20 / 100; // Aumento del 20%
                break;
            case "bebidas":
                precioBruto += precioBase * 30 / 100; // Aumento del 30%
                break;
            case "higiene":
                precioBruto += precioBase * 25 / 100 + 500; // Aumento del 25% +500 
                break;
            case "limpieza":
                precioBruto += precioBase * 19 / 100 + 4 * precioBase + 1000; // aumento aun mas 
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de producto no reconocido, se usará precio base.");
        }
        return precioBruto;
    }
}

