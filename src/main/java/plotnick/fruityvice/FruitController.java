package plotnick.fruityvice;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FruitController
{

    private FruityService service;
    private JTextField searchBox;
    private JLabel family;
    private JLabel order;
    private JLabel genus;
    private JLabel calories;
    private JLabel fat;
    private JLabel sugar;
    private JLabel carbs;
    private JLabel proteins;
    private JLabel image;


    public FruitController(FruityService service, JTextField searchField, JLabel image, JLabel family, JLabel order, JLabel genus,
                           JLabel calories, JLabel fat, JLabel carbs, JLabel sugar, JLabel proteins)
    {
        this.service = service;
        searchBox = searchField;
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
        String fruitName = searchBox.getText();
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
        Nutritions nutritions = fruit.nutritions();
        calories.setText(String.valueOf(Double.parseDouble(calories.getText())));
        fat.setText(String.valueOf(Double.parseDouble(fat.getText())));
        sugar.setText(String.valueOf(Double.parseDouble(sugar.getText())));
        carbs.setText(String.valueOf(Double.parseDouble(carbs.getText())));
        proteins.setText(String.valueOf(Double.parseDouble(proteins.getText())));


        try
        {
            ImageIcon imageIcon = new ImageIcon(new URL("https://picsum.photos/800/600"));
            image.setIcon(imageIcon);
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }


}
