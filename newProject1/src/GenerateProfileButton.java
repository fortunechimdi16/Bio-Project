import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.net.URL;


public class GenerateProfileButton extends HBox { //class header extending hbox

    Button submit, clear;
    VBox vbox2;
    static Label nameSet;
    Label bioSet, bioSet2, eduSet, workSet, birthdaySet;

    ImageView profImg;

    private Stage newWindow;
    Scene secondScene;

    HBox hbox1, hbox2, hbox3, hbox4;

    Button  back;



    public GenerateProfileButton() {
        submit = new Button("Generate Profile");
        submit.setOnAction(this::processSubmit);

        clear = new Button("Clear Form");
        clear.setOnAction(this::processClear);


        HBox subBox = new HBox(submit, clear);
        subBox.setPadding(new Insets(15, 15, 15, 25));
        subBox.setSpacing(10);

        getChildren().addAll(subBox);
    }


    private void processSubmit(ActionEvent event) {
        ColorPick accentColor1 = new ColorPick();
        Paint accentColorValue = accentColor1.getAccentColor();



        Label accentC = new Label("This is "+ Name.name.getText() + "'s Profile");
        accentC.setFont(Font.font("Calibre", FontWeight.BOLD, FontPosture.REGULAR, 24));
        accentC.setTextFill(accentColorValue);


        nameSet = new Label();
        nameSet.setTranslateX(300);
        nameSet.setText("Name: " + Name.name.getText());
        nameSet.setFont(Name.name.getFont());
        nameSet.setTextFill(Color.BLACK);

        birthdaySet = new Label();
        birthdaySet.setTranslateX(300);
        birthdaySet.setText("Age: " + Birthday.message.getText());
        birthdaySet.setFont(Birthday.message.getFont());
        birthdaySet.setTextFill(Color.BLACK);

        bioSet = new Label();
        bioSet.setTranslateX(300);
        bioSet.setAlignment(Pos.CENTER);
        bioSet.setText("LinkedIn: " + Biography.bio.getText());
        bioSet.setFont(Biography.bio.getFont());
        bioSet.setTextFill(Color.BLACK);

        bioSet2 = new Label();
        bioSet2.setTranslateX(300);
        bioSet2.setText("Biography: " + Bio.content.getText());


        eduSet = new Label();
        eduSet.setTranslateX(300);
        eduSet.setText("Education: " + Education.edu.getText());
        eduSet.setFont(Education.edu.getFont());
        eduSet.setTextFill(Color.BLACK);


        Hyperlink bioLink = new Hyperlink( Biography.bio.getText());
        bioLink.setOnAction(e -> {
            String linkedInURL = Biography.bio.getText();
            if (!linkedInURL.isEmpty()) {

            }
        });
        bioLink.setStyle("-fx-font-size: 16px;");
        bioLink.setStyle("-fx-text-fill: black;");


        workSet = new Label();
        workSet.setTranslateX(300);
        workSet.setText(" Work Experience: " + WorkExperience.work.getText());
        workSet.setFont(WorkExperience.work.getFont());
        workSet.setTextFill(Color.BLACK);


        profImg = new ImageView();
        Image selectedImage = Picture.getImage();
        if (selectedImage != null) {
            profImg.setImage(selectedImage);
            profImg.setFitWidth(300);
            profImg.setPreserveRatio(true);
        }


        StackPane imagePane = new StackPane(profImg);


        ImageView img2 = new ImageView(Birthday.image2);
        img2.setSmooth(true);
        img2.setCache(true);
        if (Birthday.image2 != null) {
            img2.setImage(Birthday.image2);
            img2.setFitWidth(50);
            img2.setPreserveRatio(true);
        }




        hbox1 = new HBox(img2);
        hbox1.setAlignment(Pos.CENTER);


        back = new Button("Return");
        back.setAlignment(Pos.CENTER_LEFT);
        back.setOnAction(this::processHome);

        hbox2 = new HBox(back);
        hbox2.setAlignment(Pos.CENTER);


        hbox3 = new HBox(bioLink);
        getChildren().addAll(hbox3);
        hbox3.setAlignment(Pos.CENTER);

        hbox4 = new HBox(accentC);
        hbox4.setAlignment(Pos.CENTER);
        getChildren().addAll(hbox4);


        vbox2 = new VBox(hbox4, imagePane, nameSet, birthdaySet, hbox1, eduSet, workSet, hbox3, Bio.content, hbox2);
        vbox2.setSpacing(10);
        vbox2.setAlignment(Pos.CENTER_LEFT);
        vbox2.setStyle("-fx-background-color: Lavender");
        vbox2.setPrefSize(1000, 600);



        ScrollPane root2 = new ScrollPane(vbox2);
        root2.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        root2.setPrefViewportHeight(400);
        root2.setPrefViewportWidth(800);
        secondScene = new Scene(root2, 900, 600);


        newWindow = new Stage();
        newWindow.setTitle("Profile for " + Name.name.getText());
        newWindow.setScene(secondScene);
        secondScene.getRoot().applyCss();

        newWindow.initModality(Modality.WINDOW_MODAL);

        newWindow.show();
    }



    private void processHome(ActionEvent event) {
        if (event.getSource() == back) {
            newWindow.close();
        }
    }







    private void processClear(ActionEvent event) {
        Name.name.clear();
        Education.edu.clear();
        Biography.bio.clear();
        WorkExperience.work.clear();

    }

}





