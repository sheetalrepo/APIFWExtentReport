package com.pojos.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 
 * @Author Sheetal Singh
 * @ProdBug https://www.youtube.com/c/sheetalsingh23/videos
 */
@Getter
@Setter
@ToString
public class StarshipPlaceholder{
    public String name;
    public String model;
    public String manufacturer;
    public String cost_in_credits;
    public String length;
    public String max_atmosphering_speed;
    public String crew;
    public String passengers;
    public String cargo_capacity;
    public String consumables;
    public String hyperdrive_rating;
    @JsonProperty("MGLT")
    public String mGLT;
    public String starship_class;
    public ArrayList<Object> pilots;
    public ArrayList<String> films;
    public Date created;
    public Date edited;
    public String url;
}