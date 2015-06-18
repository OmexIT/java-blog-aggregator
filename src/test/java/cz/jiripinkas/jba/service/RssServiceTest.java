package cz.jiripinkas.jba.service;

import cz.jiripinkas.jba.entity.Item;
import cz.jiripinkas.jba.exception.RssException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by omexic on 6/17/2015.
 */
public class RssServiceTest {

    private RssService rssService;

    @Before
    public void setUp() throws Exception {
        rssService = new RssService();
    }

    @Test
    public void testGetItemsFile() throws RssException {
        ClassLoader classLoader = getClass().getClassLoader();
        List<Item> items = rssService.getItems(new File(classLoader.getResource("test-rss/javavids.xml").getFile()));
        assertEquals(10, items.size());

        Item firstItem = items.get(0);
        assertEquals("How to solve Source not found error during debug in Eclipse", firstItem.getTitle());
        assertEquals("22 Jun 2014 23:35:49", new SimpleDateFormat("dd MMM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
    }
}