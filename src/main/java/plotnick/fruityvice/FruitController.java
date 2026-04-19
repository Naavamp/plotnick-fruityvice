package plotnick.fruityvice;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FruitController
{

    private FruityService service;
    private JTextField searchField;
    private JLabel image;
    private JLabel family;
    private JLabel order;
    private JLabel genus;;
    private JLabel calories;
    private JLabel fat;
    private JLabel sugar;
    private JLabel carbs;
    private JLabel proteins;



    public FruitController(FruityService service, JTextField searchField, JLabel image, JLabel family, JLabel order, JLabel genus,
                           JLabel calories, JLabel fat, JLabel carbs, JLabel sugar, JLabel proteins)
    {
        this.service = service;
        this.searchField = searchField;
        this.image = image;
        this.family = family;
        this.order = order;
        this.genus = genus;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
        this.sugar = sugar;
        this.proteins = proteins;

    }

    public void doSearch()
    {
        String fruitName = searchField.getText();
        Disposable disposable = service.getFruit(fruitName)

                // tells Rx to request the data on a background Thread
                .subscribeOn(Schedulers.io())

                // tells Rx to handle the response on Swing's main Thread
                .observeOn(Schedulers.from(SwingUtilities::invokeLater))
                .subscribe(
                        (response) -> handleResponse(response),
                        Throwable::printStackTrace);


    }

    private void handleResponse(Fruit fruit)
    {
        family.setText(fruit.family());
        order.setText(fruit.order());
        genus.setText(fruit.genus());
        calories.setText(String.valueOf(String.valueOf(calories.getText())));
        fat.setText(String.valueOf(String.valueOf(fat.getText())));
        sugar.setText(String.valueOf(String.valueOf(sugar.getText())));
        carbs.setText(String.valueOf(String.valueOf(carbs.getText())));
        proteins.setText(String.valueOf(String.valueOf(proteins.getText())));

        try
        {
            ImageIcon imageIcon = new ImageIcon(new URL("https://picsum.photos/600/600"));
            image.setIcon(imageIcon);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

    }


}
