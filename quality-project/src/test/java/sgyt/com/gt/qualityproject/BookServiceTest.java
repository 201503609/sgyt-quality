/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgyt.com.gt.qualityproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.*;
import sgyt.com.gt.qualityproject.repositories.BookRepository;
import sgyt.com.gt.qualityproject.services.BookService;

/**
 *
 * @author diego
 */
public class BookServiceTest {
    
    
    @InjectMocks
    private BookService svc;
    
    @Mock
    private BookRepository repo;
    
    public BookServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void getAllBooksByAuthorTest(){
        Pageable pgbl = null;
        assertEquals(repo.findByAuthorDbid(new Long(1), pgbl), null);        
    }
}
