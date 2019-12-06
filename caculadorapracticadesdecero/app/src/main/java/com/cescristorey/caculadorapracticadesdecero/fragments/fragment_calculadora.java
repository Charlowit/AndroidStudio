package com.cescristorey.caculadorapracticadesdecero.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cescristorey.caculadorapracticadesdecero.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_calculadora extends Fragment {

    View vista;
    public fragment_calculadora() {
        // Required empty public constructor
    }


    Integer primeravez = 0 , contador_igual=0, contador = 0, contador_punto = 0, cont_num=0;
    Double sumatotal = 0.0;
    Double sum1 = 0.0;
    String operando = "";

    public void identificar(String operando, Double sum1){
        if(sumatotal == 0){
            sumatotal = sum1;
        }
        else {
            if (operando == "+") {
                sumatotal += sum1;
            } else if (operando == "-") {
                sumatotal -= sum1;
            } else if (operando == "/") {
                sumatotal /= sum1;
            } else if (operando == "x") {
                sumatotal = sumatotal * sum1;
            }else if (operando == "%") {
                sumatotal = (sumatotal * sum1)/100;
            }
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final TextView calculo, cadenacalculo, debug;
        Button boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9,
                botonPunto, botonSuma, botonResta, botonMultiplicacion, botonDivision, botonIgual, botonAC, botonPorcentaje,
                botonBorrar;


        vista = inflater.inflate(R.layout.layout_fragment_calculadora, container, false);

        calculo = vista.findViewById(R.id.cadena_simple);
        cadenacalculo = vista.findViewById(R.id.cadena_calculo);
        //debug = vista.findViewById(R.id.debug);

        boton0 = vista.findViewById(R.id.boton_cero_home);
        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setText(calculo.getText() + "0");
                contador = 0;
                cont_num=1;
            }
        });

        boton1 = vista.findViewById(R.id.boton_uno_home);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setText(calculo.getText() + "1");
                contador = 0;
                cont_num=1;
            }
        });

        boton2 = vista.findViewById(R.id.boton_dos_home);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setText(calculo.getText() + "2");
                contador = 0;
                cont_num=1;
            }
        });

        boton3 = vista.findViewById(R.id.boton_tres_home);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setText(calculo.getText() + "3");
                contador = 0;
                cont_num=1;
            }
        });

        boton4 =  vista.findViewById(R.id.boton_cuatro_home);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setText(calculo.getText() + "4");
                contador = 0;
                cont_num=1;
            }
        });

        boton5 = vista.findViewById(R.id.boton_cinco_home);
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setText(calculo.getText() + "5");
                contador = 0;
                cont_num=1;
            }
        });

        boton6 = vista.findViewById(R.id.boton_seis_home);
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setText(calculo.getText() + "6");
                contador = 0;
                cont_num=1;
            }
        });

        boton7= vista.findViewById(R.id.boton_siete_home);
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setText(calculo.getText() + "7");
                contador = 0;
                cont_num=1;
            }
        });

        boton8 = vista.findViewById(R.id.boton_ocho_home);
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setText(calculo.getText() + "8");
                contador = 0;
                cont_num=1;
            }
        });

        boton9 = vista.findViewById(R.id.boton_nueve_home);
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setText(calculo.getText() + "9");
                contador = 0;
                cont_num=1;
            }
        });

        botonPunto = vista.findViewById(R.id.boton_punto_home);
        botonPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contador_punto == 0){
                    calculo.setText(calculo.getText() + ".");
                    contador = 1;
                    contador_punto = 1;
                    cont_num=1;
                }
            }
        });
        botonAC = vista.findViewById(R.id.boton_ac_home);
        botonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setText("");
                cadenacalculo.setText("");
                contador = 0;
                contador_igual = 0;
                primeravez = 0;
                sum1 = 0.0;
                sumatotal = 0.0;
                contador_punto = 0;
                operando = "";
                cont_num=0;
                //debug.setText("");

            }
        });

        botonSuma = vista.findViewById(R.id.boton_suma_home);
        botonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cont_num >= 1) {
                    sum1 = Double.valueOf((String) calculo.getText()).doubleValue();
                    String cadena = (String) cadenacalculo.getText();
                    if (primeravez == 0) {
                        operando = "+";
                        identificar(operando, sum1);
                        //debug.setText(sumatotal.toString());
                        cadenacalculo.setText(cadena + calculo.getText() + "+");
                        calculo.setText("");
                        contador = 1;
                        primeravez = 1;
                        contador_punto = 0;
                    } else if (contador == 0) {
                        identificar(operando, sum1);
                        operando = "+";
                        ;
                        //debug.setText(sumatotal.toString());
                        cadenacalculo.setText(cadena + calculo.getText() + "+");
                        calculo.setText("");
                        contador = 1;
                        contador_punto = 0;
                    }


                }
            }
        });

        botonResta = vista.findViewById(R.id.boton_resta_home);
        botonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cont_num >= 1) {
                    sum1 = Double.valueOf((String) calculo.getText()).doubleValue();
                    String cadena = (String) cadenacalculo.getText();
                    if (primeravez == 0) {
                        operando = "-";
                        identificar(operando, sum1);
                        //debug.setText(sumatotal.toString());
                        cadenacalculo.setText(cadena + calculo.getText() + "-");
                        calculo.setText("");
                        contador = 1;
                        primeravez = 1;
                        contador_punto = 0;
                    } else if (contador == 0) {
                        identificar(operando, sum1);
                        operando = "-";
                        //debug.setText(sumatotal.toString());
                        cadenacalculo.setText(cadena + calculo.getText() + "-");
                        calculo.setText("");
                        contador = 1;
                        contador_punto = 0;
                    }
                }
            }
        });

        botonMultiplicacion = vista.findViewById(R.id.boton_multiplicacion_home);
        botonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cont_num >= 1) {
                    sum1 = Double.valueOf((String) calculo.getText()).doubleValue();
                    String cadena = (String) cadenacalculo.getText();
                    if (primeravez == 0) {
                        operando = "x";
                        identificar(operando, sum1);
                        //debug.setText(sumatotal.toString());
                        cadenacalculo.setText(cadena + calculo.getText() + "*");
                        calculo.setText("");
                        contador = 1;
                        primeravez = 1;
                        contador_punto = 0;
                    } else if (contador == 0) {
                        identificar(operando, sum1);
                        operando = "x";
                        //debug.setText(sumatotal.toString());
                        cadenacalculo.setText(cadena + calculo.getText() + "*");
                        calculo.setText("");
                        contador = 1;
                        contador_punto = 0;
                    }
                }
            }
        });

        botonDivision = vista.findViewById(R.id.boton_division_home);
        botonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cont_num >= 1) {
                    sum1 = Double.valueOf((String) calculo.getText()).doubleValue();
                    String cadena = (String) cadenacalculo.getText();
                    if (primeravez == 0) {
                        operando = "/";
                        identificar(operando, sum1);
                        //debug.setText(sumatotal.toString());
                        cadenacalculo.setText(cadena + calculo.getText() + "/");
                        calculo.setText("");
                        contador = 1;
                        primeravez = 1;
                        contador_punto = 0;
                    } else if (contador == 0) {
                        identificar(operando, sum1);
                        operando = "/";
                        //debug.setText(sumatotal.toString());
                        cadenacalculo.setText(cadena + calculo.getText() + "/");
                        calculo.setText("");
                        contador = 1;
                        contador_punto = 0;

                    }
                }
            }
        });

        botonPorcentaje = vista.findViewById(R.id.boton_porcentaje_home);
        botonPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cont_num >= 1) {
                    sum1 = Double.valueOf((String) calculo.getText()).doubleValue();
                    String cadena = (String) cadenacalculo.getText();
                    if (primeravez == 0) {
                        operando = "%";
                        identificar(operando, sum1);
                        //debug.setText(sumatotal.toString());
                        cadenacalculo.setText(cadena + calculo.getText() + "%");
                        calculo.setText("");
                        contador = 1;
                        primeravez = 1;
                        contador_punto = 0;
                    } else if (contador == 0) {
                        identificar(operando, sum1);
                        operando = "%";
                        //debug.setText(sumatotal.toString());
                        cadenacalculo.setText(cadena + calculo.getText() + "%");
                        calculo.setText("");
                        contador = 1;
                        contador_punto = 0;
                    }
                }
            }
        });

        botonIgual = vista.findViewById(R.id.boton_igual_home);
        botonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sumatotal != 0.0) {
                    sum1 = Double.valueOf((String) calculo.getText()).doubleValue();
                    if (contador_igual == 0) {
                        identificar(operando, sum1);
                        String cadena = cadenacalculo.getText().toString();
                        String cadena2 = sumatotal.toString();
                        int longitud = cadena2.length();
                        cadenacalculo.setText(cadena + calculo.getText() + "=");
                        if ((cadena2.charAt(longitud - 2) == '.') && (cadena2.charAt(longitud - 1) == '0'))
                            cadena2 = cadena2.substring(0, cadena2.length() - 2);
                        calculo.setText(cadena2);
                        contador_igual = 1;
                        contador_punto = 1;
                        contador = 1;
                        primeravez = 1;
                    }
                    Toast toast1 =
                            Toast.makeText(vista.getContext(), "Pulse AC para continuar", Toast.LENGTH_SHORT);
                    toast1.show();
                }

            }
        });

        botonBorrar = vista.findViewById(R.id.boton_borrar_home);
        botonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(calculo.length() > 0){
                   String cadena_borrar = calculo.getText().toString();
                    calculo.setText(calculo.getText().toString().substring(0,calculo.length()-1));
                   String reemplazar = cadena_borrar.substring(cadena_borrar.length()-1);

                   if( reemplazar.equals(".")){

                       contador_punto = 0;
                   }
               }
            }
        });

        return vista;
    }

}
