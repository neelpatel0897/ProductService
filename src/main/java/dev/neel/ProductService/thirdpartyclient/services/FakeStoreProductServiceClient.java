package dev.neel.ProductService.thirdpartyclient.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import dev.neel.ProductService.dtos.GenericProductDto;
import dev.neel.ProductService.exceptions.NotFoundException;
import dev.neel.ProductService.thirdpartyclient.dtos.FakeStoreProductDto;


    // This will work as a client for the third party API
//Also this will work as wrapper for the third party API


@Service("FakeStoreProductServiceClient")
public class FakeStoreProductServiceClient implements ThirdPartyClientService{




    // RestTemplate is the library which allowes you to call third party API and get a data and work on it
    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductRequestURL;
    private String productsRequestBaseURL;

  //  private String fakeStoreApiUrl;
  //  private String fakeStoreProductsApiPath;

    FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}")String  fakeStoreApiUrl,@Value("${fakestore.api.path.product}") String fakeStoreProductsApiPath){
        this.restTemplateBuilder=restTemplateBuilder;
        this.productsRequestBaseURL=fakeStoreApiUrl+fakeStoreProductsApiPath;
        this.specificProductRequestURL=fakeStoreApiUrl+fakeStoreProductsApiPath+"/{id}";
    }





    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity(specificProductRequestURL, FakeStoreProductDto.class,id);
        //response.getStatusCode()

        FakeStoreProductDto fakeStoreProductDto= response.getBody();
        if(fakeStoreProductDto==null){
            throw new NotFoundException("Product with id "+id+" doesn't exsit.");
        }


        return fakeStoreProductDto;




    }


    public FakeStoreProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> respose=restTemplate.postForEntity(productsRequestBaseURL,product,FakeStoreProductDto.class);
        return respose.getBody();
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> response=restTemplate.getForEntity(productsRequestBaseURL,FakeStoreProductDto[].class);



        return Arrays.stream(response.getBody()).toList();
    }


    public FakeStoreProductDto deleteProductById(Long id){
        RestTemplate restTemplate=restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> response= restTemplate.execute(specificProductRequestURL, HttpMethod.DELETE, requestCallback, responseExtractor, id);


        FakeStoreProductDto fakeStoreProductDto= response.getBody();



        return fakeStoreProductDto;
    }


    public FakeStoreProductDto updateProductById(GenericProductDto product,Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response=restTemplate.execute(specificProductRequestURL, HttpMethod.PUT, requestCallback, responseExtractor, id);

        return response.getBody();
    }
}
