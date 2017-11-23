package by.tc.parser_task.entity;

import java.io.Serializable;

/**
 * Created by Y50-70 on 22.11.2017.
 */
public class Gem implements Serializable{
    private String name;
    private String preciousness;
    private VisualParameters visualParameters;
    private float value;
    private int id;

    private class VisualParameters{
        private String color;
        private String shine;
        private String transparency;

        private VisualParameters(){}

        private String getColor() {
            return color;
        }

        private void setColor(String color) {
            this.color = color;
        }

        private String getShine() {
            return shine;
        }

        private void setShine(String shine) {
            this.shine = shine;
        }

        private String getTransparency() {
            return transparency;
        }

        private void setTransparency(String transparency) {
            this.transparency = transparency;
        }
    }

    public Gem(){
        visualParameters = new VisualParameters();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public String getColor(){
        return visualParameters.getColor();
    }
    public void setColor(String color){
        visualParameters.setColor(color);
    }
    public String getShine(){
        return visualParameters.getShine();
    }
    public void setShine(String shine){
        visualParameters.setShine(shine);
    }
    public void setTransparency(String transparency){
        visualParameters.setTransparency(transparency);
    }
    public String getTransparency(){
        return visualParameters.getTransparency();
    }
    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
