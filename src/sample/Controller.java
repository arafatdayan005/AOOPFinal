package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.*;
import java.net.Socket;

public class Controller {

    @FXML
    public Button BtnP;
    public Button Btn1;
    public Button Btn2;
    public Button Btn3;
    public Button Btn4;

    @FXML
    public Label RGB;
    public Label R;
    public Label G;
    public Label B;
    public Label YW;
    public Label OW;
    public Label WG;

    @FXML
    public Pane BG;

    String[] colors;
    String colran;

    BufferedWriter writer;
    BufferedReader reader;

    public Controller(){
        try {
            Socket socket = new Socket("127.0.0.1", 8080);

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);


            Thread t = new Thread(){
                public void run(){
                    try{
                        String line = reader.readLine() + "\n";
                        System.out.println(line);
                        while (line != null){
                            if (line.equals("win2\n")){
                                WG.setVisible(false);
                                OW.setVisible(true);
                                Btn1.setDisable(true);
                                Btn2.setDisable(true);
                                Btn3.setDisable(true);
                                Btn4.setDisable(true);
                            }
                            line = reader.readLine() + "\n";
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    public void BPlay(){
        int r=0,g=0,b=0;
        colors = new String[4];
        for (int i=0;i<4;i++){
            r = (int)Math.floor(Math.random() * 256);
            g = (int)Math.floor(Math.random() * 256);
            b = (int)Math.floor(Math.random() * 256);
            colors[i] = new StringBuilder().append("-fx-background-color: rgb( ").append(r).append(" , ").append(g).append(" , ").append(b).append(" );").toString();
            System.out.println(colors[i]);
        }

        for (int i = 0;i<4;i++){

            if (i==0){
                Btn1.setStyle(colors[i]);
            }
            else if (i==1){
                Btn2.setStyle(colors[i]);
            }
            else if (i==2){
                Btn3.setStyle(colors[i]);
            }
            else if (i==3){
                Btn4.setStyle(colors[i]);
            }
        }
        String rancol = String.valueOf(Math.floor(Math.random() * colors.length));
        colran = colors[(int) Double.parseDouble(rancol)];
        String[] parts = colran.split(" ");
        String red = parts[2];
        String green = parts[4];
        String blue = parts[6];
        System.out.println(red+" "+green+" "+blue);


        RGB.setVisible(true);
        R.setVisible(true);
        G.setVisible(true);
        B.setVisible(true);
        R.setText(red);
        G.setText(green);
        B.setText(blue);
        BG.setVisible(true);
        Btn1.setVisible(true);
        Btn2.setVisible(true);
        Btn3.setVisible(true);
        Btn4.setVisible(true);
        Btn1.setDisable(false);
        Btn2.setDisable(false);
        Btn3.setDisable(false);
        Btn4.setDisable(false);
        YW.setVisible(false);
        OW.setVisible(false);
        WG.setVisible(false);
    }

    @FXML
    public void One() throws IOException {
        if (colors[0] == colran){
            YW.setVisible(true);
            Btn3.setDisable(true);
            Btn3.setOpacity(1);
            Btn2.setDisable(true);
            Btn2.setOpacity(1);
            Btn4.setDisable(true);
            Btn4.setOpacity(1);
            Btn4.setStyle(colran);
            Btn2.setStyle(colran);
            Btn3.setStyle(colran);
            writer.write("win1\n");
            writer.flush();
        }else{
            Btn4.setDisable(true);
            Btn4.setOpacity(1);
            Btn3.setDisable(true);
            Btn3.setOpacity(1);
            Btn2.setDisable(true);
            Btn2.setOpacity(1);
            WG.setVisible(true);
            Btn2.setStyle(colran);
            Btn3.setStyle(colran);
            Btn4.setStyle(colran);
        }
    }

    @FXML
    public void Two() throws IOException {
        if (colors[1] == colran){
            YW.setVisible(true);
            Btn3.setDisable(true);
            Btn3.setOpacity(1);
            Btn4.setDisable(true);
            Btn4.setOpacity(1);
            Btn1.setDisable(true);
            Btn1.setOpacity(1);
            Btn1.setStyle(colran);
            Btn4.setStyle(colran);
            Btn3.setStyle(colran);
            writer.write("win1\n");
            writer.flush();
        }else{
            Btn4.setDisable(true);
            Btn4.setOpacity(1);
            Btn3.setDisable(true);
            Btn3.setOpacity(1);
            Btn1.setDisable(true);
            Btn1.setOpacity(1);
            WG.setVisible(true);
            Btn1.setStyle(colran);
            Btn3.setStyle(colran);
            Btn4.setStyle(colran);
        }
    }

    @FXML
    public void Three() throws IOException {
        if (colors[2] == colran){
            YW.setVisible(true);
            Btn4.setDisable(true);
            Btn4.setOpacity(1);
            Btn2.setDisable(true);
            Btn2.setOpacity(1);
            Btn1.setDisable(true);
            Btn1.setOpacity(1);
            Btn1.setStyle(colran);
            Btn4.setStyle(colran);
            Btn4.setStyle(colran);
            writer.write("win1\n");
            writer.flush();
        }else{
            Btn4.setDisable(true);
            Btn4.setOpacity(1);
            Btn2.setDisable(true);
            Btn2.setOpacity(1);
            Btn1.setDisable(true);
            Btn1.setOpacity(1);
            WG.setVisible(true);
            Btn1.setStyle(colran);
            Btn2.setStyle(colran);
            Btn4.setStyle(colran);
        }
    }

    @FXML
    public void Four() throws IOException {
        if (colors[3] == colran){
            YW.setVisible(true);
            Btn3.setDisable(true);
            Btn3.setOpacity(1);
            Btn2.setDisable(true);
            Btn2.setOpacity(1);
            Btn1.setDisable(true);
            Btn1.setOpacity(1);
            Btn1.setStyle(colran);
            Btn2.setStyle(colran);
            Btn3.setStyle(colran);
            writer.write("win1\n");
            writer.flush();
        } else{
            Btn3.setDisable(true);
            Btn3.setOpacity(1);
            Btn2.setDisable(true);
            Btn2.setOpacity(1);
            Btn1.setDisable(true);
            Btn1.setOpacity(1);
            WG.setVisible(true);
            Btn1.setStyle(colran);
            Btn2.setStyle(colran);
            Btn3.setStyle(colran);
        }
    }
}