package com.project.code.Service;


import org.springframework.stereotype.Service;

import com.project.code.Model.Inventory;
import com.project.code.Model.Product;
import com.project.code.Repo.InventoryRepository;
import com.project.code.Repo.ProductRepository;

@Service
public class ServiceClass {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;

    public ServiceClass(InventoryRepository inventoryRepository, ProductRepository productRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
    }

    // validateInventory checks for an existing inventory entry using product and store IDs
    public boolean validateInventory(Long productID, Long storeID) {
        Inventory result = inventoryRepository.findByProductIdandStoreId(productID, storeID);
        if (result != null) {
            return false;
        }
        return true;
    }



    public boolean validateInventory(Inventory inventory) {
        Inventory result = inventoryRepository.findByProductIdandStoreId(inventory.getProduct().getId(), inventory.getStore().getId());
        if (result != null) {
            return false;
        }
        return true;
    }

    public boolean validateProduct(Product product) {
        Product result = productRepository.findByName(product.getName());
        if (result != null) {
            return false;
        }
        return true;
    }

    public boolean validateProductId(long id) {
        Product result = productRepository.findByid(id);
        System.out.println(result);
        if (result == null) {
            return false;
        }
        return true;
    }

    public Inventory getInventoryId(Inventory inventory) {
        Inventory result = inventoryRepository.findByProductIdandStoreId(inventory.getProduct().getId(), inventory.getStore().getId());

        return result;
    }

    // getInventoryId queries inventory using product and store IDs and returns the correct record.
    public Inventory getInventoryId(Long productID, Long storeID) {
        Inventory result = inventoryRepository.findByProductIdandStoreId(productID, storeID);

        return result;
    }

// 1. **validateInventory Method**:
//    - Checks if an inventory record exists for a given product and store combination.
//    - Parameters: `Inventory inventory`
//    - Return Type: `boolean` (Returns `false` if inventory exists, otherwise `true`)

// 2. **validateProduct Method**:
//    - Checks if a product exists by its name.
//    - Parameters: `Product product`
//    - Return Type: `boolean` (Returns `false` if a product with the same name exists, otherwise `true`)

// 3. **ValidateProductId Method**:
//    - Checks if a product exists by its ID.
//    - Parameters: `long id`
//    - Return Type: `boolean` (Returns `false` if the product does not exist with the given ID, otherwise `true`)

// 4. **getInventoryId Method**:
//    - Fetches the inventory record for a given product and store combination.
//    - Parameters: `Inventory inventory`
//    - Return Type: `Inventory` (Returns the inventory record for the product-store combination)

}
