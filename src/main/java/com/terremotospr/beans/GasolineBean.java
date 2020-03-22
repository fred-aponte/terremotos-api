package com.terremotospr.beans;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/14/2020
 */
public class GasolineBean extends BaseResourceBean{

    private TypeOfGasoline type;
    private Double octane;
    private Double size;

    public TypeOfGasoline getType() { return type; }

    public void setType(TypeOfGasoline type) { this.type = type; }

    public Double getOctane() { return octane; }

    public void setOctane(Double octane) { this.octane = octane; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }
}