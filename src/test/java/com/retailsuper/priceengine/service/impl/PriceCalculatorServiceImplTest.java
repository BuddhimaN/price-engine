package com.retailsuper.priceengine.service.impl;

import com.retailsuper.priceengine.dto.ProductDTO;
import com.retailsuper.priceengine.repository.ProductRepository;
import com.retailsuper.priceengine.service.ProductService;
import org.assertj.core.api.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class PriceCalculatorServiceImplTest {


    @Test
    public void calculatePrice() {
    }
}