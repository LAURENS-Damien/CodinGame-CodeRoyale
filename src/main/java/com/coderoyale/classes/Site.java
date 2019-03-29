package com.coderoyale.classes;

public class Site {

    private int siteId;
    private int xCoordinate;
    private int yCoordinate;
    private int radius;

    public Site(int siteId, int xCoordonate, int yCoordonate, int radius) {
        this.siteId = siteId;
        this.xCoordinate = xCoordonate;
        this.yCoordinate = yCoordonate;
        this.radius = radius;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getxCoordonate() {
        return xCoordinate;
    }

    public void setxCoordonate(int xCoordonate) {
        this.xCoordinate = xCoordonate;
    }

    public int getyCoordonate() {
        return yCoordinate;
    }

    public void setyCoordonate(int yCoordonate) {
        this.yCoordinate = yCoordonate;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
