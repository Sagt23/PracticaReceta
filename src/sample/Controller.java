package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.*;
import java.util.Arrays;

public class Controller {
    @FXML TextArea txtReceta, txtPreparacion, txtPreguntas, txtIngredientes;
    public void procesar(ActionEvent event){
        try{
        File f= new File("./src/sample/Receta.txt");
        BufferedReader br=new BufferedReader(new FileReader(f));
        String texto= "";
        while ((texto=br.readLine())!=null){
            txtReceta.appendText("\n"+texto );
        }
    }catch (IOException e) {
        txtReceta.setText(e.getMessage());
    }
        String[] arrLineas= txtReceta.getText().split("\n");
        for (int x=3;x<17;x++){
            String ingre= (Arrays.toString(arrLineas[x].split("" + "\n")));
            txtIngredientes.setText(ingre);
        }
        for (int x=20;x<29;x++){
            String prepa= (Arrays.toString(arrLineas[x].split(""+"\n")));
            txtPreparacion.setText(prepa);
        }
        for (int x=34;x<37;x++){
            String pregu= (Arrays.toString(arrLineas[x].split(""+"\n")));
            txtPreguntas.setText(pregu);
        }
    }
}
