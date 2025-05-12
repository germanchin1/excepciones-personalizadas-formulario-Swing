package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {  // Cambiar aqu� a 'static'
        input.useDelimiter("\n");
        String opcion;
        do {
            System.out.println("TESTER FUNCIONES UserDataValidations");
            System.out.println("1 - testCheckId");
            System.out.println("2 - testCheckFormatDate");
            System.out.println("3 - testCalculateAge");
            System.out.println("4 - testCheckPostalCode");
            System.out.println("5 - testIsNumeric");
            System.out.println("6 - testIsAlphabetic");
            System.out.println("7 - testCheckEmail");
            System.out.println("8 - testCheckName");
            System.out.println("0 - SALIR");

            System.out.println("opcion: ");
            opcion = input.next();

            switch (opcion) {
                case "1":
                    testCheckId();
                    break;
                case "2":
                    testDate();
                    break;
                case "3":
                    calculateAge();
                    break;
                case "4":
                    testPostalCode();
                    break;
                case "5":
                    testIsNumeric();
                    break;
                case "6":
                    testIsAlphabetic();
                    break;
                case "7":
                    testEmail();
                    break;
                case "8":
                    testName();
                    break;
                case "z":
                    System.out.println("Abandonando el programa");
                    break;

                default:
                    System.out.println("Opcion Incorrecta");
            }
        } while (!opcion.equals("z"));
    }

    static void testCheckId() {
        boolean dniOK = false;
        System.out.println("Introduce el DNI: ");
        String dni = input.next();
        String[] partesDNI = dni.split("(?<=\\d)(?=[A-Za-z])");
        String parteNum = partesDNI[0];
        String parteLetra = partesDNI[1];
        
        boolean numerosOK = false; 
        boolean strOK = false;
        numerosOK = UserDataValidations.checkNumeric(parteNum, numerosOK);
        strOK = UserDataValidations.isAlphabetic(parteLetra, strOK);

        if (strOK && numerosOK) {
            System.out.println("el formato es correcto, voy a comprobar si la letra es real");
        } else{
            System.out.println("DNI incorrecto (mal formato)");
        }
        
        if (UserDataValidations.checkId(dni)) {
            System.out.println("Dni correcto");
        }else {
            System.out.println("el DNI es falso");

        }
    }

    static void testDate() {
        System.out.println("Introduce una fecha (dd/mm/yyyy): ");
        String date = input.next();

        if (UserDataValidations.checkDate(date)) {
            System.out.println("La fecha es v�lida.");
        } else {
            System.out.println("La fecha NO es v�lida.");
        }
    }

    static void calculateAge() {
        int a�oActual =  2025;
        int edad = 0;
        boolean dateOK = false;
        System.out.println("Introduce tu fecha de nacimiento (dd/mm/yyyy): ");
        String date = input.next();
        if (UserDataValidations.checkDate(date)){
            System.out.println("la fecha que me has dado es correcta, voy a calcular la edad que tienes: ");
            String[] partes = date.split("/");
            int a�o = Integer.parseInt(partes[2]);
            edad = UserDataValidations.calculateAge(a�oActual ,a�o);
            System.out.println("tienes " + edad + " a�os");
        }else {
            System.out.println("la fecha que me has dado esta mal");
        }

    }

    static void testIsNumeric() {
        boolean numerosOk = false;
        System.out.println("Dame un string y te dir� s� es de n�meros.");
        String numeros = input.next();
        numerosOk = UserDataValidations.checkNumeric(numeros, numerosOk);
        if (numerosOk) {
            System.out.println("El string es de todo n�meros");
        } else {
            System.out.println("El string NO es de todo n�meros");
        }
    }

    static void testIsAlphabetic() {
        boolean strOk = false;
        System.out.println("Introduce una texto: ");
        String texto = input.next();
        strOk = UserDataValidations.isAlphabetic(texto, strOk);  //

        if (strOk) {
            System.out.println("La cadena es alfab�tica.");
        } else {
            System.out.println("La cadena NO es alfab�tica.");
        }
    }

    static void testEmail() {
        boolean emailOK = false;
        System.out.println("Introduce un correo electr�nico: ");
        String email = input.next();

        if (UserDataValidations.checkEmail(email)) {
            System.out.println("El correo es v�lido.");
        } else {
            System.out.println("El correo NO es v�lido.");
        }
    }

    static void testName() {
        boolean nameOK = false;
        System.out.println("�Como te llamas? ");
        String name = input.next();
        nameOK = UserDataValidations.checkName(name);
        if (nameOK) {
            System.out.println("El nombre es v�lido.");
        } else {
            System.out.println("El nombre no es v�lido.");
        }
    }

    static void testPostalCode() {
        boolean zipOK = false;
        System.out.println("Introduce una c�digo postal , 5 n�meros: ");
        String codigoPostal = input.next();
        zipOK = UserDataValidations.checkZIP(codigoPostal);  //

        if (zipOK) {
            System.out.println("El codigo postal es correcto (5 d�gitos)");
        } else {
            System.out.println("El codigo postal es incorrecto (no tiene 5 d�gitos)");
        }
    }

}
