import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Controller extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/MainScene.fxml"));
        Scene mainScene = new Scene(mainLoader.load());
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Calculator");
        primaryStage.setMinWidth(301);
        primaryStage.setMinHeight(530);
        primaryStage.setWidth(301);
        primaryStage.setHeight(530);
        primaryStage.setMaxWidth(301);
        primaryStage.setMaxHeight(530);
        primaryStage.getIcons().add(new Image("https://dt2sdf0db8zob.cloudfront.net/wp-content/uploads/2019/08/10-Best-Gaming-Team-Logos-and-How-to-Make-Your-Own-CurrentYear-image1-1.png"));
        primaryStage.show();

    }
}