package com.tanmay.magicFormula;

import java.math.BigDecimal;

public class MagicFormulaStock {

    private String stockName;
    private String ticker;
    private String sector;
    private BigDecimal marketCap;
    private BigDecimal peRatio;
    private BigDecimal roce;
    private int roceRank;
    private int peRank;
    private int totalRank;

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    public BigDecimal getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(BigDecimal peRatio) {
        this.peRatio = peRatio;
    }

    public BigDecimal getRoce() {
        return roce;
    }

    public void setRoce(BigDecimal roce) {
        this.roce = roce;
    }

    public int getRoceRank() {
        return roceRank;
    }

    public void setRoceRank(int roceRank) {
        this.roceRank = roceRank;
    }

    public int getPeRank() {
        return peRank;
    }

    public void setPeRank(int peRank) {
        this.peRank = peRank;
    }

    public int getTotalRank() {
        return totalRank;
    }

    public void setTotalRank(int totalRank) {
        this.totalRank = totalRank;
    }

    @Override
    public String toString() {
        return "MagicFormulaStock{" +
                "stockName='" + stockName + '\'' +
                ", ticker='" + ticker + '\'' +
                ", sector='" + sector + '\'' +
                ", marketCap=" + marketCap +
                ", peRatio=" + peRatio +
                ", roce=" + roce +
                ", roceRank=" + roceRank +
                ", peRank=" + peRank +
                ", totalRank=" + totalRank +
                '}';
    }
}
