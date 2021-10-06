package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.controller.impl.*;
import ua.lviv.iot.model.*;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class View {

    private static final String KEY_EXIT = "Q";
    private static final String TEXT_GO_BACK = "Go back or quit";
    private static final String TEXT_SELECT_MENU_OPTION = "Please choose menu option: ";
    private static final String ERROR_NO_SUCH_OPTION = "No such option found. Try again.";

    private static final Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

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
    private Map<String, String> generateTablesMenu() {
        Map<String, String> tablesMenu = new LinkedHashMap<>();
        tablesMenu.put("1", "Table: Hospital");
        tablesMenu.put("2", "Table: Injury");
        tablesMenu.put("3", "Table: Rescuer");
        tablesMenu.put("4", "Table: Reporter");
        tablesMenu.put("5", "Table: Rescue vehicle");
        tablesMenu.put("6", "Table: Call address");
        tablesMenu.put("7", "Table: Call");
        return tablesMenu;
    }

    private Map<String, Printable> generateTablesMenuMethods() {
        Map<String, Printable> tablesMenuMethods = new LinkedHashMap<>();
        tablesMenuMethods.put("1", this::showHospitalMenu);
        tablesMenuMethods.put("2", this::showInjuryMenu);
        tablesMenuMethods.put("3", this::showRescuerMenu);
        tablesMenuMethods.put("4", this::showReporterMenu);
        tablesMenuMethods.put("5", this::showRescueVehicleMenu);
        tablesMenuMethods.put("6", this::showCallAddressMenu);
        tablesMenuMethods.put("7", this::showCallMenu);
        return tablesMenuMethods;
    }

    /**
     * Show single table MENU
     */
    private void showHospitalMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateHospitalMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showInjuryMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateInjuryMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showRescuerMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateRescuerMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showReporterMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateReporterMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showRescueVehicleMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateRescueVehicleMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showCallAddressMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateCallAddressMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    private void showCallMenu() {
        Map<String, String> menu = generateMenu();
        Map<String, Printable> menuMethods = generateCallMenuMethods();
        showMenuFromMaps(menu, menuMethods);
    }

    /**
     * Generate single table MENU
     */
    private Map<String, String> generateMenu() {
        Map<String, String> menu = new LinkedHashMap<>();
        menu.put("1", "Select all");
        menu.put("2", "Select");
        menu.put("3", "Create");
        menu.put("4", "Update");
        menu.put("5", "Delete");
        return menu;
    }

    /**
     * Generate single table MENU METHODS
     */
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



    private Map<String, Printable> generateInjuryMenuMethods() {
        InjuryController injuryController = new InjuryControllerImpl();
        Formatter<Injury, Integer> formatter = new Formatter<>(Injury.class);
        ViewOperations<Injury, Integer> injuryOperation = new ViewOperations<>(injuryController, formatter, Injury.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", injuryOperation::findAll);
        menuMethods.put("2", injuryOperation::findById);
        menuMethods.put("3", injuryOperation::create);
        menuMethods.put("4", injuryOperation::update);
        menuMethods.put("5", injuryOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateRescuerMenuMethods() {
        RescuerController rescuerController = new RescuerControllerImpl();
        Formatter<Rescuer, Integer> formatter = new Formatter<>(Rescuer.class);
        ViewOperations<Rescuer, Integer> rescuerOperation = new ViewOperations<>(rescuerController, formatter, Rescuer.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", rescuerOperation::findAll);
        menuMethods.put("2", rescuerOperation::findById);
        menuMethods.put("3", rescuerOperation::create);
        menuMethods.put("4", rescuerOperation::update);
        menuMethods.put("5", rescuerOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateReporterMenuMethods() {
        ReporterController reporterController = new ReporterControllerImpl();
        Formatter<Reporter, String> formatter = new Formatter<>(Reporter.class);
        ViewOperations<Reporter, String> reporterOperation = new ViewOperations<>(reporterController, formatter, Reporter.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", reporterOperation::findAll);
        menuMethods.put("2", reporterOperation::findById);
        menuMethods.put("3", reporterOperation::create);
        menuMethods.put("4", reporterOperation::update);
        menuMethods.put("5", reporterOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateRescueVehicleMenuMethods() {
        RescueVehicleController rescueVehicleController = new RescueVehicleControllerImpl();
        Formatter<RescueVehicle, String> formatter = new Formatter<>(RescueVehicle.class);
        ViewOperations<RescueVehicle, String> rescueVehicleOperation = new ViewOperations<>(rescueVehicleController, formatter, RescueVehicle.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", rescueVehicleOperation::findAll);
        menuMethods.put("2", rescueVehicleOperation::findById);
        menuMethods.put("3", rescueVehicleOperation::create);
        menuMethods.put("4", rescueVehicleOperation::update);
        menuMethods.put("5", rescueVehicleOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateCallAddressMenuMethods() {
        CallAddressController callAddressController = new CallAddressControllerImpl();
        Formatter<CallAddress, Integer> formatter = new Formatter<>(CallAddress.class);
        ViewOperations<CallAddress, Integer> callAddressOperation = new ViewOperations<>(callAddressController, formatter, CallAddress.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", callAddressOperation::findAll);
        menuMethods.put("2", callAddressOperation::findById);
        menuMethods.put("3", callAddressOperation::create);
        menuMethods.put("4", callAddressOperation::update);
        menuMethods.put("5", callAddressOperation::delete);
        return menuMethods;
    }

    private Map<String, Printable> generateCallMenuMethods() {
        CallController callController = new CallControllerImpl();
        Formatter<Call, Integer> formatter = new Formatter<>(Call.class);
        ViewOperations<Call, Integer> callOperation = new ViewOperations<>(callController, formatter, Call.class);

        Map<String, Printable> menuMethods = new LinkedHashMap<>();
        menuMethods.put("1", callOperation::findAll);
        menuMethods.put("2", callOperation::findById);
        menuMethods.put("3", callOperation::create);
        menuMethods.put("4", callOperation::update);
        menuMethods.put("5", callOperation::delete);
        return menuMethods;
    }

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
