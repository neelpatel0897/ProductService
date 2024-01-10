package dev.neel.ProductService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import dev.neel.ProductService.dtos.GenericProductDto;
import dev.neel.ProductService.exceptions.NotFoundException;
import dev.neel.ProductService.thirdpartyclient.dtos.FakeStoreProductDto;

import dev.neel.ProductService.thirdpartyclient.services.ThirdPartyClientService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    
    ThirdPartyClientService thirdPartyClientService;
    /**
     *
     *
     */
    public FakeStoreProductService(@Qualifier("FakeStoreProductServiceClient") ThirdPartyClientService thirdPartyClientService){
        this.thirdPartyClientService=thirdPartyClientService;
    }

    private GenericProductDto convertFakeStroreProductintoGenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product=new GenericProductDto();

        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setId(fakeStoreProductDto.getId());

        return product;

    }



    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {

        return convertFakeStroreProductintoGenericProduct(thirdPartyClientService.getProductById(id));

    }


    public GenericProductDto createProduct(GenericProductDto product){

        return convertFakeStroreProductintoGenericProduct(thirdPartyClientService.createProduct(product));
    }

    @Override
    public List<GenericProductDto> getAllProducts() throws NotFoundException{

        List<FakeStoreProductDto> fakeStoreProductDtoList= thirdPartyClientService.getAllProducts();

        List<GenericProductDto> genericProductDtoList=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtoList){
            genericProductDtoList.add(convertFakeStroreProductintoGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtoList;
    }

    @Override
    public GenericProductDto deleteProductById(Long id){

        return convertFakeStroreProductintoGenericProduct(thirdPartyClientService.deleteProductById(id));
    }

    @Override
    public GenericProductDto updateProductById(GenericProductDto product,Long id) {
       return convertFakeStroreProductintoGenericProduct(thirdPartyClientService.updateProductById(product, id));
    }
}