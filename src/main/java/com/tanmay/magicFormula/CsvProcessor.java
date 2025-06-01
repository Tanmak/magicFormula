package com.tanmay.magicFormula;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The CSV file should have following format on Tickertape page table:
 * | Name | Sub-Sector | Market Cap | PE Ratio | ROCE |
 */
public class CsvProcessor {

    public List<MagicFormulaStock> process() {

        List<MagicFormulaStock> stockList = new ArrayList<>();

        Path path = Paths.get("/Users/tanmaydhar/Documents/Investment/Stock/Magic Formula/Magic_formula.csv");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String currentline = reader.readLine();

            while ((currentline = reader.readLine()) != null) {
                String[] str = currentline.split(",");
                if (str.length == 6) {
                    MagicFormulaStock stock = new MagicFormulaStock();
//                    System.out.println(Arrays.toString(str));
                    stock.setStockName(str[0]);
                    stock.setTicker(str[1]);
                    str[2] = str[2].replace("\"", "");
                    stock.setSector(str[2]);

                    str[3] = str[3].replace("\"", "");
                    if (str[3] == null || str[3].trim().equals("0") || str[3].trim().equals("")) {
                        continue;
                    } else {
                        stock.setMarketCap(new BigDecimal(str[3]));
                    }

                    str[4] = str[4].replace("\"", "");
                    if (str[4] == null || str[4].trim().equals("0") || str[4].trim().equals(" ")) {
                        continue;
                    } else {
                        stock.setPeRatio(new BigDecimal(str[4]));
                    }

                    str[5] = str[5].replace("\"", "");
                    if (str[5] == null || str[5].trim().equals("0") || str[5].trim().equals(" ")) {
                        continue;
                    } else {
                        stock.setRoce(new BigDecimal(str[5]));
                    }

                    stockList.add(stock);
                } else {
                    System.out.println("Exception for : " + Arrays.toString(str));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stockList;

    }
}