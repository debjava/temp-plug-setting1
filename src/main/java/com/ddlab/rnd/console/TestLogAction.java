//package com.ddlab.rnd.console;
//
//import com.intellij.openapi.actionSystem.AnAction;
//import com.intellij.openapi.actionSystem.AnActionEvent;
//import com.intellij.openapi.project.Project;
//import org.jetbrains.annotations.NotNull;
//
//public class TestLogAction extends AnAction {
//
//    @Override
//    public void actionPerformed(@NotNull AnActionEvent e) {
//        Project project = e.getProject();
//        if (project == null) return;
//
//        MyConsoleService console = project.getService(MyConsoleService.class);
//
//        console.log("This is a normal log.");
//        console.logError("This is an error log!");
//    }
//}
