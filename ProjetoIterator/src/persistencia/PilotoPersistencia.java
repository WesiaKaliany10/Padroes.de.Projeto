
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import classededados.Piloto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Iterator;

public class PilotoPersistencia {
    private String nomeDoArquivo;

    public PilotoPersistencia(String nome) {
        this.nomeDoArquivo = nome;
    }

   
    private Piloto criarPiloto(String linha) {
        String[] dados = linha.split(";");
        return new Piloto(
            Integer.parseInt(dados[0]),
            dados[1],
            dados[2],
            Integer.parseInt(dados[3]),
            dados[4],
            dados[5],
            dados[6]
        );
    }


    public Iterator<Piloto> listagemHashSet() throws Exception {
        HashSet<Piloto> colecao = new HashSet<>();
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        while ((linha = br.readLine()) != null) {
            colecao.add(criarPiloto(linha));
        }
        br.close();
        return colecao.iterator();
    }

   
    public Iterator<Piloto> listagemTreeSet() throws Exception {
        TreeSet<Piloto> colecao = new TreeSet<>();
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        while ((linha = br.readLine()) != null) {
            colecao.add(criarPiloto(linha));
        }
        br.close();
        return colecao.iterator();
    }

   
    public Iterator<Piloto> listagemLinkedList() throws Exception {
        LinkedList<Piloto> colecao = new LinkedList<>();
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        while ((linha = br.readLine()) != null) {
            colecao.add(criarPiloto(linha));
        }
        br.close();
        return colecao.iterator();
    }

    
    public Iterator<Piloto> listagemPriorityQueue() throws Exception {
        PriorityQueue<Piloto> colecao = new PriorityQueue<>();
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        while ((linha = br.readLine()) != null) {
            colecao.add(criarPiloto(linha));
        }
        br.close();
        return colecao.iterator();
    }

   
    public Iterator<Piloto> listagemStack() throws Exception {
        Stack<Piloto> colecao = new Stack<>();
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha;
        while ((linha = br.readLine()) != null) {
            colecao.add(criarPiloto(linha));
        }
        br.close();
        return colecao.iterator();
    }

    public Iterator<Piloto> listagemDePilotosHashSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    