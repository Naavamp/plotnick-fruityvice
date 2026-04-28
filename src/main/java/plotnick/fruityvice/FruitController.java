package plotnick.fruityvice;

import com.andrewoid.apikeys.ApiKey;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import plotnick.fruityvice.unsplash.*;

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
    private JLabel genus;
    private JLabel calories;
    private JLabel fat;
    private JLabel sugar;
    private JLabel carbs;
    private JLabel proteins;


    public FruitController(FruityService service, JTextField searchField, JLabel image,
                           JLabel family, JLabel order, JLabel genus,
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
        calories.setText(String.valueOf(fruit.nutritions().calories()));
        fat.setText(String.valueOf(fruit.nutritions().fat()));
        sugar.setText(String.valueOf(fruit.nutritions().sugar()));
        carbs.setText(String.valueOf(fruit.nutritions().carbohydrates()));
        proteins.setText(String.valueOf(fruit.nutritions().protein()));

        String fruitName = searchField.getText();
        fetchImage(fruitName);



    }

    private void fetchImage(String query)
    {
            try
            {
                UnsplashService unsplash = new UnsplashServiceFactory().create();
                Single<Photos> photos = unsplash.search(new ApiKey().get(), query);

                String urlString = ;
                ImageIcon icon = new ImageIcon(new URL(urlString));

                image.setIcon(icon);

            } catch (Exception e)
            {
                e.printStackTrace();
            }

    }
}

