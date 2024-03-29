package lk.shashan.client.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppInitializer extends Application {

    public static AnnotationConfigApplicationContext ctx;


    public static void main(String[] args) throws IOException {

        FileHandler fileHandler = new FileHandler("error.log", true);
        fileHandler.setFormatter(new SimpleFormatter());
        Logger.getLogger("").addHandler(fileHandler);

//        FileHandler fileHandler1 = new FileHandler("business_error.log", true);
//        fileHandler1.setFormatter(new SimpleFormatter());
//        Logger logger = Logger.getLogger("lk.ijse.pos.business");
//        logger.addHandler(fileHandler1);
//        logger.setUseParentHandlers(false);

        launch(args);
    }

    public static void navigateToHome(Node node, Stage mainStage) throws IOException {

        Parent root = FXMLLoader.load(AppInitializer.class.getResource("/view/DashBoard.fxml"));
        Scene mainScene = new Scene(root);
        mainStage.setScene(mainScene);

//        TranslateTransition tt1 = new TranslateTransition(Duration.millis(300), root.lookup("AnchorPane"));
//        tt1.setToX(0);
//        tt1.setFromX(-mainScene.getWidth());
//        tt1.play();

        mainStage.centerOnScreen();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);

        ctx.refresh();

        Parent root = FXMLLoader.load(this.getClass().getResource("/view/DashBoard.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Film Hall");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
