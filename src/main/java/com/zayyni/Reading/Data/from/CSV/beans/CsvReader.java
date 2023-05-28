package com.zayyni.Reading.Data.from.CSV.beans;

import com.zayyni.Reading.Data.from.CSV.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvReader{

    private IDataFilter dataFilter;

    @Autowired
    public CsvReader(IDataFilter dataFilter) {
        this.dataFilter = dataFilter;
    }

    public List<Product> readAndFilterProductsData() throws IOException {

        List<Product> pList= new ArrayList<Product>();

        FileReader fr = new FileReader(new File("products.txt"));

        BufferedReader br = new BufferedReader(fr);

        String lineData = br.readLine();

        while (lineData != null){
             String[] split =lineData.split(",");
              String pId=split[0];
              String pName=split[1];
              String price=split[2];

              Product p = new Product();
              p.setProductId(Integer.parseInt(pId));
              p.setProductName(pName);
              p.setProductPrice(Double.parseDouble(price));

              pList.add(p);

              lineData = br.readLine();
        }

        br.close();

        return dataFilter.filterProducts(pList);
    }
}
