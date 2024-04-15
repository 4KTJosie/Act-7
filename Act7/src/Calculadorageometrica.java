import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculadorageometrica {
    private static List<String> resultados = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            try {
                mostrarMenu();
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        calcularAreaPerimetro();
                        break;
                    case 2:
                        calcularPotencia();
                        break;
                    case 3:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpia el buffer de entrada
            }
        }

        mostrarResultados();
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Calcular área o perímetro");
        System.out.println("2. Calcular potencia");
        System.out.println("3. Terminar cálculo");
    }

    private static void calcularAreaPerimetro() {
        System.out.println("Seleccione la figura geométrica:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        int figura = scanner.nextInt();

        System.out.println("Seleccione la operación:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        int operacion = scanner.nextInt();

        double resultado = 0;

        switch (figura) {
            case 1: // Círculo
                System.out.print("Ingrese el radio: ");
                double radio = scanner.nextDouble();
                resultado = operacion == 1 ? Math.PI * radio * radio : 2 * Math.PI * radio;
                resultados.add((operacion == 1 ? "El área" : "El perímetro") + " del círculo con radio " + radio + " es: " + resultado);
                break;
            case 2: // Cuadrado
                System.out.print("Ingrese el lado: ");
                double lado = scanner.nextDouble();
                resultado = operacion == 1 ? lado * lado : 4 * lado;
                resultados.add((operacion == 1 ? "El área" : "El perímetro") + " del cuadrado con lado " + lado + " es: " + resultado);
                break;
            case 3: // Triángulo
                System.out.print("Ingrese la base: ");
                double base = scanner.nextDouble();
                System.out.print("Ingrese la altura: ");
                double altura = scanner.nextDouble();
                if (operacion == 1) {
                    resultado = 0.5 * base * altura;
                    resultados.add("El área del triángulo con base " + base + " y altura " + altura + " es: " + resultado);
                } else {
                    System.out.print("Ingrese el lado 1: ");
                    double lado1 = scanner.nextDouble();
                    System.out.print("Ingrese el lado 2: ");
                    double lado2 = scanner.nextDouble();
                    System.out.print("Ingrese el lado 3: ");
                    double lado3 = scanner.nextDouble();
                    resultado = lado1 + lado2 + lado3;
                    resultados.add("El perímetro del triángulo con lados " + lado1 + ", " + lado2 + " y " + lado3 + " es: " + resultado);
                }
                break;
            case 4: // Rectángulo
                System.out.print("Ingrese la base: ");
                base = scanner.nextDouble();
                System.out.print("Ingrese la altura: ");
                altura = scanner.nextDouble();
                resultado = operacion == 1 ? base * altura : 2 * (base + altura);
                resultados.add((operacion == 1 ? "El área" : "El perímetro") + " del rectángulo con base " + base + " y altura " + altura + " es: " + resultado);
                break;
            case 5: // Pentágono
                System.out.print("Ingrese el lado: ");
                lado = scanner.nextDouble();
                resultado = operacion == 1 ? (1.0 / 4.0) * Math.sqrt(25 + 10 * Math.sqrt(5)) * lado * lado : 5 * lado;
                resultados.add((operacion == 1 ? "El área" : "El perímetro") + " del pentágono con lado " + lado + " es: " + resultado);
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
    }

    private static void calcularPotencia() {
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese el exponente: ");
        int exponente = scanner.nextInt();

        double resultado = calcularPotenciaRecursiva(base, exponente);
        resultados.add(base + " elevado a la " + exponente + " es: " + resultado);
    }

    private static double calcularPotenciaRecursiva(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente < 0) {
            return 1 / calcularPotenciaRecursiva(base, -exponente);
        } else {
            return base * calcularPotenciaRecursiva(base, exponente - 1);
        }
    }

    private static void mostrarResultados() {
        System.out.println("Resultados:");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }
}