/*
 * Created by JFormDesigner on Thu Nov 01 14:46:52 GMT 2018
 */

package gui;

import org.osbot.rs07.script.MethodProvider;
import potions.*;
import settings.Settings;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class Gui {

    private Settings settings;
    private MethodProvider api;

    public Gui(Settings settings, MethodProvider api) {
        this.settings = settings;
        this.api = api;
        initComponents();
    }

    public void main() {
        Gui gui = new Gui(this.settings, this.api);
        gui.potion.setModel(new DefaultComboBoxModel<>(new String[]{
                "Absorption",
                "Overload",
                "Prayer",
                "Super Restore",
                "Super Combat",
                "Combat",
                "Super Attack",
                "Super Strength",
                "Super Defence",
                "Ranging",
                "Magic"
        }));

        DefaultTableModel model = new DefaultTableModel() {
            String[] task = {"Potion", "Priority"};

            @Override
            public int getColumnCount() {
                return task.length;
            }

            @Override
            public String getColumnName(int index) {
                return task[index];
            }
        };
        gui.potionsTable.setModel(model);
        gui.frame.setVisible(true);
    }

    private void button1ActionPerformed(ActionEvent e) {
        ArrayList<Potion> potions = new ArrayList<>();
        for (int i = 0; i < potionsTable.getRowCount(); i++) {
            String potionName = (String) potionsTable.getModel().getValueAt(i, 0);
            int priority = (int) potionsTable.getModel().getValueAt(i, 1);
            Potion potion = null;
            switch (potionName) {
                case "Absorption":
                    potion = new Absorption(api, priority);
                    break;
                case "Overload":
                    potion = new Overload(api, priority);
                    break;
                case "Prayer":
                    potion = new Prayer(api, priority);
                    break;
                case "Super Restore":
                    potion = new SuperRestore(api, priority);
                    break;
                case "Super Combat":
                    potion = new SuperCombat(api, priority);
                    break;
                case "Combat":
                    potion = new Combat(api, priority);
                    break;
                case "Super Attack":
                    potion = new SuperAttack(api, priority);
                    break;
                case "Super Strength":
                    potion = new SuperStrength(api, priority);
                    break;
                case "Super Defence":
                    potion = new SuperDefence(api, priority);
                    break;
                case "Ranging":
                    potion = new Ranging(api, priority);
                    break;
                case "Magic":
                    potion = new Magic(api, priority);
                    break;
            }
            potions.add(potion);
        }
        potions.sort(Comparator.comparing(Potion::getPriority));
        settings.setPotionsToManage(potions);
        settings.setStarted(true);
        this.frame.dispose();
        this.newPotionFrame.dispose();
    }

    private void addPotionActionPerformed(ActionEvent e) {
        this.newPotionFrame.setVisible(true);
    }

    private void removePotionActionPerformed(ActionEvent e) {
        ((DefaultTableModel)potionsTable.getModel()).removeRow(potionsTable.getSelectedRow());
    }

    private void savePotionActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) potionsTable.getModel();
        model.addRow(new Object[]{potion.getSelectedItem(), potionPriority.getValue()});
        newPotionFrame.dispose();
    }

    private void cancelPotionActionPerformed(ActionEvent e) {
        this.newPotionFrame.dispose();
    }

    private void addTaskActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void saveTaskActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void cancelTaskActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        frame = new JFrame();
        main = new JPanel();
        panel4 = new JPanel();
        hSpacer8 = new JPanel(null);
        scrollPane1 = new JScrollPane();
        potionsTable = new JTable();
        panel8 = new JPanel();
        addPotion = new JButton();
        removePotion = new JButton();
        button1 = new JButton();
        newPotionFrame = new JFrame();
        newTaskContent = new JPanel();
        label6 = new JLabel();
        potion = new JComboBox<>();
        label7 = new JLabel();
        potionPriority = new JSpinner();
        savePotion = new JButton();
        cancelPotion = new JButton();

        //======== frame ========
        {
            frame.setTitle("Ragnar's Sipper");
            Container frameContentPane = frame.getContentPane();
            frameContentPane.setLayout(new FlowLayout());

            //======== main ========
            {
                main.setLayout(new FlowLayout());

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder(new EmptyBorder(15, 15, 15, 15), "Potions", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
                    panel4.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {379, 0};
                    ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
                    ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                    ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
                    panel4.add(hSpacer8, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 0), 0, 0));

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setPreferredSize(new Dimension(454, 418));
                        scrollPane1.setViewportView(potionsTable);
                    }
                    panel4.add(scrollPane1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 0), 0, 0));

                    //======== panel8 ========
                    {
                        panel8.setLayout(new FlowLayout());

                        //---- addPotion ----
                        addPotion.setText("Add Potion");
                        addPotion.addActionListener(e -> {
			addTaskActionPerformed(e);
			addPotionActionPerformed(e);
			addPotionActionPerformed(e);
		});
                        panel8.add(addPotion);

                        //---- removePotion ----
                        removePotion.setText("Remove Potion");
                        removePotion.addActionListener(e -> {
			addTaskActionPerformed(e);
			removePotionActionPerformed(e);
		});
                        panel8.add(removePotion);
                    }
                    panel4.add(panel8, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 0), 0, 0));

                    //---- button1 ----
                    button1.setText("START");
                    button1.addActionListener(e -> button1ActionPerformed(e));
                    panel4.add(button1, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                main.add(panel4);
            }
            frameContentPane.add(main);
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }

        //======== newPotionFrame ========
        {
            newPotionFrame.setTitle("Add Potion");
            Container newPotionFrameContentPane = newPotionFrame.getContentPane();
            newPotionFrameContentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)newPotionFrameContentPane.getLayout()).columnWidths = new int[] {258, 0};
            ((GridBagLayout)newPotionFrameContentPane.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)newPotionFrameContentPane.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
            ((GridBagLayout)newPotionFrameContentPane.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

            //======== newTaskContent ========
            {
                newTaskContent.setBorder(new EmptyBorder(25, 25, 25, 25));
                newTaskContent.setLayout(new GridBagLayout());
                ((GridBagLayout)newTaskContent.getLayout()).columnWidths = new int[] {0, 138, 0};
                ((GridBagLayout)newTaskContent.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                ((GridBagLayout)newTaskContent.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)newTaskContent.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                //---- label6 ----
                label6.setText("Potion:");
                newTaskContent.add(label6, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- potion ----
                potion.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Attack",
                    "Strength",
                    "Defence"
                }));
                newTaskContent.add(potion, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label7 ----
                label7.setText("Priority");
                newTaskContent.add(label7, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- potionPriority ----
                potionPriority.setModel(new SpinnerNumberModel(1, 1, 99, 1));
                newTaskContent.add(potionPriority, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- savePotion ----
                savePotion.setText("Add");
                savePotion.addActionListener(e -> {
			saveTaskActionPerformed(e);
			savePotionActionPerformed(e);
		});
                newTaskContent.add(savePotion, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelPotion ----
                cancelPotion.setText("Cancel");
                cancelPotion.addActionListener(e -> {
			cancelTaskActionPerformed(e);
			cancelPotionActionPerformed(e);
		});
                newTaskContent.add(cancelPotion, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            newPotionFrameContentPane.add(newTaskContent, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
            newPotionFrame.pack();
            newPotionFrame.setLocationRelativeTo(null);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JFrame frame;
    private JPanel main;
    private JPanel panel4;
    private JPanel hSpacer8;
    private JScrollPane scrollPane1;
    private JTable potionsTable;
    private JPanel panel8;
    private JButton addPotion;
    private JButton removePotion;
    private JButton button1;
    private JFrame newPotionFrame;
    private JPanel newTaskContent;
    private JLabel label6;
    private JComboBox<String> potion;
    private JLabel label7;
    private JSpinner potionPriority;
    private JButton savePotion;
    private JButton cancelPotion;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
