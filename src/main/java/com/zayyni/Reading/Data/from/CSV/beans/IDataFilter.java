package com.zayyni.Reading.Data.from.CSV.beans;

import com.zayyni.Reading.Data.from.CSV.model.Product;

import java.util.List;

public interface IDataFilter {

    public List<Product> filterProducts(List<Product> productsList);

}
