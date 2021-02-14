


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("lk/royalInstitute/hibernate/view/SearchCourseFrom.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Royal Insitute");
        primaryStage.getIcons().add(new Image("/lk/royalInstitute/hibernate/asset/—Pngtree—3d crown vector royal_3781022.png"));
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
