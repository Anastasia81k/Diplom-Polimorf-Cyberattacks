package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Map;

import com.jfoenix.controls.JFXHamburger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;

import static sample.FuzzyAttack.startFuzzify;
import static sample.HashAttack.createMap;

//import static sample.Main.startMonitoring;



public class Controller implements Initializable {

    public static int countDOS =0;
    public static int countR2L =0;
    public static int countPROBE =0;
    public static int countNORMAL =0;
    public static int countU2R =0;

    private Monitoring monitoringTask;
    private Item item = new Item();

    @FXML
    private Button btnStartMonitoring;

    @FXML
    private Button btnStopMonitoring;

    @FXML
    private Pane homePanel;
    @FXML
    private JFXButton startButton;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private JFXButton auditButton;

    @FXML
    private JFXButton exitButton;

    @FXML
    private Pane auditPane;

    @FXML
    private Pane startPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXHamburger menu;


    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private ProgressBar pbQuartity;


    public void handleBtnPlus(ActionEvent actionEvent) {
       // item.setQuantity(item.getQuantity() +0.1);
    }


    @FXML
    void initialize() {
/*
        exitButton.setOnMouseClicked(event -> {
            System.exit(0);
        });

        startButton.setOnMouseClicked(event -> {
            startPane.toFront();
            try {
                startMonitoring();
                item.setQuantity(item.getQuantity() +0.1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        auditButton.setOnMouseClicked(event -> {
            auditPane.toFront();
        });

        /*pane1.setVisible(false);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5), pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), pane2);
        translateTransition.setByX(-10);
        translateTransition.play();

        menu.setOnMouseClicked(event -> {
            pane1.setVisible(true);

            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5), pane1);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();



            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), pane2);
            translateTransition2.setByX(+10);
            translateTransition2.play();
        });

        pane1.setOnMouseClicked(event -> {
            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5), pane1);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                pane1.setVisible(false);
            });

            TranslateTransition translateTransition2 = new TranslateTransition(Duration.seconds(0.5), pane2);
            translateTransition2.setByX(-10);
            translateTransition2.play();
        });
*/

    }

    static void printMap(Map<String, Double> map){
        double threat = startFuzzify(map);
        if (threat >= 0.5 && threat <= 1.5) {
            countDOS++;
        } else if (threat >= 1.5 && threat <= 2.5) {
            countR2L++;
        } else if (threat >= 3.5 && threat <= 4.5) {
            countPROBE++;
        } else if (threat >= 4.5 && threat <= 5.5) {
            countNORMAL++;
        } else if (threat >= 5.5 && threat <= 6.0) {
            countU2R++;
        }
        System.out.println("Total result of monitoring: " + countDOS + " - count DOS attacks " +  countR2L + " - count R2L " + countPROBE + " - count PROBE " + countNORMAL + " - count Normal " + countU2R + "  - count R2L");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        btnStartMonitoring.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startButton.setDisable(true);
                pbQuartity.setProgress(0);
                progressIndicator.setProgress(0);;

                monitoringTask = new Monitoring();
                pbQuartity.progressProperty().unbind();
                pbQuartity.progressProperty().bind(monitoringTask.progressProperty());
                progressIndicator.progressProperty().unbind();
                progressIndicator.progressProperty().bind(monitoringTask.progressProperty());

                monitoringTask.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent t) {
                        List<Attack> attackList = monitoringTask.getValue();
                        System.out.println(attackList);
                        //List<Result> results = new ArrayList<>();
                        for(Attack p: attackList){
                            if(p != null){
                                printMap(createMap(p));
                            }
                          //  System.out.println(p.toString());
                        }
                        System.out.println("-------------------------------------");

                    }
                });
                new Thread(monitoringTask).start();
            }
        });

        btnStopMonitoring.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnStartMonitoring.setDisable(false);
                btnStopMonitoring.setDisable(true);
                monitoringTask.cancel(true);
                pbQuartity.progressProperty().unbind();
                progressIndicator.progressProperty().unbind();
                pbQuartity.setProgress(0);
                progressIndicator.setProgress(0);
            }
        });

        exitButton.setOnMouseClicked(event -> {
            System.exit(0);
        });

        startButton.setOnMouseClicked(event -> {
            startPane.toFront();
        });
        /*btnStartMonitoring.setOnMouseClicked(event -> {
            try {
                startMonitoring();
                pbQuartity.setProgress(pbQuartity.getProgress() + 0.1);
                progressIndicator.setProgress(progressIndicator.getProgress() + 0.1);
                if(pbQuartity.getProgress() >= 0.9){
                    startButton.setDisable(true);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });*/
        auditButton.setOnMouseClicked(event -> {
            auditPane.toFront();
        });



        item.setQuantity(0);
        item.quantityProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                pbQuartity.progressProperty().bind(item.quantityProperty());
                progressIndicator.progressProperty().bind(item.quantityProperty());
            }
        });
    }


}