package deco;

import java.io.IOException;

import entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML TextField username;
    @FXML PasswordField password;

    @FXML
    private void navigateToHome(User user) throws IOException {
        Object controller = App.setRoot("Home");
        ((HomeController) controller).setUser(user);
    }
    
    @FXML private void login() throws IOException {

        User user = new User(username.getText(), password.getText(), null);

        if (username.getText().equals("admin") && password.getText().equals("admin")) {
            navigateToHome(user);
        } else if (username.getText().equals("evp") && password.getText().equals("evp")) {
            navigateToHome(user);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password");
            alert.showAndWait();
        }
    }

    @FXML private void loginAsGuest() throws IOException {
        User user = new User("guest", "guest", User.roles.GUEST);
        navigateToHome(user);
    }
}
