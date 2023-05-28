package com.zayyni.Reading.Data.from.CSV.beans;

import com.zayyni.Reading.Data.from.CSV.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataFilterImpl implements IDataFilter{

    @Override
    public List<Product> filterProducts(List<Product> productsList) {

        return productsList.stream()
                .filter(p -> p.getProductPrice()>5000.00)
                .collect(Collectors.toList());

    }
}
