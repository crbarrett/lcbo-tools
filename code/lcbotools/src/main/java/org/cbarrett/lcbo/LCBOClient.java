/**
 *  Copyright 2011 Chris Barrett
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.cbarrett.lcbo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpVersion;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.cbarrett.lcbo.domain.Dataset;
import org.cbarrett.lcbo.domain.DatasetResponse;
import org.cbarrett.lcbo.domain.DatasetsResponse;
import org.cbarrett.lcbo.domain.Product;
import org.cbarrett.lcbo.domain.ProductResponse;
import org.cbarrett.lcbo.domain.ProductsResponse;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class LCBOClient {
    private final RestTemplate restTemplate;
    
    private static final String baseURL = "http://lcboapi.com/";
    private static final String datasetsServ = "datasets";
    private static final String productServ = "products";
     
    public LCBOClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        CommonsClientHttpRequestFactory factory = (CommonsClientHttpRequestFactory) restTemplate.getRequestFactory();
		HttpClient client = factory.getHttpClient();
        
        client.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
        client.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        client.getParams().setParameter("http.protocol.content-charset", "UTF-8");
        client.getParams().setParameter("http.useragent", "lcbo-tools");
    }
    
    public List<Dataset> getDatasetsFirstPage() {
        DatasetsResponse resp = restTemplate.getForObject(baseURL + "/" + datasetsServ, DatasetsResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());
       	return resp.getPageOfDatasets();  	
    }
    public Dataset getDatasetsByPage(int page) {
        DatasetResponse resp = restTemplate.getForObject(baseURL + "/" + datasetsServ + "/" + Integer.valueOf(page).toString(), DatasetResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());
       	return resp.getDataset();  	
    }

    public Dataset getDataset(long dataset) {
        DatasetResponse resp = restTemplate.getForObject(baseURL + "/" + datasetsServ + "/" + Long.valueOf(dataset).toString(), DatasetResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());
       	return resp.getDataset();  	
    }
    
    public DatasetsResponse getTodaysNewProducts() {
        DatasetsResponse resp = restTemplate.getForObject(baseURL + "/" + datasetsServ + "/1", DatasetsResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());
       	return resp;
    }
    public DatasetsResponse getTodaysRemovedProducts() {
        DatasetsResponse resp = restTemplate.getForObject(baseURL + "/" + datasetsServ + "/1", DatasetsResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());
       	return resp;
    }
    
    public List<Product> getProductsFirstPage() {        
        ProductsResponse resp = restTemplate.getForObject(baseURL + "/" + productServ, ProductsResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());

        return resp.getPageOfProducts();
    }

    public List<Product> getProductsByPage(int page) {
        ProductsResponse resp = restTemplate.getForObject(baseURL + "/" + productServ + "/" + Integer.valueOf(page).toString(), ProductsResponse.class);
        checkStatus(resp.getStatus(), resp.getMessage());

        return resp.getPageOfProducts();  	
    }
    
    public Product getProduct(String cspc) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("cspc", cspc);
        
        ProductResponse resp = restTemplate.getForObject(baseURL + "/" + productServ + "/{cspc}", ProductResponse.class, vars);
        checkStatus(resp.getStatus(), resp.getMessage());

        return resp.getProduct();
    }

    private void checkStatus(int status, String message) {
        if (!(status >= 200 && status < 300)) {
            new HttpException(((message != null) ? message : "Received error") + " : " + status);
        }
    }    
}
