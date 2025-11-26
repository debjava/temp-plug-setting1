package com.ddlab.rnd.tool.view;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewDataTooWindowFactory implements ToolWindowFactory {

    private JScrollPane scrollPane;

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {

//        List<MyDataRow> data = ...; // Populate your data

        // Column names
//        String[] columns = {"Column 1", "Column 2", "Column 3"};
//
//        // 4 rows × 3 columns (empty cells)
//        Object[][] rows = {
//                {"", "", ""},
//                {"", "", ""},
//                {"", "", ""},
//                {"", "", ""}
//        };
//
//        // Create table model
//        DefaultTableModel model = new DefaultTableModel(rows, columns);
//
//        // Create JTable
//        JTable table = new JTable(model);
////        JTable table = new JTable(new MyTableModel(data));
//        JScrollPane scrollPane = new JScrollPane(table);


        scrollPane = new JScrollPane();

        ContentFactory contentFactory = ContentFactory.getInstance();
        Content content = contentFactory.createContent(scrollPane, "", false);
        toolWindow.getContentManager().addContent(content);

        // Store reference to this factory for external updates
        project.putUserData(MyKeys.MY_TOOLWINDOW_FACTORY, this);
    }

    public void updateData(String text, JTable table) {
//        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
    }
}
