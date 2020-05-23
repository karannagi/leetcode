package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> finalResult = new ArrayList<>();
        if (products == null || products.length == 0 || searchWord == null || searchWord.isEmpty()) {
            return finalResult;
        }
        Arrays.sort(products);
        // create productList for the products
        List<String> possibleProductList = new ArrayList<>();
        for(String product: products) {
            possibleProductList.add(product);
        }
        for(int i=0; i<searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            // check in possible product list and filter products
            List<String> filteredList = new ArrayList<>();
            for(String product: possibleProductList) {
                if(i < product.length() && c == product.charAt(i)) {
                        filteredList.add(product);
                }
            }
            // add only atmost three items to the intermediate result
            List<String> intermediateResult = new ArrayList<>();
            for(int j=0; j < 3 && j<filteredList.size(); j++) {
                intermediateResult.add(filteredList.get(j));
            }
            
            // add intermediateResult to the final result
            finalResult.add(intermediateResult);
            
            // change the possibleProductList to the already filtered list
            possibleProductList = filteredList;
        }
        return finalResult;
    }
    }

