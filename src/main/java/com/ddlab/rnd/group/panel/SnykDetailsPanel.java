package com.ddlab.rnd.group.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class SnykDetailsPanel extends JPanel {
	private JTextField snykUriTxt;
	private JTextField snykTokentxt;

	public SnykDetailsPanel() {
		setBorder(new TitledBorder(null, "Snyk Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		GridBagLayout gbl_snykPanel = new GridBagLayout();
		gbl_snykPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_snykPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_snykPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_snykPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_snykPanel);

		JLabel snykUriLbl = new JLabel("Snyk Endpoint URI:");
		GridBagConstraints gbc_snykUriLbl = new GridBagConstraints();
		gbc_snykUriLbl.insets = new Insets(0, 0, 5, 5);
		gbc_snykUriLbl.anchor = GridBagConstraints.EAST;
		gbc_snykUriLbl.gridx = 0;
		gbc_snykUriLbl.gridy = 0;
		add(snykUriLbl, gbc_snykUriLbl);

		snykUriTxt = new JTextField();
		GridBagConstraints gbc_snykUriTxt = new GridBagConstraints();
		gbc_snykUriTxt.insets = new Insets(0, 0, 5, 5);
		gbc_snykUriTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_snykUriTxt.gridx = 1;
		gbc_snykUriTxt.gridy = 0;
		add(snykUriTxt, gbc_snykUriTxt);
		snykUriTxt.setColumns(10);

		JLabel snykTokenLbl = new JLabel("Snyk Token:");
		GridBagConstraints gbc_snykTokenLbl = new GridBagConstraints();
		gbc_snykTokenLbl.anchor = GridBagConstraints.EAST;
		gbc_snykTokenLbl.insets = new Insets(0, 0, 5, 5);
		gbc_snykTokenLbl.gridx = 0;
		gbc_snykTokenLbl.gridy = 1;
		add(snykTokenLbl, gbc_snykTokenLbl);

		snykTokentxt = new JTextField();
		GridBagConstraints gbc_snykTokentxt = new GridBagConstraints();
		gbc_snykTokentxt.insets = new Insets(0, 0, 5, 5);
		gbc_snykTokentxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_snykTokentxt.gridx = 1;
		gbc_snykTokentxt.gridy = 1;
		add(snykTokentxt, gbc_snykTokentxt);
		snykTokentxt.setColumns(10);

		JLabel orgNameLbl = new JLabel("Org Name:");
		GridBagConstraints gbc_orgNameLbl = new GridBagConstraints();
		gbc_orgNameLbl.anchor = GridBagConstraints.EAST;
		gbc_orgNameLbl.insets = new Insets(0, 0, 0, 5);
		gbc_orgNameLbl.gridx = 0;
		gbc_orgNameLbl.gridy = 2;
		add(orgNameLbl, gbc_orgNameLbl);

		JComboBox<String> orgNameComboBox = new JComboBox<String>();
		GridBagConstraints gbc_orgNameComboBox = new GridBagConstraints();
		gbc_orgNameComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_orgNameComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_orgNameComboBox.gridx = 1;
		gbc_orgNameComboBox.gridy = 2;
		add(orgNameComboBox, gbc_orgNameComboBox);

		JButton btnNewButton = new JButton("Get Orgs");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
	}

}
