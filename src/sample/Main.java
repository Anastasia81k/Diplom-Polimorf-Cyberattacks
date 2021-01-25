package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static sample.FuzzyAttack.startFuzzify;
import static sample.HashAttack.createMap;

public class Main extends Application {

    double x, y =0;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Monitoring attacks");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getSceneX() - x);
            primaryStage.setY(event.getSceneY() -y);
        });
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
/*
    public static void startMonitoring() throws IOException {
        String excelFilePath = "Vector.xlsx";
        Monitoring monitoring = new Monitoring();
        List<Attack> list = monitoring.listAttacks(excelFilePath);

        System.out.println(list);
        List<Result> results = new ArrayList<>();
        for(Attack p: list){
            if(p != null){
                printMap(createMap(p));
            }
            System.out.println(p.toString());
        }
        System.out.println("-------------------------------------");
    }

    static void printMap(Map<String, Double> map){
        startFuzzify(map);
    }

*/


}
