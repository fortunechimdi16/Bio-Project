import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//class header

public class Main extends Application {

    public static Font selectedFont; //declaring variables

    private ComboBox<String> fontComboBox;



    @Override
    public void start (Stage primaryStage) { //method header

        Name name1 = new Name();
        name1.setAlignment(Pos.CENTER);

        Picture picture1 = new Picture();
        picture1.setAlignment(Pos.CENTER);

        Birthday birthday1 = new Birthday();
        birthday1.setAlignment(Pos.CENTER);

        Education edu1 = new Education();
        edu1.setAlignment(Pos.CENTER);

        WorkExperience work1 = new WorkExperience();
        work1.setAlignment(Pos.CENTER);

        Biography bio1 = new Biography();
        bio1.setAlignment(Pos.CENTER);

        Bio bio2 = new Bio();
        bio2.setAlignment(Pos.CENTER);

        GenerateProfileButton gen1 = new GenerateProfileButton();
        gen1.setAlignment (Pos.CENTER);

        ColorPick accent = new ColorPick();
        accent.setAlignment(Pos.CENTER);

        ObservableList<String> font;
        ComboBox<String> fontComboBox = new ComboBox<>();
       fontComboBox.setTranslateX(300);
       fontComboBox.getItems().addAll(Font.getFamilies());
        fontComboBox.getSelectionModel().selectFirst();
        fontComboBox.setOnAction(event -> {


            selectedFont = Font.font(fontComboBox.getValue(), 14);
            setFontForLabels(selectedFont);
        });
//adding different classes into the vbox
        VBox root = new VBox(name1, edu1, work1, bio1, bio2, picture1, birthday1, accent,fontComboBox, gen1);  //Creating VBox that will be place in the scene

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Profile Generating for: ");
        primaryStage.setScene(scene);
        primaryStage.show(); //printing on screen
    }
    public ComboBox<String> getFontComboBox() {
        return fontComboBox;
    }

    public static void setFontForLabels(Font font) {
        Name.setFontLabels(font);
        Birthday.setFontLabels(font);
        Biography.setFontLabels(font);
        Education.setFontLabels(font);
        WorkExperience.setFontLabels(font);
        Bio.setFontLabels(font);

    }

}

