package ua.kpi.fpm.javaguessnumbergame;

import ua.kpi.fpm.javaguessnumbergame.controller.Controller;
import ua.kpi.fpm.javaguessnumbergame.model.Model;
import ua.kpi.fpm.javaguessnumbergame.view.View;


/**
 * Created by Anastasia Serhienko on 4/23/16.
 */
public class Main {
    public static void main(String[] args) {
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        // Run
        controller.processUser();
    }
}
