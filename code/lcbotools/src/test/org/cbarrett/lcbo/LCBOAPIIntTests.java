package org.cbarrett.lcbo;

import java.util.List;

import org.cbarrett.scotchservices.lcbo.domain.Dataset;
import org.cbarrett.scotchservices.lcbo.domain.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/lcborest-beans.xml"})
public class LCBOAPIIntTests {

    @Autowired
    private ApplicationContext applicationContext;
        
    // Generic API Tests
    //Datasets	/datasets
    @Test
	public void testDatasetsAPI() throws Exception {    	
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        List<Dataset> dss = lcbo.getDatasetsFirstPage();

        Dataset ds = dss.get(0);
        
        //check result
        Assert.notNull(ds, "ain't null");
        Assert.isTrue(!(ds.getCsvDump().equals(null)), "has dump file");

        //output fun
        System.out.println("Dataset : " + ds.getId());
        System.out.println("   # of added products : " + ds.getAddedProductIds().size());
    }

    //Dataset	/datasets/:dataset_id
    @Test
	public void testDatasetAPI() throws Exception {
    	int fetchId = 1;
    	
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Dataset ds = lcbo.getDataset(fetchId);
        
        //check result
        Assert.notNull(ds, "ain't null");
        Assert.isTrue(fetchId == ds.getId(), "is what I asked for");
        Assert.isTrue(!(ds.getCsvDump().equals(null)), "has dump file");

        //output fun
        System.out.println("Dataset : " + ds.getId());
        System.out.println("   # of added products : " + ds.getAddedProductIds().size());
    }
    
    //Products	/products
    @Test
	public void testProductsAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        List<Product> products = lcbo.getProductsFirstPage();

        Product pro = products.get(0);
        
        //check result
        Assert.notNull(pro, "ain't null");
 
        //output fun        
        System.out.println("Product : " + pro.getProductNo());
        System.out.println("UpdatedAt : " + pro.getUpdatedAt());
    }

    //Product	/products/:product_id
    @Test
	public void testProductAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Product product = lcbo.getProduct("211730");

        System.out.println("Product : " + product.getProductNo());
        System.out.println("UpdatedAt : " + product.getUpdatedAt());
    }

    //Products at Store	/stores/:store_id/products
    @Test
	public void testProductsAtStoreAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Product product = lcbo.getProduct("211730");

        System.out.println("Product : " + product.getProductNo());
        System.out.println("UpdatedAt : " + product.getUpdatedAt());
    }
    
    //Stores with Product	/products/:product_id/stores
    @Test
	public void testStoresWithProductAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Product product = lcbo.getProduct("211730");

        System.out.println("Product : " + product.getProductNo());
        System.out.println("UpdatedAt : " + product.getUpdatedAt());
    }
    
    //Stores	/stores
    @Test
	public void testStoresAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Product product = lcbo.getProduct("211730");

        System.out.println("Product : " + product.getProductNo());
        System.out.println("UpdatedAt : " + product.getUpdatedAt());
    }
    
    //Store	/stores/:store_id
    @Test
	public void testStoreAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Product product = lcbo.getProduct("211730");

        System.out.println("Product : " + product.getProductNo());
        System.out.println("UpdatedAt : " + product.getUpdatedAt());
    }

    //Inventories	/inventories
    @Test
	public void testInventoriesAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Product product = lcbo.getProduct("211730");

        System.out.println("Product : " + product.getProductNo());
        System.out.println("UpdatedAt : " + product.getUpdatedAt());
    }

    //Inventory	/stores/:store_id/products/:product_id/inventory
    @Test
	public void testInventoryByProductAtStoreAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Product product = lcbo.getProduct("211730");

        System.out.println("Product : " + product.getProductNo());
        System.out.println("UpdatedAt : " + product.getUpdatedAt());
    }
    
    //Product Inventories	/products/:product_id/inventories
    @Test
	public void testProductInventoriesAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Product product = lcbo.getProduct("211730");

        System.out.println("Product : " + product.getProductNo());
        System.out.println("UpdatedAt : " + product.getUpdatedAt());
    }

    //Product History	/products/:product_id/history
    @Test
	public void testProductHistoryAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Product product = lcbo.getProduct("211730");

        System.out.println("Product : " + product.getProductNo());
        System.out.println("UpdatedAt : " + product.getUpdatedAt());
    }

    //Store History	/stores/:store_id/history
    @Test
	public void testStoreHistoryAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Product product = lcbo.getProduct("211730");

        System.out.println("Product : " + product.getProductNo());
        System.out.println("UpdatedAt : " + product.getUpdatedAt());
    }

    //Inventory History	/stores/:store_id/products/:product_id/history
    // http://lcboapi.com/docs/inventory-history
    @Test
	public void testInventoryHistoryByProductAtStoreAPI() throws Exception {
        LCBOClient lcbo = applicationContext.getBean(LCBOClient.class);
        Product product = lcbo.getProduct("211730");

        System.out.println("Product : " + product.getProductNo());
        System.out.println("UpdatedAt : " + product.getUpdatedAt());
    }
 }