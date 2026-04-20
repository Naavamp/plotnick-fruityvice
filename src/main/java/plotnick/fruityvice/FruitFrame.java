package plotnick.fruityvice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FruitFrame extends JFrame
{
    public FruitFrame()
    {
        setSize(500, 500);
        setTitle("Fruit");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        final JLabel pic = new JLabel();

        final JTextField searchBox = new JTextField("Strawberry");

        final JLabel familyLabel = new JLabel("Family");
        final JLabel familyField = new JLabel(" ");

        final JLabel orderLabel = new JLabel("Order");
        final JLabel orderField = new JLabel(" ");

        final JLabel genusLabel = new JLabel("Genus");
        final JLabel genusField = new JLabel(" ");

        final JLabel caloriesLabel = new JLabel("Calories");
        final JLabel caloriesField = new JLabel(" ");

        final JLabel fatLabel = new JLabel("Fat");
        final JLabel fatField = new JLabel(" ");

        final JLabel sugarLabel = new JLabel("Sugar");
        final JLabel sugarField = new JLabel(" ");

        final JLabel carbsLabel = new JLabel("Carbs");
        final JLabel carbsField = new JLabel(" ");

        final JLabel proteinLabel = new JLabel("Protein");
        final JLabel proteinField = new JLabel(" ");

        final JLabel carbLabel = new JLabel("Protein");
        final JLabel carbField = new JLabel(" ");

        JButton button = new JButton("Search");


        FruityService service = new FruityServiceFactory().create();

        FruitController controller = new FruitController(service, searchBox, pic, familyField, orderField, genusField,
                                                caloriesField, fatField, carbField, sugarField, proteinField);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.doSearch();


            }
        });

        GridBagConstraints constraints;

        // Row 0 — search box
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(searchBox, constraints);



// Row 0 — button
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.EAST;
        add(button, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(pic, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(familyLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(familyField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(orderLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(orderField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(genusLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(genusField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(caloriesLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(caloriesField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(fatLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(fatField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(sugarLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 6;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(sugarField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(carbsLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(carbsField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 8;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(proteinLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 8;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(proteinField, constraints);





    }

    public static void main(String[] args)
    {
        FruitFrame frame = new FruitFrame();
        frame.setVisible(true);
    }

}
