package com.company;

import clases.CapacidadEndedudamiento;
import com.sun.javafx.css.CalculatedValue;
import javafx.scene.input.KeyCode;

import java.util.Scanner;
import com.company.Constant;

public class Main {
    //Recuerda que aca empieza todo
    public static void main(String[] args) {

        String ingMesuales;
        String gastosfijos;
        String gastosvariables;
        double doubleingresosTotales = 0;
        double doublegastosFijos = 0;
        double doublegastoVaribales = 0;
        boolean Salir =false;

        CapacidadEndedudamiento ClaseCapacidadEnd = new CapacidadEndedudamiento();
        Scanner in = new Scanner(System.in);

        System.out.println(Constant.MSGINGRESOSTOTALES);
        ingMesuales = in.nextLine();
        while (!Salir)
        {
            if (IsNumeric(ingMesuales))
            {
                doubleingresosTotales = Double.parseDouble(ingMesuales);
                ClaseCapacidadEnd.setIngresosTotales(doubleingresosTotales);
                Salir=true;
            }
            else {
                System.out.println(Constant.MSGINGRESOSTOTALES);
                ingMesuales = in.nextLine();
                Salir=false;
            }
        }
        Salir=false;

        System.out.println(Constant.MSGGASTOSFIJOS);
        gastosfijos = in.nextLine();
        while (!Salir)
        {
            if (IsNumeric(gastosfijos))
            {
                doublegastosFijos = Double.parseDouble(gastosfijos);
                ClaseCapacidadEnd.setGastosFijos(doublegastosFijos);
                Salir=true;
            }
            else {
                System.out.println(Constant.MSGGASTOSFIJOS);
                gastosfijos = in.nextLine();
                Salir=false;
            }
        }
        Salir=false;

        System.out.println(Constant.MSGGASTOSVARIABLES);
        gastosvariables = in.nextLine();
        while (!Salir)
        {
            if (IsNumeric(gastosvariables))
            {
                doublegastoVaribales = Double.parseDouble(gastosvariables);
                ClaseCapacidadEnd.setGastoVaribales(doublegastoVaribales);
                Salir=true;
            }
            else {
                System.out.println(Constant.MSGGASTOSVARIABLES);
                gastosvariables = in.nextLine();
                Salir=false;
            }
        }

        CalcularCapacidadEndeudamiento (doubleingresosTotales,doublegastosFijos,doublegastoVaribales);

    }

    private static void CalcularCapacidadEndeudamiento(double ingresosTotales, double gastosFijos, double gastoVaribales) {
       double CapacidadEndeudamiento = 0;
       final double POR_FIJO = 0.35;
       CapacidadEndeudamiento = (ingresosTotales - gastosFijos - gastoVaribales) * POR_FIJO;
       System.out.println("Su capacidad de endeudamiento es:");
       System.out.println(CapacidadEndeudamiento);

    }

    public static boolean IsNumeric(String Valor) {
            boolean Resultado;
        try{
            Double.parseDouble(Valor);
            Resultado = true;
        } catch (Exception e) {
           Resultado =false;
            System.out.println("El valor no es Númerico");
        }
        return Resultado;
        }
    }

