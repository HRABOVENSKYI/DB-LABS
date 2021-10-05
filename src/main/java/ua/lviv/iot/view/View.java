package ua.lviv.iot.view;

import ua.lviv.iot.controller.HospitalController;
import ua.lviv.iot.controller.impl.HospitalControllerImpl;
import ua.lviv.iot.model.Hospital;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class View {

    private static final String KEY_EXIT = "Q";
    private static final String TEXT_GO_BACK = "Go back or quit";
    private static final String TEXT_SELECT_MENU_OPTION = "Please choose menu option: ";
    private static final String ERROR_NO_SUCH_OPTION = "No such option found. Try again.";

    private static Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

    public void show() {
        showTablesMenu();
    }

    /**
     * Show general tables MENU
     */
    private void showTablesMenu() {
        Map<String, String> tablesMenu = generateTablesMenu();
        Map<String, Printable> tablesMenuMethods = generateTablesMenuMethods();
        showMenuFromMaps(tablesMenu, tablesMenuMethods);
    }

    /**
     * Generate general tables MENU and MENU METHODS
     */
    // -----------------------------------------------------------------------
    private Map<String, String> generateTablesMenu() {
        Map<String, String> tablesMenu = new LinkedHashMap<>();
        tablesMenu.put("1", "Table: Hospital");
        return tablesMenu;
    }

    private Map<String, Printable> generateTablesMenuMethods() {
        Map<String, Printable> tablesMenuMethods = new LinkedHashMap<>();
        tablesMenuMethods.put("1", this::showHospitalMenu);
        return tablesMenuMethods;
    }
    // -----------------------------------------------------------------------

    /**
     * Show single table MENU
     */
    private void showHospitalMenu() {
        Map<String, String> menu = generateHospitalMenu();
        Map<String, Printable> menuMethods = generateHospitalMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    /**
     * Generate single table MENU and MENU METHODS
     */
    // -----------------------------------------------------------------------
    private Map<String, String> generateHospitalMenu() {
        Map<String, String> menu = new LinkedHashMap<String, String>();
        menu.put("1", "Select all hospitals");
        menu.put("2", "Select hospital");
        menu.put("3", "Create hospital");
        menu.put("4", "Update hospital");
        menu.put("5", "Delete hospital");
        return menu;
    }

    private Map<String, Printable> generateHospitalMenuMethods() {
        HospitalController hospitalController = new HospitalControllerImpl();
        Formatter<Hospital, Integer> formatter = new Formatter<>(Hospital.class);
        ViewOperations<Hospital, Integer> hospitalOperation = new ViewOperations<>(hospitalController, formatter, Hospital.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", hospitalOperation::findAll);
        menuMethods.put("2", hospitalOperation::findById);
        menuMethods.put("3", hospitalOperation::create);
        menuMethods.put("4", hospitalOperation::update);
        menuMethods.put("5", hospitalOperation::delete);
        return menuMethods;
    }
    // -----------------------------------------------------------------------

    /**
     * Show menu from Maps
     */
    private void showMenuFromMaps(Map<String, String> keyName, Map<String, Printable> keyMethod) {
        String keyMenu;
        do {
            printMenu(keyName);
            System.out.println(TEXT_SELECT_MENU_OPTION);
            keyMenu = input.nextLine().toUpperCase();
            Printable method = keyMethod.get(keyMenu);
            if (method != null) {
                method.print();
            } else if (!keyMenu.equals(KEY_EXIT)) {
                System.out.println(ERROR_NO_SUCH_OPTION);
            }
        } while (!keyMenu.equals(KEY_EXIT));
    }

    private void printMenu(Map<String, String> keyName) {
        keyName.entrySet().stream()
                .forEach(es -> System.out.printf("%3s - %s%n", es.getKey(), es.getValue()));
        System.out.printf("%3s - %s%n", KEY_EXIT, TEXT_GO_BACK);
    }
}
