package com.cescristorey.appmovie.retrofit;


import com.cescristorey.appmovie.ModeloPelicula.MovieFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/top_rated")
    Call<MovieFeed> getTopRated(@Query("api_key") String apiKey, @Query("language") String language);

    @GET("movie/popular")
    Call<MovieFeed> getMovieLatest(@Query("api_key") String apiKey, @Query("language") String language);


}