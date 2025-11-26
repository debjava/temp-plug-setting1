package com.ddlab.rnd.console;

import com.intellij.openapi.project.Project;
    import com.intellij.openapi.wm.ToolWindow;
    import com.intellij.openapi.wm.ToolWindowFactory;
    import com.intellij.ui.content.Content;
    import com.intellij.ui.content.ContentFactory;
    import com.intellij.execution.ui.ConsoleView;
    import com.intellij.execution.ui.ConsoleViewContentType;
    import com.intellij.execution.filters.TextConsoleBuilderFactory;
    import org.jetbrains.annotations.NotNull;

    public class MyConsoleToolWindowFactory implements ToolWindowFactory {

        @Override
        public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
            // Create a ConsoleView
            ConsoleView consoleView = TextConsoleBuilderFactory.getInstance().createBuilder(project).getConsole();

            // Create content for the tool window
            ContentFactory contentFactory = ContentFactory.getInstance();
            Content content = contentFactory.createContent(consoleView.getComponent(), "Console Output", false);
            toolWindow.getContentManager().addContent(content);

            // Set to Global Plugin Manager
            MyPluginConsoleManager.setConsoleView(consoleView);

            // You can print initial messages here
            consoleView.print("Welcome to My Plugin Console!\n", ConsoleViewContentType.NORMAL_OUTPUT);
        }
    }