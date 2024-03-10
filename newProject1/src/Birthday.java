
import javafx.event.ActionEvent;
import javafx.geometry.Insets;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Birthday extends HBox {
    static Text message;
    DatePicker datePicker;
    static Image image2;
    LocalDate birthDate, current;
    private Map<Integer, String> monthImg = new HashMap<>();

    public Birthday() {
        Label bdayLabel = new Label("Select your birthday");

        message = new Text();
        message.setFont(Font.font("Calibre", FontWeight.BOLD, FontPosture.REGULAR, 14));


        datePicker = new DatePicker(LocalDate.now());
        datePicker.setOnAction(this::processDateChoice);

        initializeMonthImg();


        HBox bdayBox = new HBox(bdayLabel, datePicker);
        bdayBox.setPadding(new Insets(15, 15, 15, 25));
        bdayBox.setSpacing(10);

        getChildren().addAll(bdayBox);
    }

    private void initializeMonthImg() {
        // Initialize the mapping of months to zodiac signs
        monthImg.put(1, "Capricorn.png");
        monthImg.put(2,"Aries.png");
        monthImg.put(3, "Aries.png");
        monthImg.put(4, "Taurus.png");
        monthImg.put(5, "Gemini.png");
        monthImg.put(6, "Cancer.png");
        monthImg.put(7, "Leo.png");
        monthImg.put(8, "Leo.png");
        monthImg.put(9, "   Virgo.png");
        monthImg.put(10, "Libra.png");
        monthImg.put(11, "Sagittarius.png");
        monthImg.put(12, "Capricorn.png");


    }


    private void generatePortfolio(int birthMonth) {

        // Create layout for portfolio window
        VBox portfolioLayout = new VBox(10);
        portfolioLayout.setPadding(new Insets(20));


        // Create an ImageView and setting in ImageView.
        ImageView imageView = new ImageView(image2);
        imageView.setSmooth(true);
        imageView.setCache(true);


        // Add the ImageView to the portfolio layout. Also, adding portfolio content
        portfolioLayout.getChildren().addAll(
                message,
                new Label("Sign: " + monthImg.get(birthMonth)), //Display image based on birth month
                imageView
        );

    }


    private void processDateChoice(ActionEvent event) {
        birthDate = datePicker.getValue();
        current = LocalDate.now();
        long age = ChronoUnit.YEARS.between(birthDate, current);
        int month = birthDate.getMonthValue();
        int day = birthDate.getDayOfMonth();
        message.setText(age + " Years Old");

        if (month == 12) {
            if (day < 23) {
                image2 = new Image("Capricorn.png");
            }

        } else if (month == 11) {
            if (day < 23) {
                image2 = new Image("Sagittarius.png");
            }

        } else if (month == 10) {
            if (day < 23) {
                image2 = new Image("Libra.png");
            }


        } else if (month == 9) {
            if (day < 23) {
                image2 = new Image("    Virgo.png");
            }

        } else if (month == 8) {
            if (day < 23) {
                image2 = new Image("Leo.png");
            }

        } else if (month == 7) {
            if (day < 23) {
                image2 = new Image("Cancer.png");
            }

        } else if (month == 6) {
            if (day < 23) {
                image2 = new Image("Cancer.png");
            }

        } else if (month == 5) {
            if (day <23) {
                image2 = new Image("Gemini.png");
            }

        } else if (month == 4) {
            if (day <26) {
                image2 = new Image("Taurus.png");
            }

        } else if (month == 3) {
            if (day < 23) {
                image2 = new Image("Aries.png");
            }

        } else if (month == 2) {
            if (day < 23) {
                image2 = new Image("Aries.png");
            }

        } else if (month == 1) {
            if (day < 23) {

                image2 = new Image("Capricorn.png");
            }

        }
    }

    //Method to change message font
    public static void setFontLabels(Font font) {
        if (message != null) {
            message.setFont(font);
        }

    }
}