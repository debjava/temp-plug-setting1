//package com.ddlab.rnd.console;
//
//import com.intellij.execution.impl.ConsoleViewImpl;
//import com.intellij.execution.ui.ConsoleView;
//import com.intellij.execution.ui.ConsoleViewContentType;
//import com.intellij.openapi.components.Service;
//import com.intellij.openapi.project.Project;
//
//@Service(Service.Level.PROJECT)
//public final class MyConsoleService {
//
//    private ConsoleView consoleView;
//
//    public void init(Project project) {
//        if (consoleView == null) {
//            consoleView = new ConsoleViewImpl(project, true);
//        }
//    }
//
//    public ConsoleView getConsoleView() {
//        return consoleView;
//    }
//
//    public void log(String text) {
//        if (consoleView != null) {
//            consoleView.print(text + "\n", ConsoleViewContentType.NORMAL_OUTPUT);
//        }
//    }
//
//    public void logError(String text) {
//        if (consoleView != null) {
//            consoleView.print(text + "\n", ConsoleViewContentType.ERROR_OUTPUT);
//        }
//    }
//}
