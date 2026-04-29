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
    private UnsplashService unsplashService;

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


    public FruitController(FruityService service, UnsplashService unsplashService, JTextField searchField, JLabel image,
                           JLabel family, JLabel order, JLabel genus,
                           JLabel calories, JLabel fat, JLabel carbs, JLabel sugar, JLabel proteins)
    {
        this.service = service;
        this.unsplashService = unsplashService;
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
        Disposable disposableFruit = service.getFruit(fruitName)
                // tells Rx to request the data on a background Thread
                .subscribeOn(Schedulers.io())

                // tells Rx to handle the response on Swing's main Thread
                .observeOn(Schedulers.from(SwingUtilities::invokeLater))
                .subscribe(
                        (this :: handleResponseFruit),
                        Throwable::printStackTrace);

        ApiKey apiKey = new ApiKey();
        String keyString = apiKey.get();

        Disposable disposableUnsplash = unsplashService.search(keyString, fruitName)
                // tells Rx to request the data on a background Thread
                .subscribeOn(Schedulers.io())

                // tells Rx to handle the response on Swing's main Thread
                .observeOn(Schedulers.from(SwingUtilities::invokeLater))
                .subscribe(
                        (this :: handleResponsePhotos),
                        Throwable::printStackTrace);

    }


    private void handleResponseFruit(Fruit fruit)
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




    }

    private void handleResponsePhotos(Photos photos)
    {
            try
            {
                ImageIcon icon = new ImageIcon(new URL(photos.results()[0].urls().small()));
                image.setIcon(icon);

            } catch (Exception e)
            {
                e.printStackTrace();
            }

    }
}

