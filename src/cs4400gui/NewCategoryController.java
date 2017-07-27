package cs4400gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.Statement;

/**
 *
 */
public class NewCategoryController {
    @FXML private TextField category_name;

    @FXML protected void createCategory(ActionEvent event) {
        Statement statement = DatabaseDriver.getStmnt();
        String new_category_name = category_name.getText();
        try {
            statement.executeUpdate("INSERT INTO Category VALUES ('" + new_category_name + "');");
            System.out.println("Created new Category!");
            SceneSwitcher.getInstance().switchScene(event, "CategoriesList.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML protected void goBack(ActionEvent event) {
        SceneSwitcher.getInstance().goBack(event);
    }
}
