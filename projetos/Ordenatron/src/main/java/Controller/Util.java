/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hermes
 */
public class Util {

    public static boolean CarregarArquivoEmLista(String nomearquivo, ArrayList<Integer> lista) {

        try {

            FileReader procurador;
            procurador = new FileReader(nomearquivo);
            BufferedReader leitor = new BufferedReader(procurador);
            String linha;

            do {
                linha = leitor.readLine();
                if (linha != null) {
                    lista.add(Integer.parseInt(linha));
                }
            } while (linha != null);
                leitor.close();
                return true;
            }catch (Exception e){
            return false;
        }
        }

    }
