package com.coderoyale.classes;

public class Site {

    private int siteId;
    private int xCoordinate;
    private int yCoordinate;
    private int radius;

    public Site(int siteId, int xCoordinate, int yCoordonate, int radius) {
        this.siteId = siteId;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordonate;
        this.radius = radius;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
