package plotnick.fruityvice;

import plotnick.fruityvice.unsplash.UnsplashService;
import plotnick.fruityvice.unsplash.UnsplashServiceFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FruitFrame extends JFrame
{
    public FruitFrame()
    {
        setSize(1000, 1000);
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

        JButton button = new JButton("Search");


        FruityService service = new FruityServiceFactory().create();
        UnsplashService unsplashService = new UnsplashServiceFactory().create();

        FruitController controller = new FruitController(service, unsplashService, searchBox, pic, familyField,
                                                         orderField, genusField, caloriesField, fatField,
                                                         carbsField, sugarField, proteinField);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                controller.doSearch();


            }
        });

        GridBagConstraints constraints;
        
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTH;
        add(searchBox, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.NORTH;
        add(button, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 8;
        constraints.anchor = GridBagConstraints.NORTH;
        add(pic, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        add(familyLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 1;
        constraints.ipadx = 10;

        constraints.anchor = GridBagConstraints.NORTH;
        add(familyField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.ipadx = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        add(orderLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(orderField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(genusLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(genusField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(caloriesLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 4;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(caloriesField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 5;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(fatLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 5;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(fatField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 6;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(sugarLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 6;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(sugarField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(carbsLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 7;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(carbsField, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 8;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(proteinLabel, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 3;
        constraints.gridy = 8;
        constraints.ipadx = 10;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(proteinField, constraints);





    }

    public static void main(String[] args)
    {
        FruitFrame frame = new FruitFrame();
        frame.setVisible(true);
    }

}
