//package com.ddlab.rnd.console;
//
//import com.intellij.openapi.project.Project;
//import com.intellij.openapi.wm.ToolWindow;
//import com.intellij.openapi.wm.ToolWindowFactory;
//import com.intellij.ui.content.Content;
//import com.intellij.ui.content.ContentFactory;
//import org.jetbrains.annotations.NotNull;
//
//public class MyConsoleToolWindowFactory implements ToolWindowFactory {
//
//    @Override
//    public void createToolWindowContent(@NotNull Project project,
//                                        @NotNull ToolWindow toolWindow) {
//
//        // Get console service
//        MyConsoleService consoleService = project.getService(MyConsoleService.class);
//
//        // Initialize console
//        consoleService.init(project);
//
//        ContentFactory contentFactory = ContentFactory.getInstance();
//
//        Content content = contentFactory.createContent(
//                consoleService.getConsoleView().getComponent(),
//                "Logs",
//                false
//        );
//
//        toolWindow.getContentManager().addContent(content);
//
//        // Print startup log
//        consoleService.log("Plugin Console Initialized.");
//    }
//}
