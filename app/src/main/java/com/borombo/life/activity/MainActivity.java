package com.borombo.life.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.borombo.life.R;
import com.borombo.life.model.Post;
import com.borombo.life.service.LifeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<List<Post>> operationsService = LifeService.service.listPosts();

        operationsService.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> list = response.body();
                //Récupère chaque objets des ressources de chaque posts
                for (Post post : list) {
                    post.initRessources();
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {}
        });

    }
}