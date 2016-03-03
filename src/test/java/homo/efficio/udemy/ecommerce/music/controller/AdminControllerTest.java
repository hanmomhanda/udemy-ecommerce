package homo.efficio.udemy.ecommerce.music.controller;

import homo.efficio.udemy.ecommerce.music.dao.ProductDao;
import homo.efficio.udemy.ecommerce.music.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.RandomAccessFile;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by hanmomhanda on 16. 3. 3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/config/test/AdminControllerTest.xml"
})
@WebAppConfiguration
public class AdminControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ServletContext servletContext;

    @Mock
    private ProductDao productDao;

    private final String IMAGES_DIR = "images";

    @InjectMocks
    private AdminController adminController;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void delete_should_delete_file() throws Exception {

        String imageWebPath = "/music/images/하니01.jpg";
        String imagesPhysicalPath = "/home/hanmomhanda/gitRepo/udemy-ecommerce/out/artifacts/udemy_ecommerce_war_exploded/WEB-INF/images";
        String filePath = imagesPhysicalPath +
                imageWebPath.substring(imageWebPath.lastIndexOf('/'));

        RandomAccessFile f = new RandomAccessFile(filePath, "rw");
        long size = 1024*3L;
        f.setLength(size);
        f.close();
        assertThat(new File(filePath).exists(), is(true));


        Product product = new Product();
        product.setProductImageWebPath(imageWebPath);
        when(productDao.getProductById(anyLong())).thenReturn(product);
        when(servletContext.getRealPath("/WEB-INF/" + IMAGES_DIR)).thenReturn(imagesPhysicalPath);


        mockMvc
            .perform(get("/admin/productInventory/deleteProduct/" + anyLong()))
            .andExpect(status().is3xxRedirection());

        verify(productDao, times(1)).getProductById(anyLong());
        verify(servletContext, times(1)).getRealPath("/WEB-INF/" + IMAGES_DIR);

        assertThat(new File(filePath).exists(), is(false));
    }
}
