package com.ddlab.rnd.console;

import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.project.Project;

public class MyPluginConsoleManager {

    private static ConsoleView consoleView;

    public static void setConsoleView(ConsoleView view) {
        consoleView = view;
    }

    public static ConsoleView getConsoleView(Project project) {
        // In a real plugin, you might want to retrieve it from the ToolWindow content
        // or a project service if it's more complex.
        return consoleView;
    }
}
