package com.tanmay.magicFormula;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class TestCsvProcessor {

    public static void main(String[] args) {
        CsvProcessor csvProcessor = new CsvProcessor();
        List<MagicFormulaStock> stockList = csvProcessor.process();
        //System.out.println(stockList);

        int i = 1;

        List<MagicFormulaStock> roceRevSortedList = stockList.stream()
                .sorted(comparing(MagicFormulaStock::getRoce, reverseOrder()))
                .collect(toList());
        for (int j = 1; j <= roceRevSortedList.size(); j++) {
            roceRevSortedList.get(j-1).setRoceRank(j);
        }

        List<MagicFormulaStock> roceRevPESortedList = roceRevSortedList.stream()
                .sorted(comparing(MagicFormulaStock::getPeRatio))
                .collect(toList());

        for (int j = 1; j <= roceRevPESortedList.size(); j++) {
            roceRevPESortedList.get(j-1).setPeRank(j);
        }

        for (int j = 1; j <= roceRevPESortedList.size(); j++) {
            roceRevPESortedList.get(j-1).setTotalRank(roceRevPESortedList.get(j-1).getPeRank() + roceRevPESortedList.get(j-1).getRoceRank());
        }

        List<MagicFormulaStock> totalList = roceRevSortedList.stream()
                .sorted(comparing(MagicFormulaStock::getTotalRank))
                .collect(toList());

        for(MagicFormulaStock stock : totalList){
            System.out.println(stock);
        }

    }

}
