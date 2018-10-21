package com.test.builder;

/**
 * 宇宙飞船
 */
public class AirShip {

    private String arbitaModule; //轨道舱

    private String engine;//引擎

    private String escapeTower;//逃逸塔

    public String getArbitaModule() {
        return arbitaModule;
    }

    public void setArbitaModule(String arbitaModule) {
        this.arbitaModule = arbitaModule;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(String escapeTower) {
        this.escapeTower = escapeTower;
    }
}
